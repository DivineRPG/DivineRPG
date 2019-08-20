package naturix.divinerpg.world;

import java.util.Random;

import com.google.common.base.Predicate;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.dimensions.mortum.WorldGenMortumStone;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator {

    public static WorldGenCustomOres instance = new WorldGenCustomOres();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
        case -1:
            genNether(world, random, chunkX, chunkZ);
            break;
        case 0:
            genSurface(world, random, chunkX, chunkZ);
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

    private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX,
            int maxZ, int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn) {
        int diffMinMaxY = maxY - minY;
        for (int x = 0; x < chance; x++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffMinMaxY);
            if (diffMinMaxY < minY) {
                diffMinMaxY = maxY;
            }
            int posZ = blockZPos + random.nextInt(maxZ);

            WorldGenMinable gen = new WorldGenMinable(block, maxVeinSize, blockToSpawnIn);

            if (minY > maxY || minY < 0 || maxY > 256)
                throw new IllegalArgumentException("Ore Generated Out of Bounds");
            int heighDiff = maxY - minY + 1;

            for (int i = 0; i < chance; i++) {
                int b = blockXPos * 16 + random.nextInt(16);
                int y = minY + random.nextInt(heighDiff);
                int z = blockZPos * 16 + random.nextInt(16);
                BlockPos pos2 = new BlockPos(b, y, z);
                gen.generate(world, random, pos2);

            }

        }
    }

    //block, worldgen, random, blockXPos, blockZPos, maxX, maxZ, maxVeinSize, chance, minY, maxY, blockToSpawnIn
    private void genSurface(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.realmiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.realmiteVein,
                Config.realmiteTries, Config.realmiteMin, Config.realmiteMax, BlockMatcher.forBlock(Blocks.STONE));
        addOreSpawn(ModBlocks.rupeeOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.rupeeVein,
                Config.rupeeTries, Config.rupeeMin, Config.rupeeMax, BlockMatcher.forBlock(Blocks.STONE));
        addOreSpawn(ModBlocks.arlemiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.arlemiteVein,
                Config.arlemiteTries, Config.arlemiteMin, Config.arlemiteMax, BlockMatcher.forBlock(Blocks.STONE));
        
        
        
        if(random.nextInt(8) == 0) {
            int posX = chunkX + random.nextInt(16) + 8;
            int posY = random.nextInt(150);
            int posZ = chunkZ + random.nextInt(16) + 8;
            BlockPos pos = new BlockPos(posX, posY, posZ);
            if(Config.generateTar && (random.nextInt(10) == 0 || posY < 60)) {
                (new WorldGenLakes(ModBlocks.tar)).generate(world, random, pos);
            }
        }
    }

    private void genNether(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.netheriteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 1,
                world.getHeight(), BlockMatcher.forBlock(Blocks.NETHERRACK));
        addOreSpawn(ModBlocks.bloodgemOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 1,
                world.getHeight(), BlockMatcher.forBlock(Blocks.NETHERRACK));

    }

    private void genEden(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.edenOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 15, 100,
                BlockMatcher.forBlock(ModBlocks.twilightStone));

    }

    private void genWild(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.wildwoodOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 15, 100,
                BlockMatcher.forBlock(ModBlocks.twilightStone));
    }

    private void genApalachia(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.apalachiaOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 15, 100,
                BlockMatcher.forBlock(ModBlocks.twilightStone));
        if(random.nextInt(16) == 0) {
            int posX = chunkX + random.nextInt(16) + 8;
            int posY = random.nextInt(150);
            int posZ = chunkZ + random.nextInt(16) + 8;
            BlockPos pos = new BlockPos(posX, posY, posZ);
            (new WorldGenLakes(Blocks.WATER)).generate(world, random, pos);
        }
    }

    private void genSkythern(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.skythernOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 15, 100,
                BlockMatcher.forBlock(ModBlocks.twilightStone));
    }

    private void genMortum(World world, Random random, int chunkX, int chunkZ) {
        addOreSpawn(ModBlocks.mortumOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 15, 100,
                BlockMatcher.forBlock(ModBlocks.twilightStone));
    }

}
