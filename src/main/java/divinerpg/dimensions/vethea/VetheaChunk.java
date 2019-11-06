package divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class VetheaChunk {

	public Chunk chunk;
	
	public VetheaChunk(Chunk chunkIn) {
		this.chunk = chunkIn;
	}
	
	public void setBlock(int x, int y, int z, Block b) {
		chunk.setBlockState(new BlockPos(x, y, z), b.getDefaultState());
	}

	public Block getBlock(int x, int y, int z) {
		return chunk.getBlockState(new BlockPos(x, y, z)).getBlock();
	}

	public Chunk getChunk() {
		return this.chunk;
	}
}
