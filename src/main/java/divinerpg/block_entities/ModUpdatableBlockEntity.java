package divinerpg.block_entities;

import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.*;

/**
 * Base implementation of networking BlockEntity
 */
public class ModUpdatableBlockEntity extends BlockEntity {
    /**
     * Always should be a empty ctor
     */
    public ModUpdatableBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.deserializeNBT(pkt.getTag());

    }


    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }
}
