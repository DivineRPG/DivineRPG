package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import net.minecraft.util.*;
import net.minecraft.world.BossEvent.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public class EntitySoulFiend extends EntityDivineBoss {


    public EntitySoulFiend(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.tickCount % 300 == 0) {
            for (int i = 0; i < 4; i++) {
                EntitySoulFiendShot shot = new EntitySoulFiendShot(EntityRegistry.SOUL_FIEND_SHOT.get(), this, level());
                shot.shoot(this.random.nextDouble() - this.random.nextDouble(), -0.25,
                        this.random.nextDouble() - this.random.nextDouble(), 0.5f, 12);
                this.level().addFreshEntity(shot);
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof Player) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 12 * 20, 0));
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12 * 20, 0));
            }
            entity.setDeltaMovement(-Mth.sin(this.xRot * (float) Math.PI / 180.0F) * 2.5, 0.4D,
                    Mth.cos(this.xRot * (float) Math.PI / 180.0F) * 2.5);
            setDeltaMovement(getDeltaMovement().x*0.6D, getDeltaMovement().y, getDeltaMovement().z*0.6D);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.YELLOW;
    }
}
