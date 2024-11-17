package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.dimensions.vethea.VetheaChunk;
import net.divinerpg.utils.blocks.VetheaBlocks;

public class FloatingTree1 implements IVetheanStructure {

	int treeCount = 0;
	Random rand = new Random();

	@Override
	public void generate(VetheaChunk chunk, int i, int j, int k) {
			chunk.setBlock(i + 0, j + 1, k + 1, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 1, k + 2, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 0, j + 2, k + 2, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 1, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 2, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 1, k + 3, VetheaBlocks.firewood);
			chunk.setBlock(i + 1, j + 1, k + 4, VetheaBlocks.firewood);
			chunk.setBlock(i + 1, j + 1, k + 5, VetheaBlocks.firewood);
			chunk.setBlock(i + 1, j + 1, k + 6, VetheaBlocks.firewood);
			chunk.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.dreamStone);
			chunk.setBlock(i + 2, j + 1, k + 6, VetheaBlocks.firewood);
			chunk.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.firewood);
			chunk.setBlock(i + 3, j + 1, k + 6, VetheaBlocks.firewood);
			chunk.setBlock(i + 3, j + 2, k + 1, VetheaBlocks.firewood);
			chunk.setBlock(i + 4, j + 0, k + 6, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 1, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 5, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 1, k + 6, VetheaBlocks.firewood);
			chunk.setBlock(i + 4, j + 1, k + 7, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 0, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 1, VetheaBlocks.firewood);
			chunk.setBlock(i + 4, j + 2, k + 2, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 4, j + 2, k + 6, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 5, j + 1, k + 6, VetheaBlocks.firewoodLeaves);
			chunk.setBlock(i + 5, j + 2, k + 1, VetheaBlocks.firewoodLeaves);
			treeCount++;
		}
}
