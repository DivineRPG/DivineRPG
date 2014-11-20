package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class FloatingTree3 implements IVetheanStructure
{

	public void generate(Block[][][] chunk, int i, int j, int k) {

		chunk[i + 0][j + 2][k + 1] = VetheaBlocks.firewoodLeaves;
		chunk[i + 0][j + 2][k + 2] = VetheaBlocks.firewoodLeaves;
		chunk[i + 0][j + 2][k + 3] = VetheaBlocks.firewoodLeaves;
		chunk[i + 0][j + 5][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 0][j + 5][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 0][k + 2] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 1][k + 0] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 1][k + 1] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 1][k + 2] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 2][k + 0] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 2][k + 1] = VetheaBlocks.firewood;
		chunk[i + 1][j + 2][k + 2] = VetheaBlocks.firewood;
		chunk[i + 1][j + 2][k + 3] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 3][k + 1] = VetheaBlocks.firewood;
		chunk[i + 1][j + 3][k + 2] = VetheaBlocks.firewood;
		chunk[i + 1][j + 3][k + 3] = VetheaBlocks.firewoodLeaves;
		chunk[i + 1][j + 4][k + 1] = VetheaBlocks.firewood;
		chunk[i + 1][j + 4][k + 2] = VetheaBlocks.firewood;
		chunk[i + 1][j + 5][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 5][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 5][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 1][j + 5][k + 3] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 1][k + 1] = VetheaBlocks.firewoodLeaves;
		chunk[i + 2][j + 1][k + 2] = VetheaBlocks.firewoodLeaves;
		chunk[i + 2][j + 2][k + 0] = VetheaBlocks.firewoodLeaves;
		chunk[i + 2][j + 2][k + 1] = VetheaBlocks.firewood;
		chunk[i + 2][j + 2][k + 2] = VetheaBlocks.firewood;
		chunk[i + 2][j + 2][k + 3] = VetheaBlocks.firewoodLeaves;
		chunk[i + 2][j + 3][k + 1] = VetheaBlocks.firewood;
		chunk[i + 2][j + 3][k + 2] = VetheaBlocks.firewood;
		chunk[i + 2][j + 4][k + 1] = VetheaBlocks.firewood;
		chunk[i + 2][j + 4][k + 2] = VetheaBlocks.firewood;
		chunk[i + 2][j + 5][k + 0] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 5][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 5][k + 2] = VetheaBlocks.dreamStone;
		chunk[i + 2][j + 5][k + 3] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 2][k + 1] = VetheaBlocks.firewoodLeaves;
		chunk[i + 3][j + 2][k + 2] = VetheaBlocks.firewoodLeaves;
		chunk[i + 3][j + 5][k + 1] = VetheaBlocks.dreamStone;
		chunk[i + 3][j + 5][k + 2] = VetheaBlocks.dreamStone;
	}
}