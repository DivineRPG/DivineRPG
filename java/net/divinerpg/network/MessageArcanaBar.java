package net.divinerpg.network;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.utils.events.ArcanaHelper;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageArcanaBar implements IMessage{
	
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
			ArcanaRenderer.value = msg.value;
			ArcanaRenderer.regen = msg.shouldRegen;
			DivineRPG.proxy.updateClientArcana(msg.value);
			return null;
		}
		
	}
}
