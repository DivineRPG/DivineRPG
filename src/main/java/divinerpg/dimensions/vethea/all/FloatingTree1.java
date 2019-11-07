package divinerpg.dimensions.vethea.all;

import java.util.Random;

import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class FloatingTree1 implements IVetheanStructure {

	int treeCount = 0;
	Random rand = new Random();

	@Override
	public void generate(VetheaChunk chunk, int i, int j, int k) {
			chunk.setBlock(i + 0, j + 1, k + 1, ModBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 1, k + 2, ModBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 2, k + 1, ModBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 2, k + 2, ModBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 1, ModBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 2, ModBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 3, ModBlocks.firewoodLog);
			chunk.setBlock(i + 1, j + 1, k + 4, ModBlocks.firewoodLog);
			chunk.setBlock(i + 1, j + 1, k + 5, ModBlocks.firewoodLog);
			chunk.setBlock(i + 1, j + 1, k + 6, ModBlocks.firewoodLog);
			chunk.setBlock(i + 1, j + 2, k + 1, ModBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 2, k + 2, ModBlocks.dreamStone);
			chunk.setBlock(i + 2, j + 1, k + 6, ModBlocks.firewoodLog);
			chunk.setBlock(i + 2, j + 2, k + 1, ModBlocks.firewoodLog);
			chunk.setBlock(i + 3, j + 1, k + 6, ModBlocks.firewoodLog);
			chunk.setBlock(i + 3, j + 2, k + 1, ModBlocks.firewoodLog);
			chunk.setBlock(i + 4, j + 0, k + 6, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 1, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 5, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 6, ModBlocks.firewoodLog);
			chunk.setBlock(i + 4, j + 1, k + 7, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 0, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 1, ModBlocks.firewoodLog);
			chunk.setBlock(i + 4, j + 2, k + 2, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 6, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 5, j + 1, k + 6, ModBlocks.firewoodLeaves);
			chunk.setBlock(i + 5, j + 2, k + 1, ModBlocks.firewoodLeaves);
			treeCount++;
		}
}
