package net.divinerpg.utils.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;


public class ArcanaHelper implements IExtendedEntityProperties {

	private final EntityPlayer player;
	private static final String NAME = "ArcanaBar";
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
		player.getDataWatcher().addObject(27, 0F);//Arcana value
		player.getDataWatcher().addObject(28, 1);//Regen delay
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setFloat("Value", this.player.getDataWatcher().getWatchableObjectFloat(27));
		tag.setInteger("RegenDelay", this.player.getDataWatcher().getWatchableObjectInt(28));
		n.setTag(NAME, tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = (NBTTagCompound) n.getTag(NAME);
		this.player.getDataWatcher().updateObject(27, tag.getFloat("Value"));
		this.player.getDataWatcher().updateObject(28, tag.getInteger("RegenDelay"));
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NAME, new ArcanaHelper(player));
	}
	
	public static ArcanaHelper getProperties(EntityPlayer player) {
		return (ArcanaHelper) player.getExtendedProperties(NAME);
	}

	public void updateAllBars() {
		if(this.player.getDataWatcher().getWatchableObjectFloat(27) != 200F){
			regen(1);
		} else {
			regen(0);
		}
		if(this.player.getDataWatcher().getWatchableObjectFloat(27) >= 200F){
			this.player.getDataWatcher().updateObject(27, 200F);
		}
	}                

	public boolean useBar(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectFloat(27) < amount) {
			this.player.getDataWatcher().updateObject(28, 50);
			return false;
		}
		this.player.getDataWatcher().updateObject(27, this.player.getDataWatcher().getWatchableObjectFloat(27) - amount);
		this.player.getDataWatcher().updateObject(28, 50);
		return true;
	}

	public void regen(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectInt(28) == 0) {
			this.player.getDataWatcher().updateObject(27, this.player.getDataWatcher().getWatchableObjectFloat(27) + amount);
		} else {
			this.player.getDataWatcher().updateObject(28, this.player.getDataWatcher().getWatchableObjectInt(28) - 1);
		}
	}

	public float getBarValue() {
		return this.player.getDataWatcher().getWatchableObjectFloat(27);
	}

	public void setBarValue(float i) {
		this.player.getDataWatcher().updateObject(27, i);
	}
	
	public void removeBarValue(float i) {
		this.player.getDataWatcher().updateObject(28, 50);
		this.player.getDataWatcher().updateObject(27, this.player.getDataWatcher().getWatchableObjectFloat(27) - i);
	}

	@Override
	public void init(Entity entity, World world) {}
}