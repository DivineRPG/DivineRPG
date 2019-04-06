package naturix.divinerpg.objects.items.vanilla;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityCorruptedBullet;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCorruptedCannon extends ItemMod {
    private Random rand = new Random();

    public ItemCorruptedCannon(String name) {
        super(name);
        setCreativeTab(DRPGCreativeTabs.ranged);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack stack = player.getHeldItem(handIn);

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
            if (player.capabilities.isCreativeMode
                    || player.inventory.hasItemStack(new ItemStack(ModItems.corruptedBullet))) {
                if (!world.isRemote) {
                    world.playSound(null, player.getPosition(), ModSounds.GHAST_CANNON, SoundCategory.MASTER, 1, 1);
                }
                for (int i = 0; i < 4; i++) {
                    EntityThrowable bullet = new EntityCorruptedBullet(world, player);
                    bullet.posX += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;
                    bullet.posY += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;
                    bullet.posZ += (this.rand.nextDouble() - this.rand.nextDouble()) / 2;
                    if (!world.isRemote) {
                        bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                        world.spawnEntity(bullet);
                        stack.getTagCompound().setLong("CanShootTime", Ticker.tick + 20);
                    }
                }
                if (!player.capabilities.isCreativeMode) {
                    ItemStack ammoStack = findAmmo(player);
                    ammoStack.shrink(1);
                    if (player instanceof EntityPlayerMP) {
                        ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
                    }
                }
            }
        }
        if (stack.getTagCompound().getLong("CanShootTime") >= 100000
                || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + 141) {
            stack.getTagCompound().setLong("CanShootTime", 0);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.bowDam("4x10"));
        list.add(TooltipLocalizer.ammo(ModItems.corruptedBullet));
        list.add(TooltipLocalizer.infiniteUses());
    }

    protected boolean isAmmo(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == ModItems.corruptedBullet;
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
