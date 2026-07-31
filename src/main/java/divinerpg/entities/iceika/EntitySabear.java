package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntitySabear extends EntityDivineMonster {
    public EntitySabear(EntityType<? extends EntitySabear> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityMamoth.class, 10, true, true, null));
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }
    @Override
    public int getMaxSpawnClusterSize() {
        return 2;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
        return i > 1;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.POLAR_BEAR_AMBIENT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.POLAR_BEAR_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundEvents.POLAR_BEAR_HURT;
    }
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        playSound(SoundEvents.POLAR_BEAR_STEP, .15F, 1F);
    }
}