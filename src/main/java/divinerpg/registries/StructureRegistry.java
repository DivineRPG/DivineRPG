package divinerpg.registries;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import divinerpg.structure.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.heightproviders.*;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.placement.*;
import net.minecraft.world.level.levelgen.structure.pools.*;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;

import static divinerpg.DivineRPG.MODID;

public class StructureRegistry {
    public static final StructurePlaceSettings defaultSettings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setLiquidSettings(LiquidSettings.APPLY_WATERLOGGING);
    public static final DeferredHolder<StructureType<?>, StructureType<?>>
        HIGHEST_GROUND = DivineRegistries.STRUCTURES.register("highest_ground", () -> codecConv(HighestGroundType.CODEC)),
        LOWEST_GROUND = DivineRegistries.STRUCTURES.register("lowest_ground", () -> codecConv(LowestGroundType.CODEC)),
        HIGHEST_CEILING = DivineRegistries.STRUCTURES.register("highest_ceiling", () -> codecConv(HighestCeilingType.CODEC)),
        LOWEST_CEILING = DivineRegistries.STRUCTURES.register("lowest_ceiling", () -> codecConv(LowestCeilingType.CODEC));
    public static class Overworld {
        public static final ResourceKey<Structure>
            LIVESTOCK_MERCHANT_HUT = registerStructure("overworld/livestock_merchant_hut"),
            IGLOO = registerStructure("overworld/igloo"),

            ANCIENT_TOMB = registerStructure("overworld/ancient_tomb"),

            AMETHYST_HOUSE = registerStructure("overworld/amethyst_house");
    }
    public static class Iceika {
        public static final ResourceKey<Structure>
            DUNGEON = registerStructure("iceika/dungeon"),

            VILLAGE = registerStructure("iceika/village"),
            SURFACE_WORKSHOP = registerStructure("iceika/surface_workshop"),

            GROGLIN_VILLAGE = registerStructure("iceika/groglin_village"),

            GRUZZORLUG_VILLAGE = registerStructure("iceika/gruzzorlug_village"),
            SURFACE_GRUZZORLUG = registerStructure("iceika/surface_gruzzorlug"),

            WHALE_SKULL = registerStructure("iceika/whale_skull");
    }
    public static class Arcana {
        public static final ResourceKey<Structure>
            RUINED_PORTAL = registerStructure("arcana/ruined_portal"),
            LORD_VATTICUS_CARAVAN = registerStructure("arcana/lord_vatticus_caravan");
    }
    public static class Eden {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("eden_structures");
    }
    public static class Wildwood {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("wildwood_structures");
    }
    public static class Apalachia {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("apalachia_structures");
    }
    public static class Skythern {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("skythern_structures");
    }
    public static class Mortum {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("mortum_structures");
    }
    public static class Vethea {
        public static final ResourceKey<Structure>
            BIG_DREAM_TREE = registerStructure("vethea/big_dream_tree"),
            BIG_HYRETREE = registerStructure("vethea/big_hyretree"),

            FLOATING_ITEMS = registerStructure("vethea/floating_items"),
            LAMP = registerStructure("vethea/lamp"),
            VETHEA_RUINED_PORTAL = registerStructure("vethea/ruined_portal"),

            HUNGER_HOUSE = registerStructure("vethea/hunger_house"),
            INFUSION_OUTPOST = registerStructure("vethea/infusion_outpost"),

            CRYPT = registerStructure("vethea/crypt"),
            CRYPT2 = registerStructure("vethea/crypt2"),
            TEMPLE = registerStructure("vethea/temple"),

