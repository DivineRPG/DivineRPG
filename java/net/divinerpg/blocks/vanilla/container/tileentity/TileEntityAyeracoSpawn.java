package net.divinerpg.blocks.vanilla.container.tileentity;

import net.divinerpg.entities.vanilla.EntityAyeracoBlue;
import net.divinerpg.entities.vanilla.EntityAyeracoGreen;
import net.divinerpg.entities.vanilla.EntityAyeracoPurple;
import net.divinerpg.entities.vanilla.EntityAyeracoRed;
import net.divinerpg.entities.vanilla.EntityAyeracoYellow;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;

public class TileEntityAyeracoSpawn extends TileEntity {
	
	private int spawnTick;
    
    public TileEntityAyeracoSpawn() {
		this.spawnTick = 600;
	}
    
    public void updateEntity() {
    	super.updateEntity();
        if(!this.worldObj.isRemote) {
			if (this.spawnTick == 600) {
			    Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.GREEN, "The Green Ayeraco Has Been Called Upon"));
				this.worldObj.setBlock((int)(this.xCoord + 8), (int)(this.yCoord),(int)(this.zCoord + 8), VanillaBlocks.ayeracoBeamGreen);
		    } else if (this.spawnTick == 430) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.BLUE, "The Blue Ayeraco Has Been Called Upon"));
				this.worldObj.setBlock((int)(this.xCoord + 15), (int)(this.yCoord),(int)(this.zCoord), VanillaBlocks.ayeracoBeamBlue);
		    } else if (this.spawnTick == 300) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.RED, "The Red Ayeraco Has Been Called Upon"));
				this.worldObj.setBlock((int)(this.xCoord + 5), (int)(this.yCoord),(int)(this.zCoord - 12), VanillaBlocks.ayeracoBeamRed);
		    } else if (this.spawnTick == 210) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.YELLOW, "The Yellow Ayeraco Has Been Called Upon"));
				this.worldObj.setBlock((int)(this.xCoord - 5), (int)(this.yCoord),(int)(this.zCoord - 12), VanillaBlocks.ayeracoBeamYellow);
		    } else if (this.spawnTick == 145) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "The Purple Ayeraco Has Been Called Upon"));
				this.worldObj.setBlock((int)(this.xCoord - 8), (int)(this.yCoord),(int)(this.zCoord + 8), VanillaBlocks.ayeracoBeamPurple);
		    } else if (this.spawnTick == 0) {
				EntityAyeracoBlue ayercoBlue = new EntityAyeracoBlue(this.worldObj);
				EntityAyeracoGreen ayercoGreen = new EntityAyeracoGreen(this.worldObj);
				EntityAyeracoRed ayercoRed = new EntityAyeracoRed(this.worldObj);
				EntityAyeracoYellow ayercoYellow = new EntityAyeracoYellow(this.worldObj);
				EntityAyeracoPurple ayercoPurple = new EntityAyeracoPurple(this.worldObj);

				ayercoBlue.setLocationAndAngles(this.xCoord + 15, this.yCoord + 4, this.zCoord, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoGreen.setLocationAndAngles(this.xCoord + 8, this.yCoord + 4, this.zCoord + 8, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoRed.setLocationAndAngles(this.xCoord + 5, this.yCoord + 4, this.zCoord - 12, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoYellow.setLocationAndAngles(this.xCoord - 5, this.yCoord + 4, this.zCoord - 12, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoPurple.setLocationAndAngles(this.xCoord - 8, this.yCoord + 4, this.zCoord + 8, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

				ayercoBlue.initOthers(ayercoGreen, ayercoRed, ayercoYellow, ayercoPurple);
				ayercoGreen.initOthers(ayercoBlue, ayercoRed, ayercoYellow, ayercoPurple);
				ayercoRed.initOthers(ayercoBlue, ayercoGreen, ayercoYellow, ayercoPurple);
				ayercoYellow.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoPurple);
				ayercoPurple.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoYellow);

				ayercoBlue.setBeamLocation((int)(this.xCoord + 15), (int)(this.yCoord),(int)(this.zCoord));
				ayercoGreen.setBeamLocation((int)(this.xCoord + 8), (int)(this.yCoord),(int)(this.zCoord + 8));
				ayercoRed.setBeamLocation((int)(this.xCoord + 5), (int)(this.yCoord),(int)(this.zCoord - 12));
				ayercoYellow.setBeamLocation((int)(this.xCoord - 5), (int)(this.yCoord),(int)(this.zCoord - 12));
				ayercoPurple.setBeamLocation((int)(this.xCoord - 8), (int)(this.yCoord),(int)(this.zCoord + 8));

				this.worldObj.spawnEntityInWorld(ayercoBlue);
				this.worldObj.spawnEntityInWorld(ayercoGreen);
				this.worldObj.spawnEntityInWorld(ayercoRed);
				this.worldObj.spawnEntityInWorld(ayercoYellow);
				this.worldObj.spawnEntityInWorld(ayercoPurple);
				Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.AQUA, "The Ayeraco Horde Has Arrived!"));
		    }
	        if (this.spawnTick > 0) {
	        	this.spawnTick--;
	        } else {
				this.invalidate();
	        }
        }
    }
}