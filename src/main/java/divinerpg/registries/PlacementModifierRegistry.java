package divinerpg.registries;

import com.mojang.serialization.Codec;
import divinerpg.DivineRPG;
import divinerpg.world.placement.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

public class PlacementModifierRegistry {
	public static final PlacementModifierType<Surface> SURFACE_PLACEMENT = register(new ResourceLocation(DivineRPG.MODID, "surface_placement"), Surface.CODEC);
	public static final PlacementModifierType<Underground> UNDERGROUND = register(new ResourceLocation(DivineRPG.MODID, "underground"), Underground.CODEC);

	public static void init() { }
	private static <P extends PlacementModifier> PlacementModifierType<P> register(ResourceLocation name, Codec<P> codec) {
		return Registry.register(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, name, () -> codec);
	}
}