package naturix.divinerpg.dimensions.arcana.components;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public abstract class DungeonComponentBase {
    public abstract boolean generate(Chunk chunk, Random rand, int x, int y, int z);

    public void setBlock(Chunk chunk, int x, int y, int z, Block block) {
        chunk.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
    }
}