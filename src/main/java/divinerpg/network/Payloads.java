package divinerpg.network;

import divinerpg.network.payload.*;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class Payloads {
	@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event) {
	    final PayloadRegistrar registrar = event.registrar("2");
	    registrar.playToClient(ItemContentChanged.TYPE, ItemContentChanged.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
	    	context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.ROBBIN_NEST.get()).ifPresent((block) -> 
	    		block.setItemNoUpdate(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(payload.itemid()))))
	    )));
	    registrar.playToServer(RequestItemContent.TYPE, RequestItemContent.STREAM_CODEC, (payload, context) -> context.enqueueWork(() -> 
	    	context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.ROBBIN_NEST.get()).ifPresent((block) ->
	    		context.reply(new ItemContentChanged(payload.pos(), block.getItem().getDescriptionId()))
		)));
		registrar.playToClient(RiftVariant.TYPE, RiftVariant.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
			context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.RIFT.get()).ifPresent((block) ->
				block.variant = payload.variant()
		)));
		registrar.playToServer(RequestRiftVariant.TYPE, RequestRiftVariant.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
			context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.RIFT.get()).ifPresent((block) ->
				context.reply(new RiftVariant(payload.pos(), block.variant))
		)));
		registrar.playToClient(AccurateSetMotionPacket.TYPE, AccurateSetMotionPacket.STREAM_CODEC, (payload, context) -> context.player().level().getEntity(payload.id()).setDeltaMovement(payload.motion()));
	    registrar.playToClient(Weather.TYPE, Weather.STREAM_CODEC, (payload, context) -> Utils.ICEIKA_WEATHER = payload.weatherType());
		AttachmentRegistry.registerPayloads(registrar);
	}
	public static final StreamCodec<ByteBuf, BlockPos> BLOCK_POS = new StreamCodec<>() {
        public BlockPos decode(ByteBuf buf) {
            return FriendlyByteBuf.readBlockPos(buf);
        }
        public void encode(ByteBuf buf, BlockPos pos) {
            FriendlyByteBuf.writeBlockPos(buf, pos);
        }
    };
	public static final StreamCodec<ByteBuf, Vec3> VEC3 = new StreamCodec<>() {
		public Vec3 decode(ByteBuf byteBuf) {return new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());}
		@Override public void encode(ByteBuf o, Vec3 vec3) {
			o.writeDouble(vec3.x);
			o.writeDouble(vec3.y);
			o.writeDouble(vec3.z);
		}
	};
}