package divinerpg.block_entities.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_BEAM;

public class AyeracoBeamBlockEntity extends UpdatableBlockEntity {
    public AyeracoBeamBlockEntity(BlockPos pos, BlockState state) {super(AYERACO_BEAM.get(), pos, state);}
}