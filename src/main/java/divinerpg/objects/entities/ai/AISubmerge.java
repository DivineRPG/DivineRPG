package divinerpg.objects.entities.ai;


import divinerpg.objects.entities.entity.EntityDivineWaterMob;
import net.minecraft.entity.ai.EntityAIBase;

public class AISubmerge extends EntityAIBase {
	
	EntityDivineWaterMob mob;
	
	public AISubmerge(EntityDivineWaterMob entity) {
		mob = entity;
		setMutexBits(3); 
		}
	
	@Override
	public boolean shouldExecute() {
			if (this.mob.posY > mob.world.getSeaLevel()) {
				return true;
			} else {
				return false;
			}
		}
	
	@Override
	public void startExecuting() {
		double targetX, targetY, targetZ; 
		boolean found_path = false;
		
			for (int try_cnt=1; try_cnt <= 5 && !found_path; ++try_cnt) {
				targetX = mob.posX + ((Math.random() * 10.0) - 5.0);
				targetY = mob.posY + ((Math.random() * 10.0) - 15.0);
				targetZ = mob.posZ + ((Math.random() * 20.0) - 10.0);
				this.mob.getNavigator().tryMoveToXYZ(targetX, targetY, targetZ, mob.randomMotionSpeed);
				found_path = ! (this.mob.getNavigator().noPath());
				}
		}
	

}