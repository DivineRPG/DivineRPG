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
            event.player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana != null)
            arcana.regen(event.player);
        });
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        event.getEntity().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            arcana.fill(event.getEntity(), arcana.getMaxArcana());
        });
    }


    @SubscribeEvent
    public void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        event.getEntity().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            arcana.fill(event.getEntity(), arcana.getMaxArcana()-arcana.getArcana());
            event.getEntity().giveExperiencePoints(0);
        });

    }}
