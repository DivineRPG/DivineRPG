package divinerpg.entities.vethea;

import divinerpg.entities.base.*;

import javax.annotation.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityHoverStinger extends EntityDivineMonster {

    public EntityHoverStinger(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.2F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
    	this.goalSelector.addGoal(0, new FloatGoal(this));
    	this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
    	this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
    	this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
    	this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    	this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
    	this.goalSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
    	this.applyEntityAI();
    	super.registerGoals();
    }

	private void applyEntityAI() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}