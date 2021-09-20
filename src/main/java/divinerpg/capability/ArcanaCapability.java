package divinerpg.capability;

import net.minecraftforge.common.capabilities.*;

public class ArcanaCapability {
    @CapabilityInject(Arcana.class)
    public static Capability<Arcana> CAPABILITY_ARCANA = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(
                Arcana.class,
                new Arcana.ArcanaStorage(),
                Arcana::createADefaultInstance);
    }
}

