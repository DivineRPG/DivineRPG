package divinerpg.events;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ArcanaTickHandler {	   
    @SubscribeEvent
    public void onTick(PlayerTickEvent event) {
        if (event.phase == Phase.START) {
            DivineAPI.getArcana(event.player).regen(event.player);
        }
    }
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        refillArcana(event.player);
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        refillArcana(event.player);
        event.player.addExperienceLevel(0);
    }

    /**
     * Restore all player arcana
     *
     * @param player - current player
     */
    private void refillArcana(EntityPlayer player) {
        IArcana arcana = DivineAPI.getArcana(player);
        if (arcana == null)
            return;

        arcana.fill(player, arcana.getMaxArcana());
    }
}
