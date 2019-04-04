package naturix.divinerpg.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class ItemTeleporter extends Teleporter {
EntityPlayer playerIn;

public ItemTeleporter(WorldServer worldIn) {
	super(worldIn);
	// TODO Auto-generated constructor stub
}

public void transferEntityToWorld(Entity entityIn, int lastDimension, WorldServer oldWorldIn, WorldServer toWorldIn,
        net.minecraft.world.Teleporter teleporter) {
	net.minecraft.world.WorldProvider pOld = oldWorldIn.provider;
	net.minecraft.world.WorldProvider pNew = toWorldIn.provider;
	double moveFactor = pOld.getMovementFactor() / pNew.getMovementFactor();

	double d0 = playerIn.getBedLocation().getX() * moveFactor;
	double d1 = playerIn.getBedLocation().getZ() * moveFactor;
	float f = entityIn.rotationYaw;
	oldWorldIn.profiler.startSection("moving");

	oldWorldIn.profiler.startSection("placing");
	d0 = MathHelper.clamp((int) d0, -29999872, 29999872);
	d1 = MathHelper.clamp((int) d1, -29999872, 29999872);

	if (entityIn.isEntityAlive()) {
		entityIn.setLocationAndAngles(d0, playerIn.getBedLocation().getY(), d1, entityIn.rotationYaw,
		        entityIn.rotationPitch);
		teleporter.placeInPortal(entityIn, f);
		toWorldIn.spawnEntity(entityIn);
		toWorldIn.updateEntityWithOptionalForce(entityIn, false);
	}

	oldWorldIn.profiler.endSection();

	entityIn.setWorld(toWorldIn);
}

public void transferPlayerToDimension(EntityPlayerMP player, int dimensionIn) {
	int i = player.dimension;
	MinecraftServer mcServer = player.getServer();
	WorldServer worldserver = mcServer.getWorld(player.dimension);
	PlayerList playerList = mcServer.getPlayerList();

	player.dimension = dimensionIn;
	WorldServer worldserver1 = mcServer.getWorld(player.dimension);
	player.connection.sendPacket(new SPacketRespawn(player.dimension, worldserver1.getDifficulty(),
	        worldserver1.getWorldInfo().getTerrainType(), player.interactionManager.getGameType()));
	playerList.updatePermissionLevel(player);
	worldserver.removeEntityDangerously(player);
	player.isDead = false;
	transferEntityToWorld(player, i, worldserver, worldserver1, this);
	playerList.preparePlayer(player, worldserver);
	player.connection.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw,
	        player.rotationPitch);
	player.interactionManager.setWorld(worldserver1);
	player.connection.sendPacket(new SPacketPlayerAbilities(player.capabilities));
	playerList.updateTimeAndWeatherForPlayer(player, worldserver1);
	playerList.syncPlayerInventory(player);

	for (PotionEffect potioneffect : player.getActivePotionEffects()) {
		player.connection.sendPacket(new SPacketEntityEffect(player.getEntityId(), potioneffect));
	}
	net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerChangedDimensionEvent(player, i, dimensionIn);
}
}