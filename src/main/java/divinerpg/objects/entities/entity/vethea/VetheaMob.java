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
        return this.posY < 48.0D * this.getSpawnLayer()  && this.posY > 48.0D * (this.getSpawnLayer() - 1) && super.getCanSpawnHere();
    }

}