package divinerpg.events;

import divinerpg.api.arcana.ArcanaAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.capabilities.ArcanaProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ArcanaTickHandler {
    IArcana arcana;

    @SubscribeEvent
    public void onTick(PlayerTickEvent event) {
        arcana = ArcanaAPI.getArcana(event.player);
        if (event.phase == Phase.START) {
            // onTickStart(event.player);
        } else {
            onTickEnd(event.player);
        }
    }

    private void onTickEnd(EntityPlayer player) {
        arcana = ArcanaAPI.getArcana(player);
        arcana.regen(player);
    }

    private void onTickStart(EntityPlayer player) {
        //arcana = ArcanaAPI.getArcana(player);
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        arcana = ArcanaAPI.getArcana(event.player);
        arcana.set(arcana.getMaxArcana());
    }

    @SubscribeEvent
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        arcana = ArcanaAPI.getArcana(event.player);
        arcana.set(0);
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        arcana = ArcanaAPI.getArcana(event.player);
        arcana.set(arcana.getMaxArcana());
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        arcana = ArcanaAPI.getArcana(event.player);
        arcana.set(arcana.getMaxArcana());
        event.player.addExperienceLevel(0);
    }
}
