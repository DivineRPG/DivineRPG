package divinerpg.block_entities.bosses;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ParasectaAltarBlockEntity extends BlockEntity {

    public ParasectaAltarBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.PARASECTA_ALTAR.get(), pos, state);
    }
}
