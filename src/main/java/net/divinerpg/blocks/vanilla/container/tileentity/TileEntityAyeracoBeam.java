package net.divinerpg.blocks.vanilla.container.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityAyeracoBeam extends TileEntity {
	
    @SideOnly(Side.CLIENT)
    private long time;
    @SideOnly(Side.CLIENT)
    private float beam;
    public ResourceLocation texture;
    
    public TileEntityAyeracoBeam(ResourceLocation tex) {
		texture = tex;
	}
    
    public TileEntityAyeracoBeam() {
        
    }
    
    @SideOnly(Side.CLIENT)
    public float renderBeam() {
    	int var1 = (int)(this.worldObj.getTotalWorldTime() - this.time);
    	this.time = this.worldObj.getTotalWorldTime();

    	if(var1 > 1) {
    		this.beam -= (float)var1 / 40.0F;
    		if(this.beam < 0.0F) 
    			this.beam = 0.0F;
    	}

    	this.beam += 0.025F;

    	if(this.beam > 1.0F) 
    		this.beam = 1.0F;

    	return this.beam;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbttagcompound);
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setString("texture", this.texture.toString());
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        texture = new ResourceLocation(tag.getString("texture"));
    }
}