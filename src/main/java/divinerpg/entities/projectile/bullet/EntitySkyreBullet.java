package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.DamageRegistry.ARCANA;
import static divinerpg.registries.SoundRegistry.SKYRE_SPARK;
import static net.minecraft.sounds.SoundSource.HOSTILE;
import static net.minecraft.world.level.Level.ExplosionInteraction.MOB;

public class EntitySkyreBullet extends DivineThrowableProjectile {
    public EntitySkyreBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        setDeltaMovement(level().getRandom().nextGaussian() * .05, -.5, level().getRandom().nextGaussian() * .05);
    }
    @Override public boolean isNoGravity() {return true;}
    @Override protected void doPostHurtEffects(LivingEntity entity) {
        if(entity instanceof Player player) {
            player.hurt(level().damageSources().source(ARCANA), player.getHealth() / 2);
            level().playSound(player, player.getX(), player.getY(), player.getZ(), SKYRE_SPARK.get(), HOSTILE, 0, 0);
        } level().explode(this, xo, yo, zo, 4.5F, false, MOB);
    }
    @Override protected void onHit(HitResult result) {
        if(tickCount > 1 && !level().isClientSide()) {
            level().explode(this, xo, yo, zo, 2, false, MOB);
            discard();
        }
    }
}