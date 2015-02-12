package net.divinerpg.utils.events;

import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ArcanaHelper implements IExtendedEntityProperties {

	private final EntityPlayer player;
	private static final String NAME = "ArcanaBar";
	
	private static int value = ConfigurationHelper.barValue;
	private static int regen = ConfigurationHelper.barRegen;
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
		player.getDataWatcher().addObject(value, 0F);//Arcana value
		player.getDataWatcher().addObject(regen, 1);//Regen delay
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setFloat("Value", this.player.getDataWatcher().getWatchableObjectFloat(value));
		tag.setInteger("RegenDelay", this.player.getDataWatcher().getWatchableObjectInt(regen));
		n.setTag(NAME, tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = (NBTTagCompound) n.getTag(NAME);
		this.player.getDataWatcher().updateObject(value, tag.getFloat("Value"));
		this.player.getDataWatcher().updateObject(regen, tag.getInteger("RegenDelay"));
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NAME, new ArcanaHelper(player));
	}
	
	public static ArcanaHelper getProperties(EntityPlayer player) {
		return (ArcanaHelper) player.getExtendedProperties(NAME);
	}

	public void updateAllBars() {
		if(this.player.getDataWatcher().getWatchableObjectFloat(value) != 200F){
			regen(1);
		} else {
			regen(0);
		}
		if(this.player.getDataWatcher().getWatchableObjectFloat(value) >= 200F){
			this.player.getDataWatcher().updateObject(value, 200F);
		}
	}                

	public boolean useBar(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectFloat(value) < amount) {
			this.player.getDataWatcher().updateObject(regen, 50);
			return false;
		}
		this.player.getDataWatcher().updateObject(value, this.player.getDataWatcher().getWatchableObjectFloat(value) - amount);
		this.player.getDataWatcher().updateObject(regen, 50);
		return true;
	}

	public void regen(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectInt(regen) == 0) {
			this.player.getDataWatcher().updateObject(value, this.player.getDataWatcher().getWatchableObjectFloat(value) + amount);
		} else {
			this.player.getDataWatcher().updateObject(regen, this.player.getDataWatcher().getWatchableObjectInt(regen) - 1);
		}
	}

	public float getBarValue() {
		return this.player.getDataWatcher().getWatchableObjectFloat(value);
	}

	public void setBarValue(float i) {
		this.player.getDataWatcher().updateObject(value, i);
	}
	
	public void removeBarValue(float i) {
		this.player.getDataWatcher().updateObject(regen, 50);
		this.player.getDataWatcher().updateObject(value, this.player.getDataWatcher().getWatchableObjectFloat(value) - i);
	}

	@Override
	public void init(Entity entity, World world) {}
}