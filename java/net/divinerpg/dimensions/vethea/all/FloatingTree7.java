package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class FloatingTree7 implements IVetheanStructure
{
	public void generate(Block[][][] chunk, int i, int j, int k) {

		chunk[i + 0][j + 2][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 2][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 2][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 2][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 3][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 1][j + 4][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 2][j + 2][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 4][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 3][j + 1][k + 1] = VetheaBlocks.mintwoodLeaves;
		chunk[i + 3][j + 4][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 4][j + 0][k + 1] = VetheaBlocks.mintwoodLeaves;
		chunk[i + 4][j + 1][k + 0] = VetheaBlocks.mintwoodLeaves;
		chunk[i + 4][j + 1][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 4][j + 1][k + 2] = VetheaBlocks.mintwoodLeaves;
		chunk[i + 4][j + 2][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 4][j + 3][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 4][j + 4][k + 1] = VetheaBlocks.mintwood;
		chunk[i + 5][j + 1][k + 1] = VetheaBlocks.mintwoodLeaves;
	}
}