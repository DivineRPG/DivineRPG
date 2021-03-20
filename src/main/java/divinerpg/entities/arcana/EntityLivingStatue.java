package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityLivingStatue extends EntityDivineMob implements IRangedAttackMob {
    public EntityLivingStatue(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.725F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.dungeonPrisonerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.dungeonPrisonerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.dungeonPrisonerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.dungeonPrisonerFollowRange);
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
        this.targetSelector.addGoal(1,
                new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0.27D, 10, 60));
    }
    
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
    	// TODO living_statue_arrow
        //this.world.spawnEntity(new EntityDivineArrow(this.world, ArrowType.LIVING_STATUE_ARROW, this, target, 1.6F, 12.0F));
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT;
    }

}