package divinerpg.block_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.DIVINE_HANGING_SIGN;

public class DivineSignHanging extends HangingSignBlockEntity {
    public DivineSignHanging(BlockPos pos, BlockState blockState) {super(pos, blockState);}
    @Override public BlockEntityType<?> getType() {return DIVINE_HANGING_SIGN.get();}
}