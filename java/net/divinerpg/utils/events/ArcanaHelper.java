package net.divinerpg.utils.events;

import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ArcanaHelper implements IExtendedEntityProperties {

	private final EntityPlayer player;
	private static final String NAME = "Arcana";
    private double returnPortalX;
    private double returnPortalY;
    private double returnPortalZ;
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
		player.getDataWatcher().addObject(ConfigurationHelper.barValue, 0F);  //Arcana ConfigurationHelper.barValue
		player.getDataWatcher().addObject(ConfigurationHelper.barRegen, 1);   //Regen delay
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setFloat("ConfigurationHelper.barValue", this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue));
		tag.setInteger("RegenDelay", this.player.getDataWatcher().getWatchableObjectInt(ConfigurationHelper.barRegen));
        tag.setDouble("returnPortalX", returnPortalX);
        tag.setDouble("returnPortalY", returnPortalY);
        tag.setDouble("returnPortalZ", returnPortalZ);
		n.setTag(NAME, tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = (NBTTagCompound) n.getTag(NAME);
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, tag.getFloat("ConfigurationHelper.barValue"));
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barRegen, tag.getInteger("RegenDelay"));
        this.returnPortalX = tag.getDouble("returnPortalX");
        this.returnPortalY = tag.getDouble("returnPortalY");
        this.returnPortalZ = tag.getDouble("returnPortalZ");
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NAME, new ArcanaHelper(player));
	}
	
	public static ArcanaHelper getProperties(EntityPlayer player) {
		return (ArcanaHelper) player.getExtendedProperties(NAME);
	}

	public void updateAllBars() {
		if(this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) != 200F){
			regen(1);
		} else {
			regen(0);
		}
		if(this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) >= 200F){
			this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, 200F);
		}
	}                

	public boolean useBar(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) < amount) {
			this.player.getDataWatcher().updateObject(ConfigurationHelper.barRegen, 50);
			return false;
		}
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) - amount);
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barRegen, 50);
		return true;
	}

	public void regen(float amount) {
		if(this.player.getDataWatcher().getWatchableObjectInt(ConfigurationHelper.barRegen) == 0) {
			this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) + amount);
		} else {
			this.player.getDataWatcher().updateObject(ConfigurationHelper.barRegen, this.player.getDataWatcher().getWatchableObjectInt(ConfigurationHelper.barRegen) - 1);
		}
	}

	public float getBarValue() {
		return this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue);
	}

	public void setBarValue(float i) {
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, i);
	}
	
	public void removeValue(float i) {
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barRegen, 50);
		this.player.getDataWatcher().updateObject(ConfigurationHelper.barValue, this.player.getDataWatcher().getWatchableObjectFloat(ConfigurationHelper.barValue) - i);
	}

    public void setReturnPortalX(double x) {
        this.returnPortalX = x;
    }

    public double getReturnPortalX() {
        return this.returnPortalX;
    }

    public void setReturnPortalY(double y) {
        this.returnPortalY = y;
    }

    public double getReturnPortalY() {
        return this.returnPortalY;
    }

    public void setReturnPortalZ(double z) {
        this.returnPortalZ = z;
    }

    public double getReturnPortalZ() {
        return this.returnPortalZ;
    }

    @Override
	public void init(Entity entity, World world) {}
}