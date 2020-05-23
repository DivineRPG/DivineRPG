package divinerpg.world;


import com.google.common.base.Predicate;
import divinerpg.config.Config;
import divinerpg.config.OreInfo;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator {

    public static WorldGenCustomOres instance = new WorldGenCustomOres();

    // declaring predicats to prevent constantly creating
    private Predicate<IBlockState> stonePredicate = BlockMatcher.forBlock(Blocks.STONE);
    private Predicate<IBlockState> netherPredicate = BlockMatcher.forBlock(Blocks.NETHERRACK);
    private Predicate<IBlockState> twilightPredicate = BlockMatcher.forBlock(BlockRegistry.twilightStone);

    private WorldGenerator waterLake = new WorldGenLakes(Blocks.WATER);
    private WorldGenerator tarLake = new WorldGenLakes(BlockRegistry.tar);
    private WorldGenerator twilightStoneLake = new WorldGenLakes(BlockRegistry.twilightStone);

    private final Map<Integer, DimensionGen> dimensionGenerators = new HashMap<Integer, DimensionGen>() {{
        put(DimensionType.NETHER.getId(), WorldGenCustomOres::genNether);
        put(DimensionType.OVERWORLD.getId(), WorldGenCustomOres::genOverworld);
        put(ModDimensions.edenDimension.getId(), WorldGenCustomOres::genEden);
        put(ModDimensions.wildwoodDimension.getId(), WorldGenCustomOres::genWild);
        put(ModDimensions.apalachiaDimension.getId(), WorldGenCustomOres::genApalachia);
        put(ModDimensions.skythernDimension.getId(), WorldGenCustomOres::genSkythern);
        put(ModDimensions.mortumDimension.getId(), WorldGenCustomOres::genMortum);
    }};

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {

        int dimensionId = world.provider.getDimension();
        if (dimensionGenerators.containsKey(dimensionId)) {
            dimensionGenerators.get(dimensionId).gen(this, world, random, chunkX, chunkZ);
        }
    }

    ///////////////////////////
    // HELPING METHODS
    ///////////////////////////

    private boolean spawnOre(World world, Random random, IBlockState ore, Predicate<IBlockState> replacing,
                             int chunkX, int chunkZ, OreInfo info) {
        return spawnOre(world, random, ore, replacing, chunkX, chunkZ, info.getMinY(), info.getMaxY(), info.getVienSize(), info.getTries());
    }

    private boolean spawnOre(World world, Random random, IBlockState ore, Predicate<IBlockState> replacing,
                             int chunkX, int chunkZ, int minY, int maxY, int veinSize, int tries) {

        int height = getHeightOrThrow(minY, maxY);
        WorldGenMinable gen = new WorldGenMinable(ore, veinSize, replacing);

        // Inserting forge hook here
        if (!TerrainGen.generateOre(world, random, gen, new BlockPos(chunkX * 16, 0, chunkZ * 16),
                OreGenEvent.GenerateMinable.EventType.CUSTOM))
            return false;

        boolean result = false;

        for (int i = 0; i < tries; i++) {
            BlockPos pos = new BlockPos(
                    chunkX * 16 + random.nextInt(16),
                    minY + random.nextInt(height + 1),
                    chunkZ * 16 + random.nextInt(16));

            result |= gen.generate(world, random, pos);
        }

        return result;
    }

    private boolean spawnTwilightOre(World world, Random random, Block ore, int chunkX, int chunkZ) {
        return spawnOre(world, random, ore.getDefaultState(), twilightPredicate, chunkX, chunkZ, Config.twilight);
    }

    /**
     * @param chance - in one of passed chanses will spawn lake
     */
    private boolean generateLake(World world, Random random, WorldGenerator generator, int chunkX, int chunkZ,
                                 int minY, int maxY, int chance) {

        // we are not lucky
        if (random.nextInt(chance) != 0)
            return false;

        BlockPos pos = new BlockPos(chunkX * 16 + random.nextInt(16),
                minY + random.nextInt(getHeightOrThrow(minY, maxY) + 1),
                chunkZ * 16 + random.nextInt(16));

        // But here offset is needed. It's a magic, isn't it?
        return generator.generate(world, random, pos.add(8, 0, 8));
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
        spawnOre(world, random, BlockRegistry.realmiteOre.getDefaultState(), stonePredicate, chunkX, chunkZ,
                Config.realmite);
        spawnOre(world, random, BlockRegistry.rupeeOre.getDefaultState(), stonePredicate, chunkX, chunkZ,
                Config.rupee);
        spawnOre(world, random, BlockRegistry.arlemiteOre.getDefaultState(), stonePredicate, chunkX, chunkZ,
                Config.arlemite);

        if (Config.generateTar) {
            // bottom layer, more frequently
            generateLake(world, random, tarLake, chunkX, chunkZ, 0, 60, 8);
            // top layer, 10 times less
            generateLake(world, random, tarLake, chunkX, chunkZ, 61, 150, 80);
        }
    }

    private void genNether(World world, Random random, int chunkX, int chunkZ) {
        spawnOre(world, random, BlockRegistry.netheriteOre.getDefaultState(), netherPredicate, chunkX, chunkZ, Config.nether);
        spawnOre(world, random, BlockRegistry.bloodgemOre.getDefaultState(), netherPredicate, chunkX, chunkZ, Config.nether);
    }

    private void genEden(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, BlockRegistry.edenOre, chunkX, chunkZ);
    }

    private void genWild(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, BlockRegistry.wildwoodOre, chunkX, chunkZ);
    }

    private void genApalachia(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, BlockRegistry.apalachiaOre, chunkX, chunkZ);
        generateLake(world, random, waterLake, chunkX, chunkZ, 0, 150, 16);
    }

    private void genSkythern(World world, Random random, int chunkX, int chunkZ) {
        spawnTwilightOre(world, random, BlockRegistry.skythernOre, chunkX, chunkZ);
    }

    private void genMortum(World world, Random random, int chunkX, int chunkZ) {
        int chance = MathHelper.clamp(300 / Config.twilight.getTries(), 1, Integer.MAX_VALUE);

        if (generateLake(world, random, twilightStoneLake, chunkX, chunkZ, 50, 70, chance)) {
            spawnOre(world,
                    random,
                    BlockRegistry.mortumOre.getDefaultState(),
                    twilightPredicate,
                    chunkX,
                    chunkZ,
                    50,
                    70,
                    Config.twilight.getVienSize() * 3,
                    Config.twilight.getTries() * 3);
        }
    }

    @FunctionalInterface
    interface DimensionGen {
        void gen(WorldGenCustomOres m, World world, Random random, int chunkX, int chunkZ);
    }
}