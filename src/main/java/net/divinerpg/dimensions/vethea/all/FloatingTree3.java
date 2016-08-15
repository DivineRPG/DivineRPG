package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.dimensions.vethea.VetheaChunk;
import net.divinerpg.utils.blocks.VetheaBlocks;

public class FloatingTree3 implements IVetheanStructure
{

	public void generate(VetheaChunk chunk, int i, int j, int k) {

		chunk.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 2, k + 2, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 2, k + 3, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 5, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 0, j + 5, k + 2, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 0, k + 2, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 0, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 1, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 2, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 2, k + 3, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 3, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 3, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 3, k + 3, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 4, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 4, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 1, j + 5, k + 0, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 2, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 3, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 1, k + 1, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 1, k + 2, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 2, k + 0, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 2, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 2, k + 3, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 3, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 3, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 4, k + 1, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 4, k + 2, VetheaBlocks.firewood);
		chunk.setBlock(i + 2, j + 5, k + 0, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 2, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 3, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 3, j + 2, k + 1, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 3, j + 2, k + 2, VetheaBlocks.firewoodLeaves);
		chunk.setBlock(i + 3, j + 5, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 3, j + 5, k + 2, VetheaBlocks.dreamStone);
	}
}