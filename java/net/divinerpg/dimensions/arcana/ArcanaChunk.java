package net.divinerpg.dimensions.arcana;

import net.minecraft.block.Block;

public class ArcanaChunk {
	
	private Block[] data;
	
	public ArcanaChunk() {
		data = new Block[32768];
	}
	
	public void setBlock(int x, int y, int z, Block b) {
		data[x<<11 | z<<7 | y] = b;
	}
	
	public Block getBlock(int x, int y, int z) {
		return data[x<<11 | z<<7 | y];
	}
	
	public Block[] getChunkData() {
		return data;
	}

}
