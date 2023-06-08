package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityStar;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStaffStarlight extends ItemModRanged {

    /**
     * Amount of spawned entities
     */
    private final int count;

    private final Component starsInfo;

    /**
     * @param arcana - arcana consuming amount
     * @param count  - count of spawning entities
     */
    public ItemStaffStarlight(int arcana, int count) {
        super("star", null, () -> SoundRegistry.STARLIGHT.get(), SoundSource.MASTER, -1, 0, null, arcana);
        this.count = count;

        starsInfo = LocalizeUtils.i18n(count > 1 ? "tooltip.staff_of_starlight" : "tooltip.starlight");
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if (!world.isClientSide) {
            for (int i = 0; i < count; i++) {
                EntityStar star = new EntityStar(EntityRegistry.STARLIGHT.get(), (double) pos.getBlockPos().getX() + 0.5D, (double) pos.getBlockPos().getY() + 25D, (double) pos.getBlockPos().getZ() + 0.5D, world);
                star.moveTo(pos.getBlockPos().getX(), pos.getBlockPos().getY() + 20, pos.getBlockPos().getZ());
                world.addFreshEntity(star);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(starsInfo);
    }

}