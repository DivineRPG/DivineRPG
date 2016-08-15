package net.divinerpg.network;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.utils.events.ArcanaHelper;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageDivineAccumulator implements IMessage{
    
    private double x, y, z;
    
    public MessageDivineAccumulator(){}
    
    public MessageDivineAccumulator(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readDouble();
        y = buf.readDouble();
        z = buf.readDouble();
    }
    
    public static class Handler implements IMessageHandler<MessageDivineAccumulator, IMessage>{

        @Override
        public IMessage onMessage(MessageDivineAccumulator msg, MessageContext ctx) {
            for(double r = 0; r < 4; r += 0.1) {
                for(double theta = 0; theta < 2*Math.PI; theta += (Math.PI/24)) {
                    DivineRPG.proxy.spawnParticle(null, msg.x+(r*Math.cos(theta)), msg.y, msg.z+(r*Math.sin(theta)), "eden", true);
                }
            }
            return null;
        }
        
    }
}
