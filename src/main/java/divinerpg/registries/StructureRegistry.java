package divinerpg.registries;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import divinerpg.structure.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
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
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;

public class StructureRegistry {
    public static final StructurePlaceSettings defaultSettings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setLiquidSettings(LiquidSettings.APPLY_WATERLOGGING);

    public static final DeferredHolder<StructureType<?>, StructureType<?>> HIGHEST_GROUND = DivineRegistries.STRUCTURES.register("highest_ground", () -> codecConv(HighestGroundType.CODEC)), LOWEST_GROUND = DivineRegistries.STRUCTURES.register("lowest_ground", () -> codecConv(LowestGroundType.CODEC)), HIGHEST_CEILING = DivineRegistries.STRUCTURES.register("highest_ceiling", () -> codecConv(HighestCeilingType.CODEC)), LOWEST_CEILING = DivineRegistries.STRUCTURES.register("lowest_ceiling", () -> codecConv(LowestCeilingType.CODEC));

    public static final ResourceKey<Structure> LORD_VATTICUS_CARAVAN = registerStructure("arcana/lord_vatticus_caravan");
    public static final ResourceKey<Structure> RUINED_PORTAL = registerStructure("arcana/ruined_portal");

    public static final ResourceKey<Structure> DUNGEON = registerStructure("iceika/dungeon");
    public static final ResourceKey<Structure> GROGLIN_VILLAGE = registerStructure("iceika/groglin_village");
    public static final ResourceKey<Structure> GRUZZORLUG_VILLAGE = registerStructure("iceika/gruzzorlug_village");
    public static final ResourceKey<Structure> SURFACE_GRUZZORLUG = registerStructure("iceika/surface_gruzzorlug");
    public static final ResourceKey<Structure> SURFACE_WORKSHOP = registerStructure("iceika/surface_workshop");
    public static final ResourceKey<Structure> VILLAGE = registerStructure("iceika/village");
    public static final ResourceKey<Structure> WHALE_SKULL = registerStructure("iceika/whale_skull");

    public static final ResourceKey<Structure> BIG_DREAM_TREE = registerStructure("vethea/big_dream_tree");
    public static final ResourceKey<Structure> BIG_HYRETREE = registerStructure("vethea/big_hyretree");
    public static final ResourceKey<Structure> CRYPT = registerStructure("vethea/crypt");
    public static final ResourceKey<Structure> CRYPT2 = registerStructure("vethea/crypt2");
    public static final ResourceKey<Structure> EVERGARDEN = registerStructure("vethea/evergarden");
    public static final ResourceKey<Structure> FLOATING_ITEMS = registerStructure("vethea/floating_items");
    public static final ResourceKey<Structure> HIVE = registerStructure("vethea/hive");
    public static final ResourceKey<Structure> HUNGER_HOUSE = registerStructure("vethea/hunger_house");
    public static final ResourceKey<Structure> INFUSION_OUTPOST = registerStructure("vethea/infusion_outpost");
    public static final ResourceKey<Structure> KAROS_MADHOUSE = registerStructure("vethea/karos_madhouse");
    public static final ResourceKey<Structure> LAMP = registerStructure("vethea/lamp");
    public static final ResourceKey<Structure> QUADROTIC_POST = registerStructure("vethea/quadrotic_post");
    public static final ResourceKey<Structure> RAGLOK_CHAMBER = registerStructure("vethea/raglok_chamber");
    public static final ResourceKey<Structure> VETHEA_RUINED_PORTAL = registerStructure("vethea/ruined_portal");
    public static final ResourceKey<Structure> TEMPLE = registerStructure("vethea/temple");
    public static final ResourceKey<Structure> WRECK_HALL = registerStructure("vethea/wreck_hall");

    public static final ResourceKey<Structure> AMETHYST_HOUSE = registerStructure("amethyst_house");
    public static final ResourceKey<Structure> ANCIENT_TOMB = registerStructure("ancient_tomb");
    public static final ResourceKey<Structure> APALACHIA_STRUCTURES = registerStructure("apalachia_structures");
    public static final ResourceKey<Structure> EDEN_STRUCTURES = registerStructure("eden_structures");
    public static final ResourceKey<Structure> IGLOO = registerStructure("igloo");
    public static final ResourceKey<Structure> LIVESTOCK_MERCHANT_HUT = registerStructure("livestock_merchant_hut");
    public static final ResourceKey<Structure> MORTUM_STRUCTURES = registerStructure("mortum_structures");
    public static final ResourceKey<Structure> SKYTHERN_STRUCTURES = registerStructure("skythern_structures");
    public static final ResourceKey<Structure> WILDWOOD_STRUCTURES = registerStructure("wildwood_structures");

    public static void bootstrapStructureSets(BootstrapContext<StructureSet> context) {
        var structureLookup = context.lookup(Registries.STRUCTURE);

        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, "amethyst_house")), new StructureSet(structureLookup.getOrThrow(AMETHYST_HOUSE), new RandomSpreadStructurePlacement(25, 12, RandomSpreadType.LINEAR, 423155)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, "ancient_tomb")), new StructureSet(structureLookup.getOrThrow(ANCIENT_TOMB), new RandomSpreadStructurePlacement(50, 25, RandomSpreadType.LINEAR, 213551)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, "igloo")), new StructureSet(structureLookup.getOrThrow(IGLOO), new RandomSpreadStructurePlacement(32, 16, RandomSpreadType.LINEAR, 25565)));
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, "livestock_merchant_hut")), new StructureSet(structureLookup.getOrThrow(LIVESTOCK_MERCHANT_HUT), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1234567890)));
    }

    public static void bootstrapStructureTemplatePool(BootstrapContext<StructureTemplatePool> context) {
        var pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/amethyst_house")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "overworld/amethyst_house").toString()), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/ancient_tomb")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "overworld/ancient_tomb").toString()), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/igloo")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "overworld/igloo").toString()), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut")), new StructureTemplatePool(pools.getOrThrow(Pools.EMPTY), List.of(Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut").toString()), 1)), StructureTemplatePool.Projection.RIGID));

    }

    public static void bootstrapStructure(BootstrapContext<Structure> context) {
        var biomeLookup = context.lookup(Registries.BIOME);
        var amethystSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BURY);
        var tombSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", "is_plains"))), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE);
        var iglooSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", "is_snowy"))), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
        var livestockSettings = new Structure.StructureSettings(biomeLookup.getOrThrow(TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", "is_plains"))), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);

        context.register(AMETHYST_HOUSE, new JigsawStructure(amethystSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/amethyst_house"))), 6, UniformHeight.of(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(-21)), false, Heightmap.Types.WORLD_SURFACE_WG));
        context.register(ANCIENT_TOMB, new HighestCeilingType(tombSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/ancient_tomb"))), Optional.empty(), 6, 55, 200, 4,  "full", 1));
        context.register(IGLOO, new JigsawStructure(iglooSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/igloo"))), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        context.register(LIVESTOCK_MERCHANT_HUT, new JigsawStructure(livestockSettings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(MODID, "overworld/livestock_merchant_hut"))), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
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