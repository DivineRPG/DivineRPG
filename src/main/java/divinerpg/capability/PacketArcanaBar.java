package divinerpg.capability;

import io.netty.buffer.*;
import net.minecraftforge.network.*;

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

    public PacketArcanaBar(IArcana arcana) {
        if (arcana == null)
            return;

        delay = arcana.getRegenDelay();
        this.arcana = arcana.getArcana();
        max = arcana.getMaxArcana();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
                    ctx.get().getSender().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                        arcana.setMaxArcana(max);
                        arcana.setRegenDelay(delay);
                        arcana.set(this.arcana);
                    });
                });
        ctx.get().setPacketHandled(true);
    }
}
