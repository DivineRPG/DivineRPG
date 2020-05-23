package divinerpg.dimensions.vethea;

import java.util.Random;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVetheanFlower extends WorldGenerator {

	private Block flower;
	
	public WorldGenVetheanFlower(Block f) {
		flower = f;
	}
	
	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(w.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == BlockRegistry.dreamGrass){
			for (int l = 0; l < 30; ++l) {
	            int i = x + r.nextInt(8) - r.nextInt(8);
	            int j = y + r.nextInt(4) - r.nextInt(4);
	            int k = z + r.nextInt(8) - r.nextInt(8);
	            if(w.isAirBlock(new BlockPos(i, j, k)) && j < 200 && flower.canPlaceBlockAt(w, new BlockPos(i, j, k))){
	                w.setBlockState(new BlockPos(i, j, k), flower.getDefaultState());
	            }
	        }
		}
		return true;
	}
}