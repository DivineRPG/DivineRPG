package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineMob;
import net.minecraft.world.World;

public abstract class VetheaMob extends EntityDivineMob {
	
	public VetheaMob(World w){
		super(w);
	}
	
	public abstract int getSpawnLayer();
	
	@Override
    public boolean getCanSpawnHere() {
        return this.posY < 48.0D * this.getSpawnLayer()  && this.posY > 48.0D * (this.getSpawnLayer() - 1) && super.getCanSpawnHere();
    }

}