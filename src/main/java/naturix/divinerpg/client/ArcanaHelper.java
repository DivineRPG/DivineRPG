package naturix.divinerpg.client;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.networking.message.MessageArcanaBar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ArcanaHelper implements ICapabilitySerializable<NBTTagCompound> {
	private final EntityPlayer player;
	public static final String NAME = "Arcana";
    private float barValue;
    public int regenDelay;
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
	}
	


	public void updateAllBars() {
		if(barValue != 200F){
			regen(1);
		} else {
			regen(0);
		}
		if(barValue >= 200F){
			barValue = 200F;
		}
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
	}                

	public boolean useBar(float amount) {
		if(barValue < amount) {
			regenDelay = 50;
			return false;
		}
		barValue -= amount;
		regenDelay = 50;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
		return true;
	}

	public void regen(float amount) {
		if(regenDelay == 0) {
			barValue += amount;
		} else {
			regenDelay--;
		}
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
	}
	
	public void forceRegen(float amount) {
		barValue += amount;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
	}

	public float getBarValue() {
		return barValue;
	}

	public void setBarValue(float i) {
		barValue = i;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
	}
	
	public void removeValue(float i) {
		regenDelay = 50;
		barValue -= i;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue, regenDelay == 0), (EntityPlayerMP)player);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
	tag.setFloat("ArcanaBarValue", barValue);
	tag.setInteger("ArcanaRegenDelay", regenDelay);
    player.getEntityData().setTag(player.PERSISTED_NBT_TAG, tag);
		return null;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		NBTTagCompound tag = (NBTTagCompound) player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
		if(!tag.hasKey("ArcanaBarValue"))return;
		barValue = tag.getFloat("ArcanaBarValue");
		regenDelay = tag.getInteger("ArcanaRegenDelay");
        player.getEntityData().setTag(player.PERSISTED_NBT_TAG, tag);
	}

}