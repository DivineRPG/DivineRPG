package divinerpg.blocks.base;

import divinerpg.block_entities.furnace.ModFurnaceBlockEntity;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public final class BlockModFurnace extends FurnaceBlock {
	public final Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntityType;
    public BlockModFurnace(Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntity, MapColor color) {
        super(Properties.copy(Blocks.FURNACE).mapColor(color));
        blockEntityType = blockEntity;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }
    @Override public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        if(stack.hasCustomHoverName()) {
           BlockEntity blockentity = level.getBlockEntity(pos);
           if(blockentity instanceof ModFurnaceBlockEntity) ((ModFurnaceBlockEntity)blockentity).setCustomName(stack.getHoverName());
        }
	}
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if(!state.is(st.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if(blockentity instanceof ModFurnaceBlockEntity) {
				if(level instanceof ServerLevel) {
					Containers.dropContents(level, pos, (ModFurnaceBlockEntity)blockentity);
					((ModFurnaceBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)level, Vec3.atCenterOf(pos));
	            } level.updateNeighbourForOutputSignal(pos, this);
			} super.onRemove(state, level, pos, st, b);
		}
	}
    @Nullable
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createFurnaceTicker(type, level, blockEntityType.get());
    }
    @Nullable
    private static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> type, Level level, BlockEntityType<? extends ModFurnaceBlockEntity> type1) {
       return level.isClientSide ? null : createTickerHelper(type, type1, ModFurnaceBlockEntity::serverTick);
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return blockEntityType.get().create(pos, state);
    }
    @Override protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if(blockentity instanceof ModFurnaceBlockEntity) {
           player.openMenu((MenuProvider)blockentity);
           player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
	}
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state.getValue(LIT)) {
            double d0 = pos.getX() + .5;
            double d1 = pos.getY();
            double d2 = pos.getZ() + .5;
            if(random.nextDouble() < .1) level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1, 1, false);
            Direction direction = state.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = random.nextDouble() * .6 - .3;
            double d5 = direction$axis == Direction.Axis.X ? direction.getStepX() * d3 : d4;
            double d6 = random.nextDouble() * 6 / 16;
            double d7 = direction$axis == Direction.Axis.Z ? direction.getStepZ() * d3 : d4;
            level.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
            if(state.getBlock() == BlockRegistry.moonlightFurnace.get()) level.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
            else level.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
        }
    }
}