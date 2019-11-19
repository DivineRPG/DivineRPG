package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import net.minecraft.world.World;

public abstract class VetheaMob extends EntityDivineRPGMob {
	
	public VetheaMob(World w){
		super(w);
	}
	
	public abstract int getSpawnLayer();
	
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