package divinerpg.tiles.bosses;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityStatue extends BlockEntity {
    public TileEntityStatue(BlockPos blockPos, BlockState state) {
        super(BlockEntityRegistry.STATUE.get(), blockPos, state);
    }
}
