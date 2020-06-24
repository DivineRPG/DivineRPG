package divinerpg.world.structures;

import divinerpg.config.Config;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import divinerpg.registry.LootTableRegistry;
import divinerpg.utils.DRPGStructureHandler;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

/**
 * Created by LiteWolf101 on Jan /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {

    public final DRPGStructureHandler HUT = new DRPGStructureHandler("overworld/livestock_merchant_hut");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            Biome biome = world.getChunkFromChunkCoords(chunkX, chunkZ).getBiome(new BlockPos(chunkX * 16, 0, chunkZ * 16), world.getBiomeProvider());
            if (Config.generateHuts && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
                int hutChance = 120;
                if(world.getWorldType() == WorldType.FLAT) {
                    hutChance = 700;
                }
                generateStructure(HUT, world, random, chunkX, chunkZ, hutChance, Blocks.GRASS);
            }
        }
    }

    /**
     * Generates a structure with the specified blocks in a given area
     */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
                                   int chance, Block topBlock) {
        int x = chunkX * 16 + 1;
        int z = chunkZ * 16 + 1;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            if (locationIsValidSpawn(world, x, y, z, topBlock)) {
                generator.generate(world, random, pos);
            }
        }
    }

    private int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;
        while (!foundGround) {
            y--;
            if(y <= 1) {
                break;
            }
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = (block == topBlock);
        }
        return y;
    }

    public boolean locationIsValidSpawn(World world, int x, int y, int z, Block topBlock) {
        /*
            Check if block (3, 3) away from the selected generation point is equivalent to the grass block.
            This is to ensure flatness in some cases (e.g. to avoid spawning it in a steep hillside).
            However, the checked block is close enough to ensure that generation of the structure is not relegated to entirely flat areas which are probably harder to find.
            Will need tweaking later
         */
        if(world.getBlockState(new BlockPos(x, y, z)).getBlock() == topBlock) {
            if(world.getBlockState(new BlockPos(x + 3, y, z + 3)).getBlock() == topBlock) {
                return true;
            }
        }
        return false;
    }
}