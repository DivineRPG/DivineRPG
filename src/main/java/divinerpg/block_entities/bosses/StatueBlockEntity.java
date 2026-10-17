package divinerpg.block_entities.bosses;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class StatueBlockEntity extends BlockEntity {
    public StatueBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
//    public StatueBlockEntity(BlockPos blockPos, BlockState state) {super(STATUE.get(), blockPos, state);}
}