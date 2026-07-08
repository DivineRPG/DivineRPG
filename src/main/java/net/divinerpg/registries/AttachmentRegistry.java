package net.divinerpg.registries;

import com.mojang.serialization.Codec;
import net.divinerpg.attachments.data.ArcanaData;
import net.divinerpg.config.Config;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.divinerpg.registries.DivineRegistries.ATTACHMENTS;

public class AttachmentRegistry {
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> SOUL_TRAP_COUNT = ATTACHMENTS.register("soul_trap_count", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("value")).build());

    public static final Supplier<AttachmentType<ArcanaData>> ARCANA = ATTACHMENTS.register("arcana", () -> AttachmentType.builder(holder -> new ArcanaData(0F, Config.Values.ARCANA_MAX)).serialize(ArcanaData.CODEC.fieldOf("arcana")).sync(ArcanaData.STREAM_CODEC).build());

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Float>> MAX_ARCANA = registerServerHandled("max_arcana", () -> Config.Values.ARCANA_MAX, Codec.FLOAT);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> IN_DUNGEON = registerServerHandled("in_dungeon", () -> false, Codec.BOOL);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> ANGRY = registerServerHandled("angry", () -> false, Codec.BOOL);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Byte>> VARIANT = registerServerHandled("variant", () -> (byte)0, Codec.BYTE);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> HANGING = registerServerHandled("hanging", () -> false, Codec.BOOL);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> SPECIAL = registerServerHandled("special", () -> false, Codec.BOOL);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> HOOKED = registerServerHandled("hooked", () -> false, Codec.BOOL);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> COLOR = registerCommonHandled("color", () -> 0xFF0000, Codec.INT);

    private static <T> DeferredHolder<AttachmentType<?>, AttachmentType<T>> registerServerHandled(String name, Supplier<T> def, Codec<T> codec) {
        return ATTACHMENTS.register(name, () -> AttachmentType.builder(def).serialize(codec.fieldOf("value")).sync(ByteBufCodecs.VAR_INT.map(i -> (T)i, i -> (Integer)i)).build());
    }

    private static <T> DeferredHolder<AttachmentType<?>, AttachmentType<T>> registerCommonHandled(String name, Supplier<T> def, Codec<T> codec) {
        return ATTACHMENTS.register(name, () -> AttachmentType.builder(def).serialize(codec.fieldOf("value")).sync(ByteBufCodecs.VAR_INT.map(i -> (T)i, i -> (Integer)i)).build());
    }

    public static void load(){

    }
}