package net.divinerpg.dimensions.vethea.all;
import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class Lamp2 implements IVetheanStructure
{
	public void generate(Block[][][] chunk, int i, int j, int k) {
		chunk[i + 0][j + 0][k + 1] = VetheaBlocks.darkEverstone;
		chunk[i + 1][j + 0][k + 0] = VetheaBlocks.darkEverstone;
		chunk[i + 1][j + 0][k + 1] = VetheaBlocks.darkEverstone;
		chunk[i + 1][j + 0][k + 2] = VetheaBlocks.darkEverstone;
		chunk[i + 1][j + 1][k + 1] = VetheaBlocks.darkEverstone;
		chunk[i + 1][j + 2][k + 1] = VetheaBlocks.dreamLamp;
		chunk[i + 2][j + 0][k + 1] = VetheaBlocks.darkEverstone;
	}
}