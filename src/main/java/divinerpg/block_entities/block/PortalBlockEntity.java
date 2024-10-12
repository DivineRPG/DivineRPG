package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.util.UniversalPosition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

public class PortalBlockEntity extends BlockEntity {
	public UniversalPosition targetPosition;
	public PortalBlockEntity(BlockPos pos, BlockState blockState) {
		super(BlockEntityRegistry.PORTAL.get(), pos, blockState);
	}
	public boolean hasTargetPos() {
		return targetPosition != null;
	}
	@Override
	protected void saveAdditional(CompoundTag tag, Provider registries) {
		super.saveAdditional(tag, registries);
		if(targetPosition != null) {
			tag.putString("target_dim", targetPosition.dimension().location().toString());
			tag.putLong("target_pos", targetPosition.blockPos().asLong());
		}
	}
	@Override
	protected void loadAdditional(CompoundTag tag, Provider registries) {
		super.loadAdditional(tag, registries);
		if(tag.contains("target_pos") && tag.contains("target_dim")) targetPosition = new UniversalPosition(ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(tag.getString("target_dim"))), BlockPos.of(tag.getLong("target_pos")));
	}
}