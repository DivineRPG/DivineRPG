package net.divinerpg.utils;

import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerUtil implements IExtendedEntityProperties {

	private final EntityPlayer player;
	private static final String NAME = "DRPGPlayerUtils";
	public boolean seen = false;
	
	public PlayerUtil(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {}

	@Override
	public void loadNBTData(NBTTagCompound n) {}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NAME, new PlayerUtil(player));
	}
	
	public static PlayerUtil getProperties(EntityPlayer player) {
		return (PlayerUtil) player.getExtendedProperties(NAME);
	}

    @Override
	public void init(Entity entity, World world) {}
}