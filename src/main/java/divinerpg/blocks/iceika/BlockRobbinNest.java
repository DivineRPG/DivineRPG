package divinerpg.blocks.iceika;

import divinerpg.block_entities.block.RobbinNestBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

public class BlockRobbinNest extends BaseEntityBlock {
	protected static final VoxelShape BASE_SHAPE = Block.box(2, 0, 2, 14, 4, 14);
	public BlockRobbinNest() {super(Block.Properties.copy(Blocks.HAY_BLOCK).randomTicks().noOcclusion().mapColor(MapColor.COLOR_BROWN).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false));}
	@Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return BASE_SHAPE;}
	@Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
	@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return BlockEntityRegistry.ROBBIN_NEST.get().create(pos, state);}
	@Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if(state.is(this) && random.nextBoolean() && level.getExistingBlockEntity(pos) instanceof RobbinNestBlockEntity block && block.getItem().is(ItemRegistry.robbin_egg.get())) {
			block.removeItem(1);
			EntityRegistry.ROBBIN.get().spawn(level, pos, MobSpawnType.BREEDING);
		}
	}
	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}
	@Override
	public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}
	@Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block) {
			ItemStack handItem = player.getItemInHand(hand);
			if(handItem == null || handItem.isEmpty()) {
				if(!block.getItem().isEmpty()) {
					player.setItemInHand(hand, block.getItem());
					block.setItemSilent(ItemStack.EMPTY);
					return InteractionResult.SUCCESS;
				} return InteractionResult.FAIL;
			} if(block.getItem().isEmpty()) {
				block.setItemSilent(handItem.copy());
				if(!player.isCreative()) player.setItemInHand(hand, ItemStack.EMPTY);
				return InteractionResult.SUCCESS;
			} level.addFreshEntity(new ItemEntity(level, pos.getX() + .5, pos.getY() + .1, pos.getZ() + .5, block.getItem()));
			block.setItemSilent(ItemStack.EMPTY);
			return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		if((!state.is(s.getBlock()) || !s.hasBlockEntity())) {
			if(level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block && !block.isEmpty()) Containers.dropContents(level, pos, block);
			level.removeBlockEntity(pos);
			level.updateNeighbourForOutputSignal(pos, this);
		}
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block) {
			if(!block.isEmpty()) Containers.dropContents(level, pos, block);
			level.removeBlockEntity(pos);
			level.updateNeighbourForOutputSignal(pos, this);
		} return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
}