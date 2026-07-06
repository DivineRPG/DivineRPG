package net.divinerpg.registries;

import net.divinerpg.world.config.tree.GiantDivineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.divinerpg.registries.DivineRegistries.FOLIAGE_PLACERS;

public class FoliagePlacerRegistry {
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<GiantDivineFoliagePlacer>> GIANT_DIVINE_FOLIAGE = FOLIAGE_PLACERS.register("giant_divine_foliage", () -> new FoliagePlacerType<>(GiantDivineFoliagePlacer.CODEC));

    public static void load() {
        GiantDivineFoliagePlacer.init(FoliagePlacerRegistry.GIANT_DIVINE_FOLIAGE);
    }
}
