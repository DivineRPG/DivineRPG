package divinerpg.events;

import divinerpg.registry.ModDimensions;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ChangeDimensionFixes {

    // todo remove for sure
    public static BlockPos vetheaSpawn;

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        // todo
//        DimensionType from = DimensionType.getById(event.fromDim);
//        DimensionType to = DimensionType.getById(event.toDim);
//
//        BlockNightmareBed.onChangeDimension(event.player, from, to);
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.player.dimension == ModDimensions.vetheaDimension.getId()) {
            event.player.attemptTeleport(vetheaSpawn.getX(), vetheaSpawn.getY(), vetheaSpawn.getZ());
        }
    }
}
