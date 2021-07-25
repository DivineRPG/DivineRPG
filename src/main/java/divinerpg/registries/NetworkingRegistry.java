package divinerpg.registries;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.arcana.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.network.*;
import net.minecraftforge.fml.network.simple.*;

public class NetworkingRegistry {
    private static int packetId = 0;
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(DivineRPG.MODID, "divinerpg_packet"), () -> "1.0", s -> true, s -> true);

    private static int nextID() {
        return packetId++;
    }

    public static void init() {
        INSTANCE.registerMessage(nextID(),
                PacketArcanaBar.class,
                PacketArcanaBar::toBytes,
                PacketArcanaBar::new,
                PacketArcanaBar::handle);
        INSTANCE.registerMessage(nextID(),
                PacketDivineAccumulator.class,
                PacketDivineAccumulator::toBytes,
                PacketDivineAccumulator::new,
                PacketDivineAccumulator::handle);

    }
}
