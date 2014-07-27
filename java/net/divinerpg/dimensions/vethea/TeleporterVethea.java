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

public class TeleporterVethea extends Teleporter {
	private final WorldServer worldServerInstance;
	private final Random random;
	private final LongHashMap destinationCoordinateCache = new LongHashMap();
	private final List destinationCoordinateKeys = new ArrayList();

	public TeleporterVethea(WorldServer par1WorldServer) {
		super(par1WorldServer);
		this.worldServerInstance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

	public void placeInPortal(EntityPlayer player, double x, double y, double z, float par8) {
		int dim = player.worldObj.provider.dimensionId;
		if(dim != ConfigurationHelper.vethea) {
			x = getRandomIntegerBetween((int) x - 16, (int) x + 16);
			z = getRandomIntegerBetween((int) z - 16, (int) z + 16);
			int x1 = (int)x, z1 = (int)z;
			if(player.worldObj.getBlock(x1, (int)y+2, z1) != Blocks.air) {
				for(int i = 0; player.worldObj.getBlock(x1, (int)y+2, z1) != Blocks.air; x1++) {
					z1++;
				}
				x = x1;
				z = z1;
			}
			player.setLocationAndAngles(x, 20, z, player.rotationYaw, 0.0F);
			player.motionX = player.motionY = player.motionZ = 0.0D;
		} else {
			if(worldServerInstance.provider.dimensionId == ConfigurationHelper.vethea) {
				player.travelToDimension(0);
				ChunkCoordinates bed = player.getBedLocation(0);
				if(bed == null) {
					bed = worldServerInstance.getSpawnPoint();
				}
				player.posX = bed.posX;
				player.posY = bed.posY;
				player.posZ = bed.posZ;
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