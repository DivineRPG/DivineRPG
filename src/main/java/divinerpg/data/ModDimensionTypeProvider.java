package divinerpg.data;

import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.DimensionType;
import org.joml.Vector3f;

import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
public class ModDimensionTypeProvider {
    public static final ResourceKey<DimensionType> APALACHIA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "apalachia"));

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        HolderSet<Block> apalachiaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.APALACHIA_INFINIBURN);

        context.register(APALACHIA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, apalachiaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(0x501D80)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(0x301250)).build(), HolderSet.empty(), Optional.empty()));
    }



    private static Vector3f vecFromHex(int hex) {
        float r = ((hex >> 16) & 0xFF) / 255.0f;
        float g = ((hex >> 8) & 0xFF) / 255.0f;
        float b = (hex & 0xFF) / 255.0f;
        return new Vector3f(r, g, b);
    }
}
