package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.bullet.EntitySoulFiendShot;
import divinerpg.registries.EntityRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntitySoulFiend extends EntityDivineBoss {


    public EntitySoulFiend(EntityType<? extends EntitySoulFiend> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.tickCount % 300 == 0) {
            for (int i = 0; i < 4; i++) {
                EntitySoulFiendShot shot = EntityRegistry.SOUL_FIEND_SHOT.get().create(level(), EntitySpawnReason.EVENT);
                shot.setOwner(this);
                shot.setPos(position());
                shot.shoot(this.random.nextDouble() - this.random.nextDouble(), -0.25,
                        this.random.nextDouble() - this.random.nextDouble(), 0.5f, 12);
                this.level().addFreshEntity(shot);
            }
        }
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        if (super.doHurtTarget(level, entity)) {
            if (entity instanceof Player) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, 12 * 20, 0));
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12 * 20, 0));
            }
            entity.setDeltaMovement(-Mth.sin(this.getXRot() * (float) Math.PI / 180.0F) * 2.5, 0.4D,
                    Mth.cos(this.getXRot() * (float) Math.PI / 180.0F) * 2.5);
            setDeltaMovement(getDeltaMovement().x*0.6D, getDeltaMovement().y, getDeltaMovement().z*0.6D);
            return true;
        } else {
            return false;
        }
    }
}