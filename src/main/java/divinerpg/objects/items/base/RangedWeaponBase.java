package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.enums.BulletType;
import divinerpg.enums.ParticleType;
import divinerpg.objects.entities.entity.projectiles.EntityColoredBullet;
import divinerpg.objects.entities.entity.projectiles.EntityParticleBullet;
import divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.PositionHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class RangedWeaponBase extends ItemMod {

    private final Class<? extends EntityThrowable> clazz;
    private final SoundEvent sound;
    private final SoundCategory soundCategory;
    private final int delay;
    private final Supplier<Item> ammoSupplier;
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
     * @param ammoSupplier
     *            - Ammo for weapon. If supplier returns null, no ammo required
     * @param arcanaConsuming
     *            - Arcana consuming per shot. Pass 0 to not consume at all
     */
    public RangedWeaponBase(String name, Class<? extends EntityThrowable> clazz, BulletType bulletType,
            SoundEvent sound, SoundCategory soundCategory, int maxDamage, int delay, Supplier<Item> ammoSupplier, int arcanaConsuming) {
        super(name, DivineRPGTabs.RANGED_WEAPONS);
        setMaxDamage(maxDamage);
        setMaxStackSize(1);

        this.clazz = clazz;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;

        if(ammoSupplier == null) {
            this.ammoSupplier = () -> null;
        }
        else {
            this.ammoSupplier = ammoSupplier;
        }

        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }

    public RangedWeaponBase(String name, BulletType bulletType, SoundEvent shotSound, Supplier<Item> ammoSupplier, int maxDamange,
            int counter) {
        this(name, null, bulletType, shotSound, SoundCategory.MASTER, maxDamange, counter, ammoSupplier, 0);
    }

    public RangedWeaponBase(String name, BulletType bulletType, SoundEvent shotSound, int uses, int counter) {
        this(name, bulletType, shotSound, () -> null, uses, counter);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (bulletType != null) {
            tooltip.add(LocalizeUtils.rangedDam(bulletType.getDamage()));
        }

        EntityPlayer player = DivineRPG.proxy.getPlayer();
        if (!needsAmmo() || player == null) {
            tooltip.add(LocalizeUtils.infiniteAmmo());
        } else {
            ItemStack ammo = findAmmo(player);
            tooltip.add(LocalizeUtils.ammo(getAmmo(), ammo != null));
        }

        tooltip.add(stack.getMaxDamage() == -1 ? LocalizeUtils.infiniteUses() :
                LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));

        if (arcanaConsuming > 0)
            tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsuming));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        EnumActionResult result = EnumActionResult.FAIL;

        if (canUseRangedWeapon(player, stack)) {
            ActionResult<ItemStack> ammo = tryFindAmmo(player);
            ActionResult<IArcana> checkArcana = tryCheckArcana(player);

            if (ammo.getType() == EnumActionResult.SUCCESS && checkArcana.getType() == EnumActionResult.SUCCESS) {
                doPreUsageEffects(world, player);

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

                if (!player.capabilities.isCreativeMode) {
                    stack.damageItem(1, player);
                }

                player.getCooldownTracker().setCooldown(stack.getItem(), delay * 4 + 1);

                if (player instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
                }

                doPostUsageEffects(world, player);
            }


        }

        return new ActionResult<>(result, stack);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    private Item getAmmo() {
        return this.ammoSupplier.get();
    }

    private boolean needsAmmo() {
        return this.ammoSupplier.get() != null;
    }

    private boolean isAmmo(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == getAmmo();
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

    /*
        Trying to find ammo stack.
        If SUCCESS, can continue
        If ItemStack is not null, we need to shrink it
     */
    protected ActionResult<ItemStack> tryFindAmmo(EntityPlayer player) {
        ItemStack stack = null;
        EnumActionResult result = EnumActionResult.SUCCESS;

        if (!player.capabilities.isCreativeMode && needsAmmo()) {
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
            arcana = DivineAPI.getArcana(player);
            if (arcana == null || arcana.getArcana() < this.arcanaConsuming) {
                result = EnumActionResult.FAIL;
            }
        }

        return new ActionResult<>(result, arcana);
    }

    /*
        Trying to detect if we can use the item.
     */
    protected boolean canUseRangedWeapon(EntityPlayer player, ItemStack stack) {
        return (player.capabilities.isCreativeMode || stack.getMaxDamage() <= 0
                || stack.getItemDamage() < stack.getMaxDamage());
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
        else if (bulletType.getParticle() != ParticleType.NONE) {
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

    protected void doPreUsageEffects(World world, EntityPlayer player) {
        return;
    }

    protected void doPostUsageEffects(World world, EntityPlayer player) {
        return;
    }
}
