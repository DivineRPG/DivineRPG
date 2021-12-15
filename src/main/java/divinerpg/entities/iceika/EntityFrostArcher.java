package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityFrostArcher extends EntityDivineMob implements IRangedAttackMob {
    public EntityFrostArcher(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.725F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.frostArcherHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.frostArcherDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.frostArcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.frostArcherFollowRange);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        this.level.addFreshEntity(new EntityDivineArrow(EntityRegistry.ARROW_SHOT, this.level, ArrowType.FROST_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }
}
