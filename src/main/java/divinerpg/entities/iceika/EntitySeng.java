package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;

public class EntitySeng extends EntityDivineMonster {

    public EntitySeng(EntityType<? extends EntitySeng> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
    	targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityDolossal.class, true));
    	targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityMamoth.class, 10, true, true, LivingEntity::isBaby));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 3;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 2;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SENG_AMBIENT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SENG_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SENG_GROWL.get();
    }
}
