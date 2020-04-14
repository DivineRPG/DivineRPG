package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.registry.ModDimensions;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ChangeDimensionFixes {
	

	public static BlockPos vetheaSpawn;
	
	
	@SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if(event.toDim==ModDimensions.vetheaDimension.getId()) {	
        	vetheaSpawn = event.player.getPosition();	
        	event.player.setSpawnChunk(vetheaSpawn, true, ModDimensions.vetheaDimension.getId());
        }
		if(event.toDim==ModDimensions.arcanaDimension.getId()) {
            NBTTagCompound portalPos = new NBTTagCompound();
			event.player.readEntityFromNBT(portalPos);
            BlockPos pos = new BlockPos(portalPos.getInteger("PortalPosX"), portalPos.getInteger("PortalPosY"), portalPos.getInteger("PortalPosZ"));
            event.player.attemptTeleport(pos.getX(), pos.getY(), pos.getZ());
		}
        
    }
	
	
	@SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if(event.player.dimension==ModDimensions.vetheaDimension.getId()) {	
        	event.player.attemptTeleport(vetheaSpawn.getX(), vetheaSpawn.getY(), vetheaSpawn.getZ());	
        }
    }
}
