package naturix.divinerpg.world;

import java.util.Random;

import com.google.common.base.Predicate;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {


	public static ModWorldGen instance = new ModWorldGen();
	int jeff = ModDimensions.edenDimension.getId();
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case -1:
                genNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                genSurface(world, random, chunkX, chunkZ);
                break;
            case 2:
                genEden(world, random, chunkX, chunkZ);
                break;
            case 1:
            	break;
        }
    }
	 private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn){
		  int diffMinMaxY = maxY - minY;
		  for(int x = 0; x < chance; x++){
		   int posX = blockXPos + random.nextInt(maxX);
		   int posY = minY + random.nextInt(diffMinMaxY);
		   if(diffMinMaxY < minY) {diffMinMaxY = maxY;}
		   int posZ = blockZPos + random.nextInt(maxZ);

		   WorldGenMinable gen = new WorldGenMinable(block, maxVeinSize, blockToSpawnIn);
			
			if(minY > maxY || minY < 0 || maxY > 256) throw new IllegalArgumentException("Ore Generated Out of Bounds");
			int heighDiff = maxY - minY + 1;
			
			for(int i = 0; i < chance; i++) {
				int b = blockXPos * 16 + random.nextInt(16);
				int y = minY + random.nextInt(heighDiff);
				int z = blockZPos * 16 + random.nextInt(16);
				
				gen.generate(world, random, new BlockPos(b, y, z));
			}
		
		  }
	 }
	 //block, world, random, blockXPos, blockZPos, maxX, maxZ, maxVeinSize, chance, minY, maxY, blockToSpawnIn
	 private void genSurface(World world, Random random, int chunkX, int chunkZ){
		 addOreSpawn(ModBlocks.oreRealmite.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 3, 1, 48, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(ModBlocks.oreRupee.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 3, 1, 16, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(ModBlocks.oreArlemite.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 3, 1, 16, BlockMatcher.forBlock(Blocks.STONE));
		 
	 }
	 private void genNether(World world, Random random, int chunkX, int chunkZ){
		 addOreSpawn(ModBlocks.oreNetherite.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 1, world.getHeight(), BlockMatcher.forBlock(Blocks.NETHERRACK));
		 addOreSpawn(ModBlocks.orebloodgem.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 1, world.getHeight(), BlockMatcher.forBlock(Blocks.NETHERRACK));
		 
	 }
	 private void genEden(World world, Random random, int chunkX, int chunkZ){
		 addOreSpawn(ModBlocks.oreEden.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 4, 5, 1, world.getHeight(), BlockMatcher.forBlock(ModBlocks.rockTwilight));
		 
	 }
	 
}
