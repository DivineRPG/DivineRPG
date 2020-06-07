package divinerpg.dimensions.vethea;

import divinerpg.DivineRPG;
import divinerpg.registry.BlockRegistry;
import divinerpg.structure.vethea.crypt1.Crypt1;
import divinerpg.structure.vethea.crypt2.Crypt2;
import divinerpg.structure.vethea.evergarden.Evergarden;
import divinerpg.structure.vethea.hive.Hive;
import divinerpg.structure.vethea.hungerhouse.HungerHouse1;
import divinerpg.structure.vethea.hungerhouse.HungerHouse2;
import divinerpg.structure.vethea.hungerhouse.HungerHouse3;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouse;
import divinerpg.structure.vethea.quadroticpost.QuadroticPost;
import divinerpg.structure.vethea.raglokchamber.RaglokChamber;
import divinerpg.structure.vethea.temple1.Temple1;
import divinerpg.structure.vethea.temple2.Temple2;
import divinerpg.structure.vethea.wreckhall.WreckHall;
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

        for (int i = 0; i < 4; i++) {
            VetheaLevelGenerators level = new VetheaLevelGenerators(floorHeight * i, roofHeight);
            customize(level, i);
            levels.add(level);
        }
    }

    private void customize(VetheaLevelGenerators level, int position) {

        //
        // Crystal lakes
        //
        WorldGenMinable large = new WorldGenMinable(BlockRegistry.fireCrystal.getDefaultState(),
                50,
                BlockStateMatcher.forBlock(BlockRegistry.dreamGrass));

        WorldGenMinable meduim = new WorldGenMinable(BlockRegistry.fireCrystal.getDefaultState(),
                45,
                BlockStateMatcher.forBlock(BlockRegistry.dreamGrass));

        WorldGenMinable small = new WorldGenMinable(BlockRegistry.fireCrystal.getDefaultState(),
                20,
                BlockStateMatcher.forBlock(BlockRegistry.dreamGrass));

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
        // Pillar (does not generate on the top layer)
        //
        if(position < 3) {
            level.addWorldGen(new WorldGenEnhanced(new WorldGenVetheanPillarNew(floorHeight - roofHeight), 24, surfaceLevel));
        }

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
        // Level dependent structures
        //
        switch (position) {
            case 0:

                level.addStructure(new Crypt1(world, 18, 10));
                level.addStructure(new Crypt2(world, 18, 12));

                level.addStructure(new HungerHouse1(world, 18, 24));
                level.addStructure(new HungerHouse2(world, 18, 22));
                level.addStructure(new HungerHouse3(world, 18, 24));

                for (int i = 4; i <= 6; i++) {
                    level.addWorldGen(new WorldGenEnhanced(
                            new TempleWorldGenerator(createForVethea(position, "tree" + i),
                                    true), 24, surfaceLevel));
                }

                addFlowers(level, surfaceLevel, BlockRegistry.greenGemtop, BlockRegistry.purpleGemtop, BlockRegistry.yellowDulah, BlockRegistry.greenDulah);
                break;

            case 1:

                level.addStructure(new Hive(world, 20, 64));
                level.addStructure(new Temple1(world, 20, 64));
                level.addStructure(new Temple2(world, 20, 64));


                level.addWorldGen(new WorldGenEnhanced(
                        new TempleWorldGenerator(createForVethea(position, "tree3"),
                                true), 10, surfaceLevel));

                level.addWorldGen(new WorldGenEnhanced(
                        new TempleWorldGenerator(createForVethea(0, "tree3"),
                                true), 10, surfaceLevel));

                addFlowers(level, surfaceLevel, BlockRegistry.fernite, BlockRegistry.dreamglow, BlockRegistry.shimmer);
                break;

            case 2:

                level.addStructure(new QuadroticPost(world, 15,112));
                level.addStructure(new KarosMadhouse(world, 15,112));

                for (int i = 7; i <= 8; i++) {
                    level.addWorldGen(new WorldGenEnhanced(
                            new TempleWorldGenerator(createForVethea(position, "tree" + i),
                                    true), 24, surfaceLevel));
                }

                addFlowers(level, surfaceLevel, BlockRegistry.shineGrass, BlockRegistry.cracklespike, BlockRegistry.bulbatobe);
                break;

            case 3:
                level.addStructure(new Evergarden(world, 22,160));
                level.addStructure(new RaglokChamber(world, 22,160));
                level.addStructure(new WreckHall(world, 22,160));

                addFlowers(level, surfaceLevel, BlockRegistry.shimmer, BlockRegistry.shineGrass, BlockRegistry.dreamglow);
                break;
        }
    }

    private void addFlowers(VetheaLevelGenerators level, int height, Block... blocks) {
        for (Block block : blocks) {
            level.addWorldGen(new WorldGenEnhanced(new WorldGenVetheanFlower(block), 5, height));
        }
    }

    private ResourceLocation createForVethea(int level, String structureFolder) {
        return new ResourceLocation(DivineRPG.MODID, String.format("vethea/layer%s/%s", level + 1, structureFolder));
    }

    private ResourceLocation createForAllLevels(String structureName) {
        return new ResourceLocation(DivineRPG.MODID, String.format("vethea/all_floors/%s", structureName));
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
    public void populate(int chunkX, int chunkZ) {
        Random random = world.setRandomSeed(chunkX, chunkZ, 10387313);
        levels.forEach(level -> level.populate(world, random, chunkX, chunkZ));

        // Decorator code
        int x = chunkX * 16 + 1;
        int z = chunkZ * 16 + 1;
        BlockPos pos = new BlockPos(x, 0, z);
        Biome biome = this.world.getBiome(pos);
        biome.decorate(this.world, random, pos);

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
