package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityParticleBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class ItemStaffSkyDrop extends ItemModRanged {
    public ItemStaffSkyDrop(BulletType bulletType, int arcana, int count, int delay, int uses) {
        super(bulletType, SoundRegistry.STARLIGHT.get(), null, uses, delay, arcana);
        projectileAmount = count;
    }
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(!world.isClientSide) {
            for(int i = 0; i < projectileAmount; i++) {
                EntityParticleBullet star = new EntityParticleBullet(EntityRegistry.PARTICLE_BULLET.get(), world, player, bulletType);
                star.moveTo(pos.getBlockPos().getX(), pos.getBlockPos().getY() + 20, pos.getBlockPos().getZ());
                world.addFreshEntity(star);
            }
        }
    }
}