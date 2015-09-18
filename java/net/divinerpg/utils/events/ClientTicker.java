package net.divinerpg.utils.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.client.render.gui.GUIOverlay;
import net.minecraft.client.Minecraft;

public class ClientTicker {

    public static int tick;

    @SubscribeEvent
    public void tickClient(ClientTickEvent evt) {
        if (evt.phase == Phase.END) {
            tick++;
            if (GUIOverlay.guiTick > 0) GUIOverlay.guiTick--;
            if (ArcanaRenderer.regen && ArcanaRenderer.value < 200 && Minecraft.getMinecraft().currentScreen == null) ArcanaRenderer.value++;
        }

    }

}
