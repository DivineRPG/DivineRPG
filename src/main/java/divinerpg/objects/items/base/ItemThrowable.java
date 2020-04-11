package divinerpg.objects.items.base;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeKeys;
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

import javax.annotation.Nullable;
import java.util.List;

public class ItemThrowable extends ItemMod {
    protected BulletType bulletType;

    public ItemThrowable(String name, BulletType bulletType) {
        super(name, DivineRPGTabs.ranged);
        this.bulletType = bulletType;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeKeys.rangedDam(bulletType.getDamage()));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

        if (!world.isRemote) {
            EntityShooterBullet bullet = new EntityShooterBullet(world, player, bulletType);
            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}