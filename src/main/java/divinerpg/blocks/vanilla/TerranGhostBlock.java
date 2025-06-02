package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.TerranGhostBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;
import java.util.List;

public class TerranGhostBlock extends BaseEntityBlock {
    public static final MapCodec<TerranGhostBlock> CODEC = simpleCodec(TerranGhostBlock::new);
    public TerranGhostBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1.0F;
    }
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return true;
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityRegistry.TERRAN_GHOST.get().create(blockPos, blockState);
    }
    @Nullable @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createCrateTicker(level, type, BlockEntityRegistry.TERRAN_GHOST.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCrateTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends TerranGhostBlockEntity> entityType) {
        return level.isClientSide ? createTickerHelper(type, entityType, TerranGhostBlockEntity::clientTick) : createTickerHelper(type, entityType, TerranGhostBlockEntity::serverTick);
    }
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(!state.is(newState.getBlock())) {
            if(level instanceof ServerLevel s) {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if(blockEntity instanceof TerranGhostBlockEntity e && e.originalState != null && e.originalState != newState) {
                    List<ItemStack> drops = e.originalState.getDrops(new LootParams.Builder(s).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, ItemRegistry.terran_shickaxe.toStack()));
                    for(ItemStack drop : drops) if(!drop.isEmpty()) {
                        ItemEntity itemEntity = new ItemEntity(s, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                        itemEntity.setDeltaMovement(0, 0.1, 0);
                        s.addFreshEntity(itemEntity);
                    }
                }
            } level.removeBlockEntity(pos);
        }
    }
}
