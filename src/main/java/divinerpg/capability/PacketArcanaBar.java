package divinerpg.capability;

import io.netty.buffer.*;
import net.minecraftforge.fml.network.*;

import java.util.function.*;

public class PacketArcanaBar {
    private int delay;
    private float arcana;
    private float max;
    public PacketArcanaBar(ByteBuf buf) {
        max = buf.readFloat();
        arcana = buf.readFloat();
        delay = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeFloat(max);
        buf.writeFloat(arcana);
        buf.writeInt(delay);
    }

    public PacketArcanaBar(Arcana arcana) {
        if (arcana == null)
            return;

        delay = arcana.getRegenDelay();
        this.arcana = arcana.getArcana();
        max = arcana.getMaxArcana();
    }


    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Arcana arcana = ctx.get().getSender().getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElseThrow(null);
            arcana.setMaxArcana(max);
            arcana.setRegenDelay(delay);
            arcana.set(this.arcana);
        });
        ctx.get().setPacketHandled(true);
    }

}
