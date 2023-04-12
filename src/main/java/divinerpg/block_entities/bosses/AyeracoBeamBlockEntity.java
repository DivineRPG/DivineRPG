package divinerpg.block_entities.bosses;

import divinerpg.registries.*;
import divinerpg.block_entities.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.*;

public class AyeracoBeamBlockEntity extends ModUpdatableBlockEntity {
	public AyeracoBeamBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntityRegistry.AYERACO_BEAM.get(), p_155229_, p_155230_);
    }
	@Override
	public void load(CompoundTag tag) {
		if(level != null && !level.isClientSide) super.load(tag);
	}
}