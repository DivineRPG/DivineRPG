package divinerpg.blocks.vanilla;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockColdHellfireSponge extends BlockMod {
	public BlockColdHellfireSponge() {
		super(Block.Properties.copy(Blocks.SPONGE));
	}
	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		if(level.dimensionType().ultraWarm()) {
			level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hellfire_sponge")).defaultBlockState(), UPDATE_ALL);
			level.playLocalSound(pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1F, 1F, false);
		}
	}
}