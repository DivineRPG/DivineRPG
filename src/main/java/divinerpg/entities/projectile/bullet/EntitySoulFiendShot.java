package divinerpg.entities.projectile.bullet;

import divinerpg.client.particle.options.ParticleColouredOption;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.EntityRegistry.SOUL_SPIDER;
import static divinerpg.registries.ParticleRegistry.COLORED;
import static net.minecraft.world.entity.MobSpawnType.MOB_SUMMONED;

public class EntitySoulFiendShot extends ThrowableProjectile {
    public EntitySoulFiendShot(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    @Override public void onHit(HitResult result) {
        if(tickCount > 1 && !level().isClientSide()) {
            for(int i = 0; i < 3; i++) SOUL_SPIDER.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, new BlockPos((int)result.getLocation().x, (int)result.getLocation().y, (int)result.getLocation().z), MOB_SUMMONED, true, false);
            discard();
        }
    }
    @Override public void tick() {
        super.tick();
        if(level().isClientSide()) for(int cnt = 0; cnt < 8; ++cnt) {
            level().addParticle(new ParticleColouredOption(COLORED.get(), 0), xo + (random.nextDouble() - random.nextDouble()) / 4, yo + (random.nextDouble() - random.nextDouble()) / 4, zo + (random.nextDouble() - random.nextDouble()) / 4, .2, .2, .2);
            level().addParticle(new ParticleColouredOption(COLORED.get(), 255000), xo + (random.nextDouble() - random.nextDouble()) / 4, yo + (random.nextDouble() - random.nextDouble()) / 4, zo + (random.nextDouble() - random.nextDouble()) / 4, .2, .2, .2);
        } if(!level().isClientSide && tickCount > 20) discard();
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}