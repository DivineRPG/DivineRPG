package divinerpg.blocks.twilight;

import divinerpg.block_entities.chests.EdenChestBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.*;

import javax.annotation.*;

public class BlockEdenChest extends BlockModChest {

    public BlockEdenChest() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.5F).instrument(NoteBlockInstrument.BASEDRUM), () -> BlockEntityRegistry.EDEN_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new EdenChestBlockEntity(p_153215_, p_153216_);
    }
}