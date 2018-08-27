package naturix.divinerpg.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityTeakerDisc extends Entity implements IProjectile {

	public EntityTeakerDisc(World world) {
		super(world);
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		
	}

}
