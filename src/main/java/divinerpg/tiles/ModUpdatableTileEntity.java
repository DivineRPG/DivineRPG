package divinerpg.tiles;

import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.tileentity.*;

import javax.annotation.*;

/**
 * Base implementation of networking TileEntity
 */
public class ModUpdatableTileEntity extends TileEntity {
    /**
     * Always should be a empty ctor
     */
    public ModUpdatableTileEntity(TileEntityType type) {
        super(type);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), -1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
     this.deserializeNBT(pkt.getTag());

    }

    @Override
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        load(state, tag);
    }

}
