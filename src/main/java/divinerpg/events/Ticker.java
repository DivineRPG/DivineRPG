package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
    public void onTick(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            IArcana arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(new Arcana());
            arcana.regen(event.player);
        }
    }
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        IArcana arcana = event.getPlayer().getCapability(ArcanaProvider.ARCANA_CAP).orElse(new Arcana());
        arcana.fill(event.getPlayer(), arcana.getMaxArcana());
    }
}
