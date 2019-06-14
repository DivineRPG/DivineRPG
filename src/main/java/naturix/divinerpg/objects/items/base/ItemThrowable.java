package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.enums.DiskType;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDisk;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemThrowable extends ItemMod {
    protected BulletType projectileType;
    protected DiskType disk;
    public boolean isDisk;
    public ItemThrowable(String name, BulletType projectileType) {
        super(name, DRPGCreativeTabs.ranged);
        this.projectileType = projectileType;
        this.isDisk=false;
    }
    public ItemThrowable(String name, DiskType disk) {
        super(name, DRPGCreativeTabs.ranged);
        this.disk = disk;
        this.isDisk=true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(projectileType.getDamage()));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

        if (!world.isRemote && isDisk == false) {
            EntityShooterBullet bullet = new EntityShooterBullet(world, player, projectileType);
            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
        }
        if (!world.isRemote && isDisk == true) {
            EntityDisk bullet = new EntityDisk(world, player, this.disk, itemstack.getItem()); 
            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}