package net.divinerpg.registries;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.function.Supplier;

public class DataComponentRegistry {
    public static final Supplier<DataComponentType<Byte>> VARIANT = DivineRegistries.DATA_COMPONENTS.register("variant", () -> DataComponentType.<Byte>builder().persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE).build());
    public static void load() {}
}
