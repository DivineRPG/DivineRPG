package divinerpg.block_entities.bosses;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DramixAltarBlockEntity extends BlockEntity {

    public DramixAltarBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DRAMIX_ALTAR.get(), pos, state);
    }
}
