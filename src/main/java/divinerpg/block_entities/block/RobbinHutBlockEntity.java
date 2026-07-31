package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class RobbinHutBlockEntity extends BlockEntity {
    public CompoundTag robbin1, robbin2;
    public RobbinHutBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ROBBIN_HUT.get(), pos, state);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.storeNullable("RobbinOne", CompoundTag.CODEC, robbin1 != null && !robbin1.isEmpty() ? robbin1 : null);
        output.storeNullable("RobbinTwo", CompoundTag.CODEC, robbin2 != null && !robbin2.isEmpty() ? robbin2 : null);
    }

    @Override public void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        robbin1 = input.read("RobbinOne", CompoundTag.CODEC)
                .filter(tag -> !tag.isEmpty())
                .orElse(null);

        robbin2 = input.read("RobbinTwo", CompoundTag.CODEC)
                .filter(tag -> !tag.isEmpty())
                .orElse(null);
    }
}