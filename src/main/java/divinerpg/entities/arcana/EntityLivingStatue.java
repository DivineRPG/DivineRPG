package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

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
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
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
        this.level.addFreshEntity(new EntityDivineArrow(EntityRegistry.ARROW_SHOT, this.level, ArrowType.LIVING_STATUE_ARROW, this, target, 1.6F, 12.0F));
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