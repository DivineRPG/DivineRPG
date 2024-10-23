package divinerpg.registries;


import divinerpg.DivineRPG;
import divinerpg.world.placement.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PlacementModifierRegistry {
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, DivineRPG.MODID);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Surface>> SURFACE_PLACEMENT = PLACEMENT_MODIFIER.register("surface_placement", () -> () -> Surface.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<Underground>> UNDERGROUND = PLACEMENT_MODIFIER.register("underground", () -> () -> Underground.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<ChunkMargin>> CHUNK_MARGIN = PLACEMENT_MODIFIER.register("chunk_margin", () -> () -> ChunkMargin.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<InSquare>> IN_SQUARE = PLACEMENT_MODIFIER.register("in_square", () -> () -> InSquare.CODEC);
}