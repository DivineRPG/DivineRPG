package divinerpg.dimensions.iceika.structures;

import java.util.Random;

import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenArcherDungeon extends WorldGenerator {

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 10; i++) {
			for(int l = 0; l < 10; l++) {
				if(w.getBlockState(new BlockPos(x + i, y, z + l)) != ModBlocks.frozenStone) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
    public boolean generate(World w, Random rand, BlockPos pos) {
		int x=pos.getX(), y=pos.getY(), z=pos.getZ();
		if(!locationIsValidSpawn(w, x, y, z)) return false;
		addRectangle(6, 4, 5, w, x, y, z, ModBlocks.icyBricks);
		addRectangle(8, 8, 5, w, x + 5, y, z - 2, ModBlocks.icyBricks);
		addRectangle(8, 6, 3, w, x + 6, y + 1, z - 1, Blocks.AIR);
		addRectangle(7, 2, 3, w, x, y + 1, z + 1, Blocks.AIR);
		addRectangle(7, 2, 1, w, x, y, z + 1, ModBlocks.icyStone);
		addRectangle(7, 8, 1, w, x + 5, y, z - 2, ModBlocks.icyStone);
		addRectangle(1, 4, 4, w, x + 12, y, z - 1, ModBlocks.icyBricks);
		addRectangle(4, 4, 5, w, x + 13, y, z + 2, ModBlocks.icyBricks);
		addRectangle(4, 6, 5, w, x + 13, y, z + 3, ModBlocks.icyBricks);
		addRectangle(5, 2, 1, w, x + 12, y, z + 3, ModBlocks.icyStone);
		addRectangle(2, 5, 3, w, x + 14, y + 1, z + 3, Blocks.AIR);
		addRectangle(2, 5, 1, w, x + 14, y, z + 3, ModBlocks.icyStone);
		addRectangle(1, 2, 3, w, x + 13, y + 1, z + 3, Blocks.AIR);
		addRectangle(8, 4, 5, w, x + 16, y, z + 5, ModBlocks.icyBricks);
		addRectangle(7, 2, 3, w, x + 16, y + 1, z + 6, Blocks.AIR);
		addRectangle(7, 2, 1, w, x + 16, y, z + 6, ModBlocks.icyStone);
		addRectangle(4, 3, 5, w, x + 20, y, z + 3, ModBlocks.icyBricks);
		addRectangle(8, 8, 5, w, x + 18, y, z - 5, ModBlocks.icyBricks);
		addRectangle(6, 6, 3, w, x + 19, y + 1, z - 4, Blocks.AIR);
		addRectangle(6, 6, 1, w, x + 19, y, z - 4, ModBlocks.icyStone);
		addRectangle(2, 4, 3, w, x + 21, y + 1, z + 2, Blocks.AIR);
		addRectangle(2, 4, 1, w, x + 21, y, z + 2, ModBlocks.icyStone);
		addBlock(w, x + 20, y, z - 1, ModBlocks.frostArcherSpawner);
		addBlock(w, x + 23, y, z - 1, ModBlocks.frostArcherSpawner);
		addBlock(w, x + 8, y, z + 1, ModBlocks.frostArcherSpawner);
		//TODO - make frosted chest drop stuff
		w.setBlockState(new BlockPos(x + 24, y + 1, z - 4), ModBlocks.frostedChest.getDefaultState(), 0);
		w.setBlockState(new BlockPos(x + 19, y + 1, z - 4), ModBlocks.frostedChest.getDefaultState(), 0);
		addRectangle(10, 2, 3, w, x - 5, y + 1, z + 1, Blocks.AIR);
        return true;
    }
	
	
	public static void addRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), b.getDefaultState());
				}
			}
		}
	}
	public static void addCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlockState(new BlockPos(x + x1, y + y1 + 1, z + z1), b.getDefaultState());
				}
			}
		}
	}
	
	public static void addBlock(World w, int x, int y, int z, Block b) {
		addCube(1, w, x, y, z, b);
	}
}