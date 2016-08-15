package net.divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterVetheaToOverworld extends Teleporter {
	private final WorldServer worldServerInstance;
	private final Random random;
	private final LongHashMap destinationCoordinateCache = new LongHashMap();
	private final List destinationCoordinateKeys = new ArrayList();

	public TeleporterVetheaToOverworld(WorldServer par1WorldServer) {
		super(par1WorldServer);
		this.worldServerInstance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

	public void placeInPortal(EntityPlayer player, double x, double y, double z, float par8) {
		if(worldServerInstance.provider.dimensionId == 0) {
			ChunkCoordinates bed = player.getBedLocation(0);
			if(bed == null) {
				bed = worldServerInstance.getSpawnPoint();
			}
			for(int i = bed.posY; i < 255; i++) {
				if(worldServerInstance.getBlock(bed.posX, i, bed.posZ) == Blocks.air && (worldServerInstance.getBlock(bed.posX, i-1, bed.posZ) != Blocks.air || i == bed.posY)) {
					player.setPositionAndUpdate(bed.posX, i, bed.posZ);
					break;
				}
			}
		}
	}

	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float par8) {
		if(entity instanceof EntityPlayer) {
			placeInPortal((EntityPlayer) entity, x, y, z, par8);
		}
	}

	@Override
	public boolean makePortal(Entity par1Entity) {
		return true;
	}
	
	private static int getRandomIntegerBetween(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) - min;
	}
}