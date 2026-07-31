package divinerpg.registries;

import divinerpg.DivineRPG;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = DivineRPG.MODID)
public class NetworkRegistry {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(DivineRPG.MODID);

        AttachmentRegistry.ARCANA.registerPayload(registrar);
    }
}