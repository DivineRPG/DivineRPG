package divinerpg.dimensions.vethea.all;
import divinerpg.dimensions.vethea.IVetheanStructure;
import divinerpg.dimensions.vethea.VetheaChunk;
import divinerpg.registry.ModBlocks;

public class FloatingTree3 implements IVetheanStructure
{

	public void generate(VetheaChunk chunk, int i, int j, int k) {

		chunk.setBlock(i + 0, j + 2, k + 1, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 2, k + 2, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 2, k + 3, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 0, j + 5, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 0, j + 5, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 0, k + 2, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 0, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 1, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 1, k + 2, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 2, k + 0, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 2, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 2, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 2, k + 3, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 3, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 3, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 3, k + 3, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 1, j + 4, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 4, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 1, j + 5, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 1, j + 5, k + 3, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 1, k + 1, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 1, k + 2, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 2, k + 0, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 2, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 2, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 2, k + 3, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 2, j + 3, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 3, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 4, k + 1, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 4, k + 2, ModBlocks.firewoodLog);
		chunk.setBlock(i + 2, j + 5, k + 0, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 2, ModBlocks.dreamStone);
		chunk.setBlock(i + 2, j + 5, k + 3, ModBlocks.dreamStone);
		chunk.setBlock(i + 3, j + 2, k + 1, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 3, j + 2, k + 2, ModBlocks.firewoodLeaves);
		chunk.setBlock(i + 3, j + 5, k + 1, ModBlocks.dreamStone);
		chunk.setBlock(i + 3, j + 5, k + 2, ModBlocks.dreamStone);
	}
}