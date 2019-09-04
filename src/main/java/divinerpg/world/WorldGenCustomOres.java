package divinerpg.world;

import com.google.common.base.Predicate;
import divinerpg.Config;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator {

    public static WorldGenCustomOres instance = new WorldGenCustomOres();

    // declaring predicats to prevent constantly creating
    private Predicate<IBlockState> stonePredicat = BlockMatcher.forBlock(Blocks.STONE);
    private Predicate<IBlockState> netherPredicat = BlockMatcher.forBlock(Blocks.NETHERRACK);
    private Predicate<IBlockState> twilightPredicat = BlockMatcher.forBlock(ModBlocks.twilightStone);

    private WorldGenerator waterLake = new WorldGenLakes(Blocks.WATER);
    private WorldGenerator tarLake = new WorldGenLakes(ModBlocks.tar);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                genNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                genOverworld(world, random, chunkX, chunkZ);
                break;
            case 1:
                break;
        }

        if (world.provider.getDimension() == ModDimensions.edenDimension.getId()) {
            genEden(world, random, chunkX, chunkZ);
        }
        if (world.provider.getDimension() == ModDimensions.wildWoodDimension.getId()) {
            genWild(world, random, chunkX, chunkZ);
        }
        if (world.provider.getDimension() == ModDimensions.apalachiaDimension.getId()) {
            genApalachia(world, random, chunkX, chunkZ);
        }
        if (world.provider.getDimension() == ModDimensions.skythernDimension.getId()) {
            genSkythern(world, random, chunkX, chunkZ);
        }
        if (world.provider.getDimension() == ModDimensions.mortumDimension.getId()) {
            genMortum(world, random, chunkX, chunkZ);
        }

    }

    ///////////////////////////
    // HELPING METHODS
    ///////////////////////////

    private void spawnOre(World world, Random random, IBlockState ore, Predicate<IBlockState> replacing,
                          int chunkX, int chunkZ, int maxVeinSize, int tries, int minY, int maxY) {

        int height = getHeightOrThrow(minY, maxY);
        WorldGenMinable gen = new WorldGenMinable(ore, maxVeinSize, replacing);

        // Inserting forge hook here
        if (!TerrainGen.generateOre(world, random, gen, new BlockPos(chunkX * 16, 0, chunkZ * 16),
                OreGenEvent.GenerateMinable.EventType.CUSTOM))
            return;

        for (int i = 0; i < tries; i++) {
            BlockPos pos = new BlockPos(
                    chunkX * 16 + random.nextInt(16),
                    minY + random.nextInt(height + 1),
                    chunkZ * 16 + random.nextInt(16));

            gen.generate(world, random, pos);
        }
    }

    private void spawnTwilightOre(World world, Random random, Block ore, int chunkX, int chunkZ) {
        spawnOre(world, random, ore.getDefaultState(), twilightPredicat, chunkX, chunkZ,
                4, 5, 15, 100);
    }

    /**
     * @param chance - in one of passed chanses will spawn lake
     */
    private void generateLake(World world, Random random, WorldGenerator generator, int chunkX, int chunkZ,
                              int minY, int maxY, int chance) {

        // we are not lucky
        if (random.nextInt(chance) != 0)
            return;

        BlockPos pos = new BlockPos(chunkX * 16 + random.nextInt(16),
                minY + random.nextInt(getHeightOrThrow(minY, maxY) + 1),
                chunkZ * 16 + random.nextInt(16));

        // But here offset is needed. It's a magic, isn't it?
        generator.generate(world, random, pos.add(8, 0, 8));
    }

    /**
     * Gets height difference and throw in case of errors
     */
    private int getHeightOrThrow(int minY, int maxY) {
        int height = maxY - minY;
        if (height <= 0) {
            throw new IllegalArgumentException("Max Y equals or less min Y");
        }
        if (minY < 0 || maxY > 256)
            throw new IllegalArgumentException("Ore Generated Out of Bounds");

        return height;
    }


    /////////////////////////////////
    // DIMENSION ORE SPAWNING
    /////////////////////////////////
    private void genOverworld(World world, Random random, int chunkX, int chunkZ) {
        spawnOre(world, random, ModBlocks.realmiteOre.getDefaultState(), stonePredicat, chunkX, chunkZ,
                Config.realmiteVein, Config.realmiteTries, Config.realmiteMin, Config.realmiteMax);
        spawnOre(world, random, ModBlocks.rupeeOre.getDefaultState(), stonePredicat, chunkX, chunkZ,
                Config.rupeeVein, Config.rupeeTries, Config.rupeeMin, Config.rupeeMax);
        spawnOre(world, random, ModBlocks.arlemiteOre.getDefaultState(), stonePredicat, chunkX, chunkZ,
                Config.arlemiteVein, Config.arlemiteTries, Config.arlemiteMin, Config.arlemiteMax);

        if (Config.generateTar) {
            // bottom layer, more frequently
            generateLake(world, random, tarLake, chunkX, chunkZ, 0, 60, 8);
            // top layer, 10 times less
            generateLake(world, random, tarLake, chunkX, chunkZ, 61, 150, 80);
        }
    }

    private void genNether(World world, Random random, int chunkX, int chunkZ) {
        spawnOre(world, random, ModBlocks.netheriteOre.getDefaultState(), netherPredicat, chunkX, chunkZ,
                4, 5, 1, world.getHeight());
        spawnOre(world, random, ModBlocks.bloodgemOre.getDefaultState(), netherPredicat, chunkX, chunkZ,
                4, 5, 1, world.getHeight());
    }

    private void genEden(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, ModBlocks.edenOre, chunkX, chunkZ);
    }

    private void genWild(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, ModBlocks.wildwoodOre, chunkX, chunkZ);
    }

    private void genApalachia(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, ModBlocks.apalachiaOre, chunkX, chunkZ);
        generateLake(world, random, waterLake, chunkX, chunkZ, 0, 150, 16);
    }

    private void genSkythern(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, ModBlocks.skythernOre, chunkX, chunkZ);
    }

    private void genMortum(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, ModBlocks.mortumOre, chunkX, chunkZ);
    }
}
