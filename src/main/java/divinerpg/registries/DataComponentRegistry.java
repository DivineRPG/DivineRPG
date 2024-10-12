package divinerpg.registries;

import com.mojang.serialization.Codec;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredRegister.DataComponents;

public class DataComponentRegistry {
	public static final DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(DivineRPG.MODID);
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> activated = DATA_COMPONENTS.registerComponentType("activated", builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<ResourceLocation>> dimension = DATA_COMPONENTS.registerComponentType("dimension", builder -> builder.persistent(ResourceLocation.CODEC).networkSynchronized(ResourceLocation.STREAM_CODEC));
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> position = DATA_COMPONENTS.registerComponentType("position", builder -> builder.persistent(BlockPos.CODEC).networkSynchronized(BlockPos.STREAM_CODEC));
}