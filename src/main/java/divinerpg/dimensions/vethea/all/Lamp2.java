package divinerpg.dimensions.vethea.all;
import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class Lamp2 implements IVetheanStructure
{
	public void generate(VetheaChunk chunk, int i, int j, int k) {
		chunk.setBlock(i + 0, j + 0, k + 1, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 0, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 0, k + 1, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 0, k + 2, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 1, k + 1, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 2, k + 1, ModBlocks.dreamLamp);
		chunk.setBlock(i + 2, j + 0, k + 1, ModBlocks.darkEverstone);
	}
}