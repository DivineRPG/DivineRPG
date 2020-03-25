package divinerpg.structure.mock.interfaces;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.stream.Stream;

/**
 * Representing world storage.
 * Contains chunks where any of game objects exists (blocks/ tile entities / entities)
 */
public interface IWorldStorage extends INBTSerializable<NBTTagCompound> {

    /**
     * Iterate through all chunks
     *
     * @return
     */
    Stream<IChunkStorage> getChunks();

    /**
     * Gets chunk within bounding box
     *
     * @param box
     * @return
     */
    default Stream<IChunkStorage> getChunks(StructureBoundingBox box) {
        return getChunks().filter(x -> box.intersectsWith(
                x.getPos().getXStart(),
                x.getPos().getZStart(),
                x.getPos().getXEnd(),
                x.getPos().getZEnd()));
    }

    void addEntity(Entity e);

    void setBlockState(BlockPos pos, IBlockState state);

    default void setBlock(BlockPos pos, Block block) {
        setBlockState(pos, block.getDefaultState());
    }

    void addTileEntity(TileEntity entity);


    IBlockState getBlockState(BlockPos pos);
}
