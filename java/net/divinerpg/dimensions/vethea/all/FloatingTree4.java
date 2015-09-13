package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.dimensions.vethea.VetheaChunk;
import net.divinerpg.utils.blocks.VetheaBlocks;

public class FloatingTree4 implements IVetheanStructure
{

	public void generate(VetheaChunk chunk, int i, int j, int k) {

		chunk.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 3, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 1, j + 4, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 4, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 3, j + 1, k + 1, VetheaBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 3, j + 4, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 4, j + 0, k + 1, VetheaBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 1, k + 0, VetheaBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 1, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 4, j + 1, k + 2, VetheaBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 2, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 4, j + 3, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 4, j + 4, k + 1, VetheaBlocks.hyrewood);
		chunk.setBlock(i + 5, j + 1, k + 1, VetheaBlocks.hyrewoodLeaves);
	}
}