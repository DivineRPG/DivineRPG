package net.divinerpg.utils.events;

import net.divinerpg.DivineRPG;
import net.divinerpg.network.MessageArcanaBar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ArcanaHelper implements IExtendedEntityProperties {

	private final EntityPlayer player;
	public static final String NAME = "Arcana";
    private float barValue;
    public int regenDelay;
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
		tag.setFloat("ArcanaBarValue", barValue);
		tag.setInteger("ArcanaRegenDelay", regenDelay);
        player.getEntityData().setTag(player.PERSISTED_NBT_TAG, tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = (NBTTagCompound) player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
		if(!tag.hasKey("ArcanaBarValue"))return;
		barValue = tag.getFloat("ArcanaBarValue");
		regenDelay = tag.getInteger("ArcanaRegenDelay");
        player.getEntityData().setTag(player.PERSISTED_NBT_TAG, tag);
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NAME, new ArcanaHelper(player));
	}
	
	public static ArcanaHelper getProperties(EntityPlayer player) {
		return (ArcanaHelper) player.getExtendedProperties(NAME);
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
	public void init(Entity entity, World world) {}
}