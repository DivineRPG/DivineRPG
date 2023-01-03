package divinerpg.tiles;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.*;

public class TileEntityNightmareBed extends BlockEntity {

    public TileEntityNightmareBed(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.NIGHTMARE_BED.get(), pos, state);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
