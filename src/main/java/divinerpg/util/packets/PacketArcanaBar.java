package divinerpg.util.packets;

import io.netty.buffer.*;
import net.minecraftforge.network.*;

import java.util.function.*;

import divinerpg.capability.*;

public class PacketArcanaBar {
    private float max, arcana;
    public PacketArcanaBar(ByteBuf buf) {
        max = buf.readFloat();
        arcana = buf.readFloat();
    }
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(max);
        buf.writeFloat(arcana);
    }
    public PacketArcanaBar(Arcana arcana) {
        max = arcana.getMaxArcana(false);
        this.arcana = arcana.getAmount(false);
    }
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
        	Arcana.clientMax = max;
        	Arcana.clientAmount = arcana;
        });
        ctx.get().setPacketHandled(true);
    }
}
