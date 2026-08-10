package divinerpg.registries;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import divinerpg.structure.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Map;

import static divinerpg.DivineRPG.MODID;

public class StructureRegistry {
    public static final StructurePlaceSettings defaultSettings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setLiquidSettings(LiquidSettings.APPLY_WATERLOGGING);
    public static final DeferredHolder<StructureType<?>, StructureType<?>> HIGHEST_GROUND = DivineRegistries.STRUCTURES.register("highest_ground", () -> codecConv(HighestGroundType.CODEC)), LOWEST_GROUND = DivineRegistries.STRUCTURES.register("lowest_ground", () -> codecConv(LowestGroundType.CODEC)), HIGHEST_CEILING = DivineRegistries.STRUCTURES.register("highest_ceiling", () -> codecConv(HighestCeilingType.CODEC)), LOWEST_CEILING = DivineRegistries.STRUCTURES.register("lowest_ceiling", () -> codecConv(LowestCeilingType.CODEC));

    public static final ResourceKey<Structure> LIVESTOCK_MERCHANT_HUT_STRUCTURE = registerStructure("livestock_merchant_hut");

    public static void bootstrapStructureSets(BootstrapContext<StructureSet> context) {
        var structureLookup = context.lookup(Registries.STRUCTURE);

        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, "livestock_merchant_hut_set")), new StructureSet(structureLookup.getOrThrow(LIVESTOCK_MERCHANT_HUT_STRUCTURE), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1234567890)));
    }

    public static void bootstrapStructureTemplatePool(BootstrapContext<StructureTemplatePool> context) {
        var pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut").toString()), 1)), StructureTemplatePool.Projection.RIGID));
    }

    public static void bootstrapStructure(BootstrapContext<Structure> context) {
        var biomeLookup = context.lookup(Registries.BIOME);
        var settings = new Structure.StructureSettings(biomeLookup.getOrThrow(BiomeTags.HAS_VILLAGE_PLAINS), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);

        context.register(LIVESTOCK_MERCHANT_HUT_STRUCTURE, new JigsawStructure(settings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut"))), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
    }

    private static ResourceKey<Structure> registerStructure(String name) {
        return ResourceKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static <S extends Structure> StructureType<S> codecConv(MapCodec<S> codec) {
        return () -> (MapCodec<S>) codec;
    }

    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos) {
        structure.placeInWorld(level, pos, pos, defaultSettings, random, 2);
    }
    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos, Rotation rotation) {
        structure.placeInWorld(level, pos, pos, defaultSettings.copy().setRotation(rotation), random, 2);
    }

    public static void load() {}
}