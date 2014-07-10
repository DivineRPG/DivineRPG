package net.divinerpg.dimensions.vethea.all;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;

public class WorldAddition  {
	
	private static World world = Minecraft.getMinecraft().theWorld;
	
	public static boolean setBlockWithMetadata(int x, int y, int z, Block BlockID, int MetaData) {
		return world.setBlock(x, y, z, BlockID, MetaData, 2);
	}
}