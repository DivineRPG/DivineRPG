package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityColoredBullet;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityParticleBullet;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.PositionHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("Duplicates")
public class RangedWeaponBase extends ItemMod {

    private final Class<? extends EntityThrowable> clazz;
    private final SoundEvent sound;
    private final SoundCategory soundCategory;
    private final int delay;
    private final Item ammo;
    private int arcanaConsuming;

    private final String delayTagName = "CanShootTime";

    protected BulletType bulletType;

    /**
     * Constructor for Divine RPG ranged weapons
     * 
     * @param name
     *            - name of resource
     * @param clazz
     *            - Class of spawned entity
     * @param bulletType
     *            - Type of bullets. Has lower priority than clazz param
     * @param sound
     *            - what sound will be on bullet spawn
     * @param soundCategory
     *            - sound category, mostly MASTER
     * @param maxDamage
     *            - max usage of item
     * @param delay
     *            - cooldown for shoot
     * @param ammo
     *            - Ammo for weapon. IF null, no ammo required
     * @param arcanaConsuming
     *            - Arcana consuming per shot. Pass 0 to not consume at all
     */
    public RangedWeaponBase(String name, Class<? extends EntityThrowable> clazz, BulletType bulletType,
            SoundEvent sound, SoundCategory soundCategory, int maxDamage, int delay, Item ammo, int arcanaConsuming) {
        super(name, DivineRPGTabs.ranged);
        setMaxDamage(maxDamage);
        setMaxStackSize(1);

        this.clazz = clazz;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;
        this.ammo = ammo;
        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }

    public RangedWeaponBase(String name, BulletType bulletType, SoundEvent shotSound, Item ammo, int maxDamange,
            int counter) {
        this(name, null, bulletType, shotSound, SoundCategory.MASTER, maxDamange, counter, ammo, 0);
    }

    public RangedWeaponBase(String name, BulletType bulletType, SoundEvent shotSound, int uses, int counter) {
        this(name, bulletType, shotSound, null, uses, counter);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (bulletType != null) {
            tooltip.add(TooltipLocalizer.rangedDam(bulletType.getDamage()));
        }

        addAmmoInfo(tooltip);

        tooltip.add(getMaxDamage() == -1 ? TooltipLocalizer.infiniteUses() :
                TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));

        if (arcanaConsuming > 0)
            tooltip.add(TooltipLocalizer.arcanaConsumed(arcanaConsuming));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        EnumActionResult result = EnumActionResult.FAIL;

        if (manageDelay(player, stack)) {

            ActionResult<ItemStack> canUseCannon = canUseCannon(player, stack);
            ActionResult<ItemStack> ammo = tryFindAmmo(player);
            ActionResult<IArcana> checkArcana = tryCheckArcana(player);

            if (canUseCannon.getType() == ammo.getType() && ammo.getType() == checkArcana.getType()
                    && checkArcana.getType() == EnumActionResult.SUCCESS) {

                if (!world.isRemote) {
                    world.playSound(null, player.getPosition(),
                            this.sound != null ? this.sound : SoundEvents.ENTITY_ARROW_SHOOT,
                            this.soundCategory != null ? this.soundCategory : SoundCategory.MASTER, 1, 1);

                    spawnEntity(world, player, stack, bulletType, clazz);
                }

                IArcana arcana = checkArcana.getResult();
                if (arcana != null)
                    arcana.consume(player, arcanaConsuming);

                ItemStack ammoStack = ammo.getResult();
                if (ammoStack != null) {
                    ammoStack.shrink(1);
                }

                ItemStack cannonStack = canUseCannon.getResult();
                if (cannonStack != null) {
                    cannonStack.damageItem(1, player);

                    cannonStack.getTagCompound().setLong("CanShootTime", Ticker.tick + delay * 4);
                }

                if (player instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
                }
            }
        }

