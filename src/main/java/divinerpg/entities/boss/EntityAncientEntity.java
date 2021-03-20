package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityAncientEntity extends EntityDivineBoss {
    public EntityAncientEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward = 2000;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.ancientEntityHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.ancientEntityDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.ancientEntitySpeed).add(Attributes.FOLLOW_RANGE, EntityStats.ancientEntityFollowRange);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        super.doHurtTarget(entity);
        if (this.getTarget() != null) {
            this.getTarget().setDeltaMovement(this.getDeltaMovement().x * 10.0D, 2.0D, this.getDeltaMovement().z * 10.0D);
            if (this.getTarget() instanceof PlayerEntity) {
                getTarget().addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 0));
                playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
            }
            return true;
        }
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}
