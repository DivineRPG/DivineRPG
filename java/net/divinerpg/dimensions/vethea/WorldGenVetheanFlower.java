package net.divinerpg.dimensions.vethea;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVetheanFlower extends WorldGenerator {

	private Block flower;
	
	public WorldGenVetheanFlower(Block f) {
		flower = f;
	}
	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		if(w.getBlock(x, y - 1, z) == VetheaBlocks.dreamGrass){
			for (int l = 0; l < 30; ++l) {
	            int i = x + r.nextInt(8) - r.nextInt(8);
	            int j = y + r.nextInt(4) - r.nextInt(4);
	            int k = z + r.nextInt(8) - r.nextInt(8);
	            if(w.isAirBlock(i, j, k) && j < 200 && flower.canBlockStay(w, i, j, k)) {
	                w.setBlock(i, j, k, flower);
	            }
	        }
		}
		return true;
	}
}