package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityStar;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStaffStarlight extends ItemModRanged {

    /**
     * Amount of spawned entities
     */
    private final int count;

    private final ITextComponent starsInfo;

    /**
     * @param name   name of ite,
     * @param arcana - arcana consuming amount
     * @param count  - count of spawning entities
     */
    public ItemStaffStarlight(String name, int arcana, int count) {
        super(name, EntityRegistry.STARLIGHT, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 0, null, arcana);
        this.count = count;

        starsInfo = LocalizeUtils.i18n(count > 1 ? "tooltip.staff_of_starlight" : "tooltip.starlight");
    }

    @Override
    protected boolean canUseRangedWeapon(PlayerEntity player, ItemStack stack) {
        if (!player.level.isClientSide) {
            Vector3d start  = player.getEyePosition(1);
            Vector3d vec31 = player.getViewVector(1);
            Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
            RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player);
            if(player.level.getBlockState(new BlockPos(pos.getTo().x, pos.getTo().y, pos.getTo().z)).getBlock() instanceof Block){
                return false;
            }
        }
        return super.canUseRangedWeapon(player, stack);
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        Vector3d start  = player.getEyePosition(1);
        Vector3d vec31 = player.getViewVector(1);
        Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
        RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player);

        if(player.level.getBlockState(new BlockPos(pos.getTo().x, pos.getTo().y, pos.getTo().z)).getBlock() instanceof Block){

            if (!world.isClientSide) {
                for (int i = 0; i < count; i++) {
                    world.addFreshEntity(new EntityStar(EntityRegistry.STARLIGHT, (double) pos.getTo().x + 0.5D, (double) pos.getTo().y + 25D,
                            (double) pos.getTo().z + 0.5D, world));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(starsInfo);
    }

}