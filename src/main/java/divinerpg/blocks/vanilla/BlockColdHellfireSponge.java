package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockRegistry.hellfireSponge;
import static net.minecraft.sounds.SoundEvents.FIRECHARGE_USE;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.Blocks.SPONGE;
import static net.minecraft.world.level.block.LevelEvent.PARTICLES_TRIAL_SPAWNER_SPAWN;
import static net.minecraft.world.level.material.MapColor.COLOR_RED;

public class BlockColdHellfireSponge extends BlockMod {
	public BlockColdHellfireSponge() {super(Properties.ofFullCopy(SPONGE).mapColor(COLOR_RED));}
	@Override public void onPlace(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if(level.dimensionType().ultraWarm()) {
			level.setBlock(pos, hellfireSponge.get().defaultBlockState(), UPDATE_ALL);
			level.levelEvent(PARTICLES_TRIAL_SPAWNER_SPAWN, pos, 0);
			level.playSound(null, pos, FIRECHARGE_USE, BLOCKS, 1, (1 + level.getRandom().nextFloat() * .8F) * .7F);
		}
	}
}