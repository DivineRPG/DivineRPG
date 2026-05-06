package divinerpg.blocks.iceika;

import divinerpg.blocks.arcana.BlockArcaniteVinesHead;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;

import static divinerpg.registries.BlockRegistry.winterberryVinesBody;
import static divinerpg.registries.ItemRegistry.winterberry;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.BLOOM;

public class BlockWinterberryVinesHead extends BlockArcaniteVinesHead {
	public static final BooleanProperty RIPE = BLOOM;
	public BlockWinterberryVinesHead(Properties properties) {super(properties.lightLevel((state) -> 1).dynamicShape());}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		BlockState aboveState = level.getBlockState(pos.above());
		if(aboveState.getBlock() == winterberryVinesBody.get() && aboveState.getValue(RIPE))
			popResource(level, pos.above(), new ItemStack(winterberry.get(), 1));
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
	@Override protected Block getBodyBlock() {return winterberryVinesBody.get();}
}