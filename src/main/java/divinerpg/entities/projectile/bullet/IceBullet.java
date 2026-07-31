package divinerpg.entities.projectile.bullet;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class IceBullet extends ThrowableProjectile {
    public IceBullet(EntityType<? extends ThrowableProjectile> entityType, Level level) {super(entityType, level);}
    @Override protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(result.getEntity() instanceof LivingEntity l) l.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 5 * 20, 3), getOwner());
        result.getEntity().addDeltaMovement(getDeltaMovement().scale(.2));
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}