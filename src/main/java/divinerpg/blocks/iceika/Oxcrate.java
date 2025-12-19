package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.CrateBlockEntity;
import divinerpg.blocks.vanilla.BlockCrate;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static divinerpg.registries.BlockRegistry.oxdriteBlock;

public class Oxcrate extends BlockCrate {
    public static final MapCodec<Oxcrate> CODEC = simpleCodec(Oxcrate::new);
    public Oxcrate() {this(Properties.ofFullCopy(oxdriteBlock.get()));}
    public Oxcrate(Properties properties) {super(properties);}
    @Override public MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.OXCRATE.get().create(pos, state);
    }
    @Nullable
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.OXCRATE.get(), CrateBlockEntity::serverTick);
    }
}