package divinerpg.world.arcana;

import net.minecraft.util.math.ChunkPos;

import java.util.HashMap;

public class MazeMapMemoryStorage {
    private static HashMap<ChunkPos, Cell[][]> mazeMaps = new HashMap<ChunkPos, Cell[][]>();

    public static void addMap(ChunkPos pos, Cell[][] grid) {
        mazeMaps.put(pos, grid);
    }

    public static Cell[][] getMapForChunkPos(ChunkPos pos) {
        return mazeMaps.get(pos);
    }

}