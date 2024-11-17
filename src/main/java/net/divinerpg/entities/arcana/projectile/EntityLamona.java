package net.divinerpg.entities.arcana.projectile;

import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityLamona extends EntityThrowable {
	
	public EntityLamona(World var1) {
		super(var1);
	}

	public EntityLamona(World var1, EntityLivingBase var2) {
		super(var1, var2);
	}

	public EntityLamona(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		addLight();
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(!this.worldObj.isRemote) {
			this.setDead();
			
		}
	}
	
	private void addLight() {
    	this.worldObj.setLightValue(EnumSkyBlock.Block, (int)this.posX, (int)this.posY, (int)this.posZ, 15);
        this.worldObj.markBlockRangeForRenderUpdate((int)this.posX, (int)this.posY, (int)this.posX, 12, 12, 12);
        this.worldObj.markBlockForUpdate((int)this.posX, (int)this.posY, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY +1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY +1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY +1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY +1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY +1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY +1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY +1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY +1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY +1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY -1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY -1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY -1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY -1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY -1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY -1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY -1, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY -1, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY -1, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX +1, (int)this.posY, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY, (int)this.posZ -1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX -1, (int)this.posY, (int)this.posZ);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY, (int)this.posZ +1);
        this.worldObj.updateLightByType(EnumSkyBlock.Block, (int)this.posX, (int)this.posY, (int)this.posZ -1);
    }

}