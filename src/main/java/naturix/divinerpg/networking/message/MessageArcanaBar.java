package naturix.divinerpg.networking.message;

import io.netty.buffer.ByteBuf;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaRenderer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageArcanaBar implements IMessage {
	
	private float value;
	private boolean shouldRegen;
	
	public MessageArcanaBar(){}
	
	public MessageArcanaBar(float barValue, boolean shouldRegen){
		this.value = barValue;
		this.shouldRegen = shouldRegen;
	}
	
	@Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(value);
        buf.writeBoolean(shouldRegen);
    }

	@Override
	public void fromBytes(ByteBuf buf) {
		value = buf.readFloat();
		shouldRegen = buf.readBoolean();
	}
	
	public static class Handler implements IMessageHandler<MessageArcanaBar, IMessage>{

		@Override
		public IMessage onMessage(MessageArcanaBar msg, MessageContext ctx) {

			// Using value from message!!!
			ArcanaRenderer.value = msg.value;
			ArcanaRenderer.regen = msg.shouldRegen;

			DivineRPG.proxy.updateClientArcana(msg.value);
			
			return null;
		}
		
	}
}