package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BlockBuddingOlivine extends AmethystBlock {
	public BlockBuddingOlivine(Properties p) {
		super(p);
	}
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if(random.nextInt(5) == 0) {
	        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
	        BlockPos blockpos = pos.relative(direction);
	        BlockState blockstate = level.getBlockState(blockpos);
	        if(canClusterGrowAtState(blockstate))  level.setBlockAndUpdate(blockpos, BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "olivine_cluster")).defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER)));
		}
	}
	public static boolean canClusterGrowAtState(BlockState state) {
		return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
	}
}