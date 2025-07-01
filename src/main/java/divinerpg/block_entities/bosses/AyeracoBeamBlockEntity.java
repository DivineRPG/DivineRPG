package divinerpg.block_entities.bosses;

import divinerpg.block_entities.ModUpdatableBlockEntity;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_BEAM;

public class AyeracoBeamBlockEntity extends ModUpdatableBlockEntity {
	public AyeracoBeamBlockEntity(BlockPos pos, BlockState state) {super(AYERACO_BEAM.get(), pos, state);}
	@Override public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		if(level != null && !level.isClientSide) super.loadAdditional(tag, registries);
	}
}