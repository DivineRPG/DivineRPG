package divinerpg.dimensions.vethea_new;

import divinerpg.api.Reference;
import divinerpg.dimensions.vethea.WorldGenVetheanFlower;
import divinerpg.dimensions.vethea.village.WorldGenVillageIsland;
import divinerpg.registry.ModBlocks;
import divinerpg.structure.legacy.DrpgLegacyStructure;
import divinerpg.structure.template.DivineLargeStructure;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.MapGenStructure;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class VetheaChunkGenerator implements IChunkGenerator {

    private final List<VetheaLevelGenerators> levels = new ArrayList<>();
    private World world;
    private int floorHeight = 48;
    private int roofHeight = 16;

    public VetheaChunkGenerator(World world) {
        this.world = world;
        int height = world.getHeight();

        int index = 0;

        for (int i = 0; i < height; i += floorHeight) {
            VetheaLevelGenerators level = new VetheaLevelGenerators(i, roofHeight);
            customize(level, index);
            levels.add(level);
            index++;
        }
    }

    private void customize(VetheaLevelGenerators level, int position) {

        //
        // Crystal lakes
        //
        WorldGenMinable large = new WorldGenMinable(ModBlocks.fireCrystal.getDefaultState(),
                50,
                BlockStateMatcher.forBlock(ModBlocks.dreamGrass));

        WorldGenMinable meduim = new WorldGenMinable(ModBlocks.fireCrystal.getDefaultState(),
                45,
                BlockStateMatcher.forBlock(ModBlocks.dreamGrass));

        WorldGenMinable small = new WorldGenMinable(ModBlocks.fireCrystal.getDefaultState(),
                20,
                BlockStateMatcher.forBlock(ModBlocks.dreamGrass));

        // surface Y pos for current floor
        int surfaceLevel = position * floorHeight + roofHeight;

        level.addWorldGen(new WorldGenEnhanced(large, 7 * 6, surfaceLevel));
        level.addWorldGen(new WorldGenEnhanced(meduim, 2 * 6, surfaceLevel));
        level.addWorldGen(new WorldGenEnhanced(small, 6, surfaceLevel));

        // ************************************************************************************

        //
        // Trees
        //
        for (int i = 0; i < 7; i++) {
            TempleWorldGenerator tree = new TempleWorldGenerator(createForAllLevels(String.format("floatingtree%s", i + 1)),
                    new BlockPos(11, (floorHeight - roofHeight) / 2, 11));

            // trees will be over player height
            level.addWorldGen(new WorldGenEnhanced(tree, 5, surfaceLevel + 8));
        }

        // ************************************************************************************

        //
        // Pillar
        //
        level.addWorldGen(new WorldGenEnhanced(new WorldGenVetheanPillarNew(floorHeight - roofHeight), 24, surfaceLevel));

        //
        // Infusion
        //
        level.addWorldGen(new WorldGenEnhanced(new TempleWorldGenerator(createForAllLevels("infusionoutpost"), true), 43, surfaceLevel));

        //
        // Lamps
        //
        for (int i = 1; i <= 2; i++) {
            level.addWorldGen(new WorldGenEnhanced(new TempleWorldGenerator(createForAllLevels(String.format("lamp%s", i)), new BlockPos(10, 0, 10)), 40, surfaceLevel));
        }

        //
        // Items
        //
        String[] items = {"bow", "hook", "mushroom", "pickaxe", "pointedsquare", "ring", "sword", "trident"};

        for (String item : items) {
            level.addWorldGen(new WorldGenEnhanced(new TempleWorldGenerator(createForAllLevels(item), new BlockPos(3, 0, 16)), 60, surfaceLevel));
        }

        //
        // TODO remake FloorTexture
        //


        //
        // Level dependent structures
        //
        switch (position) {
            case 0:

                level.addStructure(new DivineLargeStructure(world,
                        "Crypt1",
                        createForVethea(position, "crypt1"),
                        position * floorHeight + 10,
                        10));

               /* level.addStructure(new DivineLargeStructure(world,
                        "Crypt2",
                        createForVethea(position, "crypt2"),
                        position * floorHeight + 13,
                        40));*/

                for (int i = 4; i <= 6; i++) {
                    level.addWorldGen(new WorldGenEnhanced(
                            new TempleWorldGenerator(createForVethea(position, "tree" + i),
                                    true), 24, surfaceLevel));
                }

               /* level.addStructure(new DrpgLegacyStructure("VetheaVillage",
                        5,
                        new WorldGenVillageIsland(),
                        30));*/

                addFlowers(level, surfaceLevel, ModBlocks.greenGemtop, ModBlocks.purpleGemtop, ModBlocks.yellowDulah, ModBlocks.greenDulah);
                break;

            case 1:
                level.addStructure(new DivineLargeStructure(world,
                        "Hive",
                        createForVethea(position, "hive"),
                        surfaceLevel,
                        25));

                level.addStructure(new DivineLargeStructure(world,
                        "Pyramid1",
                        createForVethea(position, "pyramid"),
                        surfaceLevel,
                        25));

                level.addStructure(new DivineLargeStructure(world,
                        "Pyramid2",
                        createForVethea(position, "pyramid2"),
                        surfaceLevel,
                        25));

                level.addWorldGen(new WorldGenEnhanced(
                        new TempleWorldGenerator(createForVethea(position, "tree3"),
                                true), 10, surfaceLevel));

                level.addWorldGen(new WorldGenEnhanced(
                        new TempleWorldGenerator(createForVethea(0, "tree3"),
                                true), 10, surfaceLevel));

                addFlowers(level, surfaceLevel, ModBlocks.fernite, ModBlocks.dreamglow, ModBlocks.shimmer);
                break;

            case 2:
                level.addStructure(new DivineLargeStructure(world,
                        "Karosmadhouse",
                        createForVethea(position, "karosmadhouse"),
                        surfaceLevel,
                        10));

                level.addWorldGen(new WorldGenEnhanced(
                        new TempleWorldGenerator(createForVethea(position, "quadroticpost"),
                                true), 30, surfaceLevel));

                for (int i = 7; i <= 8; i++) {
                    level.addWorldGen(new WorldGenEnhanced(
                            new TempleWorldGenerator(createForVethea(position, "tree" + i),
                                    true), 24, surfaceLevel));
                }

                addFlowers(level, surfaceLevel, ModBlocks.shineGrass, ModBlocks.cracklespike, ModBlocks.bulbatobe);
                break;

            case 3:
                level.addStructure(new DivineLargeStructure(world,
                        "Evergarden",
                        createForVethea(position, "evergarden"),
                        surfaceLevel,
                        30));
                level.addStructure(new DivineLargeStructure(world,
                        "4Tree1",
                        createForVethea(position, "layer4tree1"),
                        surfaceLevel,
                        25));
                level.addStructure(new DivineLargeStructure(world,
                        "4Tree2",
                        createForVethea(position, "layer4tree2"),
                        surfaceLevel,
                        25));
                level.addStructure(new DivineLargeStructure(world,
                        "RaglokChamber",
                        createForVethea(position, "raglokchamber"),
                        surfaceLevel,
                        30));
                level.addStructure(new DivineLargeStructure(world,
                        "WreckHall",
                        createForVethea(position, "wreckhall"),
                        surfaceLevel,
                        30));

                addFlowers(level, surfaceLevel, ModBlocks.shimmer, ModBlocks.shineGrass, ModBlocks.dreamglow);
                break;
        }
    }

    private void addFlowers(VetheaLevelGenerators level, int height, Block... blocks) {
        for (Block block : blocks) {
            level.addWorldGen(new WorldGenEnhanced(new WorldGenVetheanFlower(block), 5, height));
        }
    }

    private ResourceLocation createForVethea(int level, String structureFolder) {
        return new ResourceLocation(Reference.MODID, String.format("vethea/%slevel/%s", level, structureFolder));
    }

    private ResourceLocation createForAllLevels(String structureName) {
        return new ResourceLocation(Reference.MODID, String.format("vethea/all_floors/%s", structureName));
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        levels.forEach(level -> level.generateChunk(world, chunkPrimer, x, z));
        Chunk chunk = new Chunk(world, chunkPrimer, x, z);
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
        Random random = world.setRandomSeed(x, z, 10387313);
        levels.forEach(level -> level.populate(world, random, x, z));
    }

    @Override
    public boolean generateStructures(Chunk chunk, int i, int i1) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.getBiomeProvider().getBiome(pos);
        return biome.getSpawnableList(creatureType);
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World world, String s, BlockPos blockPos, boolean b) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunk, int i, int i1) {
        // ignored
    }

    @Override
    public boolean isInsideStructure(World world, String s, BlockPos blockPos) {
        MapGenStructure structure = levels.stream().map(x -> x.findStructure(s)).filter(Objects::nonNull).findFirst().orElse(null);
        if (structure != null) {
            return structure.isInsideStructure(blockPos);
        }

        return false;
    }
}
