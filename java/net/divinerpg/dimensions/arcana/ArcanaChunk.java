package net.divinerpg.dimensions.arcana;

import net.minecraft.block.Block;

public class ArcanaChunk {
	
	private Block[] data;
	private byte[] meta;
	
	public ArcanaChunk() {
		data = new Block[32768];
		meta = new byte[32768];
	}
	
	public void setBlock(int x, int y, int z, Block b) {
		this.setBlock(x, y, z, b, 0);
	}
	
	public void setBlock(int x, int y, int z, Block b, int m) {
		data[x<<11 | z<<7 | y] = b;
		meta[x<<11 | z<<7 | y] = (byte)m;
	}
	
	public Block getBlock(int x, int y, int z) {
		return data[x<<11 | z<<7 | y];
	}
	
	public Block[] getChunkData() {
		return data;
	}
	
	public byte[] getChunkMetadata() {
		return meta;
	}

}
