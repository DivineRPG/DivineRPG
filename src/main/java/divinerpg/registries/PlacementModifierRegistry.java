package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.placement.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.*;

public class PlacementModifierRegistry {
	public static final  DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(Registry.PLACEMENT_MODIFIER_REGISTRY, DivineRPG.MODID);
	
	public static final RegistryObject<PlacementModifierType<Surface>> SURFACE_PLACEMENT = PLACEMENT_MODIFIERS.register("surface_placement", () -> () -> Surface.CODEC);
	public static final RegistryObject<PlacementModifierType<Underground>> UNDERGROUND = PLACEMENT_MODIFIERS.register("underground", () -> () -> Underground.CODEC);
}