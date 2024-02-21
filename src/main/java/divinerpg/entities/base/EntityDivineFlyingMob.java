package divinerpg.entities.base;

import divinerpg.entities.ai.EscapeWaterGoal;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nullable;

public abstract class EntityDivineFlyingMob extends EntityDivineMonster {
    protected @Nullable Vec3 pathfindPos;
    protected final float preferredHeight, preferredDistance, pathFindDistance;
    protected EntityDivineFlyingMob(EntityType<? extends EntityDivineMonster> type, Level worldIn) {
        super(type, worldIn);
        preferredHeight = 5F;
        preferredDistance = 8F;
        pathFindDistance = 14F;
    }
    protected EntityDivineFlyingMob(EntityType<? extends EntityDivineMonster> type, Level worldIn, float pathFindDistance) {
        super(type, worldIn);
        preferredHeight = 5F;
        preferredDistance = 8F;
        this.pathFindDistance = pathFindDistance;
    }
    protected EntityDivineFlyingMob(EntityType<? extends EntityDivineMonster> type, Level worldIn, float preferredHeight, float preferredDistance, float pathFindDistance) {
        super(type, worldIn);
        this.preferredHeight = preferredHeight;
        this.preferredDistance = preferredDistance;
        this.pathFindDistance = pathFindDistance;
    }
    @Override
    protected PathNavigation createNavigation(Level level) {
    	return new FlyingPathNavigation(this, level);
    }
    @Override
    protected void registerGoals() {
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        goalSelector.addGoal(1, new EscapeWaterGoal(this));
        if(!(this instanceof RangedAttackMob)) goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, false));
        if(isAggressive()) {
            targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true, false));
        }
    }
    @Override protected boolean shouldDespawnInPeaceful() {return true;}
    @Override public boolean causeFallDamage(float f, float g, DamageSource d) {return false;}
    @Override protected void checkFallDamage(double d, boolean b, BlockState s, BlockPos p) {}
    @Override public boolean onClimbable() {return false;}
    public void reachTarget() {};
    @Override protected void customServerAiStep() {
        if(!isNoGravity()) setNoGravity(true);
        if(isInWater()) {
        	setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + .5, getDeltaMovement().z);
        	pathfindPos = null;
        	getNavigation().stop();
        	return;
        } boolean blockedPath = horizontalCollision || verticalCollision;
        if(!blockedPath) {
            Vec3 futurePos = position().add(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z);
            BlockPos pos = new BlockPos((int) futurePos.x, (int) futurePos.y, (int) futurePos.z);
            BlockState state = level().getBlockState(pos);
            blockedPath = state.is(Blocks.POWDER_SNOW) || state.is(Blocks.LAVA) || !state.getCollisionShape(level(), pos).equals(Shapes.empty());
        } //decide where to go next
    	LivingEntity target = getTarget();
        if(pathfindPos == null || blockedPath) {
            double findX = getX() + ((random.nextFloat() - .5F) * pathFindDistance), findY = getY() + ((random.nextFloat() - .6F) * pathFindDistance), findZ = getZ() + ((random.nextFloat() - .5F) * pathFindDistance);
            if(getNavigation().getPath() != null && !blockedPath) {
            	BlockPos destination = getNavigation().getPath().getTarget();
            	pathfindPos = new Vec3(destination.getX(), destination.getY(), destination.getZ());
            } else if(target != null && !blockedPath) {
                if(this instanceof RangedAttackMob) {
                    boolean tooclose = distanceTo(target) < preferredDistance;
                    pathfindPos = new Vec3(findX + (tooclose ? -1D : 1D) * (target.getX() - getX()) / 3D, findY + (target.getY() - getY() + preferredHeight), findZ + (tooclose ? -1D : 1D) * (target.getZ() - getZ()) / 3D);
                } else pathfindPos = target.position().add(0D, .5, 0D);
            } else pathfindPos = new Vec3(findX, findY, findZ);
        } else if(target != null && !(this instanceof RangedAttackMob) && Math.sqrt(target.distanceToSqr(pathfindPos)) > 2D) pathfindPos = target.position().add(0D, .5, 0D);
        //movement
        double speed = getAttributeValue(Attributes.FLYING_SPEED);
        setDeltaMovement(getDeltaMovement().x + (pathfindPos.x - getX()) / 64D * speed, getDeltaMovement().y + (pathfindPos.y- getY()) / 64D * speed, getDeltaMovement().z + (pathfindPos.z - getZ()) / 64D * speed);
        double distanceX = pathfindPos.x - getX(), distanceY = pathfindPos.y- getY(), distanceZ = pathfindPos.z - getZ();
        yRot = Utils.rotlerp(yRot, (float) (Mth.atan2(distanceZ, distanceX) * 180D / Math.PI) - 90F, 90F);
        xRot = Utils.rotlerp(xRot, (float) -(Mth.atan2(distanceY, Math.sqrt(distanceX * distanceX + distanceZ * distanceZ)) * 180D / Math.PI), 20F);
        if(Math.sqrt(distanceToSqr(pathfindPos)) < 1D) {
        	pathfindPos = null;
        	if(getNavigation().getPath() != null && getNavigation().getPath().getDistToTarget() < 1.5F) {
        		reachTarget();
        		getNavigation().stop();
        	}
        }
    }
}