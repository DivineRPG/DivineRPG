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
	private static final String NAME = "Arcana";
    private double returnPortalX;
    private double returnPortalY;
    private double returnPortalZ;
    private float barValue;
    private int regenDelay;
	
	public ArcanaHelper(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setFloat("BarValue", barValue);
		tag.setInteger("RegenDelay", regenDelay);
        tag.setDouble("returnPortalX", returnPortalX);
        tag.setDouble("returnPortalY", returnPortalY);
        tag.setDouble("returnPortalZ", returnPortalZ);
		n.setTag(NAME, tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = (NBTTagCompound) n.getTag(NAME);
		barValue = tag.getFloat("BarValue");
		regenDelay = tag.getInteger("RegenDelay");
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
		if(barValue != 200F){
			regen(1);
		} else {
			regen(0);
		}
		if(barValue >= 200F){
			barValue = 200F;
		}
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue), (EntityPlayerMP)player);
	}                

	public boolean useBar(float amount) {
		if(barValue < amount) {
			regenDelay = 50;
			return false;
		}
		barValue -= amount;
		regenDelay = 50;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue), (EntityPlayerMP)player);
		return true;
	}

	public void regen(float amount) {
		if(regenDelay == 0) {
			barValue += amount;
		} else {
			regenDelay--;
		}
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue), (EntityPlayerMP)player);
	}

	public float getBarValue() {
		return barValue;
	}

	public void setBarValue(float i) {
		barValue = i;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue), (EntityPlayerMP)player);
	}
	
	public void removeValue(float i) {
		regenDelay = 50;
		barValue -= i;
		if(player instanceof EntityPlayerMP) DivineRPG.network.sendTo(new MessageArcanaBar(barValue), (EntityPlayerMP)player);
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