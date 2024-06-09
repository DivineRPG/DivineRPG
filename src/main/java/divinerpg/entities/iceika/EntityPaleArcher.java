package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import javax.annotation.Nullable;

public class EntityPaleArcher extends EntityDivineMonster implements RangedAttackMob {
    public EntityPaleArcher(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(BlockPathTypes.WATER, -1);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.594F;}
    @Override public boolean isAggressive() {return true;}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.icicle_bow.get()));
    }
    @Nullable
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
        RandomSource random = level.getRandom();
        populateDefaultEquipmentSlots(random, difficulty);
        populateDefaultEquipmentEnchantments(random, difficulty);
        return data;
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level(), ArrowType.PALE_ARCHER_ARROW, this, target, 1.6F, 1.2F);
        double d0 = target.getX() - getX();
        double d1 = target.getY(.3333333333333333) - projectile.getY();
        double d2 = target.getZ() - getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        projectile.shoot(d0, d1 + d3 * (double).2F, d2, 1.6F, (float)(14 - level().getDifficulty().getId() * 4));
        level().addFreshEntity(projectile);
    }
    @Override public int getMaxSpawnClusterSize() {return 3;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 3;}
    @Override public SoundEvent getAmbientSound() {return SoundEvents.STRAY_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.STRAY_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.STRAY_DEATH;}
    @Override protected void playStepSound(BlockPos pos, BlockState state) {}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public MobType getMobType() {return MobType.UNDEAD;}
}