package net.divinerpg.api.entity.tileentity;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.entities.arcana.EntityRoamer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityStupidSpawner extends TileEntity {
	
	private String entityName;
	private int spawnTimer;
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
        for(int n = 0; n < 3; n++) {
        	DivineRPG.proxy.spawnParticle(this.worldObj, this.xCoord+0.5, this.yCoord+0.5, this.zCoord+0.5, "blackFlame", true, 3);
        }
        if(!this.worldObj.isRemote) {
        	//System.out.println(this.spawnTimer);
        	if(this.spawnTimer > 0) this.spawnTimer--;
        	if(this.spawnTimer == 0) {
        		int c = this.worldObj.getEntitiesWithinAABB(EntityRoamer.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord+1, this.yCoord+1, this.zCoord+1).expand(8, 6, 8)).size();

        		if(c < 8) {
        			for(int x = -4; x <= 4; x++) {
        				for(int y = -2; y <= 4; y++) {
        					for(int z = -4; z <= 4; z++) {
        						if(this.yCoord+y > 0 && this.worldObj.getBlock(this.xCoord+x, this.yCoord+y, this.zCoord+z) == Blocks.air && this.worldObj.getBlock(this.xCoord+x, this.yCoord+y+1, this.zCoord+z) == Blocks.air && this.worldObj.getBlock(this.xCoord+x, this.yCoord+y-1, this.zCoord+z) != Blocks.air && this.rand.nextInt(20) == 0) {
        							Entity e = EntityList.createEntityByName(this.entityName, this.worldObj);
        							if(e != null) {
        								e.setLocationAndAngles(this.xCoord+x, this.yCoord+y, this.zCoord+z, this.rand.nextInt(360), 0);
        								this.worldObj.spawnEntityInWorld(e);
        				            	System.out.println("HI");
        							}
        						}
        					}
        				}
        			}
        		}
        		this.spawnTimer = 50;
        	}
        }
    }
    
    public void setEntityName(String name) {
    	this.entityName = name;
    }
}