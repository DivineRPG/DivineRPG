package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.networking.message.MessageArcanaBar;
import divinerpg.networking.message.MessageDivineAccumulator;
import net.minecraftforge.fml.relauncher.Side;

public class ModMessages {

	public static void initServer(){
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, 0, Side.SERVER);
        
        //Dont need particles on a server...
//        DivineRPG.network.registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, 3, Side.SERVER);
    }
	public static void initClient(){
        DivineRPG.network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, 1, Side.CLIENT);
        DivineRPG.network.registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, 2, Side.CLIENT);
    }
}
