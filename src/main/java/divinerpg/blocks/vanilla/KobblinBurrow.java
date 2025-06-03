package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.KobblinBurrowBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.BlockEntityRegistry.KOBBLIN_BURROW;

public class KobblinBurrow extends BaseEntityBlock {
    public static final MapCodec<KobblinBurrow> CODEC = simpleCodec(KobblinBurrow::new);
    public KobblinBurrow(Properties properties) {super(properties);}
    @Override protected MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}
    @Override public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return KOBBLIN_BURROW.get().create(blockPos, blockState);
    }
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, KOBBLIN_BURROW.get(), KobblinBurrowBlockEntity::serverTick);
    }
    @Override protected RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
}