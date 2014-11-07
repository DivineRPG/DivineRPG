package net.divinerpg.entities.vanilla.projectile;

import net.divinerpg.entities.vanilla.EntityFrost;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFrostShot extends EntityThrowable{

	public EntityFrostShot(World w) {
		super(w);
	}
	
	public EntityFrostShot(World w, double i, double j, double k) {
		super(w);
		this.setThrowableHeading(i, j, k, 0, 0);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1) {
		if(par1.entityHit != null && !(par1.entityHit instanceof EntityFrost)){
			par1.entityHit.attackEntityFrom(DamageSource.onFire, 10f);
		}else{
			this.worldObj.setBlock(par1.blockX, par1.blockY+1, par1.blockZ, Blocks.fire);
		}
		this.setDead();
	}
}
