package divinerpg.entities.base;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.fish.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class EntityDivineWaterMob extends WaterAnimal implements Enemy {
    public EntityDivineWaterMob(EntityType<? extends EntityDivineWaterMob> type, Level worldIn) {super(type, worldIn);}
    @Override protected int getBaseExperienceReward(ServerLevel level) {return XP_REWARD_MEDIUM;}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new TryFindWaterGoal(this));
        goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1, 10));
        goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 32));
//        goalSelector.addGoal(3, new FollowBoatGoal(this));
        goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Guardian.class, 8, 1, 1));
        targetSelector.addGoal(0, (new HurtByTargetGoal(this, Guardian.class)).setAlertOthers());
    }
    @Override public boolean checkSpawnObstruction(LevelReader worldIn) {
        return worldIn.containsAnyLiquid(getBoundingBox()) && worldIn.noCollision(this);
    }
    @Nullable
    @SuppressWarnings("deprecation")
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, EntitySpawnReason type, @Nullable SpawnGroupData data) {
        setAirSupply(getMaxAirSupply());
        setXRot(0);
        return data;
    }
    @Override protected void handleAirSupply(ServerLevel level, int airSupply) {}
    @Override protected PathNavigation createNavigation(Level level) {return new WaterBoundPathNavigation(this, level);}
    @Override public int getMaxHeadXRot() {return 1;}
    @Override public int getMaxHeadYRot() {return 1;}
    @Override public void tick() {
        super.tick();
        if(onGround()) {
            setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2 - 1) * .2F), .5, (random.nextFloat() * 2 - 1) * .2F));
            setYRot(random.nextFloat() * 360);
            setOnGround(false);
//            hasImpulse = true;
        }
    }
    protected boolean closeToNextPos() {
        BlockPos blockpos = this.getNavigation().getTargetPos();
        return blockpos != null ? blockpos.closerToCenterThan(this.position(), 12) : false;
    }
    @Override public void travel(Vec3 vec) {
        if(isEffectiveAi() && isInWater()) {
            moveRelative(getSpeed(), vec);
            move(MoverType.SELF, getDeltaMovement());
            setDeltaMovement(getDeltaMovement().scale(.9));
            if(getTarget() == null) setDeltaMovement(getDeltaMovement().add(0, -.005, 0));
        } else super.travel(vec);
    }
}