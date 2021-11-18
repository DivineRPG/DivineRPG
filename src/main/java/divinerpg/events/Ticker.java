package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Ticker {
    public static int tick;
    @SubscribeEvent
    public void tickServer(TickEvent.ServerTickEvent evt) {
        if(evt.phase == TickEvent.Phase.END) {
            tick++;
            if(tick>100000) tick = 0;
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            Arcana arcana = event.player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
            if(arcana != null)
            arcana.regen(event.player);
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Arcana arcana = event.getPlayer().getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
        arcana.fill(event.getPlayer(), arcana.getMaxArcana());
    }

    @SubscribeEvent
    public void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        Arcana arcana = event.getPlayer().getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
        arcana.fill(event.getPlayer(), arcana.getMaxArcana()-arcana.getArcana());
        event.getPlayer().giveExperiencePoints(0);
    }
}
