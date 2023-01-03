package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.capability.PacketArcanaBar;
import divinerpg.items.arcana.PacketDivineAccumulator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkingRegistry {
    public static SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(DivineRPG.MODID, "messages")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered networking");
        INSTANCE.messageBuilder(PacketArcanaBar.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketArcanaBar::new)
                .encoder(PacketArcanaBar::toBytes)
                .consumerMainThread(PacketArcanaBar::handle)
                .add();

        INSTANCE.messageBuilder(PacketDivineAccumulator.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketDivineAccumulator::new)
                .encoder(PacketDivineAccumulator::toBytes)
                .consumerMainThread(PacketDivineAccumulator::handle)
                .add();

    }

}
