package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class VetheaMob extends EntityDivineRPGMob {
	
	public VetheaMob(World w){
		super(w);
	}
	
	public abstract int getSpawnLayer();

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIAttackMelee(this, 1, true));
		this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
    public boolean getCanSpawnHere() {
		int spawnLayer = this.getSpawnLayer();

		if(spawnLayer == 0) {
			return super.getCanSpawnHere();
		}
		else {
			return this.posY < 48.0D * spawnLayer  && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
		}
    }
}