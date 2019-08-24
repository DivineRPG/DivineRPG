package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.enums.ParticleType;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

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
                    DivineRPG.proxy.spawnParticle(Minecraft.getMinecraft().world,
                            ParticleType.EDEN_PORTAL,
                            msg.z+(r*Math.sin(theta)),
                            msg.x+(r*Math.cos(theta)),
                            msg.y,
                            Math.random(),
                            Math.random(),
                            Math.random()
                    );

                }
            }
            return null;
        }
        
    }
}