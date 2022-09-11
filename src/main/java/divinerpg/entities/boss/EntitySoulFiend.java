package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntitySoulFiend extends EntityDivineBoss {


    public EntitySoulFiend(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.725F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount % 300 == 0 && this.isAlive()) {
            for (int i = 0; i < 4; i++) {
                EntitySoulFiendShot shot = new EntitySoulFiendShot(EntityRegistry.SOUL_FIEND_SHOT, this, level);
                shot.shoot(this.random.nextDouble() - this.random.nextDouble(), -0.25,
                        this.random.nextDouble() - this.random.nextDouble(), 0.5f, 12);
                this.level.addFreshEntity(shot);
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof PlayerEntity) {
                ((LivingEntity) entity).addEffect(new EffectInstance(Effects.CONFUSION, 12 * 20, 0));
                ((LivingEntity) entity).addEffect(new EffectInstance(Effects.BLINDNESS, 12 * 20, 0));
            }
            entity.setDeltaMovement(-MathHelper.sin(this.xRot * (float) Math.PI / 180.0F) * 2.5, 0.4D,
                    MathHelper.cos(this.xRot * (float) Math.PI / 180.0F) * 2.5);
            setDeltaMovement(getDeltaMovement().x*0.6D, getDeltaMovement().y, getDeltaMovement().z*0.6D);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.soulFiendHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.soulFiendDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.soulFiendSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.soulFiendFollowRange);
    }
}
