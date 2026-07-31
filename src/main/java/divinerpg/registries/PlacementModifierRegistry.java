package divinerpg.registries;

import com.mojang.serialization.MapCodec;
import divinerpg.world.placement.*;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class PlacementModifierRegistry {

    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Surface>> SURFACE_PLACEMENT = DivineRegistries.PLACEMENT_MODIFIERS.register("surface_placement", () -> () -> Surface.CODEC);
    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Underground>> UNDERGROUND = DivineRegistries.PLACEMENT_MODIFIERS.register("underground", () -> () -> Underground.CODEC);
    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<ChunkMargin>> CHUNK_MARGIN = DivineRegistries.PLACEMENT_MODIFIERS.register("chunk_margin", () -> () -> ChunkMargin.CODEC);
    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<InSquare>> IN_SQUARE = DivineRegistries.PLACEMENT_MODIFIERS.register("in_square", () -> () -> InSquare.CODEC);

    public static final DeferredHolder<MapCodec<? extends DensityFunction>, MapCodec<Heaviside>> HEAVISIDE = DivineRegistries.DENSITY_FUNCTION.register("heaviside", () -> Heaviside.DATA_CODEC);

    public static void load() {}
}
