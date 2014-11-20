package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class FloatingTree1 implements IVetheanStructure {

	int treeCount = 0;
	Random rand = new Random();

	@Override
	public void generate(Block[][][] chunk, int i, int j, int k) {
			chunk[i + 0][j + 1][k + 1] = VetheaBlocks.dreamStone;
			chunk[i + 0][j + 1][k + 2] = VetheaBlocks.dreamStone;
			chunk[i + 0][j + 2][k + 1] = VetheaBlocks.dreamStone;
			chunk[i + 0][j + 2][k + 2] = VetheaBlocks.dreamStone;
			chunk[i + 1][j + 1][k + 1] = VetheaBlocks.dreamStone;
			chunk[i + 1][j + 1][k + 2] = VetheaBlocks.dreamStone;
			chunk[i + 1][j + 1][k + 3] = VetheaBlocks.firewood;
			chunk[i + 1][j + 1][k + 4] = VetheaBlocks.firewood;
			chunk[i + 1][j + 1][k + 5] = VetheaBlocks.firewood;
			chunk[i + 1][j + 1][k + 6] = VetheaBlocks.firewood;
			chunk[i + 1][j + 2][k + 1] = VetheaBlocks.dreamStone;
			chunk[i + 1][j + 2][k + 2] = VetheaBlocks.dreamStone;
			chunk[i + 2][j + 1][k + 6] = VetheaBlocks.firewood;
			chunk[i + 2][j + 2][k + 1] = VetheaBlocks.firewood;
			chunk[i + 3][j + 1][k + 6] = VetheaBlocks.firewood;
			chunk[i + 3][j + 2][k + 1] = VetheaBlocks.firewood;
			chunk[i + 4][j + 0][k + 6] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 1][k + 1] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 1][k + 5] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 1][k + 6] = VetheaBlocks.firewood;
			chunk[i + 4][j + 1][k + 7] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 2][k + 0] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 2][k + 1] = VetheaBlocks.firewood;
			chunk[i + 4][j + 2][k + 2] = VetheaBlocks.firewoodLeaves;
			chunk[i + 4][j + 2][k + 6] = VetheaBlocks.firewoodLeaves;
			chunk[i + 5][j + 1][k + 6] = VetheaBlocks.firewoodLeaves;
			chunk[i + 5][j + 2][k + 1] = VetheaBlocks.firewoodLeaves;
			treeCount++;
		}
}
