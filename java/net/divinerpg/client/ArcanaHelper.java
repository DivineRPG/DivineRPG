package net.divinerpg.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;


public class ArcanaHelper implements IExtendedEntityProperties {

	private static int arcana = 0;
	private static int regenDelay = 0;

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("Arcana", arcana);
		n.setInteger("Regen", regenDelay);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.arcana = n.getInteger("Arcana");
		this.regenDelay = n.getInteger("Regen");
	}

	public static void updateAllBars() {
		if(arcana != 200){
			regen(1);
		} else {
			regen(0);
		}
		if(arcana >= 200){
			arcana = 200;
		}
	}                

	public static boolean useBar(int amount) {
		if(arcana < amount) {
			regenDelay = 50;
			return false;
		}
		arcana -= amount;
		regenDelay = 50;
		return true;
	}

	public static void regen(int par1) {
		if(regenDelay == 0) {
			arcana += par1;
		} else {
			regenDelay -= 1;
		}
	}

	public static float getBarValue() {
		return arcana;
	}

	public static void setBarValue(int i) {
		arcana += i;
	}
	
	public static void removeBarValue(int i) {
		regenDelay = 50;
		arcana -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}