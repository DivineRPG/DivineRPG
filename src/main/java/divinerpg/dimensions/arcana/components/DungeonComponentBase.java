package divinerpg.dimensions.arcana.components;

import java.util.Random;

import divinerpg.dimensions.arcana.ArcanaChunkPrimer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public abstract class DungeonComponentBase {
    public abstract boolean generate(ArcanaChunkPrimer chunk, Random rand, int x, int y, int z);

    public void setBlock(ArcanaChunkPrimer chunk, int x, int y, int z, Block block) {
        chunk.setBlockState(x, y, z, block.getDefaultState());
    }

    public void setBlockState(ArcanaChunkPrimer chunk, int x, int y, int z, IBlockState state) {
        chunk.setBlockState(x, y, z, state);
    }
}