package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.arrows.IcicleArrow;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;

import javax.annotation.Nullable;

public class EntityPaleArcher extends EntityDivineMonster implements RangedAttackMob {
    public EntityPaleArcher(EntityType<? extends EntityPaleArcher> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(PathType.WATER, -1);
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        super.registerGoals();
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.icicle_bow.get()));
    }
    @SuppressWarnings("deprecation")
    @Nullable
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
        RandomSource random = level.getRandom();
        populateDefaultEquipmentSlots(random, difficulty);
        populateDefaultEquipmentEnchantments(level, random, difficulty);
        return data;
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            IcicleArrow abstractarrow = new IcicleArrow(level(), this, new ItemStack(ItemRegistry.icicle_arrow.get()), getItemInHand(InteractionHand.MAIN_HAND));
            double d0 = target.getX() - getX(), d1 = target.getY(.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * .2, d2, 1.6F, 14 - (level().getDifficulty().getId() << 2));
            playSound(SoundEvents.SKELETON_SHOOT, 1, 1 / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }
    @Override public int getMaxSpawnClusterSize() {return 3;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 3;}
    @Override public SoundEvent getAmbientSound() {return SoundEvents.STRAY_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.STRAY_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.STRAY_DEATH;}
    @Override protected void playStepSound(BlockPos pos, BlockState state) {}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
}