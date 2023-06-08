package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityMeteor;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMeteorMash extends ItemModRanged {
    public ItemMeteorMash() {
        super("meteor", null, () -> SoundRegistry.STARLIGHT.get(), SoundSource.MASTER, -1, 0, null, 35);
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));


            ThrowableProjectile entity = new EntityMeteor(EntityRegistry.METEOR.get(), (double) pos.getBlockPos().getX() + 0.5D, (double) pos.getBlockPos().getY() + 25D,
                    (double) pos.getBlockPos().getZ() + 0.5D, world);
            entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            entity.moveTo(pos.getLocation());
            world.addFreshEntity(entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.meteormash"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
