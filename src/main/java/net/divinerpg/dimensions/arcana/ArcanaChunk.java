package net.divinerpg.dimensions.arcana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class ArcanaChunk {
	private Block[] data;
	private byte[] meta;
    public List<ChunkPosition> chunkTileEntityPositions;
	
	public ArcanaChunk() {
		data = new Block[32768];
		meta = new byte[32768];
		this.chunkTileEntityPositions = new ArrayList<ChunkPosition>();
	}
	
	public void setBlock(int x, int y, int z, Block b) {
		this.setBlock(x, y, z, b, 0);
	}
	
	public void setBlock(int x, int y, int z, Block b, int m) {
		data[x<<11 | z<<7 | y] = b;
		meta[x<<11 | z<<7 | y] = (byte)m;
		if (b.hasTileEntity(m)) {
			this.chunkTileEntityPositions.add(new ChunkPosition(x, y, z));
		}
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
