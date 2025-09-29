package divinerpg.blocks.iceika;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.Blocks.GLOW_LICHEN;
import static net.minecraft.world.level.material.MapColor.SNOW;

public class BlockSnowyMoss extends GlowLichenBlock {
	public BlockSnowyMoss() {super(Properties.ofFullCopy(GLOW_LICHEN).mapColor(SNOW));}
	@Override public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
		float f = state.getDestroySpeed(level, pos);
		if(player.getMainHandItem().getItem() instanceof ShearsItem) return player.getDigSpeed(state, pos) / f / 15;
		else return super.getDestroyProgress(state, player, level, pos);
	}
}