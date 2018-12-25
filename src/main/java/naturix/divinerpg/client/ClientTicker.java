package naturix.divinerpg.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class ClientTicker {

    public static int tick;
    public static int        guiTick = 600;
    @SubscribeEvent
    public void tickClient(ClientTickEvent evt) {
        if (evt.phase == Phase.END) {
            tick++;
            if (guiTick > 0) guiTick--;
            if (ArcanaRenderer.regen && ArcanaRenderer.value < 200 && Minecraft.getMinecraft().currentScreen == null) ArcanaRenderer.value++;
        }

    }

}