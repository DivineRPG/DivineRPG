package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWinterberryVinesBody extends WeepingVinesPlantBlock implements BonemealableBlock {
	public static final BooleanProperty RIPE = BlockStateProperties.BLOOM;

	public BlockWinterberryVinesBody(Properties properties) {
		super(properties.randomTicks().lightLevel((state) -> state.getValue(RIPE) ? 5 : 1).dynamicShape());
		registerDefaultState(this.stateDefinition.any().setValue(RIPE, false));
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_head"));
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(RIPE);
    }

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (random.nextFloat() < 0.11F) level.setBlock(pos, state.setValue(RIPE, true), 3);
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		level.setBlock(pos, state.setValue(RIPE, true), 2);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader p_53900_, BlockPos p_53901_, BlockState state, boolean p_53903_) {
		return !state.getValue(RIPE) || super.isValidBonemealTarget(p_53900_, p_53901_, state, p_53903_);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		BlockState aboveState = level.getBlockState(pos.above());
		if (aboveState.getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_body")) && aboveState.getValue(RIPE)) {
			popResource(level, pos.above(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")), 1));
		}
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {
		if (state.getValue(RIPE)) {
	        popResource(level, pos, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")), 1));
	        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
	        level.setBlock(pos, state.setValue(RIPE, false), 2);
	        return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RIPE);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 60;
        }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 15;
    }
}
