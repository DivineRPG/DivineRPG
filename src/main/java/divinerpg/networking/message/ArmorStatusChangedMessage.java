package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.events.ArmorWearingEvents;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.nio.charset.Charset;

public class ArmorStatusChangedMessage implements IMessage {
    private boolean isOn;
    private ResourceLocation id;

    public ArmorStatusChangedMessage() {
    }

    public ArmorStatusChangedMessage(ResourceLocation id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        isOn = buf.readBoolean();
        int length = buf.readInt();
        id = new ResourceLocation(buf.readCharSequence(length, Charset.defaultCharset()).toString());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(isOn);
        String text = id.toString();
        buf.writeInt(text.length());
        buf.writeCharSequence(text, Charset.defaultCharset());
    }

    public static class Handler implements IMessageHandler<ArmorStatusChangedMessage, IMessage> {

        @Override
        public IMessage onMessage(ArmorStatusChangedMessage message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT) {
                IArmorPowers powers = DivineAPI.getArmorPowers(DivineRPG.proxy.getPlayer());
                if (powers != null) {
                    if (message.isOn) {
                        powers.putOn(message.id);
                    } else {
                        powers.takeOff(message.id);
                    }
                }
            }

            if (ctx.side == Side.SERVER) {
                // will recheck armor sets on any EntityPlayerSP creation
                // After recheck send to client all info about wearnig sets
                ArmorWearingEvents.recheckAllWearing(ctx.getServerHandler().player, true);
            }

            return null;
        }
    }
}
