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
    public static final ResourceKey<DimensionType> EDEN = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "eden"));
    public static final ResourceKey<DimensionType> WILDWOOD = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "wildwood"));
    public static final ResourceKey<DimensionType> APALACHIA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "apalachia"));
    public static final ResourceKey<DimensionType> SKYTHERN = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "skythern"));
    public static final ResourceKey<DimensionType> MORTUM = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "mortum"));
    public static final ResourceKey<DimensionType> ICEIKA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "iceika"));
    public static final ResourceKey<DimensionType> ARCANA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "arcana"));
    public static final ResourceKey<DimensionType> VETHEA = ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(MODID, "vethea"));

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        HolderSet<Block> edenInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.EDEN_INFINIBURN);
        HolderSet<Block> wildwoodInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.WILDWOOD_INFINIBURN);
        HolderSet<Block> apalachiaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.APALACHIA_INFINIBURN);
        HolderSet<Block> skythernInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.SKYTHERN_INFINIBURN);
        HolderSet<Block> mortumInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.MORTUM_INFINIBURN);
        HolderSet<Block> iceikaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.ICEIKA_INFINIBURN);
        HolderSet<Block> arcanaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.ARCANA_INFINIBURN);
        HolderSet<Block> vetheaInfiniburn = context.lookup(Registries.BLOCK).getOrThrow(TagRegistry.VETHEA_INFINIBURN);

        context.register(EDEN, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, edenInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(10747897)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(16380011)).build(), HolderSet.empty(), Optional.empty()));
        context.register(WILDWOOD, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, wildwoodInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(10730239)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(6133246)).build(), HolderSet.empty(), Optional.empty()));
        context.register(APALACHIA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, apalachiaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(0x501D80)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(0x301250)).build(), HolderSet.empty(), Optional.empty()));
        context.register(SKYTHERN, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, skythernInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(16777215)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(13948116)).build(), HolderSet.empty(), Optional.empty()));
        context.register(MORTUM, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, mortumInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(16756224)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(9536597)).build(), HolderSet.empty(), Optional.empty()));
        context.register(ICEIKA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, iceikaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(8108535)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(10679540)).build(), HolderSet.empty(), Optional.empty()));
        context.register(ARCANA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, arcanaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(11786203)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(11965169)).build(), HolderSet.empty(), Optional.empty()));
        context.register(VETHEA, new DimensionType(true, true, false, false, 6.0D, 0, 256, 244, vetheaInfiniburn, 0.0f, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.NONE, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.SKY_COLOR, vecFromHex(2319699)).set(EnvironmentAttributes.FOG_COLOR, vecFromHex(2719305)).build(), HolderSet.empty(), Optional.empty()));

    }



    private static Vector3f vecFromHex(int hex) {
        float r = ((hex >> 16) & 0xFF) / 255.0f;
        float g = ((hex >> 8) & 0xFF) / 255.0f;
        float b = (hex & 0xFF) / 255.0f;
        return new Vector3f(r, g, b);
    }
}
