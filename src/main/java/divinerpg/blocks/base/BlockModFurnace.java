package divinerpg.blocks.base;

import divinerpg.block_entities.furnace.ModFurnaceBlockEntity;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public final class BlockModFurnace extends FurnaceBlock {
	public final Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntityType;

    public BlockModFurnace(Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntity, MapColor color) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(3.5F).instrument(NoteBlockInstrument.BASEDRUM));
        this.blockEntityType = blockEntity;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }

    @Override
	public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
		return state.getValue(AbstractFurnaceBlock.LIT) ? 12 : 0;
	}

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
           BlockEntity blockentity = level.getBlockEntity(pos);
           if (blockentity instanceof ModFurnaceBlockEntity) ((ModFurnaceBlockEntity)blockentity).setCustomName(stack.getHoverName());
        }
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if (!state.is(st.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof ModFurnaceBlockEntity) {
				if (level instanceof ServerLevel) {
					Containers.dropContents(level, pos, (ModFurnaceBlockEntity)blockentity);
					((ModFurnaceBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)level, Vec3.atCenterOf(pos));
	            }
	            level.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, level, pos, st, b);
		}
	}

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createFurnaceTicker(type, level, blockEntityType.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> p_151989_, Level p_151988_, BlockEntityType<? extends ModFurnaceBlockEntity> p_151990_) {
       return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, ModFurnaceBlockEntity::serverTick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return blockEntityType.get().create(pos, state);
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof ModFurnaceBlockEntity) {
           player.openMenu((MenuProvider)blockentity);
           player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
	}
}
