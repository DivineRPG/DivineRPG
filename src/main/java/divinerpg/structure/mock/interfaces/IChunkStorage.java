package divinerpg.structure.mock.interfaces;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents storage for objects inside chunks
 * Including blocks / entities / tile entities
 */
public interface IChunkStorage extends INBTSerializable<NBTTagCompound> {
    /**
     * Gets chunk position
     *
     * @return
     */
    ChunkPos getPos();

    /**
     * Gets map of tiles within chunk. Always absolute poses
     *
     * @return
     */
    default Map<BlockPos, TileEntity> createTilesForWorld(World world) {
        LinkedHashMap<BlockPos, TileEntity> map = new LinkedHashMap<>();

        getTiles().forEach((pos, nbt) -> {
            TileEntity entity = TileEntity.create(world, nbt);
            if (entity == null)
                return;

            if (new ChunkPos(entity.getPos()).equals(getPos()))
                map.put(entity.getPos(), entity);
        });

        return map;

    }

    /**
     * Gets list of entities
     *
     * @return
     */
    default Map<BlockPos, Entity> createEntitiesForWorld(World world) {
        LinkedHashMap<BlockPos, Entity> map = new LinkedHashMap<>();

        getEntities().forEach((pos, compound) -> {
            try {
                Entity e = EntityList.createEntityFromNBT(compound, world);

                if (e != null
                        && new ChunkPos(e.getPosition()).equals(getPos())) {
                    map.put(e.getPosition(), e);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return map;
    }


    /**
     * Returns serizlized tile entities
     *
     * @return
     */
    Map<BlockPos, NBTTagCompound> getTiles();

    /**
     * Returns serialized entities
     *
     * @return
     */
    Map<BlockPos, NBTTagCompound> getEntities();

    /**
     * Gets map of block within chunk. Always absolute poses
     *
     * @return
     */
    Map<BlockPos, IBlockState> getBlocks();

    /**
     * Adding entity to world
     *
     * @param e
     */
    void addEntity(Entity e);

    /**
     * Set new blockstate
     *
     * @param pos   - current pos
     * @param block - current block
     */
    default void setBlock(BlockPos pos, Block block) {
        setBlockState(pos, block.getDefaultState());
    }

    /**
     * Set new block
     *
     * @param pos   - current pos
     * @param state - current state
     */
    default void setBlockState(BlockPos pos, IBlockState state) {
        setBlockState(pos, state, null);
    }

    /**
     * Modify world by setting new block state with tile entity
     * Pass state as null to prevent block changes
     * Pass entity as null to prevent creating new tile entity
     *
     * @param pos
     * @param state
     * @param entity
     */
    void setBlockState(BlockPos pos, @Nullable IBlockState state, @Nullable TileEntity entity);

    /**
     * Getting blockstate from absolute pos
     *
     * @param pos - absolute pos
     * @return
     */
    @Nullable
    IBlockState getBlockStateFromAbsolute(BlockPos pos);

    /**
     * Getting actual size of chunk blocks
     *
     * @return
     */
    StructureBoundingBox getSize();
}
