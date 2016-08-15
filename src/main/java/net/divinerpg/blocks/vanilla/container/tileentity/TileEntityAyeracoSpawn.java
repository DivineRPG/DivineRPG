package net.divinerpg.blocks.vanilla.container.tileentity;

import net.divinerpg.entities.vanilla.EntityAyeracoBlue;
import net.divinerpg.entities.vanilla.EntityAyeracoGreen;
import net.divinerpg.entities.vanilla.EntityAyeracoPurple;
import net.divinerpg.entities.vanilla.EntityAyeracoRed;
import net.divinerpg.entities.vanilla.EntityAyeracoYellow;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;

public class TileEntityAyeracoSpawn extends TileEntity {
    
    public class BeamCoords {
        public int beamX;
        public int beamY;
        public int beamZ;

        public BeamCoords() {
            this.beamX = 0;
            this.beamY = 0;
            this.beamZ = 0;
        }

        public boolean equals(Object o) {
            if (!(o instanceof BeamCoords)) {
                return false;
            } else {
                BeamCoords beamCoords = (BeamCoords) o;
                return beamCoords.beamX == this.beamX
                        && beamCoords.beamY == this.beamY
                        && beamCoords.beamZ == this.beamZ;
            }
        }
    }
	
    private BeamCoords greenBeam;
    private BeamCoords blueBeam;
    private BeamCoords redBeam;
    private BeamCoords yellowBeam;
    private BeamCoords purpleBeam;
	public int spawnTick;
    
    public TileEntityAyeracoSpawn() {
        greenBeam = new BeamCoords();
        blueBeam = new BeamCoords();
        redBeam = new BeamCoords();
        yellowBeam = new BeamCoords();
        purpleBeam = new BeamCoords();
		this.spawnTick = 600;
	}
    
