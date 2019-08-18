package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.networking.message.MessageArcanaBar;
import naturix.divinerpg.networking.message.MessageDivineAccumulator;
import net.minecraftforge.fml.relauncher.Side;

public class ModMessages {

    public static void init(){
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, 0, Side.SERVER);
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, 1, Side.CLIENT);

        DivineRPG.network.registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, 2, Side.CLIENT);
        DivineRPG.network.registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, 3, Side.SERVER);
    }
}
