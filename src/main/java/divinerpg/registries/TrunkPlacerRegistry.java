package divinerpg.registries;

import divinerpg.world.config.tree.GiantDivineTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TrunkPlacerRegistry {
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<GiantDivineTrunkPlacer>> GIANT_DIVINE_TRUNK = DivineRegistries.TRUNK_PLACERS.register("giant_divine_trunk", () -> new TrunkPlacerType<>(GiantDivineTrunkPlacer.CODEC));


    public static void load() {
        GiantDivineTrunkPlacer.init(TrunkPlacerRegistry.GIANT_DIVINE_TRUNK);
    }
}
