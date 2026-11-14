package divinerpg.blocks.iceika;

import divinerpg.block_entities.chest.CrateBlockEntity;
import divinerpg.blocks.vanilla.Crate;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.Nullable;

import static divinerpg.registries.BlockRegistry.oxdriteBlockSet;

public class Oxcrate extends Crate {
    public Oxcrate() {this(BlockBehaviour.Properties.ofFullCopy(oxdriteBlockSet.getLast().get()));}
    public Oxcrate(BlockBehaviour.Properties properties) {super(properties);}
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.OXCRATE.get().create(pos, state);
    }
    @Nullable
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, BlockEntityRegistry.OXCRATE.get(), CrateBlockEntity::serverTick);
    }
}