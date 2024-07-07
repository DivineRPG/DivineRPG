package divinerpg.blocks.base;

import divinerpg.block_entities.furnace.InfiniFurnaceBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.*;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockModInfiniFurnace extends BaseEntityBlock {
	public final Supplier<BlockEntityType<? extends InfiniFurnaceBlockEntity>> blockEntityType;
	public BlockModInfiniFurnace(Supplier<BlockEntityType<? extends InfiniFurnaceBlockEntity>> blockEntity, MapColor color) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(3.5F).instrument(NoteBlockInstrument.BASEDRUM));
        this.blockEntityType = blockEntity;
        this.registerDefaultState(this.stateDefinition.any().setValue(AbstractFurnaceBlock.FACING, Direction.NORTH).setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(false)));
    }
	protected BlockModInfiniFurnace(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends InfiniFurnaceBlockEntity>> blockEntity) {
		super(properties);
        this.blockEntityType = blockEntity;
		this.registerDefaultState(this.stateDefinition.any().setValue(AbstractFurnaceBlock.FACING, Direction.NORTH).setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(false)));
	}
	@Override
	public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
		return state.getValue(AbstractFurnaceBlock.LIT) ? 12 : 0;
	}
	@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createFurnaceTicker(level, type, blockEntityType.get());
    }
	@Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return blockEntityType.get().create(pos, state);
    }
	protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof InfiniFurnaceBlockEntity) {
           player.openMenu((MenuProvider)blockentity);
           player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }
	@Override
	public InteractionResult use(BlockState p_48706_, Level level, BlockPos pos, Player player, InteractionHand p_48710_, BlockHitResult p_48711_) {
		if (level.isClientSide) return InteractionResult.SUCCESS;
		else {
	        openContainer(level, pos, player);
	        return InteractionResult.CONSUME;
		}
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(AbstractFurnaceBlock.FACING, context.getHorizontalDirection().getOpposite());
	}
	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		if (stack.hasCustomHoverName()) {
	         BlockEntity blockentity = level.getBlockEntity(pos);
	         if (blockentity instanceof InfiniFurnaceBlockEntity) ((InfiniFurnaceBlockEntity)blockentity).setCustomName(stack.getHoverName());
	    }
	}
	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if(!state.is(st.getBlock()) || !st.hasBlockEntity()) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if(blockentity instanceof InfiniFurnaceBlockEntity) {
				if(level instanceof ServerLevel) {
					Containers.dropContents(level, pos, (InfiniFurnaceBlockEntity)blockentity);
					((InfiniFurnaceBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)level, Vec3.atCenterOf(pos));
	            } level.updateNeighbourForOutputSignal(pos, this);
			} level.removeBlockEntity(pos);
		}
	}
	@Override public boolean hasAnalogOutputSignal(BlockState state) {return true;}
	@Override
	public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
	      return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}
	@Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(AbstractFurnaceBlock.FACING, rotation.rotate(state.getValue(AbstractFurnaceBlock.FACING)));
	}
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(AbstractFurnaceBlock.FACING)));
	}
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AbstractFurnaceBlock.FACING, AbstractFurnaceBlock.LIT);
	}
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends InfiniFurnaceBlockEntity> entityType) {
		return level.isClientSide ? null : createTickerHelper(type, entityType, InfiniFurnaceBlockEntity::serverTick);
	}
	@Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if(state.getValue(AbstractFurnaceBlock.LIT)) {
			double d0 = pos.getX() + .5;
			double d1 = pos.getY();
			double d2 = pos.getZ() + .5;
			if(random.nextDouble() < .1) level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1, 1, false);
			Direction direction = state.getValue(AbstractFurnaceBlock.FACING);
			Direction.Axis direction$axis = direction.getAxis();
			double d3 = 0.52D;
			double d4 = random.nextDouble() * .6 - .3;
			double d5 = direction$axis == Direction.Axis.X ? direction.getStepX() * d3 : d4;
			double d6 = random.nextDouble() * 6 / 16;
			double d7 = direction$axis == Direction.Axis.Z ? direction.getStepZ() * d3 : d4;
			level.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
			if(state.getBlock() == BlockRegistry.oceanfireFurnace.get()) level.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
			else level.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
		}
	}
}