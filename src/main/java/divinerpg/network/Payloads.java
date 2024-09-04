package divinerpg.network;

import divinerpg.entities.base.FactionEntity.Faction;
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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class Payloads {
	@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event) {
	    final PayloadRegistrar registrar = event.registrar("1");
	    registrar.playToClient(ArcanaAmount.TYPE, ArcanaAmount.STREAM_CODEC, (payload, context) -> context.enqueueWork(() -> context.player().setData(AttachmentRegistry.ARCANA, payload.amount())));
	    registrar.playToClient(MaxArcana.TYPE, MaxArcana.STREAM_CODEC, (payload, context) -> context.enqueueWork(() -> context.player().setData(AttachmentRegistry.MAX_ARCANA, payload.amount())));
	    registrar.playToClient(ItemContentChanged.TYPE, ItemContentChanged.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
	    	context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.ROBBIN_NEST.get()).ifPresent((block) -> 
	    		block.setItemNoUpdate(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(payload.itemid()))))
	    )));
	    registrar.playToServer(RequestReputation.TYPE, RequestReputation.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
	    	context.reply(new Reputation(payload.faction(), Faction.getFation(payload.faction()).getReputation(context.player())))
    	));
	    registrar.playToClient(Reputation.TYPE, Reputation.STREAM_CODEC, (payload, context) -> context.enqueueWork(() ->
	    	Faction.getFation(payload.faction()).setReputation(context.player(), payload.reputation())
		));
	    registrar.playToServer(RequestItemContent.TYPE, RequestItemContent.STREAM_CODEC, (payload, context) -> context.enqueueWork(() -> 
	    	context.player().level().getBlockEntity(payload.pos(), BlockEntityRegistry.ROBBIN_NEST.get()).ifPresent((block) ->
	    		context.reply(new ItemContentChanged(payload.pos(), block.getItem().getDescriptionId()))
		)));
	    registrar.playToClient(Weather.TYPE, Weather.STREAM_CODEC, (payload, context) -> Utils.ICEIKA_WEATHER = payload.weatherType());
	}
	public static final StreamCodec<ByteBuf, BlockPos> BLOCK_POS = new StreamCodec<ByteBuf, BlockPos>() {
        public BlockPos decode(ByteBuf buf) {
            return FriendlyByteBuf.readBlockPos(buf);
        }
        public void encode(ByteBuf buf, BlockPos pos) {
            FriendlyByteBuf.writeBlockPos(buf, pos);
        }
    };
}