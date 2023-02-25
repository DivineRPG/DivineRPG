package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModMoss;
import divinerpg.registries.ConfiguredFeatureRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockBrittleMoss extends BlockModMoss {
	public BlockBrittleMoss() {
		super(Block.Properties.copy(Blocks.MOSS_BLOCK).strength(0.6F, 2.0F));
	}
	@Override
	public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean b) {
		return level.getBlockState(pos.below()).isAir() || level.getBlockState(pos.above()).isAir();
	}
	@Override
	public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
		BlockState s = level.getBlockState(pos);
		if(s.is(BlockTags.MOSS_REPLACEABLE) || s.is(BlockTags.SNOW)) {
			if(s.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_moss")))) ConfiguredFeatureRegistry.BRITTLE_PLANTS.get().place(level, null, random, pos);
			else level.setBlock(pos, state, 3);
		}
	}
}