        return new ActionResult<>(result, stack);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    private void addAmmoInfo(List<String> list) {
        EntityPlayer player = DivineRPG.proxy.getPlayer();
        if (player == null || this.ammo == null) {
            list.add(TooltipLocalizer.infiniteAmmo());
        } else {
            ItemStack ammo = findAmmo(player);
            list.add(TooltipLocalizer.ammo(this.ammo, ammo != null));
        }
    }

    private boolean isAmmo(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == this.ammo;
    }

    private ItemStack findAmmo(EntityPlayer player) {
        if (this.isAmmo(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isAmmo(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if (this.isAmmo(itemstack)) {
                    return itemstack;
                }
            }
            return null;
        }
    }

    protected boolean manageDelay(EntityPlayer player, ItemStack cannon) {
        // Trying to set compound
        if (!cannon.hasTagCompound()) {
            cannon.setTagCompound(new NBTTagCompound());
        }
        // get reference
        NBTTagCompound compound = cannon.getTagCompound();
        // get value
        long canShootTime = compound.getLong(delayTagName);

        // in creative mode can shoot always
        boolean result = player.capabilities.isCreativeMode || Ticker.tick >= canShootTime;

        // we managing delay here, re-evaulating every item using time
        if (canShootTime >= 100000 || canShootTime > Ticker.tick + delay * 4 + 1) {
            compound.setLong(delayTagName, 0);
        }

        return result;
    }

    /*
        Trying to find ammo stack.
        If SUCCESS, can continue
        If ItemStack is not null, we need to shrink it
     */
    protected ActionResult<ItemStack> tryFindAmmo(EntityPlayer player) {
        ItemStack stack = null;
        EnumActionResult result = EnumActionResult.SUCCESS;

        if (!player.capabilities.isCreativeMode && this.ammo != null) {
            stack = findAmmo(player);
            if (stack == null || stack.getCount() < 1) {
                result = EnumActionResult.FAIL;
            }
        }

        return new ActionResult<>(result, stack);
    }

    /*
        Trying to get capability and check if we have enough arcana
     */
    protected ActionResult<IArcana> tryCheckArcana(EntityPlayer player) {
        IArcana arcana = null;
        EnumActionResult result = EnumActionResult.SUCCESS;

        if (!player.capabilities.isCreativeMode && this.arcanaConsuming > 0) {
            arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
            if (arcana == null || arcana.getArcana() < this.arcanaConsuming) {
                result = EnumActionResult.FAIL;
            }
        }

        return new ActionResult<>(result, arcana);
    }

    /*
        Trying to detect if we can use the item.
        If returned SUCCESS, we can
        If ItemStack is not null, we need to damage it
     */
    protected ActionResult<ItemStack> canUseCannon(EntityPlayer player, ItemStack stack) {
        EnumActionResult result = EnumActionResult.SUCCESS;

        if (player.capabilities.isCreativeMode) {
            return new ActionResult<>(result, null);
        }

        if (stack.getMaxDamage() > 0 && stack.getItemDamage() >= stack.getMaxDamage()) {
            result = EnumActionResult.FAIL;
        }

        return new ActionResult<>(result, stack);
    }

    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType,
            Class<? extends EntityThrowable> clazz) {

        EntityThrowable bullet = null;

        // Class has the most priority
        if (clazz != null) {
            try {
                bullet = (clazz.getConstructor(World.class, EntityPlayer.class).newInstance(world, player));
            } catch (Exception e) {
                e.printStackTrace();

                // Weapon will not work, so it would be better to crush
                throw new RuntimeException(e.getMessage());
            }
        }
        // In other cases we look to a BulletType field
        else if (bulletType.getParticle() != DRPGParticleTypes.NONE) {
            bullet = new EntityParticleBullet(world, player, bulletType);
        } else if (bulletType.getColor() != null) {
            bullet = new EntityColoredBullet(world, player, bulletType);
        } else {
            bullet = new EntityShooterBullet(world, player, bulletType);
        }

        PositionHelper.moveBullet(player, bullet);
        bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
        world.spawnEntity(bullet);
    }
}
