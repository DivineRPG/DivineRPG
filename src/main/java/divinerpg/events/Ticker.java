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
            ArcanaProvider.ARCANA_CAP.getDefaultInstance().regen(event.player);
        }
    }
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ArcanaProvider.ARCANA_CAP.getDefaultInstance().fill(event.getPlayer(), ArcanaProvider.ARCANA_CAP.getDefaultInstance().getMaxArcana());
    }
}
