package net.divinerpg.utils.events;

import java.util.HashMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.world.BlockEvent;

public class EventEnsureVetheaSpawn {

    @SubscribeEvent
    public void tick(PlayerTickEvent evt) {
        if (!evt.player.worldObj.isRemote && evt.player.dimension == ConfigurationHelper.vethea) {
            HashMap<Integer, ChunkCoordinates> map = Util.getPlayerSpawnChunkMap(evt.player);
            ChunkCoordinates c = map.get(ConfigurationHelper.vethea);
            if (c != null) {
                int x = c.posX, y = c.posY, z = c.posZ;
                if (evt.player.worldObj.getChunkProvider().chunkExists(MathHelper.floor_double(((double)c.posX) / 16), MathHelper.floor_double(((double)c.posZ) / 16))) {
                    evt.player.worldObj.setBlock(x, y, z, Blocks.air);
                    evt.player.worldObj.setBlock(x, y + 1, z, Blocks.air);
                }
            }
        }
    }

    @SubscribeEvent
    public void place(BlockEvent.PlaceEvent evt) {
        if (evt.player.dimension == ConfigurationHelper.vethea) {
            HashMap<Integer, ChunkCoordinates> map = Util.getPlayerSpawnChunkMap(evt.player);
            ChunkCoordinates c = map.get(ConfigurationHelper.vethea);
            if (c != null) {
                int x = c.posX, y = c.posY, z = c.posZ;
                if (evt.x == x && (evt.y == y || evt.y == y + 1) && evt.z == z) evt.setCanceled(true);
            }
        }
    }
}