            HIVE = registerStructure("vethea/hive"),
            KAROS_MADHOUSE = registerStructure("vethea/karos_madhouse"),
            QUADROTIC_POST = registerStructure("vethea/quadrotic_post"),
            EVERGARDEN = registerStructure("vethea/evergarden"),
            RAGLOK_CHAMBER = registerStructure("vethea/raglok_chamber"),
            WRECK_HALL = registerStructure("vethea/wreck_hall");
    }
    public static void bootstrapStructureSets(BootstrapContext<StructureSet> context) {
        var structures = context.lookup(Registries.STRUCTURE);

        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Overworld.LIVESTOCK_MERCHANT_HUT.identifier()), new StructureSet(structures.getOrThrow(Overworld.LIVESTOCK_MERCHANT_HUT), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1234567890)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Overworld.IGLOO.identifier()), new StructureSet(structures.getOrThrow(Overworld.IGLOO), new RandomSpreadStructurePlacement(32, 16, RandomSpreadType.LINEAR, 25565)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Overworld.ANCIENT_TOMB.identifier()), new StructureSet(structures.getOrThrow(Overworld.ANCIENT_TOMB), new RandomSpreadStructurePlacement(50, 25, RandomSpreadType.LINEAR, 213551)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Overworld.AMETHYST_HOUSE.identifier()), new StructureSet(structures.getOrThrow(Overworld.AMETHYST_HOUSE), new RandomSpreadStructurePlacement(25, 12, RandomSpreadType.LINEAR, 423155)));

        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Iceika.DUNGEON.identifier()), new StructureSet(structures.getOrThrow(Iceika.DUNGEON), new RandomSpreadStructurePlacement(16, 4, RandomSpreadType.LINEAR, 182386712)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Iceika.VILLAGE.identifier()),
            new StructureSet(List.of(
                StructureSet.entry(structures.getOrThrow(Iceika.VILLAGE)),
                StructureSet.entry(structures.getOrThrow(Iceika.GROGLIN_VILLAGE)),
                StructureSet.entry(structures.getOrThrow(Iceika.GRUZZORLUG_VILLAGE))
            ), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 28487452)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Iceika.WHALE_SKULL.identifier()), new StructureSet(structures.getOrThrow(Iceika.WHALE_SKULL), new RandomSpreadStructurePlacement(5, 1, RandomSpreadType.LINEAR, 1823877126)));

        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Apalachia.STRUCTURES.identifier()), new StructureSet(structures.getOrThrow(Apalachia.STRUCTURES), new RandomSpreadStructurePlacement(4, 2, RandomSpreadType.LINEAR, 68435185)));
    }
    public static void bootstrapStructureTemplatePool(BootstrapContext<StructureTemplatePool> context) {
        var pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.LIVESTOCK_MERCHANT_HUT.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Overworld.LIVESTOCK_MERCHANT_HUT.identifier().toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.IGLOO.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Overworld.IGLOO.identifier().toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.ANCIENT_TOMB.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Overworld.ANCIENT_TOMB.identifier().toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.AMETHYST_HOUSE.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Overworld.AMETHYST_HOUSE.identifier().toString()), 1)),
                StructureTemplatePool.Projection.RIGID));

        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.DUNGEON.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/dungeon/center").toString()), 4),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/dungeon/hall").toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.VILLAGE.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/village/workshop_library").toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.GROGLIN_VILLAGE.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/tower").toString()), 3),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/market").toString()), 2),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/fortress").toString()), 1),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/outpost").toString()), 3),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/outpost_1").toString()), 2),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/groglin/army_camp").toString()), 2)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.GRUZZORLUG_VILLAGE.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/gruzzorlug/central_dome").toString()), 2),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/gruzzorlug/fortress").toString()), 1),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/gruzzorlug/gate").toString()), 1),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/gruzzorlug/tower").toString()), 3),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/gruzzorlug/army_camp").toString()), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.WHALE_SKULL.identifier()), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "iceika/whale_skull").toString()), 1)),
                StructureTemplatePool.Projection.RIGID));

        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia_structures")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_fallen_log").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_fallen_log2").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_fallen_log3").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_fallen_log4").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_fallen_log5").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_house").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_pillar1").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_pillar2").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_pillar3").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_pillar4").toString()), 1),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_portal_remnants1").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_portal_remnants2").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/apalachia_shrine").toString()), 5),
                Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia/eternal_archer_dungeon").toString()), 3)),
                StructureTemplatePool.Projection.RIGID));
    }
    public static void bootstrapStructure(BootstrapContext<Structure> context) {
        var biomeLookup = context.lookup(Registries.BIOME);
        var livestockSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(Tags.Biomes.IS_PLAINS), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        var iglooSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(Tags.Biomes.IS_SNOWY), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        var tombSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(Tags.Biomes.IS_PLAINS), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE);
        var amethystSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BURY);

        var iceikaDungeonSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.IS_ICEIKA), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BURY);
        var iceikaVillageSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.ALLOWS_ICEIKA_VILLAGE), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        var iceikaGroglinVillageSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.ALLOWS_GROGLIN_VILLAGE), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        var iceikaGruzzorlugVillageSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.ALLOWS_GRUZZORLUG_VILLAGE), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        // TODO: to change to BiomeRegistry.BONEYARD
        var iceikaWhaleSkullSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.IS_ICEIKA_OCEAN), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE);

        var apalachiaStructures = new Structure.StructureSettings(biomeLookup.getOrThrow(TagRegistry.Biomes.IS_APALACHIA), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);

        context.register(Overworld.LIVESTOCK_MERCHANT_HUT, new JigsawStructure(livestockSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.LIVESTOCK_MERCHANT_HUT.identifier())), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE));
        context.register(Overworld.IGLOO, new JigsawStructure(iglooSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.IGLOO.identifier())), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE));
        context.register(Overworld.ANCIENT_TOMB, new HighestCeilingType(tombSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.ANCIENT_TOMB.identifier())), Optional.empty(), 6, 55, 200, 4,  "full", 1));
        context.register(Overworld.AMETHYST_HOUSE, new JigsawStructure(amethystSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Overworld.AMETHYST_HOUSE.identifier())), 6, UniformHeight.of(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(-21)), false));

        context.register(Iceika.DUNGEON, new JigsawStructure(iceikaDungeonSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.DUNGEON.identifier())), 6, UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.absolute(50)), true));
        context.register(Iceika.VILLAGE, new JigsawStructure(iceikaVillageSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.VILLAGE.identifier())), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE));
        context.register(Iceika.GROGLIN_VILLAGE, new JigsawStructure(iceikaGroglinVillageSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.GROGLIN_VILLAGE.identifier())), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE));
        context.register(Iceika.GRUZZORLUG_VILLAGE, new JigsawStructure(iceikaGruzzorlugVillageSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.GRUZZORLUG_VILLAGE.identifier())), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE));
        context.register(Iceika.WHALE_SKULL, new JigsawStructure(iceikaWhaleSkullSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Iceika.WHALE_SKULL.identifier())), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.OCEAN_FLOOR_WG));

        context.register(Apalachia.STRUCTURES, new HighestGroundType(apalachiaStructures, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "twilight/apalachia_structures"))), Optional.empty(), 6, 10, 255, 0, "full", 1));
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