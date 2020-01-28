package divinerpg.dimensions.vethea.all;
import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class FloatingTree6 implements IVetheanStructure
{
	public void generate(VetheaChunk chunk, int i, int j, int k) {

		chunk.setBlock(i + 0, j + 8, k + 1, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 1, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 3, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 4, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 5, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 6, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 7, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 8, k + 0, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 1, j + 8, k + 1, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 1, j + 8, k + 2, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 1, j + 9, k + 1, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 2, j + 0, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 0, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 0, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 1, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 1, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 8, k + 1, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 3, j + 0, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 3, j + 6, k + 2, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 4, j + 0, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 4, j + 1, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 2, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 3, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 4, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 5, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 6, k + 1, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 4, j + 6, k + 2, ModBlocks.dreamwoodLog);
		chunk.setBlock(i + 4, j + 7, k + 2, ModBlocks.dreamwoodLeaves);
		chunk.setBlock(i + 5, j + 6, k + 2, ModBlocks.dreamwoodLeaves);
	}
}