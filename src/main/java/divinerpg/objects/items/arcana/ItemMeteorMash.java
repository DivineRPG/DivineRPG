package divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityMeteor;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModSounds;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemMeteorMash extends RangedWeaponBase {

    public ItemMeteorMash() {
        super("meteor_mash", null, null, ModSounds.STARLIGHT, SoundCategory.MASTER, -1, 0, null, 35);
        //        ItemStaff.staffList.add(this);
    }

    @Override
    protected boolean canUseRangedWeapon(EntityPlayer player, ItemStack stack) {
        RayTraceResult pos = PositionHelper.rayTrace(player, 32, 1);
        if (pos.typeOfHit != RayTraceResult.Type.BLOCK) {
            return false;
        }

        return super.canUseRangedWeapon(player, stack);
    }

    @Override
    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType,
            Class<? extends EntityThrowable> clazz) {
        RayTraceResult pos = PositionHelper.rayTrace(player, 32, 1);
        if (pos.typeOfHit == RayTraceResult.Type.BLOCK) {
            int blockX = pos.getBlockPos().getX();
            int blockY = pos.getBlockPos().getY();
            int blockZ = pos.getBlockPos().getZ();
            EnumFacing side = pos.sideHit;

            if (side == EnumFacing.DOWN)
                --blockY;
            if (side == EnumFacing.UP)
                ++blockY;
            if (side == EnumFacing.EAST)
                --blockZ;
            if (side == EnumFacing.WEST)
                ++blockZ;
            if (side == EnumFacing.SOUTH)
                --blockX;
            if (side == EnumFacing.NORTH)
                ++blockX;

            if (!world.isRemote) {
                EntityThrowable entity = new EntityMeteor(world, (double) blockX + 0.5D, (double) blockY + 25D,
                        (double) blockZ + 0.5D);
                entity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(entity);
            }
            player.getLook(1);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipHelper.getInfoText("tooltip.meteormash"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}