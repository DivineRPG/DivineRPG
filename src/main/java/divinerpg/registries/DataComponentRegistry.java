package divinerpg.registries;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

import static divinerpg.registries.DivineRegistries.DATA_COMPONENTS;

public class DataComponentRegistry {
    public static final Supplier<DataComponentType<Byte>> variant = DATA_COMPONENTS.register("variant", () -> DataComponentType.<Byte>builder().persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE).build());
    public static final Supplier<DataComponentType<Boolean>> activated = DATA_COMPONENTS.register("activated", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final Supplier<DataComponentType<Identifier>> dimension = DATA_COMPONENTS.register("dimension", () -> DataComponentType.<Identifier>builder().persistent(Identifier.CODEC).networkSynchronized(Identifier.STREAM_CODEC).build());
    public static final Supplier<DataComponentType<BlockPos>> position = DATA_COMPONENTS.register("position", () -> DataComponentType.<BlockPos>builder().persistent(BlockPos.CODEC).networkSynchronized(BlockPos.STREAM_CODEC).build());
    public static final Supplier<DataComponentType<Integer>> weaponAbility = DATA_COMPONENTS.register("weapon_ability", () -> DataComponentType.<Integer>builder().networkSynchronized(ByteBufCodecs.INT).build());
    public static final Supplier<DataComponentType<Float>> weaponPower = DATA_COMPONENTS.register("weapon_power", () -> DataComponentType.<Float>builder().networkSynchronized(ByteBufCodecs.FLOAT).build());

    public static void load() {}
}