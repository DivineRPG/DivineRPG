package net.divinerpg.items.vanilla;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.potion.PotionEffect;

public class ItemTeleportationCrystal extends ItemMod {
	
	public ItemTeleportationCrystal() {
		super("teleportationCrystal");
		setCreativeTab(DivineRPGTabs.utility);
		setMaxStackSize(1);
		setMaxDamage(10);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player instanceof EntityPlayerMP && !player.isRiding()) {
		    EntityPlayerMP playerMP = (EntityPlayerMP)player;
		    if (player.dimension != 0) {
		        transferPlayerToDimension(playerMP, 0);
		    } else {
		        ServerConfigurationManager configManager = playerMP.mcServer.getConfigurationManager();
		        movePlayerToSpawn(playerMP, configManager.getServerInstance().worldServerForDimension(0));
		    }
            player.setPositionAndUpdate(player.posX, player.posY, player.posZ);
            if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
		}
		return stack;
	}
	
	public static void transferPlayerToWorld(EntityPlayerMP player, WorldServer oldWorld, WorldServer newWorld) {
        double moveFactor = oldWorld.provider.getMovementFactor() / newWorld.provider.getMovementFactor();
        double x = player.posX * moveFactor;
        double z = player.posZ * moveFactor;
        x = MathHelper.clamp_double(x, -29999872, 29999872);
        z = MathHelper.clamp_double(z, -29999872, 29999872);
        if (player.isEntityAlive()) {
            player.setLocationAndAngles(x, player.posY, z, player.rotationYaw, player.rotationPitch);
            newWorld.spawnEntityInWorld(player);
            newWorld.updateEntityWithOptionalForce(player, false);
        }
        player.setWorld(newWorld);
	}
	 
	public static void movePlayerToSpawn(EntityPlayerMP player, WorldServer worldServer)
	{
        ChunkCoordinates bedSpawn = player.getBedLocation(0);
        if (bedSpawn != null) {
            ChunkCoordinates safeBedSpawn = EntityPlayer.verifyRespawnCoordinates(worldServer, bedSpawn, true);
            if (safeBedSpawn != null) {
                player.setLocationAndAngles((double)((float)safeBedSpawn.posX + 0.5F), (double)((float)safeBedSpawn.posY + 0.1F), (double)((float)safeBedSpawn.posZ + 0.5F), 0.0F, 0.0F);
                player.setSpawnChunk(bedSpawn, true);
            } else {
                player.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(0, 0.0F));
            }
        } else {
            ChunkCoordinates worldSpawn = worldServer.getSpawnPoint();
            player.setLocationAndAngles((double)((float)worldSpawn.posX + 0.5F), (double)((float)worldSpawn.posY + 0.1F), (double)((float)worldSpawn.posZ + 0.5F), 0.0F, 0.0F);
        }
        worldServer.theChunkProviderServer.loadChunk((int)player.posX >> 4, (int)player.posZ >> 4);
        while (!worldServer.getCollidingBoundingBoxes(player, player.boundingBox).isEmpty()) {
            player.setPosition(player.posX, player.posY + 1.0D, player.posZ);
        } 
	}
	
	public static void transferPlayerToDimension(EntityPlayerMP player, int newDimension)
    {
        ServerConfigurationManager configManager = player.mcServer.getConfigurationManager();
        int oldDimension = player.dimension;

        WorldServer oldWorldServer = configManager.getServerInstance().worldServerForDimension(oldDimension);
        WorldServer newWorldServer = configManager.getServerInstance().worldServerForDimension(0);

        player.dimension = newDimension;
        player.playerNetServerHandler.sendPacket(new S07PacketRespawn(player.dimension, player.worldObj.difficultySetting, player.worldObj.getWorldInfo().getTerrainType(), player.theItemInWorldManager.getGameType()));
        oldWorldServer.removePlayerEntityDangerously(player);
        player.isDead = false;

        transferPlayerToWorld(player, oldWorldServer, newWorldServer);
        configManager.func_72375_a(player, oldWorldServer);

        movePlayerToSpawn(player, newWorldServer);

        player.playerNetServerHandler.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
        player.theItemInWorldManager.setWorld(newWorldServer);
        configManager.updateTimeAndWeatherForPlayer(player, newWorldServer);
        configManager.syncPlayerInventory(player);
        Iterator<PotionEffect> iterator = player.getActivePotionEffects().iterator();
        while (iterator.hasNext()) {
            PotionEffect potioneffect = iterator.next();
            player.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(player.getEntityId(), potioneffect));
        }
        FMLCommonHandler.instance().firePlayerChangedDimensionEvent(player, oldDimension, newDimension);
    }

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Teleport to spawn point");
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage()-stack.getItemDamage()));
	}
}
