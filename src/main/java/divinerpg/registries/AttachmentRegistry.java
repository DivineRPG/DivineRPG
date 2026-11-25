package divinerpg.registries;

import com.mojang.serialization.Codec;
import divinerpg.attachments.Reputation;
import divinerpg.attachments.base.*;
import divinerpg.config.Config;
import divinerpg.entities.base.FactionEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.*;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

import static divinerpg.registries.DivineRegistries.ATTACHMENTS;

public class AttachmentRegistry {
    private AttachmentRegistry() {}

    //Standard Attachment
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> SOUL_TRAP_COUNT = ATTACHMENTS.register("soul_trap_count", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("value")).build());

    //Single sided
	/*
	The SingleSidedAttachments can be replaced with a single field in the entity's class with overriding readAdditionalSaveData(CompondTag) and addAdditionalSaveData(CompondTag).
	The benefit of the SingleSidedAttachments is that they provide a very simple way of controlling and overseeing sided data access. Another benefit is that they can also be attached to non-divinerpg entities, just like regular attachments
	 */
    //TODO: public static final SingleSidedAttachment<DimensionalInventory> DIMENSIONAL_INVENTORY = registerSingleSided("dimensional_inventory", DimensionalInventory::new, false);
    public static final SingleSidedAttachment<Integer> ANGER_TIME = registerSingleSided("anger_time", () -> 0, Codec.INT, false);
    public static final SingleSidedAttachment<Boolean> IMPORTANT = registerSingleSided("important", () -> false, Codec.BOOL, false);

    //Server handled
    public static final ServerHandledAttachment<Float> ARCANA = registerServerHandled("arcana", () -> 0F, Codec.FLOAT, ByteBufCodecs.FLOAT);
    public static final ServerHandledAttachment<Float> MAX_ARCANA = registerServerHandled("max_arcana", () -> Config.Values.ARCANA_MAX, Codec.FLOAT, ByteBufCodecs.FLOAT);

    public static final ServerHandledAttachment<Boolean> IN_DUNGEON = registerServerHandled("in_dungeon", () -> false, Codec.BOOL, ByteBufCodecs.BOOL);

    public static final ServerHandledAttachment<Boolean> ANGRY = registerServerHandled("angry", () -> false, Codec.BOOL, ByteBufCodecs.BOOL);
    public static final Reputation GROGLIN_REPUTATION = new Reputation("groglin_reputation", () -> FactionEntity.Faction.GROGLIN);
    public static final Reputation GRUZZORLUG_REPUTATION = new Reputation("gruzzorlug_reputation", () -> FactionEntity.Faction.GRUZZORLUG);
    public static final Reputation ICEIKA_MERCHANT_REPUTATION = new Reputation("iceika_merchant_reputation", () -> FactionEntity.Faction.ICEIKA_MERCHANT);
    public static final ServerHandledAttachment<Byte> VARIANT = registerServerHandled("variant", () -> (byte)0, Codec.BYTE, ByteBufCodecs.BYTE);
    public static final ServerHandledAttachment<Boolean> HANGING = registerServerHandled("hanging", () -> false, Codec.BOOL, ByteBufCodecs.BOOL);
    public static final ServerHandledAttachment<Boolean> SPECIAL = registerServerHandled("special", () -> false, Codec.BOOL, ByteBufCodecs.BOOL);
    public static final ServerHandledAttachment<Boolean> HOOKED = registerServerHandled("hooked", () -> false, Codec.BOOL, ByteBufCodecs.BOOL);
//	public static final ServerHandledAttachment<AttachedItem> ITEM = registerServerHandled("item", AttachedItem::new, AttachedItem.CODEC);

	/*
	Allowing clients to modify data is very hackable.
	Use only if you are not afraid of hack clients that can exploit this resource.
	Good examples where to allow data modification on clients are non-game-mechanic-altering data values, such as visual elements like color and text.
	 */
    //Client handled

    //Common handled
    public static final CommonHandledAttachment<Integer> COLOR = registerCommonHandled("color", () -> 0xFF0000, Codec.INT, ByteBufCodecs.INT);

    public static void registerPayloads(final PayloadRegistrar r) {
        ARCANA.registerPayload(r);
        MAX_ARCANA.registerPayload(r);
        IN_DUNGEON.registerPayload(r);
        ANGRY.registerPayload(r);
        GROGLIN_REPUTATION.registerPayload(r);
        GRUZZORLUG_REPUTATION.registerPayload(r);
        ICEIKA_MERCHANT_REPUTATION.registerPayload(r);
        VARIANT.registerPayload(r);
        HANGING.registerPayload(r);
        SPECIAL.registerPayload(r);
        HOOKED.registerPayload(r);
//		ITEM.registerPayload(r);

        //TODO: fix color payload
        //COLOR.registerPayload(r);
    }

    public static <T> SingleSidedAttachment<T> registerSingleSided(String name, Supplier<T> defaultValue, Codec<T> codec, boolean clientSide) {
        return new SingleSidedAttachment<>(name, defaultValue, codec, clientSide);
    }
    public static <T extends ValueIOSerializable> SingleSidedAttachment<T> registerSingleSided(String name, Supplier<T> defaultValue, boolean clientSide) {
        return new SingleSidedAttachment.Serializable<>(name, defaultValue, clientSide);
    }
    public static <T> ServerHandledAttachment<T> registerServerHandled(String name, Supplier<T> defaultValue, Codec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        return new ServerHandledAttachment<>(name, defaultValue, codec, streamCodec);
    }
    public static <T extends ValueIOSerializable> ServerHandledAttachment<T> registerServerHandled(String name, Supplier<T> defaultValue, StreamCodec<ByteBuf, T> streamCodec) {
        return new ServerHandledAttachment.Serializable<>(name, defaultValue, streamCodec);
    }
    public static <T> ClientHandledAttachment<T> registerClientHandled(String name, Supplier<T> defaultValue, Codec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        return new ClientHandledAttachment<>(name, defaultValue, codec, streamCodec);
    }
    public static <T extends ValueIOSerializable> ClientHandledAttachment<T> registerClientHandled(String name, Supplier<T> defaultValue, StreamCodec<ByteBuf, T> streamCodec) {
        return new ClientHandledAttachment.Serializable<>(name, defaultValue, streamCodec);
    }
    public static <T> CommonHandledAttachment<T> registerCommonHandled(String name, Supplier<T> defaultValue, Codec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        return new CommonHandledAttachment<>(name, defaultValue, codec, streamCodec);
    }
    public static <T extends ValueIOSerializable> CommonHandledAttachment<T> registerCommonHandled(String name, Supplier<T> defaultValue, StreamCodec<ByteBuf, T> streamCodec) {
        return new CommonHandledAttachment.Serializable<>(name, defaultValue, streamCodec);
    }

    public static void load() {}
}