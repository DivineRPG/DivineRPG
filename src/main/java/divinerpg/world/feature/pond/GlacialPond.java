package divinerpg.world.feature.pond;

import static divinerpg.world.placement.Surface.hasSpace;

import java.util.List;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.ForgeRegistries;

public class GlacialPond extends GeothermalPond {
	@Override
	protected void genDeep(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.3F) setBlock(level, pos, Blocks.ICE.defaultBlockState());
		pos = pos.below();
		setBlock(level, pos, Blocks.WATER.defaultBlockState());
		genShallow(rules, level, random, pos);
	}
	@Override
	protected void genShallow(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		pos = pos.below();
		setBlock(level, pos, random.nextFloat() < 0.8F && !hasSpace(level, pos.below()) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_gravel")).defaultBlockState() : ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cobbled_frozen_stone")).defaultBlockState());
	}
	@Override
	protected void genEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.08F) {
			setBlock(level, pos, Blocks.WATER.defaultBlockState());
			pos = pos.below();
		}
		setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_gravel")).defaultBlockState());
	}
	@Override
	protected boolean canSustain(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		return level.getBlockState(pos.above()).isAir() && (!level.getBlockState(pos.below()).isAir()) && rule(rules, random, level.getBlockState(pos));
	}
}