package divinerpg.block_entities;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.*;

public class NightmareBedBlockEntity extends BlockEntity {

    public NightmareBedBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.NIGHTMARE_BED.get(), pos, state);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
