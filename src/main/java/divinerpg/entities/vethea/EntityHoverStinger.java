package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityHoverStinger extends EntityDivineMonster {
    public EntityHoverStinger(EntityType<? extends EntityHoverStinger> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
    	goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 1));
    	goalSelector.addGoal(2, new FollowMobGoal(this, 1, 1, 1));
    	super.registerGoals();
    }
    @Nullable
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.BEE_LOOP_AGGRESSIVE;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.BEE_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.BEE_DEATH;}
}