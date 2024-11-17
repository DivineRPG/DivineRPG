package net.divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class VetheaChunk {
	private Block[] data;
	private byte[] meta;
    public List<ChunkPosition> chunkTileEntityPositions;
	
	public VetheaChunk() {
		data = new Block[65536];
		meta = new byte[65536];
		this.chunkTileEntityPositions = new ArrayList<ChunkPosition>();
	}
	
	public void setBlock(int x, int y, int z, Block b) {
		this.setBlock(x, y, z, b, 0);
	}
	
	public void setBlock(int x, int y, int z, Block b, int m) {
		data[x << 12 | z << 8 | y] = b;
		meta[x << 12 | z << 8 | y] = (byte)m;
		if (b.hasTileEntity(m)) {
			this.chunkTileEntityPositions.add(new ChunkPosition(x, y, z));
		}
	}
	
	public Block getBlock(int x, int y, int z) {
		return data[x << 12 | z << 8 | y];
	}
	
	public Block[] getChunkData() {
		return data;
	}
	
	public byte[] getChunkMetadata() {
		return meta;
	}

}
