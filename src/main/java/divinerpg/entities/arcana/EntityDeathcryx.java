package divinerpg.entities.arcana;

import net.minecraft.potion.*;
import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityDeathcryx extends EntityDivineMob {
    public EntityDeathcryx(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.85F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.deathcryxHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.deathcryxDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.deathcryxSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.deathcryxFollowRange);
    }
    
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        //TODO - set arcana canSpawn
//        return level.dimension() == KeyRegistry.ARCANA_WORLD;
    return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 12 * 20, 0, false, false));
            }
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX_HURT;
    }

}
