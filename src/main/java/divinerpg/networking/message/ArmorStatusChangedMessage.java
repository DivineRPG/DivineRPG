package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.cap.IArmorPowers;
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
        ByteBuf byteBuf = buf.readBytes(length);
        String id = byteBuf.toString(Charset.defaultCharset());
        this.id = new ResourceLocation(id);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(isOn);
        byte[] bytes = id.toString().getBytes(Charset.defaultCharset());
        buf.writeInt(bytes.length);
        buf.writeBytes(bytes);
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

            return null;
        }
    }
}
