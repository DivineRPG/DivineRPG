package divinerpg.data;

import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
public class ModDimensionTypeProvider {
    public static final ResourceKey<DimensionType> APALACHIA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "apalachia"));

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        HolderSet<Block> apalachiaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.APALACHIA_INFINIBURN);

        context.register(APALACHIA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, apalachiaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.OVERWORLD, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.EMPTY, HolderSet.empty(), Optional.empty()));
    }
}
