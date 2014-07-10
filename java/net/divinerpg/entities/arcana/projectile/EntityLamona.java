package net.divinerpg.entities.arcana.projectile;

import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLamona extends EntityThrowable {
	
	public EntityLamona(World var1) {
		super(var1);
	}

	public EntityLamona(World var1, EntityLiving var2) {
		super(var1, var2);
	}

	public EntityLamona(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();

		if(this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ).getMaterial() == Material.air) {	
			this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, ArcanaBlocks.blockOfLight);
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}