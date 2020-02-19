package divinerpg.api.java.divinerpg.api.armorNew;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ArmorEvents {

    private static void handleFroPlayer(EntityPlayer player, Class clazz, Event e) {
        if (player == null || clazz == null || e == null)
            return;

        ArmorObserver observer = ArmorMapEvents.getCurrentMap().get(player);
        if (observer == null)
            return;

        observer.handle(clazz, e);
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent e) {
        handleFroPlayer(e.player, TickEvent.PlayerTickEvent.class, e);
    }

    @SubscribeEvent
    public static void onHurn(LivingHurtEvent e) {
        handleFroPlayer((EntityPlayer) e.getSource().getTrueSource(), LivingHurtEvent.class, e);
        handleFroPlayer((EntityPlayer) e.getEntity(), LivingHurtEvent.class, e);
    }
}
