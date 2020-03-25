package divinerpg.structure.mock;

import divinerpg.structure.mock.interfaces.IWorldStorage;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

import javax.annotation.Nullable;

public class MockWorld extends World {
    private final IWorldStorage storage;

    public MockWorld(IWorldStorage storage) {
        super(null, null, new WorldProvider() {
            @Override
            public DimensionType getDimensionType() {
                return DimensionType.OVERWORLD;
            }
        }, null, false);
        this.storage = storage;
    }

    @Override
    protected IChunkProvider createChunkProvider() {
        return null;
    }

    @Override
    protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
        return false;
    }

    @Override
    public boolean addTileEntity(TileEntity tile) {
        if (this.isOutsideBuildHeight(tile.getPos())) {
            return false;
        }

        storage.addTileEntity(tile);
        return true;
    }

    @Override
    public boolean setBlockState(BlockPos pos, IBlockState newState, int flags) {
        if (this.isOutsideBuildHeight(pos)) {
            return false;
        }

        storage.setBlockState(pos, newState);
        return true;
    }

    @Nullable
    @Override
    public IBlockState getBlockState(BlockPos pos) {
        return storage.getBlockState(pos);
    }

    @Override
    public boolean isAirBlock(BlockPos pos) {
        IBlockState state = getBlockState(pos);
        return state == null || state.getBlock().isAir(state, this, pos);
    }

    @Override
    public boolean spawnEntity(Entity entityIn) {
        storage.addEntity(entityIn);
        return true;
    }
}
