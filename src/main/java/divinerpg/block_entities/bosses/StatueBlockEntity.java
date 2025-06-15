package divinerpg.block_entities.bosses;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.STATUE;

public class StatueBlockEntity extends BlockEntity {
    public StatueBlockEntity(BlockPos blockPos, BlockState state) {super(STATUE.get(), blockPos, state);}
}