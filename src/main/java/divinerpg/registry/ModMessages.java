package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.networking.message.EquipmentChangeMessage;
import divinerpg.networking.message.MessageArcanaBar;
import divinerpg.networking.message.MessageDivineAccumulator;
import divinerpg.networking.message.PlayerLoggedEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ModMessages {
    private static int i = 0;

    public static void initServer() {
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, i++, Side.SERVER);
        DivineRPG.network.registerMessage(EquipmentChangeMessage.Handler.class, EquipmentChangeMessage.class, i++, Side.SERVER);
        DivineRPG.network.registerMessage(PlayerLoggedEvent.Handler.class, PlayerLoggedEvent.class, i++, Side.SERVER);
    }

    public static void initClient() {
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, i++, Side.CLIENT);
        DivineRPG.network.registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, i++, Side.CLIENT);
        DivineRPG.network.registerMessage(EquipmentChangeMessage.Handler.class, EquipmentChangeMessage.class, i++, Side.CLIENT);
    }
}
