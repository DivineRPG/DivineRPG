package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RobbinHutBlockEntity extends BlockEntity {
	public CompoundTag robbin1, robbin2;
	public RobbinHutBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.ROBBIN_HUT.get(), pos, state);
	}
	@Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.saveAdditional(tag, registries);
		tag.put("RobbinOne", robbin1 == null ? new CompoundTag() : robbin1);
		tag.put("RobbinTwo", robbin2 == null ? new CompoundTag() : robbin2);
	}
	@Override public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.loadAdditional(tag, registries);
		if(tag.contains("RobbinOne")) {
			robbin1 = tag.getCompound("RobbinOne");
			if(robbin1.isEmpty()) robbin1 = null;
		} if(tag.contains("RobbinTwo")) {
			robbin2 = tag.getCompound("RobbinTwo");
			if(robbin2.isEmpty()) robbin2 = null;
		}
	}
}