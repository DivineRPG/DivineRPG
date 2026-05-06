package divinerpg.blocks.iceika;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

import static divinerpg.registries.ItemRegistry.winterberry;
import static net.minecraft.sounds.SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.BLOOM;

public class BlockWinterberryVinesBody extends WeepingVinesPlantBlock implements BonemealableBlock {
	public static final BooleanProperty RIPE = BLOOM;
	public BlockWinterberryVinesBody(Properties properties) {
		super(properties.randomTicks().lightLevel((state) -> state.getValue(RIPE) ? 5 : 1).dynamicShape());
		registerDefaultState(this.stateDefinition.any().setValue(RIPE, false));
	}
	@Override protected GrowingPlantHeadBlock getHeadBlock() {return (GrowingPlantHeadBlock) BlockRegistry.winterberryVinesHead.get();}
	@Override public boolean isRandomlyTicking(BlockState state) {return !state.getValue(RIPE);}
	@Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if(random.nextFloat() < .11F) level.setBlock(pos, state.setValue(RIPE, true), 3);
	}
	@Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		level.setBlock(pos, state.setValue(RIPE, true), 2);
	}
	@Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return !state.getValue(RIPE) || super.isValidBonemealTarget(level, pos, state);
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		BlockState aboveState = level.getBlockState(pos.above());
		if(aboveState.getBlock() == BlockRegistry.winterberryVinesBody.get() && aboveState.getValue(RIPE))
			popResource(level, pos.above(), new ItemStack(winterberry.get(), 1));
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
	@Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if(state.getValue(RIPE)) {
	        popResource(level, pos, new ItemStack(winterberry.get(), 1));
	        level.playSound(null, pos, SWEET_BERRY_BUSH_PICK_BERRIES, BLOCKS, 1, .8F + level.random.nextFloat() * .4F);
	        level.setBlock(pos, state.setValue(RIPE, false), 2);
	        return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(RIPE);}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 15;}
}