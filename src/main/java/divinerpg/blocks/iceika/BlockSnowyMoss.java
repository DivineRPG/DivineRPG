package divinerpg.blocks.iceika;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.block.Blocks.GLOW_LICHEN;
import static net.minecraft.world.level.material.MapColor.SNOW;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class BlockSnowyMoss extends GlowLichenBlock {
	public BlockSnowyMoss() {super(Properties.ofFullCopy(GLOW_LICHEN).mapColor(SNOW));}
	@Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
		float baseProgress = super.getDestroyProgress(state, player, level, pos);
		return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(player.getMainHandItem().getItem()));
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
}