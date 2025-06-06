package divinerpg.network.payload;

import divinerpg.DivineRPG;
import divinerpg.network.Payloads;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public record AccurateSetMotionPacket(int id, Vec3 motion) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AccurateSetMotionPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "accurate_set_motion"));
    public static final StreamCodec<ByteBuf, AccurateSetMotionPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, AccurateSetMotionPacket::id, Payloads.VEC3, AccurateSetMotionPacket::motion, AccurateSetMotionPacket::new);
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}