package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class Glowsprout extends AuroraoakTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(Blocks.MUD) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "gelidite"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_dirt"))) || state.is(Blocks.MYCELIUM);
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight = 3 + random.nextInt(9), extraHeight = treeHeight + 2;
			if(heightCheck(level, pos, extraHeight, 1)) {
				gradualGrowth(level, random, pos.mutable(), config.log, config.leaves, treeHeight, .1F, .05F, true);
				return true;
			}
		} return false;
	}
	@Override
	protected void growLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves) {
		setBlock(level, pos, leaves, false);
		pos = pos.offset(0, -1, 0);
		grow(level, pos, leaves, 1, 0);
		grow(level, pos, leaves, 1, 1);
		grow(level, pos, leaves, 2, -1);
		grow(level, pos, leaves, 2, 0);
		grow(level, pos, leaves, 2, 1);
		if(random.nextBoolean()) {
			pos = pos.offset(0, -1, 0);
			grow(level, pos, leaves, 2, 2);
			grow(level, pos, leaves, 3, -1);
			grow(level, pos, leaves, 3, 0);
			grow(level, pos, leaves, 3, 1);
		}
	}
}