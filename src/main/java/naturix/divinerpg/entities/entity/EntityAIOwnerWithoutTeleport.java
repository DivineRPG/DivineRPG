package naturix.divinerpg.entities.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

public class EntityAIOwnerWithoutTeleport extends EntityAIBase {
    private final EntityTameable thePet;
    private EntityLivingBase theOwner;
    World world;
    private final double followSpeed;
    private final PathNavigate petPathfinder;
    private int timeToRecalcPath;
    float maxDist;
    float minDist;
    private float oldWaterCost;

    public EntityAIOwnerWithoutTeleport(EntityTameable tameableIn, double followSpeedIn, float minDistIn, float maxDistIn)
    {
        this.thePet = tameableIn;
        this.world = tameableIn.world;
        this.followSpeed = followSpeedIn;
        this.petPathfinder = tameableIn.getNavigator();
        this.minDist = minDistIn;
        this.maxDist = maxDistIn;
        this.setMutexBits(3);
    }

	@Override
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.thePet.getOwner();

		if (entitylivingbase == null) {
			return false;
		} else if (this.thePet.isSitting()) {
			return false;
		} else if (this.thePet.getDistanceSq(entitylivingbase) < (double)(this.minDist * this.minDist)) {
			return false;
		} else {
			this.theOwner = entitylivingbase;
			return true;
		}
	}

	@Override
    public boolean shouldContinueExecuting() {
        return !this.petPathfinder.noPath() && this.thePet.getDistanceSq(this.theOwner) > (double)(this.maxDist * this.maxDist) && !this.thePet.isSitting();
	}

	@Override
	public void startExecuting() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.thePet.getPathPriority(PathNodeType.WATER);
        this.thePet.setPathPriority(PathNodeType.WATER, 0.0F);
	}

	@Override
	public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPath();
        this.thePet.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
	}

	@Override
	public void updateTask() {
		this.thePet.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0F, (float) this.thePet.getVerticalFaceSpeed());

        if (!this.thePet.isSitting()) {
	        if (--this.timeToRecalcPath <= 0) {
	            this.timeToRecalcPath = 10;
	
	            this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.followSpeed);
	        }
		}
	}
}