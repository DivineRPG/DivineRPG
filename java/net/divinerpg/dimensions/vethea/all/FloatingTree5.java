package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class FloatingTree5 implements IVetheanStructure
{

	public void generate(Block[][][] chunk, int i, int j, int k) {

		chunk[i + 0][j + 1][k + 8] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 1][j + 0][k + 8] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 1][j + 1][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 1][k + 6] = VetheaBlocks.hyrewood;
		chunk[i + 1][j + 1][k + 7] = VetheaBlocks.hyrewood;
		chunk[i + 1][j + 1][k + 8] = VetheaBlocks.hyrewood;
		chunk[i + 1][j + 1][k + 9] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 1][j + 2][k + 1] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 1][j + 2][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 2][k + 8] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 0][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 1] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 1][k + 4] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 6] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 8] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 2][k + 0] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 2][k + 1] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 2][k + 2] = VetheaBlocks.hyrewood;
		chunk[i + 2][j + 2][k + 3] = VetheaBlocks.hyrewood;
		chunk[i + 2][j + 2][k + 4] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 2][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 2][k + 6] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 3][k + 1] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 2][j + 3][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 5][k + 6] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 3][j + 0][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 1][k + 4] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 1][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 1][k + 6] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 2][k + 1] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 3][j + 2][k + 4] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 2][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 2][k + 6] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 3][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 3][k + 6] = VetheaBlocks.hyrewood;
		chunk[i + 3][j + 4][k + 6] = VetheaBlocks.hyrewood;
		chunk[i + 3][j + 5][k + 5] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 3][j + 5][k + 6] = VetheaBlocks.dreamDirt;
		chunk[i + 3][j + 5][k + 7] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 3][j + 6][k + 6] = VetheaBlocks.hyrewoodLeaves;
		chunk[i + 4][j + 1][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 4][j + 2][k + 5] = VetheaBlocks.dreamStone;
		chunk[i + 4][j + 5][k + 6] = VetheaBlocks.hyrewoodLeaves;
	}
}