    public void updateEntity() {
    	super.updateEntity();
        if(!this.worldObj.isRemote) {
			if (this.spawnTick == 600) {
		        setBeamLocation(greenBeam, 8, 8);
		        setBeamLocation(blueBeam, 15, 0);
		        setBeamLocation(redBeam, 5, -12);
		        setBeamLocation(yellowBeam, -5, -12);
		        setBeamLocation(purpleBeam, -8, 8);

			    Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.GREEN, MessageLocalizer.normal("message.ayeraco.green")));
				this.worldObj.setBlock(greenBeam.beamX, greenBeam.beamY, greenBeam.beamZ, VanillaBlocks.ayeracoBeamGreen);
		    } else if (this.spawnTick == 430) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.BLUE, MessageLocalizer.normal("message.ayeraco.blue")));
				this.worldObj.setBlock(blueBeam.beamX, blueBeam.beamY, blueBeam.beamZ, VanillaBlocks.ayeracoBeamBlue);
		    } else if (this.spawnTick == 300) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.RED, MessageLocalizer.normal("message.ayeraco.red")));
				this.worldObj.setBlock(redBeam.beamX, redBeam.beamY, redBeam.beamZ, VanillaBlocks.ayeracoBeamRed);
		    } else if (this.spawnTick == 210) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.YELLOW, MessageLocalizer.normal("message.ayeraco.yellow")));
				this.worldObj.setBlock(yellowBeam.beamX, yellowBeam.beamY, yellowBeam.beamZ, VanillaBlocks.ayeracoBeamYellow);
		    } else if (this.spawnTick == 145) {
		    	Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, MessageLocalizer.normal("message.ayeraco.purple")));
				this.worldObj.setBlock(purpleBeam.beamX, purpleBeam.beamY, purpleBeam.beamZ, VanillaBlocks.ayeracoBeamPurple);
		    } else if (this.spawnTick == 0) {
                EntityAyeracoGreen ayercoGreen = new EntityAyeracoGreen(this.worldObj);
				EntityAyeracoBlue ayercoBlue = new EntityAyeracoBlue(this.worldObj);
				EntityAyeracoRed ayercoRed = new EntityAyeracoRed(this.worldObj);
				EntityAyeracoYellow ayercoYellow = new EntityAyeracoYellow(this.worldObj);
				EntityAyeracoPurple ayercoPurple = new EntityAyeracoPurple(this.worldObj);

                ayercoGreen.setLocationAndAngles(greenBeam.beamX, greenBeam.beamY + 4, greenBeam.beamZ, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoBlue.setLocationAndAngles(blueBeam.beamX, blueBeam.beamY + 4, blueBeam.beamZ, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoRed.setLocationAndAngles(redBeam.beamX, redBeam.beamY + 4, redBeam.beamZ, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoYellow.setLocationAndAngles(yellowBeam.beamX, yellowBeam.beamY + 4, yellowBeam.beamZ, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				ayercoPurple.setLocationAndAngles(purpleBeam.beamX, purpleBeam.beamY + 4, purpleBeam.beamZ, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

                ayercoGreen.initOthers(ayercoBlue, ayercoRed, ayercoYellow, ayercoPurple);
				ayercoBlue.initOthers(ayercoGreen, ayercoRed, ayercoYellow, ayercoPurple);
				ayercoRed.initOthers(ayercoBlue, ayercoGreen, ayercoYellow, ayercoPurple);
				ayercoYellow.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoPurple);
				ayercoPurple.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoYellow);

                ayercoGreen.setBeamLocation(greenBeam.beamX, greenBeam.beamY, greenBeam.beamZ);
				ayercoBlue.setBeamLocation(blueBeam.beamX, blueBeam.beamY, blueBeam.beamZ);
				ayercoRed.setBeamLocation(redBeam.beamX, redBeam.beamY, redBeam.beamZ);
				ayercoYellow.setBeamLocation(yellowBeam.beamX, yellowBeam.beamY, yellowBeam.beamZ);
				ayercoPurple.setBeamLocation(purpleBeam.beamX, purpleBeam.beamY, purpleBeam.beamZ);

                this.worldObj.spawnEntityInWorld(ayercoGreen);
				this.worldObj.spawnEntityInWorld(ayercoBlue);
				this.worldObj.spawnEntityInWorld(ayercoRed);
				this.worldObj.spawnEntityInWorld(ayercoYellow);
				this.worldObj.spawnEntityInWorld(ayercoPurple);
				Util.sendMessageToAll(Util.addChatMessage(EnumChatFormatting.AQUA, MessageLocalizer.normal("message.ayeraco.spawn")));
		    }
			if(spawnTick == 0)this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.air);
        }
        if (this.spawnTick > 0) {
        	this.spawnTick--;
        }
    }
    
    private void setBeamLocation(BeamCoords beamCoords, int x, int z) {
        beamCoords.beamX = this.xCoord + x;
        beamCoords.beamY = this.yCoord;
        beamCoords.beamZ = this.zCoord + z;
        
        if (this.worldObj.getBlock(beamCoords.beamX, beamCoords.beamY, beamCoords.beamZ) == Blocks.air) {
            while (beamCoords.beamY > 0 && this.worldObj.getBlock(beamCoords.beamX, beamCoords.beamY - 1, beamCoords.beamZ) == Blocks.air) {
                beamCoords.beamY--;
            }
        } else {
            while (beamCoords.beamY < 200 && this.worldObj.getBlock(beamCoords.beamX, beamCoords.beamY, beamCoords.beamZ) != Blocks.air) {
                beamCoords.beamY++;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.spawnTick = tag.getInteger("spawnTick");

        greenBeam.beamX = tag.getInteger("greenBeamX");
        greenBeam.beamY = tag.getInteger("greenBeamY");
        greenBeam.beamZ = tag.getInteger("greenBeamZ");

        blueBeam.beamX = tag.getInteger("blueBeamX");
        blueBeam.beamY = tag.getInteger("blueBeamY");
        blueBeam.beamZ = tag.getInteger("blueBeamZ");

        redBeam.beamX = tag.getInteger("redBeamX");
        redBeam.beamY = tag.getInteger("redBeamY");
        redBeam.beamZ = tag.getInteger("redBeamZ");

        yellowBeam.beamX = tag.getInteger("yellowBeamX");
        yellowBeam.beamY = tag.getInteger("yellowBeamY");
        yellowBeam.beamZ = tag.getInteger("yellowBeamZ");

        purpleBeam.beamX = tag.getInteger("purpleBeamX");
        purpleBeam.beamY = tag.getInteger("purpleBeamY");
        purpleBeam.beamZ = tag.getInteger("purpleBeamZ");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("spawnTick", this.spawnTick);
        
        tag.setInteger("greenBeamX", greenBeam.beamX);
        tag.setInteger("greenBeamY", greenBeam.beamY);
        tag.setInteger("greenBeamZ", greenBeam.beamZ);

        tag.setInteger("blueBeamX", blueBeam.beamX);
        tag.setInteger("blueBeamY", blueBeam.beamY);
        tag.setInteger("blueBeamZ", blueBeam.beamZ);

        tag.setInteger("redBeamX", redBeam.beamX);
        tag.setInteger("redBeamY", redBeam.beamY);
        tag.setInteger("redBeamZ", redBeam.beamZ);

        tag.setInteger("yellowBeamX", yellowBeam.beamX);
        tag.setInteger("yellowBeamY", yellowBeam.beamY);
        tag.setInteger("yellowBeamZ", yellowBeam.beamZ);

        tag.setInteger("purpleBeamX", purpleBeam.beamX);
        tag.setInteger("purpleBeamY", purpleBeam.beamY);
        tag.setInteger("purpleBeamZ", purpleBeam.beamZ);
    }
    
}