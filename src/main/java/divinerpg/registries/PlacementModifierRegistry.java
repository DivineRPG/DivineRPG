package divinerpg.registries;


import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import divinerpg.world.density_function.Heaviside;
import divinerpg.world.placement.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PlacementModifierRegistry {
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, DivineRPG.MODID);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Surface>> SURFACE_PLACEMENT = PLACEMENT_MODIFIER.register("surface_placement", () -> () -> Surface.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Underground>> UNDERGROUND = PLACEMENT_MODIFIER.register("underground", () -> () -> Underground.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<ChunkMargin>> CHUNK_MARGIN = PLACEMENT_MODIFIER.register("chunk_margin", () -> () -> ChunkMargin.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<InSquare>> IN_SQUARE = PLACEMENT_MODIFIER.register("in_square", () -> () -> InSquare.CODEC);

	public static final DeferredRegister<MapCodec<? extends DensityFunction>> DENSITY_FUNCTION = DeferredRegister.create(BuiltInRegistries.DENSITY_FUNCTION_TYPE, DivineRPG.MODID);
	public static final DeferredHolder<MapCodec<? extends DensityFunction>, MapCodec<Heaviside>> HEAVISIDE = DENSITY_FUNCTION.register("heaviside", () -> Heaviside.DATA_CODEC);
}