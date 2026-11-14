package divinerpg.blocks.base;

import divinerpg.block_entities.block.ProximitySpawnerBlockEntity;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.BlockHitResult;

import static divinerpg.registries.BlockEntityRegistry.PROXIMITY_SPAWNER;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.ENABLED;

public class ProximitySpawner extends BaseEntityBlock {
    public ProximitySpawner(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(ENABLED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(ENABLED);}
    @Override protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if(level.getBlockEntity(pos) instanceof ProximitySpawnerBlockEntity spawner) {
            boolean enabled = spawner.entityName != null;
            if(state.getValue(ENABLED) != enabled) state.setValue(ENABLED, enabled);
        } return state;
    }
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(player.isCreative() && level.getBlockEntity(pos) instanceof ProximitySpawnerBlockEntity entity) {
            if(!(stack.getItem() instanceof SpawnEggItem) && state.getValue(ENABLED)) entity.entityName = null;
            else if(stack.getItem() instanceof SpawnEggItem spawnEgg) entity.entityName = SpawnEggItem.getType(stack).getDescriptionId().substring(7).replace('.', ':');
            else return InteractionResult.FAIL;
            boolean enabled = entity.entityName != null;
            if(state.getValue(ENABLED) != enabled) level.setBlock(pos, state.setValue(ENABLED, enabled), UPDATE_ALL);
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return PROXIMITY_SPAWNER.get().create(pos, state);}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, PROXIMITY_SPAWNER.get(), ProximitySpawnerBlockEntity::serverTick);
    }
    //TODO: proximity spawner tooltip
//    @OnlyIn(CLIENT)
//    @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) { {
//        super.appendHoverText(stack, context, context, tooltip, builder, flagIn);
//        Spawner.appendHoverText(stack, tooltipComponents, "SpawnData");
//    }
}