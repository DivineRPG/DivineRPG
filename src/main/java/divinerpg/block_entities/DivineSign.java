package divinerpg.block_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.DIVINE_SIGN;

public class DivineSign extends SignBlockEntity {
    public DivineSign(BlockPos pos, BlockState blockState) {super(DIVINE_SIGN.get(), pos, blockState);}
}