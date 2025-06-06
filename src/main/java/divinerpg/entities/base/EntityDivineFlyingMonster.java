package divinerpg.entities.base;

import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nullable;

public abstract class EntityDivineFlyingMonster extends EntityDivineMonster {
    protected @Nullable Vec3 pathfindPos;
    protected final float preferredHeight, preferredDistance, pathFindDistance;
    protected EntityDivineFlyingMonster(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn) {
        super(type, worldIn);
        preferredHeight = 5;
        preferredDistance = 8;
        pathFindDistance = 14;
    }
    protected EntityDivineFlyingMonster(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn, float pathFindDistance) {
        super(type, worldIn);
        preferredHeight = 5;
        preferredDistance = 8;
        this.pathFindDistance = pathFindDistance;
    }
    protected EntityDivineFlyingMonster(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn, float preferredHeight, float preferredDistance, float pathFindDistance) {
        super(type, worldIn);
        this.preferredHeight = preferredHeight;
        this.preferredDistance = preferredDistance;
        this.pathFindDistance = pathFindDistance;
    }
    @Override protected PathNavigation createNavigation(Level level) {return new FlyingPathNavigation(this, level);}
    @Override protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}
    @Override public boolean onClimbable() {return false;}
    public void reachTarget() {}
    @Override
    protected void customServerAiStep() {
        flyingAIStep();
    }
    public void flyingAIStep() {
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
            double findX = getX() + ((random.nextFloat() - .5) * pathFindDistance), findY = getY() + ((random.nextFloat() - .6) * pathFindDistance), findZ = getZ() + ((random.nextFloat() - .5) * pathFindDistance);
            if(getNavigation().getPath() != null && !blockedPath) {
                BlockPos destination = getNavigation().getPath().getTarget();
                pathfindPos = new Vec3(destination.getX(), destination.getY(), destination.getZ());
            } else if(target != null && !blockedPath) {
                if(this instanceof RangedAttackMob) {
                    boolean tooclose = distanceTo(target) < preferredDistance;
                    pathfindPos = new Vec3(findX + (tooclose ? -1 : 1) * (target.getX() - getX()) / 3, findY + (target.getY() - getY() + preferredHeight), findZ + (tooclose ? -1 : 1) * (target.getZ() - getZ()) / 3);
                } else pathfindPos = target.position().add(0, .5, 0);
            } else pathfindPos = new Vec3(findX, findY, findZ);
        } else if(target != null && !(this instanceof RangedAttackMob) && Math.sqrt(target.distanceToSqr(pathfindPos)) > 2) pathfindPos = target.position().add(0, .5, 0);
        //movement
        double speed = getAttributeValue(Attributes.FLYING_SPEED);
        setDeltaMovement(getDeltaMovement().x + (pathfindPos.x - getX()) / 64 * speed, getDeltaMovement().y + (pathfindPos.y- getY()) / 64 * speed, getDeltaMovement().z + (pathfindPos.z - getZ()) / 64 * speed);
        double distanceX = pathfindPos.x - getX(), distanceZ = pathfindPos.z - getZ();
        yHeadRot = Utils.rotlerp(getYRot(), (float)(Mth.atan2(distanceZ, distanceX) * Mth.RAD_TO_DEG) - 90, 90);
        zza = .5F;
        setYRot(getYRot() + Mth.wrapDegrees((float)(Mth.atan2(getDeltaMovement().z, getDeltaMovement().x) * Mth.RAD_TO_DEG) - 90 - getYRot()));
        if(Math.sqrt(distanceToSqr(pathfindPos)) < 1) {
            pathfindPos = null;
            if(getNavigation().getPath() != null && getNavigation().getPath().getDistToTarget() < 1.5) {
                reachTarget();
                getNavigation().stop();
            }
        }
    }
}