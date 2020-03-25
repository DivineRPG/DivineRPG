package divinerpg.structure.mock.interfaces;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

/**
 * Represents block storage inside single chunk.
 * All data is stored in Integer array, optimized for NBT storage
 */
public interface IChunkPrimer extends INBTSerializable<NBTTagCompound> {
    /**
     * Set block state in current chunk
     *
     * @param pos   - current pos. Will user relative pos
     * @param state - state to set
     */
    default void setBlockStateFromAbsolute(BlockPos pos, IBlockState state) {
        setBlockState(pos.getX() % 16, pos.getY(), pos.getZ() % 16, state);
    }

    /**
     * Get block from chunk
     *
     * @param pos - current position
     * @return
     */
    default IBlockState getBlockStateFromAbsolute(BlockPos pos) {
        return getBlockState(pos.getX() % 16, pos.getY(), pos.getZ() % 16);
    }

    /**
     * Check bounds for chunk
     *
     * @param x - relative x position
     * @param y - y position
     * @param z - relative z position
     * @return
     */
    default boolean checkBounds(int x, int y, int z) {
        if (x < 0 || 16 < x)
            return false;

        if (z < 0 || 16 < z)
            return false;

        return y >= 0 && 255 >= y;
    }

    /**
     * Set block at current relative poses
     *
     * @param x     - [0..15]
     * @param y     - [0..255]
     * @param z     - [0..15]
     * @param state - block state
     */
    void setBlockState(int x, int y, int z, IBlockState state);

    /**
     * Gets blocks from relative poses
     *
     * @param x - [0..15]
     * @param y - [0..255]
     * @param z - [0..15]
     * @return
     */
    @Nullable
    IBlockState getBlockState(int x, int y, int z);
}
