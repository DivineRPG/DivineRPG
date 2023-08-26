package divinerpg.blocks.twilight;

import divinerpg.block_entities.chests.EdenChestBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockEdenChest extends BlockModChest {

    public BlockEdenChest() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.5F).instrument(NoteBlockInstrument.BASEDRUM), () -> BlockEntityRegistry.EDEN_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EdenChestBlockEntity(pos, state);
    }
}