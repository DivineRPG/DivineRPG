package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class BlockColdHellfireSponge extends BlockMod {
	public BlockColdHellfireSponge() {
		super(Block.Properties.ofFullCopy(Blocks.WET_SPONGE).mapColor(MapColor.COLOR_RED));
	}
	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		if(level.dimensionType().ultraWarm()) {
			level.setBlock(pos, BlockRegistry.hellfireSponge.get().defaultBlockState(), UPDATE_ALL);
			level.playLocalSound(pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1F, 1F, false);
		}
	}
}
