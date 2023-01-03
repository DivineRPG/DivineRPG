package divinerpg.blocks.base;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import divinerpg.tiles.furnace.TileEntityInfiniFurnace;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

public class BlockModInfiniFurnace extends BaseEntityBlock {
	public final Supplier<BlockEntityType<? extends TileEntityInfiniFurnace>> blockEntityType;
	public BlockModInfiniFurnace(Supplier<BlockEntityType<? extends TileEntityInfiniFurnace>> blockEntity) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.5F));
        this.blockEntityType = blockEntity;
        this.registerDefaultState(this.stateDefinition.any().setValue(AbstractFurnaceBlock.FACING, Direction.NORTH).setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(false)));
    }
	protected BlockModInfiniFurnace(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends TileEntityInfiniFurnace>> blockEntity) {
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
        if (blockentity instanceof TileEntityInfiniFurnace) {
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
	         if (blockentity instanceof TileEntityInfiniFurnace) ((TileEntityInfiniFurnace)blockentity).setCustomName(stack.getHoverName());
	    }
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if (!state.is(st.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof TileEntityInfiniFurnace) {
				if (level instanceof ServerLevel) {
					Containers.dropContents(level, pos, (TileEntityInfiniFurnace)blockentity);
					((TileEntityInfiniFurnace)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)level, Vec3.atCenterOf(pos));
	            }
	            level.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, level, pos, st, b);
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
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends TileEntityInfiniFurnace> entityType) {
		return level.isClientSide ? null : createTickerHelper(type, entityType, TileEntityInfiniFurnace::serverTick);
	}
	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
	      if (state.getValue(AbstractFurnaceBlock.LIT)) {
	         double d0 = (double)pos.getX() + 0.5D, d1 = (double)pos.getY(), d2 = (double)pos.getZ() + 0.5D;
	         if (random.nextDouble() < 0.1D) level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
	         Direction direction = state.getValue(AbstractFurnaceBlock.FACING);
	         Direction.Axis direction$axis = direction.getAxis();
	         double d4 = random.nextDouble() * 0.6D - 0.3D, d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
	         double d6 = random.nextDouble() * 6.0D / 16.0D, d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
	         level.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	         level.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	      }
	}
}