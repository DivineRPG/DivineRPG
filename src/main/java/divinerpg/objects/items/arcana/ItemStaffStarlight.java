package divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityStar;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemStaffStarlight extends RangedWeaponBase {

    public ItemStaffStarlight(String name, int arcana) {
        super(name, EntityStar.class, null, ModSounds.STARLIGHT, SoundCategory.MASTER, -1, 0, null, arcana);
        // ItemProjectileShooter.gunList.add(this);
        this.setFull3D();
        //        ItemStaff.staffList.add(this);
    }

    @Override
    protected boolean canUseRangedWeapon(EntityPlayer player, ItemStack stack) {
        if (!player.world.isRemote) {
            RayTraceResult pos = PositionHelper.rayTrace(player, 32, 1);
            if (pos.typeOfHit != RayTraceResult.Type.BLOCK) {
                return false;
            }
        }

        return super.canUseRangedWeapon(player, stack);
    }

    @Override
    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType,
            Class<? extends EntityThrowable> clazz) {
        RayTraceResult pos = PositionHelper.rayTrace(player, 32, 1);
        int x = pos.getBlockPos().getX(), y = pos.getBlockPos().getY() + 1, z = pos.getBlockPos().getZ();

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

                if (stack.getItem() == ModItems.staffOfStarlight) {
                    for (int i = 0; i < 8; i++)
                        world.spawnEntity(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D,
                                (double) blockZ + 0.5D));
                } else {
                    world.spawnEntity(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D,
                            (double) blockZ + 0.5D));
                }
            }
            player.getLook(1);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add(TooltipLocalizer.rangedDam(20));

        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(stack.getItem() == ModItems.staffOfStarlight ? "Drops several stars from the sky" :
                "Drops a star from the sky");
    }

}