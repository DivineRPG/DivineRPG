package divinerpg.dimensions.vethea.all;
import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class FloatingTree4 implements IVetheanStructure
{

	public void generate(VetheaChunk chunk, int i, int j, int k) {

		chunk.setBlock(i + 0, j + 2, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 2, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 3, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 1, j + 4, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 2, j + 2, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 4, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 3, j + 1, k + 1, ModBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 3, j + 4, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 4, j + 0, k + 1, ModBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 1, k + 0, ModBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 1, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 4, j + 1, k + 2, ModBlocks.hyrewoodLeaves);
		chunk.setBlock(i + 4, j + 2, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 4, j + 3, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 4, j + 4, k + 1, ModBlocks.hyrewoodLog);
		chunk.setBlock(i + 5, j + 1, k + 1, ModBlocks.hyrewoodLeaves);
	}
}