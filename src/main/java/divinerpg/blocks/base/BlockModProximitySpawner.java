package divinerpg.blocks.base;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.ProximitySpawnerBlockEntity;
import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static divinerpg.registries.BlockEntityRegistry.PROXIMITY_SPAWNER;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.ENABLED;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class BlockModProximitySpawner extends BaseEntityBlock {
	public static final MapCodec<BlockModProximitySpawner> CODEC = simpleCodec(BlockModProximitySpawner::new);
	@Override public MapCodec<BlockModProximitySpawner> codec() {return CODEC;}
	public BlockModProximitySpawner(Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(ENABLED, false));
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(ENABLED);}
	@Override public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		if(level.getBlockEntity(pos) instanceof ProximitySpawnerBlockEntity spawner) {
			boolean enabled = spawner.entityName != null;
			if(state.getValue(ENABLED) != enabled) state.setValue(ENABLED, enabled);
		} return state;
	}
	@Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(player.isCreative() && level.getBlockEntity(pos) instanceof ProximitySpawnerBlockEntity entity) {
			if(stack.isEmpty() && state.getValue(ENABLED)) entity.entityName = null;
			else if(stack.getItem() instanceof SpawnEggItem spawnEgg) entity.entityName = spawnEgg.getType(stack).getDescriptionId().substring(7).replace('.', ':');
			else return ItemInteractionResult.FAIL;
			boolean enabled = entity.entityName != null;
			if(state.getValue(ENABLED) != enabled) level.setBlock(pos, state.setValue(ENABLED, enabled), UPDATE_ALL);
			return ItemInteractionResult.SUCCESS;
		} return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
	@Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
	@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return PROXIMITY_SPAWNER.get().create(pos, state);}
	@Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return level.isClientSide ? null : createTickerHelper(type, PROXIMITY_SPAWNER.get(), ProximitySpawnerBlockEntity::serverTick);
	}
	@OnlyIn(CLIENT)
	@Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		Spawner.appendHoverText(stack, tooltipComponents, "SpawnData");
	}
}