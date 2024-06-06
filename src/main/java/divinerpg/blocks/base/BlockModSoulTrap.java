package divinerpg.blocks.base;

import divinerpg.capability.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockModSoulTrap extends BlockMod {
	public BlockModSoulTrap() {super(Properties.of().mapColor(DyeColor.GRAY).strength(5, 6).sound(SoundType.METAL));}
	@Override public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		level.getChunk(pos.getX() >> 4, pos.getZ() >> 4).getCapability(SoulTrapCountProvider.SOUL_TRAP_COUNT).orElseGet(SoulTrapCount::new).add();
	}
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		level.getChunk(pos.getX() >> 4, pos.getZ() >> 4).getCapability(SoulTrapCountProvider.SOUL_TRAP_COUNT).orElseGet(SoulTrapCount::new).remove();
	}
}