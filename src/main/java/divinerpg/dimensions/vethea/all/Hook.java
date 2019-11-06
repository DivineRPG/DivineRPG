package divinerpg.dimensions.vethea.all;
import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class Hook implements IVetheanStructure {
	
	public void generate(VetheaChunk chunk, int i, int j, int k) {
		chunk.setBlock(i + 0, j + 6, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 0, j + 7, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 5, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 1, j + 6, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 1, j + 7, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 1, j + 8, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 0, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 1, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 2, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 3, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 4, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 5, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 2, j + 6, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 7, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 2, j + 8, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 2, j + 9, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 0, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 1, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 3, j + 2, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 3, j + 3, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 4, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 3, j + 5, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 8, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 9, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 3, j + 10, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 3, j + 11, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 0, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 1, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 4, j + 2, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 4, j + 3, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 4, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 5, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 9, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 4, j + 10, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 4, j + 11, k + 0, ModBlocks.everstone);
		chunk.setBlock(i + 4, j + 12, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 0, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 1, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 2, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 3, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 10, k + 0, ModBlocks.darkEverstone);
		chunk.setBlock(i + 5, j + 11, k + 0, ModBlocks.darkEverstone);
	}
}