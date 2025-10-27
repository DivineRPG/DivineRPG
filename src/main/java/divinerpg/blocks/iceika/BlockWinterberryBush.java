package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

import static divinerpg.registries.ItemRegistry.winterberry;
import static net.minecraft.sounds.SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.block.SoundType.SWEET_BERRY_BUSH;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.BLOOM;
import static net.minecraft.world.level.material.MapColor.PLANT;
import static net.minecraft.world.level.material.PushReaction.DESTROY;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class BlockWinterberryBush extends BlockMod implements BonemealableBlock {
	public static final BooleanProperty RIPE = BLOOM;
    public BlockWinterberryBush() {
        super(Properties.of().mapColor(PLANT).noCollission().randomTicks().strength(.2F).sound(SWEET_BERRY_BUSH).lightLevel((state) -> state.getValue(RIPE) ? 5 : 1).pushReaction(DESTROY));
		registerDefaultState(stateDefinition.any().setValue(RIPE, false));
    }
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
    }
    @Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(player.getMainHandItem().getItem()));
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
    @Override public boolean isRandomlyTicking(BlockState state) {return !state.getValue(RIPE);}
    @Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(random.nextFloat() < .11F) level.setBlock(pos, state.setValue(RIPE, true), 3);
    }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		level.setBlock(pos, state.setValue(RIPE, true), 3);
	}
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {return !state.getValue(RIPE);}
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult p_60508_) {
		if(state.getValue(RIPE)) {
	        popResource(level, pos, new ItemStack(winterberry.get(), 1));
	        level.playSound(null, pos, SWEET_BERRY_BUSH_PICK_BERRIES, BLOCKS, 1, .8F + level.random.nextFloat() * .4F);
	        level.setBlock(pos, state.setValue(RIPE, false), 2);
	        return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(RIPE);}
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {return true;}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}