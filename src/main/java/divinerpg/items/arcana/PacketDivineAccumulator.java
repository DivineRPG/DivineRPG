package divinerpg.items.arcana;

import io.netty.buffer.*;
import net.minecraftforge.fml.network.*;

import java.util.function.*;

public class PacketDivineAccumulator {
    private double x, y, z;
    public PacketDivineAccumulator(ByteBuf buf) {

        x = buf.readDouble();
        y = buf.readDouble();
        z = buf.readDouble();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }

    public PacketDivineAccumulator(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            for (double r = 0; r < 4; r += 0.1) {
                for (double theta = 0; theta < 2 * Math.PI; theta += (Math.PI / 24)) {

//                    DivineRPG.proxy.spawnParticle(
//                            DivineRPG.proxy.getPlayer().world,
//                            ParticleType.EDEN_PORTAL,
//                            msg.z + (r * Math.sin(theta)),
//                            msg.x + (r * Math.cos(theta)),
//                            msg.y,
//                            Math.random(),
//                            Math.random(),
//                            Math.random());
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
