package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KarosDispenser extends DispenserBlockEntity {
    public KarosDispenser(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.KAROS_DISPENSER.get(), pos, blockState);
    }
}