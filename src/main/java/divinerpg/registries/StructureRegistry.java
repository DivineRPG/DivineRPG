package divinerpg.registries;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import divinerpg.structure.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.*;
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

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.arcanaPortalFrame;
import static divinerpg.registries.BlockRegistry.mortumBlock;
import static divinerpg.registries.TagRegistry.Biomes.*;
import static net.minecraft.world.level.block.Blocks.AIR;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
import static net.minecraft.world.level.levelgen.Heightmap.Types.*;
import static net.minecraft.world.level.levelgen.structure.StructureSpawnOverride.BoundingBoxType.*;
import static net.minecraft.world.level.levelgen.structure.TerrainAdjustment.*;
import static net.minecraft.world.level.levelgen.structure.placement.AbstractSpreadingStructurePlacement.FrequencyReductionMethod.DEFAULT;
import static net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType.LINEAR;
import static net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool.Projection.*;
import static net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings.IGNORE_WATERLOGGING;

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
            DUNGEON_COMPLEX = registerStructure("iceika/dungeon/complex"),
            DUNGEON_WALL = registerStructure("iceika/dungeon/wall"),
            DUNGEON_SPAWNERS = registerStructure("iceika/dungeon/spawners"),
            DUNGEON_SPAWNERS_CENTER = registerStructure("iceika/dungeon/spawners_center"),
            DUNGEON_OBSTRUCTIONS = registerStructure("iceika/dungeon/obstructions"),
            DUNGEON_TRAPS = registerStructure("iceika/dungeon/traps"),
            DUNGEON = registerStructure("iceika/dungeon"),

            VILLAGE_COMPLEX = registerStructure("iceika/village/complex"),
            VILLAGE_STREETS = registerStructure("iceika/village/streets"),
            VILLAGE_STREET_LAMPS = registerStructure("iceika/village/street_lamps"),
            VILLAGE = registerStructure("iceika/village"),
            SURFACE_WORKSHOP = registerStructure("iceika/surface_workshop"),

            GROGLIN_COMPLEX = registerStructure("iceika/groglin/complex"),
            GROGLIN_STREETS = registerStructure("iceika/groglin/streets"),
            GROGLIN_WALL_BACK = registerStructure("iceika/groglin/wall/back"),
            GROGLIN_WALL_RIGHT = registerStructure("iceika/groglin/wall/right"),
            GROGLIN_WALL_RIGHT_1 = registerStructure("iceika/groglin/wall/right_1"),
            GROGLIN_WALL_RIGHT_2 = registerStructure("iceika/groglin/wall/right_2"),
            GROGLIN_WALL_RIGHT_3 = registerStructure("iceika/groglin/wall/right_3"),
            GROGLIN_WALL_RIGHT_4 = registerStructure("iceika/groglin/wall/right_4"),
            GROGLIN_WALL_LEFT = registerStructure("iceika/groglin/wall/left"),
            GROGLIN_WALL_LEFT_1 = registerStructure("iceika/groglin/wall/left_1"),
            GROGLIN_WALL_LEFT_2 = registerStructure("iceika/groglin/wall/left_2"),
            GROGLIN_WALL_LEFT_3 = registerStructure("iceika/groglin/wall/left_3"),
            GROGLIN_WALL_LEFT_4 = registerStructure("iceika/groglin/wall/left_4"),
            GROGLIN_VILLAGE = registerStructure("iceika/groglin_village"),

            GRUZZORLUG_COMPLEX = registerStructure("iceika/gruzzorlug/complex"),
            GRUZZORLUG_MINE = registerStructure("iceika/gruzzorlug/mine"),
            GRUZZORLUG_STATUE_BOTTOM = registerStructure("iceika/gruzzorlug/statue_bottom"),
            GRUZZORLUG_STREETS = registerStructure("iceika/gruzzorlug/streets"),
            GRUZZORLUG_LAMP = registerStructure("iceika/gruzzorlug/lamp"),
            GRUZZORLUG_WALL_FRONT_RIGHT = registerStructure("iceika/gruzzorlug/wall/front_right"),
            GRUZZORLUG_WALL_FRONT_RIGHT_TOWER = registerStructure("iceika/gruzzorlug/wall/front_right_tower"),
            GRUZZORLUG_WALL_FRONT_LEFT = registerStructure("iceika/gruzzorlug/wall/front_left"),
            GRUZZORLUG_WALL_FRONT_LEFT_TOWER = registerStructure("iceika/gruzzorlug/wall/front_left_tower"),
            GRUZZORLUG_WALL_BACK = registerStructure("iceika/gruzzorlug/wall/back"),
            GRUZZORLUG_WALL_BACK_PATCH = registerStructure("iceika/gruzzorlug/wall/back_patch"),
            GRUZZORLUG_WALL_BACK_RIGHT_PATCH = registerStructure("iceika/gruzzorlug/wall/back_right_patch"),
            GRUZZORLUG_WALL_BACK_RIGHT_TOWER = registerStructure("iceika/gruzzorlug/wall/back_right_tower"),
            GRUZZORLUG_WALL_BACK_LEFT_PATCH = registerStructure("iceika/gruzzorlug/wall/back_left_patch"),
            GRUZZORLUG_WALL_BACK_LEFT_TOWER = registerStructure("iceika/gruzzorlug/wall/back_left_tower"),
            GRUZZORLUG_WALL_RIGHT = registerStructure("iceika/gruzzorlug/wall/right"),
            GRUZZORLUG_WALL_LEFT = registerStructure("iceika/gruzzorlug/wall/left"),
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
            STRUCTURES = registerStructure("twilight/eden/structures");
    }
    public static class Wildwood {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("twilight/wildwood/structures");
    }
    public static class Apalachia {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("twilight/apalachia/structures");
    }
    public static class Skythern {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("twilight/skythern/structures");
    }
    public static class Mortum {
        public static final ResourceKey<Structure>
            STRUCTURES = registerStructure("twilight/mortum/structures");
    }
    public static class Vethea {
        public static final ResourceKey<Structure>
            BIG_DREAM_TREE = registerStructure("vethea/dream_grounds/big_dream_tree"),
            BIG_HYRETREE = registerStructure("vethea/hyrelands/big_hyretree"),

            FLOATING_ITEMS = registerStructure("vethea/all_biomes/floating_items"),
            LAMP = registerStructure("vethea/all_biomes/lamp"),
            RUINED_PORTAL = registerStructure("vethea/ember_caverns/ruined_portal"),

            HUNGER_HOUSE = registerStructure("vethea/ember_caverns/hunger_house"),
            INFUSION_OUTPOST = registerStructure("vethea/all_biomes/infusion_outpost"),

            CRYPT = registerStructure("vethea/ember_caverns/crypt"),
            CRYPT2 = registerStructure("vethea/ember_caverns/crypt2"),
            TEMPLE = registerStructure("vethea/dream_grounds/temple"),

            HIVE = registerStructure("vethea/dream_grounds/hive"),
            KAROS_MADHOUSE = registerStructure("vethea/hyrelands/karos_madhouse"),
            QUADROTIC_POST = registerStructure("vethea/hyrelands/quadrotic_post"),
            EVERGARDEN = registerStructure("vethea/hyrelands/evergarden"),
            RAGLOK_CHAMBER = registerStructure("vethea/scorched_tops/raglok_chamber"),
            WRECK_HALL = registerStructure("vethea/scorched_tops/wreck_hall");
    }
    public static void bootstrapStructure(BootstrapContext<Structure> context) {
        var biomes = context.lookup(Registries.BIOME);
        var pools = context.lookup(Registries.TEMPLATE_POOL);

        jigsaw(context, pools, Overworld.LIVESTOCK_MERCHANT_HUT, settings(biomes, Tags.Biomes.IS_PLAINS, BEARD_THIN), 6).heightmap(WORLD_SURFACE).register();
        jigsaw(context, pools, Overworld.IGLOO, settings(biomes, Tags.Biomes.IS_SNOWY, BEARD_THIN), 6).heightmap(WORLD_SURFACE).register();
        context.register(Overworld.ANCIENT_TOMB, new HighestCeilingType(settings(biomes, Tags.Biomes.IS_PLAINS, TerrainAdjustment.NONE), pool(pools, Overworld.ANCIENT_TOMB), Optional.empty(), 6, 55, 200, 4, "full", 1));
        jigsaw(context, pools, Overworld.AMETHYST_HOUSE, settings(biomes, BiomeTags.IS_OVERWORLD, UNDERGROUND_STRUCTURES, BURY), 6).range(-56, -21).register();

        jigsaw(context, pools, Iceika.DUNGEON, settings(biomes, IS_ICEIKA, BURY), 6).range(5, 50).expansionHack().liquidSettings(IGNORE_WATERLOGGING).register();
        jigsaw(context, pools, Iceika.VILLAGE, settings(biomes, HAS_STRUCTURE_ICEIKA_VILLAGE, BEARD_THIN), 7).expansionHack().heightmap(WORLD_SURFACE).maxDistance(116).register();
        jigsaw(context, pools, Iceika.SURFACE_WORKSHOP, settings(biomes, HAS_STRUCTURE_ICEIKA_VILLAGE, BEARD_THIN), 6).range(64, 255).maxDistance(1).register();
        jigsaw(context, pools, Iceika.GROGLIN_VILLAGE, settings(biomes, HAS_STRUCTURE_GROGLIN_VILLAGE, BEARD_THIN), 7).expansionHack().heightmap(WORLD_SURFACE).maxDistance(116).register();
        jigsaw(context, pools, Iceika.GRUZZORLUG_VILLAGE, settings(biomes, HAS_STRUCTURE_GRUZZORLUG_VILLAGE, BEARD_THIN), 7).expansionHack().heightmap(WORLD_SURFACE).maxDistance(116).register();
        jigsaw(context, pools, Iceika.SURFACE_GRUZZORLUG, settings(biomes, HAS_STRUCTURE_GRUZZORLUG_VILLAGE, BEARD_THIN), 6).range(64, 255).maxDistance(1).register();
        jigsaw(context, pools, Iceika.WHALE_SKULL, settings(biomes, HAS_STRUCTURE_WHALE_SKULL, NONE), 6).heightmap(OCEAN_FLOOR_WG).maxDistance(1).register();

        jigsaw(context, pools, Arcana.RUINED_PORTAL, settings(biomes, HAS_STRUCTURE_RUINED_PORTAL_ARCANA, BEARD_THIN), 6).heightmap(WORLD_SURFACE).maxDistance(1).register();
        jigsaw(context, pools, Arcana.LORD_VATTICUS_CARAVAN, settings(biomes, HAS_STRUCTURE_LORD_VATTICUS_CARAVAN, BEARD_THIN), 6).heightmap(WORLD_SURFACE).maxDistance(1).register();

        context.register(Eden.STRUCTURES, new HighestGroundType(settings(biomes, IS_EDEN, BEARD_THIN), pool(pools, Eden.STRUCTURES), Optional.empty(), 6, 10, 255, 0, "full", 1));
        context.register(Wildwood.STRUCTURES, new HighestGroundType(settings(biomes, IS_WILDWOOD, BEARD_THIN), pool(pools, Wildwood.STRUCTURES), Optional.empty(), 6, 10, 255, 0, "full", 1));
        context.register(Apalachia.STRUCTURES, new HighestGroundType(settings(biomes, IS_APALACHIA, BEARD_THIN), pool(pools, Apalachia.STRUCTURES), Optional.empty(), 6, 10, 255, 0, "full", 1));
        context.register(Skythern.STRUCTURES, new LowestGroundType(settings(biomes, IS_SKYTHERN, BEARD_THIN), pool(pools, Skythern.STRUCTURES), Optional.empty(), 6, 10, 255, 0, "slice", 1));
        context.register(Mortum.STRUCTURES, new LowestGroundType(settings(biomes, IS_MORTUM, UNDERGROUND_STRUCTURES, BEARD_THIN), pool(pools, Mortum.STRUCTURES), Optional.empty(), 6, 32, 100, 0, "random_section", 1));

        context.register(Vethea.BIG_DREAM_TREE, new LowestGroundType(settings(biomes, IS_VETHEA_DREAM_GROUNDS, NONE), pool(pools, Vethea.BIG_DREAM_TREE), Optional.empty(), 6, 55, 160, 0, "full", 1));
        context.register(Vethea.BIG_HYRETREE, new HighestGroundType(settings(biomes, IS_VETHEA_HYRELANDS, BEARD_THIN), pool(pools, Vethea.BIG_HYRETREE), Optional.empty(), 6, 156, 256, 0, "full", 1));

        jigsaw(context, pools, Vethea.FLOATING_ITEMS, settings(biomes, IS_VETHEA, UNDERGROUND_STRUCTURES, NONE), 6).range(-60, 310).maxDistance(1).register();
        context.register(Vethea.LAMP, new LowestGroundType(settings(biomes, IS_VETHEA, BEARD_THIN), pool(pools, Vethea.LAMP), Optional.empty(), 6, -60, 318, -1, "random_section", 1));
        jigsaw(context, pools, Vethea.RUINED_PORTAL, settings(biomes, IS_VETHEA_EMBER_CAVERNS, BEARD_THIN), 6).range(-60, 38).maxDistance(1).register();

        context.register(Vethea.HUNGER_HOUSE, new HighestCeilingType(settings(biomes, IS_VETHEA_EMBER_CAVERNS, NONE), pool(pools, Vethea.HUNGER_HOUSE), Optional.empty(), 6, -60, 50, -8, "full", 1));
        context.register(Vethea.INFUSION_OUTPOST, new LowestGroundType(settings(biomes, IS_VETHEA, BEARD_THIN), pool(pools, Vethea.INFUSION_OUTPOST), Optional.empty(), 6, -60, 318, -1, "random_section", 1));

        context.register(Vethea.CRYPT, new LowestGroundType(settings(biomes, IS_VETHEA_EMBER_CAVERNS, Map.of(
            MobCategory.MONSTER, new StructureSpawnOverride(
                STRUCTURE, WeightedList.of(
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.BIPHRON.get(), new UniformInt(1, 2)), 5),
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.VERMENOUS.get(), new UniformInt(1, 2)), 5)
                )
            )
        ), UNDERGROUND_STRUCTURES, NONE), pool(pools, Vethea.CRYPT), Optional.empty(), 6, -60, 45, 4, "full", 1));
        context.register(Vethea.CRYPT2, new LowestGroundType(settings(biomes, IS_VETHEA_EMBER_CAVERNS, Map.of(
            MobCategory.MONSTER, new StructureSpawnOverride(
                STRUCTURE, WeightedList.of(
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.BIPHRON.get(), new UniformInt(1, 2)), 5),
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.VERMENOUS.get(), new UniformInt(1, 2)), 5)
                )
            )
        ), UNDERGROUND_STRUCTURES, NONE), pool(pools, Vethea.CRYPT2), Optional.empty(), 6, -60, 45, 6, "full", 1));
        context.register(Vethea.TEMPLE, new LowestGroundType(settings(biomes, IS_VETHEA_DREAM_GROUNDS, BEARD_THIN), pool(pools, Vethea.TEMPLE), Optional.empty(), 6, 55, 160, 0, "full", 1));

        context.register(Vethea.HIVE, new LowestGroundType(settings(biomes, IS_VETHEA_DREAM_GROUNDS, Map.of(
            MobCategory.MONSTER, new StructureSpawnOverride(
                PIECE, WeightedList.of(
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.HIVE_SOLDIER.get(), new UniformInt(1, 2)), 5),
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.HOVER_STINGER.get(), new UniformInt(1, 2)), 5),
                    new Weighted<>(new MobSpawnSettings.SpawnerData(EntityRegistry.BIPHRON.get(), new UniformInt(1, 2)), 5)
                )
            )
        ), NONE), pool(pools, Vethea.HIVE), Optional.empty(), 6, 55, 160, 4, "full", 1));
        context.register(Vethea.KAROS_MADHOUSE, new LowestGroundType(settings(biomes, IS_VETHEA_HYRELANDS, NONE), pool(pools, Vethea.KAROS_MADHOUSE), Optional.empty(), 6, 160, 256, 2, "full", 1));
        context.register(Vethea.QUADROTIC_POST, new LowestCeilingType(settings(biomes, IS_VETHEA, NONE), pool(pools, Vethea.QUADROTIC_POST), Optional.empty(), 6, 128, 256, 3, "full", 1));
        context.register(Vethea.EVERGARDEN, new HighestGroundType(settings(biomes, IS_VETHEA_HYRELANDS, BEARD_THIN), pool(pools, Vethea.EVERGARDEN), Optional.empty(), 6, 160, 256, 0, "full", 1));
        context.register(Vethea.RAGLOK_CHAMBER, new HighestGroundType(settings(biomes, IS_VETHEA_SCORCHED_TOPS, NONE), pool(pools, Vethea.RAGLOK_CHAMBER), Optional.empty(), 6, 256, 296, 3, "full", 1));
        context.register(Vethea.WRECK_HALL, new HighestGroundType(settings(biomes, IS_VETHEA_SCORCHED_TOPS, BEARD_THIN), pool(pools, Vethea.WRECK_HALL), Optional.empty(), 6, 256, 300, 0, "full", 1));
    }
    public static void bootstrapStructureSets(BootstrapContext<StructureSet> context) {
        var structures = context.lookup(Registries.STRUCTURE);

        singleLinear(context, structures, Overworld.LIVESTOCK_MERCHANT_HUT, 25, 14, 25565);
        singleLinear(context, structures, Overworld.IGLOO, 32, 16, 25565);
        singleLinear(context, structures, Overworld.ANCIENT_TOMB, 50, 25, 213551);
        singleLinear(context, structures, Overworld.AMETHYST_HOUSE, new Vec3i(0, -15, 0), 25, 12, 423155);

        selectLinear(context, "iceika/dungeons", List.of(
            entry(structures, Iceika.DUNGEON)
        ), 16, 4, 182386712);
        selectLinear(context, "iceika/villages", List.of(
            entry(structures, Iceika.VILLAGE),
            entry(structures, Iceika.GROGLIN_VILLAGE),
            entry(structures, Iceika.GRUZZORLUG_VILLAGE)
        ), 32, 8, 28487452);
        selectLinear(context, "iceika/surface", List.of(
            entry(structures, Iceika.SURFACE_WORKSHOP),
            entry(structures, Iceika.SURFACE_GRUZZORLUG)
        ), 12, 4, 1678672354); // 3458678672354 was too large apparently, as this one strictly accepts only [non-negative] integers
        singleLinear(context, structures, Iceika.WHALE_SKULL, 5, 1, 1823877126);

        singleLinear(context, structures, Arcana.RUINED_PORTAL, 25, 8, 25565432);
        singleLinear(context, structures, Arcana.LORD_VATTICUS_CARAVAN, 25, 13, 25565573);

        singleLinear(context, structures, Eden.STRUCTURES, new Vec3i(0, 5, 0), 4, 2, 42312345);
        singleLinear(context, structures, Wildwood.STRUCTURES, new Vec3i(0, 5, 0), 4, 2, 21896785);
        singleLinear(context, structures, Apalachia.STRUCTURES, new Vec3i(0, 5, 0), 4, 2, 68435185);
        singleLinear(context, structures, Skythern.STRUCTURES, new Vec3i(0, 5, 0), 3, 2, 14122456);
        singleLinear(context, structures, Mortum.STRUCTURES, new Vec3i(0, 5, 0), 3, 2, 97124535);

        selectLinear(context, "vethea/big_trees", List.of(
            entry(structures, Vethea.BIG_DREAM_TREE),
            entry(structures, Vethea.BIG_HYRETREE)
        ), 16, 8, 557403648);
        singleLinear(context, structures, Vethea.FLOATING_ITEMS, 2, 1, 1586506120);
        singleLinear(context, structures, Vethea.LAMP, 8, 4, 404134514);
        singleLinear(context, structures, Vethea.RUINED_PORTAL, 14, 10, 1724795294);
        singleLinear(context, structures, Vethea.HUNGER_HOUSE, 16, 8, 1581946197);
        singleLinear(context, structures, Vethea.INFUSION_OUTPOST, 12, 6, 791986225);
        selectLinear(context, "vethea/dungeons", List.of(
            entry(structures, Vethea.CRYPT),
            entry(structures, Vethea.CRYPT2),
            entry(structures, Vethea.TEMPLE)
        ), 16, 12, 1587242645);
        selectLinear(context, "vethea/boss_structures", List.of(
            entry(structures, Vethea.HIVE),
            entry(structures, Vethea.KAROS_MADHOUSE),
            entry(structures, Vethea.QUADROTIC_POST),
            entry(structures, Vethea.EVERGARDEN),
            entry(structures, Vethea.RAGLOK_CHAMBER),
            entry(structures, Vethea.WRECK_HALL)
        ), 25, 12, 1733680842);
    }
    public static void bootstrapStructureTemplatePool(BootstrapContext<StructureTemplatePool> context) {
        var emptyPool = context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);

        singleRigid(context, emptyPool, Overworld.LIVESTOCK_MERCHANT_HUT);
        singleRigid(context, emptyPool, Overworld.IGLOO);
        singleRigid(context, emptyPool, Overworld.ANCIENT_TOMB);
        singleRigid(context, emptyPool, Overworld.AMETHYST_HOUSE);

        registerPool(context, emptyPool, Iceika.DUNGEON_COMPLEX, List.of(
            rigid("iceika/dungeon/hallway", 10),
            rigid("iceika/dungeon/junction_left", 8),
            rigid("iceika/dungeon/junction_right", 8),
            rigid("iceika/dungeon/crossroads", 6),
            rigid("iceika/dungeon/staircase_up", 4),
            rigid("iceika/dungeon/staircase_down", 4),
            rigid("iceika/dungeon/spawner_hallway", 3),
            rigid("iceika/dungeon/spawner_junction_left", 2),
            rigid("iceika/dungeon/spawner_junction_right", 2),
            rigid("iceika/dungeon/spawner_crossroads", 1),
            rigid("iceika/dungeon/treasure_room", 1),
            rigid("iceika/dungeon/greenhouse", 1),
            rigid("iceika/dungeon/wall", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON_WALL, List.of(
            empty(1),
            rigid("iceika/dungeon/wall", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON_SPAWNERS, List.of(
            rigid("iceika/dungeon/spawners/pale_archer", 1),
            rigid("iceika/dungeon/spawners/rollum", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON_SPAWNERS_CENTER, List.of(
            rigid("iceika/dungeon/spawners/pale_archer_center", 1),
            rigid("iceika/dungeon/spawners/rollum_center", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON_OBSTRUCTIONS, List.of(
            empty(32),
            rigid("iceika/dungeon/obstructions/post_1", 5),
            rigid("iceika/dungeon/obstructions/post_2", 5),
            rigid("iceika/dungeon/obstructions/door_1", 2),
            rigid("iceika/dungeon/obstructions/door_2", 2),
            rigid("iceika/dungeon/obstructions/snow", 1),
            rigid("iceika/dungeon/obstructions/pumpkin", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON_TRAPS, List.of(
            empty(15),
            rigid("iceika/dungeon/traps/allure", 1)
        ));
        registerPool(context, emptyPool, Iceika.DUNGEON, List.of(
            rigid("iceika/dungeon/center", 4),
            rigid("iceika/dungeon/hall", 1)
        ));

        registerPool(context, emptyPool, Iceika.VILLAGE_COMPLEX, List.of(
            match("iceika/village/road/road", 1),
            rigid("iceika/village/workshop_house_1", 5),
            rigid("iceika/village/workshop_house_2", 5),
            rigid("iceika/village/workshop_house_3", 5),
            rigid("iceika/village/workshop_house_4", 5),
            rigid("iceika/village/workshop_house_5", 5),
            rigid("iceika/village/workshop_house_6", 5)
        ));
        registerPool(context, emptyPool, Iceika.VILLAGE_STREETS, List.of(
            match("iceika/village/road/crossroads", 1),
            match("iceika/village/road/junction", 1),
            match("iceika/village/road/road", 2),
            match("iceika/village/road/junction_left", 2),
            match("iceika/village/road/junction_right", 2)
        ));
        registerPool(context, emptyPool, Iceika.VILLAGE_STREET_LAMPS, List.of(
            empty(1),
            rigid("iceika/lamps/coalstone_lamp_1", 1),
            rigid("iceika/lamps/coalstone_lamp_3", 1)
        ));
        registerPool(context, emptyPool, Iceika.VILLAGE, List.of(
            rigid("iceika/village/workshop_library", 1)
        ));
        registerPool(context, emptyPool, Iceika.SURFACE_WORKSHOP, List.of(
            rigid("iceika/lamps/coalstone_lamp_1", 5),
            rigid("iceika/lamps/coalstone_lamp_2", 5),
            rigid("iceika/lamps/coalstone_lamp_3", 5),
            match("iceika/campfire", 1)
        ));

        registerPool(context, emptyPool, Iceika.GROGLIN_COMPLEX, List.of(
            match("iceika/groglin/road/road", 1),
            match("iceika/groglin/road/junction_left", 1),
            match("iceika/groglin/road/junction_right", 1),
            rigid("iceika/groglin/army_camp", 1),
            rigid("iceika/groglin/cage", 4),
            rigid("iceika/groglin/farm", 4),
            rigid("iceika/groglin/spike", 2),
            rigid("iceika/groglin/statue", 1),
            rigid("iceika/groglin/outpost", 6),
            rigid("iceika/groglin/tower", 6),
            rigid("iceika/groglin/hut", 7),
            rigid("iceika/groglin/hut_1", 5),
            rigid("iceika/groglin/hut_2", 5),
            rigid("iceika/groglin/small_hut", 8)
        ));
        registerPool(context, emptyPool, Iceika.GROGLIN_STREETS, List.of(
            match("iceika/groglin/road/crossroads", 1),
            match("iceika/groglin/road/junction", 2),
            match("iceika/groglin/road/road", 2),
            match("iceika/groglin/road/junction_left", 4),
            match("iceika/groglin/road/junction_right", 4)
        ));
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_BACK);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_RIGHT);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_RIGHT_1);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_RIGHT_2);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_RIGHT_3);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_RIGHT_4);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_LEFT);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_LEFT_1);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_LEFT_2);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_LEFT_3);
        singleMatch(context, emptyPool, Iceika.GROGLIN_WALL_LEFT_4);
        registerPool(context, emptyPool, Iceika.GROGLIN_VILLAGE, List.of(
            rigid("iceika/groglin/tower", 3),
            rigid("iceika/groglin/market", 2),
            rigid("iceika/groglin/fortress", 1),
            rigid("iceika/groglin/outpost", 3),
            rigid("iceika/groglin/outpost_1", 2),
            rigid("iceika/groglin/army_camp", 2)
        ));

        registerPool(context, emptyPool, Iceika.GRUZZORLUG_COMPLEX, List.of(
            match("iceika/gruzzorlug/road/road", 1),
            match("iceika/gruzzorlug/road/junction_left", 1),
            match("iceika/gruzzorlug/road/junction_right", 1),
            rigid("iceika/gruzzorlug/army_camp", 5),
            rigid("iceika/gruzzorlug/tower", 6),
            rigid("iceika/gruzzorlug/hut", 7),
            rigid("iceika/gruzzorlug/small_hut", 8)
        ));
        registerPool(context, emptyPool, Iceika.GRUZZORLUG_MINE, List.of(
            rigid("iceika/gruzzorlug/mine/hallway", 5),
            rigid("iceika/gruzzorlug/mine/down", 5),
            rigid("iceika/gruzzorlug/mine/left_turn", 4),
            rigid("iceika/gruzzorlug/mine/right_turn", 4),
            rigid("iceika/gruzzorlug/mine/junction", 3),
            rigid("iceika/gruzzorlug/mine/crossing", 2),
            rigid("iceika/gruzzorlug/mine/up", 1)
        ));
        singleRigid(context, emptyPool, Iceika.GRUZZORLUG_STATUE_BOTTOM);
        registerPool(context, emptyPool, Iceika.GRUZZORLUG_STREETS, List.of(
            rigid("iceika/gruzzorlug/mine_entrance", 1),
            match("iceika/gruzzorlug/road/crossroads", 2),
            match("iceika/gruzzorlug/road/junction", 2),
            match("iceika/gruzzorlug/road/road", 2),
            match("iceika/gruzzorlug/road/junction_left", 4),
            match("iceika/gruzzorlug/road/junction_right", 4)
        ));
        registerPool(context, emptyPool, Iceika.GRUZZORLUG_LAMP, List.of(
            empty(4),
            rigid("iceika/gruzzorlug/lamp", 1)
        ));
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_FRONT_RIGHT);
        singleRigid(context, emptyPool, Iceika.GRUZZORLUG_WALL_FRONT_RIGHT_TOWER);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_FRONT_LEFT);
        singleRigid(context, emptyPool, Iceika.GRUZZORLUG_WALL_FRONT_LEFT_TOWER);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK_PATCH);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK_RIGHT_PATCH);
        singleRigid(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK_RIGHT_TOWER);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK_LEFT_PATCH);
        singleRigid(context, emptyPool, Iceika.GRUZZORLUG_WALL_BACK_LEFT_TOWER);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_RIGHT);
        singleMatch(context, emptyPool, Iceika.GRUZZORLUG_WALL_LEFT);
        registerPool(context, emptyPool, Iceika.GRUZZORLUG_VILLAGE, List.of(
            rigid("iceika/gruzzorlug/central_dome", 2),
            rigid("iceika/gruzzorlug/fortress", 1),
            rigid("iceika/gruzzorlug/gate", 1),
            rigid("iceika/gruzzorlug/tower", 3),
            rigid("iceika/gruzzorlug/army_camp", 1)
        ));
        registerPool(context, emptyPool, Iceika.SURFACE_GRUZZORLUG, List.of(
            rigid("iceika/gruzzorlug/statue_top", 1),
            rigid("iceika/gruzzorlug/igloo", 1)
        ));

        singleRigid(context, emptyPool, Iceika.WHALE_SKULL);

        registerPool(context, emptyPool, Arcana.RUINED_PORTAL, List.of(
            rigid(Arcana.RUINED_PORTAL.identifier().getPath(), Holder.direct(new StructureProcessorList(List.of(
                new RuleProcessor(List.of(
                    new ProcessorRule(new RandomBlockMatchTest(arcanaPortalFrame.get(), .5F), AlwaysTrueTest.INSTANCE, AIR.defaultBlockState()))
                ))
            )), 1)
        ));
        singleRigid(context, emptyPool, Arcana.LORD_VATTICUS_CARAVAN);

        registerPool(context, emptyPool, Eden.STRUCTURES, List.of(
            rigid("twilight/eden/ancient_eden_tree", 4),
            rigid("twilight/eden/broken_eden_portal", 15),
            rigid("twilight/eden/eden_hut1", 5),
            rigid("twilight/eden/eden_hut2", 5),
            rigid("twilight/eden/eden_hut3", 5),
            rigid("twilight/eden/eden_hut4", 5),
            rigid("twilight/eden/eden_pillar1", 10),
            rigid("twilight/eden/eden_pillar2", 10),
            rigid("twilight/eden/eden_pillar3", 10),
            rigid("twilight/eden/eden_pillar4", 10),
            rigid("twilight/eden/laying_eden_portal1", 10),
            rigid("twilight/eden/laying_eden_portal2", 10),
            rigid("twilight/eden/overgrown_eden_portal1", 10),
            rigid("twilight/eden/overgrown_eden_portal2", 10),
            rigid("twilight/eden/sun_clock", 5),
            rigid("twilight/eden/sunshrine", 5),
            rigid("twilight/eden/sunstorm_dungeon", 2)
        ));

        registerPool(context, emptyPool, Wildwood.STRUCTURES, List.of(
            rigid("twilight/wildwood/giant_mangrove", 5),
            rigid("twilight/wildwood/giant_mangrove_dead", 5),
            rigid("twilight/wildwood/giant_mangrove_treehouse", 5),
            rigid("twilight/wildwood/heavily_overgrown_wildwood_portal1", 5),
            rigid("twilight/wildwood/heavily_overgrown_wildwood_portal2", 5),
            rigid("twilight/wildwood/heavily_overgrown_wildwood_portal3", 5),
            rigid("twilight/wildwood/wildwood_dungeon1", 5),
            rigid("twilight/wildwood/wildwood_house", 5),
            rigid("twilight/wildwood/wildwood_outpost", 5),
            rigid("twilight/wildwood/wildwood_pillar1", 5),
            rigid("twilight/wildwood/wildwood_pillar2", 5),
            rigid("twilight/wildwood/termasect_nest", 3)
        ));

        registerPool(context, emptyPool, Apalachia.STRUCTURES, List.of(
            rigid("twilight/apalachia/apalachia_fallen_log", 5),
            rigid("twilight/apalachia/apalachia_fallen_log2", 5),
            rigid("twilight/apalachia/apalachia_fallen_log3", 5),
            rigid("twilight/apalachia/apalachia_fallen_log4", 5),
            rigid("twilight/apalachia/apalachia_fallen_log5", 5),
            rigid("twilight/apalachia/apalachia_house", 5),
            rigid("twilight/apalachia/apalachia_pillar1", 5),
            rigid("twilight/apalachia/apalachia_pillar2", 5),
            rigid("twilight/apalachia/apalachia_pillar3", 5),
            rigid("twilight/apalachia/apalachia_pillar4", 5),
            rigid("twilight/apalachia/apalachia_portal_remnants1", 5),
            rigid("twilight/apalachia/apalachia_portal_remnants2", 5),
            rigid("twilight/apalachia/apalachia_shrine", 5),
            rigid("twilight/apalachia/eternal_archer_dungeon", 3)
        ));

        registerPool(context, emptyPool, Skythern.STRUCTURES, List.of(
            rigid("twilight/skythern/pieces_of_skythern_portal1", 5),
            rigid("twilight/skythern/pieces_of_skythern_portal2", 5),
            rigid("twilight/skythern/pieces_of_skythern_portal3", 5),
            rigid("twilight/skythern/skythern_building", 5),
            rigid("twilight/skythern/skythern_fallen_log1", 5),
            rigid("twilight/skythern/skythern_fallen_log2", 5),
            rigid("twilight/skythern/skythern_fallen_log3", 5),
            rigid("twilight/skythern/skythern_fallen_log4", 5),
            rigid("twilight/skythern/skythern_fallen_log5", 5),
            rigid("twilight/skythern/skythern_pillar1", 5),
            rigid("twilight/skythern/skythern_pillar2", 5),
            rigid("twilight/skythern/skythern_shrine1", 5),
            rigid("twilight/skythern/skythern_shrine2", 5),
            rigid("twilight/skythern/skythern_shrine3", 5),
            rigid("twilight/skythern/experienced_cori_dungeon", 3)
        ));

        registerPool(context, emptyPool, Mortum.STRUCTURES, List.of(
            rigid("twilight/mortum/evidence_of_mortum_portal1", 5),
            rigid("twilight/mortum/evidence_of_mortum_portal2", 5),
            rigid("twilight/mortum/evidence_of_mortum_portal3", 5),
            rigid("twilight/mortum/mortum_hut", 5),
            rigid("twilight/mortum/mortum_pillar1", 5),
            rigid("twilight/mortum/mortum_pillar2", 5),
            rigid("twilight/mortum/mortum_pillar3", 5),
            rigid("twilight/mortum/mortum_shrine", 5),
            rigid("twilight/mortum/mortum_tomb1", 5),
            rigid("twilight/mortum/mortum_tomb2", 5)
        ));

        singleRigid(context, emptyPool, Vethea.BIG_DREAM_TREE);
        registerPool(context, emptyPool, Vethea.BIG_HYRETREE, List.of(
            rigid("vethea/hyrelands/big_hyretree", 1),
            rigid("vethea/hyrelands/big_hyretree2", 1)
        ));

        singleRigid(context, emptyPool, Vethea.CRYPT);
        singleRigid(context, emptyPool, Vethea.CRYPT2);
        singleRigid(context, emptyPool, Vethea.TEMPLE);

        registerPool(context, emptyPool, Vethea.FLOATING_ITEMS, List.of(
            rigid("vethea/all_biomes/bow", 1),
            rigid("vethea/all_biomes/hook", 1),
            rigid("vethea/all_biomes/mushroom", 1),
            rigid("vethea/all_biomes/pickaxe", 1),
            rigid("vethea/all_biomes/pointedsquare", 1),
            rigid("vethea/all_biomes/ring", 1),
            rigid("vethea/all_biomes/sword", 1),
            rigid("vethea/all_biomes/trident", 1)
        ));
        registerPool(context, emptyPool, Vethea.LAMP, List.of(
            rigid("vethea/all_biomes/lamp1", 1),
            rigid("vethea/all_biomes/lamp2", 1)
        ));
        registerPool(context, emptyPool, Vethea.RUINED_PORTAL, List.of(
            rigid(Vethea.RUINED_PORTAL.identifier().getPath(), Holder.direct(new StructureProcessorList(List.of(
                new RuleProcessor(List.of(
                    new ProcessorRule(new RandomBlockMatchTest(mortumBlock.get(), .5F), AlwaysTrueTest.INSTANCE, AIR.defaultBlockState()))
                ))
            )), 1)
        ));

        registerPool(context, emptyPool, Vethea.HUNGER_HOUSE, List.of(
            rigid("vethea/ember_caverns/hunger_house_1", 1),
            rigid("vethea/ember_caverns/hunger_house_2", 1),
            rigid("vethea/ember_caverns/hunger_house_3", 1)
        ));
        singleRigid(context, emptyPool, Vethea.INFUSION_OUTPOST);

        singleRigid(context, emptyPool, Vethea.HIVE);
        singleRigid(context, emptyPool, Vethea.KAROS_MADHOUSE);
        singleRigid(context, emptyPool, Vethea.QUADROTIC_POST);
        singleRigid(context, emptyPool, Vethea.EVERGARDEN);
        singleRigid(context, emptyPool, Vethea.RAGLOK_CHAMBER);
        singleRigid(context, emptyPool, Vethea.WRECK_HALL);
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
    // STRUCTURE
    // Structure settings
    private static Structure.StructureSettings settings(HolderGetter<Biome> biomes, TagKey<Biome> biomeTag, Map<MobCategory, StructureSpawnOverride> spawnOverrides, GenerationStep.Decoration step, TerrainAdjustment adjustment) {
        return new Structure.StructureSettings(biomes.getOrThrow(biomeTag), spawnOverrides, step, adjustment);
    }
    // Structure settings, surface structures
    private static Structure.StructureSettings settings(HolderGetter<Biome> biomes, TagKey<Biome> biomeTag, Map<MobCategory, StructureSpawnOverride> spawnOverrides, TerrainAdjustment adjustment) {
        return settings(biomes, biomeTag, spawnOverrides, GenerationStep.Decoration.SURFACE_STRUCTURES, adjustment);
    }
    // Structure settings, no spawn overrides
    private static Structure.StructureSettings settings(HolderGetter<Biome> biomes, TagKey<Biome> biomeTag, GenerationStep.Decoration step, TerrainAdjustment adjustment) {
        return settings(biomes, biomeTag, Map.of(), step, adjustment);
    }
    // Structure settings, no spawn overrides, surface structures
    private static Structure.StructureSettings settings(HolderGetter<Biome> biomes, TagKey<Biome> biomeTag, TerrainAdjustment adjustment) {
        return settings(biomes, biomeTag, GenerationStep.Decoration.SURFACE_STRUCTURES, adjustment);
    }
    // Template pool
    private static Holder<StructureTemplatePool> pool(HolderGetter<StructureTemplatePool> pools, ResourceKey<Structure> structure) {
        return pools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, structure.identifier()));
    }
    private static JigsawBuilder jigsaw(BootstrapContext<Structure> context, HolderGetter<StructureTemplatePool> pools, ResourceKey<Structure> structure, Structure.StructureSettings settings, int size) {
        return new JigsawBuilder(context, pools, structure, settings, size);
    }
    private static class JigsawBuilder {
        private final BootstrapContext<Structure> context;
        private final HolderGetter<StructureTemplatePool> pools;
        private final ResourceKey<Structure> structure;
        private final Structure.StructureSettings settings;
        private final int size;
        private HeightProvider height = ConstantHeight.of(VerticalAnchor.absolute(0));
        private boolean useExpansionHack = false;
        @Nullable private Heightmap.Types heightmap = null;
        private JigsawStructure.MaxDistance maxDistanceFromCenter = new JigsawStructure.MaxDistance(80);
        private LiquidSettings liquidSettings = JigsawStructure.DEFAULT_LIQUID_SETTINGS;
        private JigsawBuilder(BootstrapContext<Structure> context, HolderGetter<StructureTemplatePool> pools, ResourceKey<Structure> structure, Structure.StructureSettings settings, int size) {
            this.context = context;
            this.pools = pools;
            this.structure = structure;
            this.settings = settings;
            this.size = size;
        }
        public JigsawBuilder height(int y) {
            height = ConstantHeight.of(VerticalAnchor.absolute(y));
            return this;
        }
        public JigsawBuilder range(int min, int max) {
            height = UniformHeight.of(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max));
            return this;
        }
        public JigsawBuilder expansionHack() {
            useExpansionHack = true;
            return this;
        }
        public JigsawBuilder heightmap(Heightmap.Types type) {
            heightmap = type;
            return this;
        }
        public JigsawBuilder maxDistance(int distance) {
            maxDistanceFromCenter = new JigsawStructure.MaxDistance(distance);
            return this;
        }
        public JigsawBuilder liquidSettings(LiquidSettings settings) {
            liquidSettings = settings;
            return this;
        }
        public void register() {
            context.register(structure, new JigsawStructure(settings, pool(pools, structure), Optional.empty(), size, height, useExpansionHack, Optional.ofNullable(heightmap), maxDistanceFromCenter, List.of(), JigsawStructure.DEFAULT_DIMENSION_PADDING, liquidSettings));
        }
    }
    // STRUCTURE SET
    // Single
    private static void singleSpread(BootstrapContext<StructureSet> context, HolderGetter<Structure> structures, ResourceKey<Structure> structure, Vec3i offset, AbstractSpreadingStructurePlacement.FrequencyReductionMethod method, float frequency, int spacing, int separation, RandomSpreadType spreadType, int salt) {
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, structure.identifier()), new StructureSet(structures.getOrThrow(structure), new RandomSpreadStructurePlacement(offset, method, frequency, salt, Optional.empty(), spacing, separation, spreadType)));
    }
    // Single, specified locale offset, default method and frequency, LINEAR
    private static void singleLinear(BootstrapContext<StructureSet> context, HolderGetter<Structure> structures, ResourceKey<Structure> structure, Vec3i offset, int spacing, int separation, int salt) {
        singleSpread(context, structures, structure, offset, DEFAULT, 1, spacing, separation, LINEAR, salt);
    }
    // Single, no locale offset, default method and frequency, LINEAR
    private static void singleLinear(BootstrapContext<StructureSet> context, HolderGetter<Structure> structures, ResourceKey<Structure> structure, int spacing, int separation, int salt) {
        singleSpread(context, structures, structure, Vec3i.ZERO, DEFAULT, 1, spacing, separation, LINEAR, salt);
    }
    // Selection
    private static void selectSpread(BootstrapContext<StructureSet> context, String path, List<StructureSet.StructureSelectionEntry> entries, StructurePlacement placement) {
        context.register(ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(MODID, path)), new StructureSet(entries, placement));
    }
    // Selection, LINEAR
    private static void selectLinear(BootstrapContext<StructureSet> context, String path, List<StructureSet.StructureSelectionEntry> entries, int spacing, int separation, int salt) {
        selectSpread(context, path, entries, new RandomSpreadStructurePlacement(spacing, separation, LINEAR, salt));
    }
    // Default weight
    private static StructureSet.StructureSelectionEntry entry(HolderGetter<Structure> structures, ResourceKey<Structure> structure) {
        return StructureSet.entry(structures.getOrThrow(structure));
    }
    // Specified weight
    private static StructureSet.StructureSelectionEntry entry(HolderGetter<Structure> structures, ResourceKey<Structure> structure, int weight) {
        return StructureSet.entry(structures.getOrThrow(structure), weight);
    }
    // TEMPLATE_POOL
    // List
    private static void registerPool(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> fallback, ResourceKey<Structure> structure, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> templates, StructureTemplatePool.Projection projection) {
        context.register(ResourceKey.create(Registries.TEMPLATE_POOL, structure.identifier()), new StructureTemplatePool(fallback, templates, projection));
    }
    // List, RIGID
    private static void registerPool(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> fallback, ResourceKey<Structure> structure, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> templates) {
        registerPool(context, fallback, structure, templates, RIGID);
    }
    // RIGID, custom processor
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> rigid(String path, Holder<StructureProcessorList> processors, int weight) {
        return Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, path).toString(), processors), weight);
    }
    // RIGID, no processor
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> rigid(String path, int weight) {
        return Pair.of(StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, path).toString()), weight);
    }
    // TERRAIN_MATCHING, custom processor
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> match(String path, Holder<StructureProcessorList> processors, int weight) {
        var element = StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, path).toString(), processors);
        return Pair.of(ignored -> element.apply(TERRAIN_MATCHING), weight);
    }
    // TERRAIN_MATCHING, no processor
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> match(String path, int weight) {
        var element = StructurePoolElement.single(Identifier.fromNamespaceAndPath(MODID, path).toString());
        return Pair.of(ignored -> element.apply(TERRAIN_MATCHING), weight);
    }
    // Empty entry
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> empty(int weight) {
        return Pair.of(StructurePoolElement.empty(), weight);
    }
    // Single, RIGID
    private static void singleRigid(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> fallback, ResourceKey<Structure> structure) {
        registerPool(context, fallback, structure, List.of(Pair.of(StructurePoolElement.single(structure.identifier().toString()), 1)), RIGID);
    }
    // Single, TERRAIN_MATCHING
    private static void singleMatch(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> fallback, ResourceKey<Structure> structure) {
        registerPool(context, fallback, structure, List.of(Pair.of(StructurePoolElement.single(structure.identifier().toString()), 1)), TERRAIN_MATCHING);
    }
}