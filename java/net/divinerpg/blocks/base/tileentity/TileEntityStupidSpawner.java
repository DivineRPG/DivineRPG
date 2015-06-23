package net.divinerpg.blocks.base.tileentity;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityStupidSpawner extends TileEntity {
	
	private String entityName;
	private int spawnTimer;
	private boolean spawnParticles = false;
	private Random rand = new Random();

	@Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.entityName = tag.getString("EntityName");
    }

	@Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setString("EntityName", this.entityName);
    }

	@Override
    public void updateEntity() {
        super.updateEntity();
        if(this.worldObj.isRemote) {
        	if (this.spawnParticles) {
		        for(int n = 0; n < 3; n++) {
		        	DivineRPG.proxy.spawnParticle(this.worldObj, this.xCoord+0.5, this.yCoord+0.5, this.zCoord+0.5, "blackFlame", true, 3);
		        }
        	}
        } else if (this.worldObj.getClosestPlayer(this.xCoord+0.5D, this.yCoord+0.5D, this.zCoord+0.5D, 16D) != null) {
        	if(this.spawnTimer > 0) this.spawnTimer--;
        	if(this.spawnTimer == 0) {
        		int c = this.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord+1, this.yCoord+1, this.zCoord+1).expand(8, 6, 8)).size();
        		if (c < 8) {
        			for(int i = 0; i < 4; i++) {
                		Entity e = EntityList.createEntityByName(this.entityName, this.worldObj);
        				if (e != null) {
        					int x = this.xCoord + this.rand.nextInt(9) - 4;
            				int y = this.yCoord + this.rand.nextInt(3) - 1;
            				int z = this.zCoord + this.rand.nextInt(9) - 4;
                			AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x+e.boundingBox.minX, y+e.boundingBox.minY, z+e.boundingBox.minZ, x+e.boundingBox.maxX, y+e.boundingBox.maxY, z+e.boundingBox.maxZ);
            				if (this.worldObj.checkNoEntityCollision(boundingBox) && this.worldObj.getCollidingBoundingBoxes(e, boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(boundingBox)) {
            					e.setLocationAndAngles(x, y, z, this.rand.nextInt(360), 0);
            					this.worldObj.spawnEntityInWorld(e);
            				}
        				}
        			}
        		}
        		this.spawnTimer = 300;
        	}
        }
    }
    
    public void setEntityName(String name) {
    	this.entityName = name;
    }

    public void setSpawnParticles(boolean spawnParticles) {
    	this.spawnParticles = spawnParticles;
    }
}
