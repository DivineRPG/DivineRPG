package naturix.divinerpg.objects.items.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.enums.ProjectileType;
import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityColoredBullet;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityParticleBullet;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.DRPGParticleTypes;
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

public class ItemProjectileShooter extends ItemMod {

    public static List<Item> gunList = new ArrayList<Item>();
    public static List<Item> phaserList = new ArrayList<Item>();
    protected SoundEvent shotSound;
    protected ProjectileType projectileType;
    protected Item ammo;
    protected int uses;
    private int delay;

    public ItemProjectileShooter(String name, ProjectileType projectileType, SoundEvent shotSound, Item ammo, int uses,
            int counter) {
        this(name, projectileType, ammo, uses, counter);
        this.shotSound = shotSound;
    }

    public ItemProjectileShooter(String name, ProjectileType projectileType, Item ammo, int uses, int counter) {
        this(name, projectileType, uses, counter);
        this.ammo = ammo;
    }

    public ItemProjectileShooter(String name, ProjectileType projectileType, SoundEvent shotSound, int uses,
            int counter) {
        this(name, projectileType, uses, counter);
        this.shotSound = shotSound;
    }

    public ItemProjectileShooter(String name, ProjectileType projectileType, int uses, int counter) {
        super(name);
        setCreativeTab(DRPGCreativeTabs.ranged);
        setMaxStackSize(1);
        this.projectileType = projectileType;
        this.uses = uses;
        this.delay = counter;
        this.setMaxDamage(uses);
        if (!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon")
                && !name.contains("bowheadCannon") && !name.contains("Anchor")) {
            gunList.add(this);
        } else if (name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon")
                || name.contains("bowheadCannon") || name.contains("Anchor")) {
            phaserList.add(this);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(projectileType.getDamage()));
        list.add(this.ammo == null ? TooltipLocalizer.infiniteAmmo() : TooltipLocalizer.ammo(this.ammo));
        list.add(this.uses == -1 ? TooltipLocalizer.infiniteUses()
                : TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack stack = player.getHeldItem(handIn);

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
            if (player.capabilities.isCreativeMode || this.ammo == null
                    || player.inventory.hasItemStack(new ItemStack(ammo))) {
                if (this.uses > -1 && !player.capabilities.isCreativeMode) {
                    stack.damageItem(1, player);
                }
                if (this.ammo != null && !player.capabilities.isCreativeMode) {
                    ItemStack ammoStack = findAmmo(player);
                    ammoStack.shrink(1);
                    if (player instanceof EntityPlayerMP) {
                        ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
                    }
                }
                if (!world.isRemote) {
                    world.playSound(null, player.getPosition(),
                            this.shotSound != null ? this.shotSound : SoundEvents.ENTITY_ARROW_SHOOT,
                            SoundCategory.MASTER, 1, 1);
                    EntityThrowable bullet;
                    if (projectileType.getParticle() != DRPGParticleTypes.NONE) {
                        bullet = new EntityParticleBullet(world, player, projectileType);
                    } else if (projectileType.getColor() != null) {
                        bullet = new EntityColoredBullet(world, player, projectileType);
                    } else {
                        bullet = new EntityShooterBullet(world, player, projectileType);
                    }
                    bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                    world.spawnEntity(bullet);
                    stack.getTagCompound().setLong("CanShootTime", Ticker.tick + delay * 4);
                }
            }
        }
        if (stack.getTagCompound().getLong("CanShootTime") >= 100000
                || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + delay * 4 + 1) {
            stack.getTagCompound().setLong("CanShootTime", 0);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }

    protected boolean isAmmo(@Nullable ItemStack stack) {
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
}