package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.world.*;

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
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.getBiome(blockPosition()).shouldSnow(worldIn, blockPosition());
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Frost archer arrow
//        this.world.spawnEntity(new EntityDivineArrow(this.world, ArrowType.FROST_ARCHER_ARROW, this, target, 1.6F, 12.0F));
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

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_FROST_ARCHER;
    }
}
