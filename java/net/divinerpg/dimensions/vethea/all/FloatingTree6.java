package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class FloatingTree6 implements IVetheanStructure
{
	public void generate(Block[][][] chunk, int i, int j, int k) {

		chunk[i + 0][j + 8][k + 1] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 1][j + 1][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 1][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 2][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 3][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 4][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 5][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 6][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 7][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 8][k + 0] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 1][j + 8][k + 1] = VetheaBlocks.dreamWoodLog;
		chunk[i + 1][j + 8][k + 2] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 1][j + 9][k + 1] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 2][j + 0][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 0][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 0][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 8][k + 1] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 3][j + 0][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 6][k + 2] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 4][j + 0][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 4][j + 1][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 2][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 3][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 4][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 5][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 6][k + 1] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 4][j + 6][k + 2] = VetheaBlocks.dreamWoodLog;
		chunk[i + 4][j + 7][k + 2] = VetheaBlocks.dreamWoodLeaves;
		chunk[i + 5][j + 6][k + 2] = VetheaBlocks.dreamWoodLeaves;
	}
}