package divinerpg.block_entities.bosses;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

public class StatueBlockEntity extends BlockEntity {
    public StatueBlockEntity(BlockPos blockPos, BlockState state) {
        super(BlockEntityRegistry.STATUE.get(), blockPos, state);
    }
}
