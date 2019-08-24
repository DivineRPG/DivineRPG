package divinerpg.utils;

import java.util.Objects;

import net.minecraft.util.math.BlockPos;

public class ChunkCoord {
    private final int chunkX;
    private final int chunkZ;

    public ChunkCoord(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public static ChunkCoord getChunkCoordFromPos(BlockPos pos) {
        return new ChunkCoord(pos.getX() >> 4, pos.getZ() >> 4);
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkCoord that = (ChunkCoord) o;
        return chunkX == that.chunkX &&
                chunkZ == that.chunkZ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chunkX, chunkZ);
    }
}