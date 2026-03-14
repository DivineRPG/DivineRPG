package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.feature.tree.GiantDivineTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TrunkPlacerRegistry {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, DivineRPG.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<GiantDivineTrunkPlacer>> GIANT_DIVINE_TRUNK = TRUNK_PLACERS.register("giant_divine_trunk", () -> new TrunkPlacerType<>(GiantDivineTrunkPlacer.CODEC));
}
