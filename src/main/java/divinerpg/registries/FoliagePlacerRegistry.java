package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.feature.tree.GiantDivineFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FoliagePlacerRegistry {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DivineRPG.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<GiantDivineFoliagePlacer>> GIANT_DIVINE_FOLIAGE = FOLIAGE_PLACERS.register("giant_divine_foliage", () -> new FoliagePlacerType<>(GiantDivineFoliagePlacer.CODEC));
}
