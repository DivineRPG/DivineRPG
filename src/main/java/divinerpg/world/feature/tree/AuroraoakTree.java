package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class AuroraoakTree extends DivineTree {
	protected void gradualGrowth(WorldGenLevel level, RandomSource random, MutableBlockPos pos, BlockState log, BlockState leaves, int maxY, float curvatureChance, float splitChance, boolean replace) {
		setBlock(level, pos, log, replace);
		for(int y = 0; y <= maxY; y++) {
			setBlock(level, pos.move(random.nextFloat() < curvatureChance ? random.nextInt(3) - 1 : 0, 1, random.nextFloat() < curvatureChance ? random.nextInt(3) - 1 : 0), log, replace);
			if(random.nextFloat() < splitChance) gradualGrowth(level, random, new MutableBlockPos(pos.getX() + random.nextInt(3) - 1, pos.getY(), pos.getZ() + random.nextInt(3) - 1), log, leaves, maxY - y, curvatureChance, splitChance, replace);
		}
		growLeaves(level, random, pos.move(0, 1, 0), leaves);
	}
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_dirt"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_grass"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_stone"))) || state.is(Blocks.PACKED_ICE) || state.is(Blocks.SNOW_BLOCK);
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeType = random.nextInt(4), treeHeight = treeType == 0 ? 3 + random.nextInt(3) : 4 + random.nextInt(7), extraHeight = treeHeight + 2;
			if(heightCheck(level, pos, extraHeight, 1)) {
				BlockState log = config.log, leaves = config.leaves;
				if(treeType == 0) {
					grow(level, pos, log, 1, 0, true);
					grow(level, random, pos.above(), log, 1, 0, true, .25F);
					grow(level, pos, log, treeHeight, true);
					extraHeight -= treeHeight;
					grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight);
					grow(level, pos.offset(0, treeHeight - 1, 0), leaves, extraHeight + 2, 1, 0);
					int branchY = treeHeight - random.nextInt(4), r = random.nextInt(3);
					extraHeight = treeHeight - branchY;
					grow(level, random, pos.offset(0, branchY - 1, 0), log, 1, 0, .2F);
					growBranch(level, random, pos.offset(-1, branchY, -1), log, leaves, r > extraHeight ? 0 : extraHeight - r, extraHeight, extraHeight > 1, false);
					branchY = treeHeight - random.nextInt(4);
					r = random.nextInt(3);
					extraHeight = treeHeight - branchY;
					growBranch(level, random, pos.offset(1, branchY, 1), log, leaves, r > extraHeight ? 0 : extraHeight - r, extraHeight, extraHeight > 1, true);
				} else gradualGrowth(level, random, pos.mutable(), log, leaves, treeHeight, .25F, .1F, true);
				return true;
			}
		} return false;
	}
	private void growBranch(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState log, BlockState leaves, int height, int treeHeight, boolean shift, boolean direction) {
		if(height < 0) return;
		grow(level, pos, log, height, true);
		grow(level, pos.offset(0, height + 1, 0), leaves, treeHeight - height);
		grow(level, shift ? pos.offset(0, 1, 0) : pos, leaves, treeHeight - (shift ? 1 : 0), 1, 0);
		int r = random.nextInt(3), s = random.nextInt(3) - 1;
		if(treeHeight > r) growBranch(level, random, pos.offset(direction ? 1 : -1, r, direction ? 1 : -1), log, leaves, height - r + s, treeHeight - r + s, false, direction);
	}
	private void growLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves) {
		int type = random.nextInt(4);
		if(type == 3) type = random.nextInt(4);
		grow(level, pos, leaves, 1, 1);
		grow(level, pos, leaves, 2, 2);
		if(type > 0) {
			grow(level, pos, leaves, 2, 0);
			if(type > 1) {
				grow(level, pos, leaves, 3, 0);
				if(type == 3) {
					grow(level, pos, leaves, 4, 1);
					grow(level, pos, leaves, 4, -1);
					grow(level, pos.offset(0, 2, 0), leaves, 2, 2);
					grow(level, pos.offset(0, 3, 0), leaves, 3, 0);
				}
			}
		}
		grow(level, pos.offset(0, 2, 0), leaves, 2, 0);
		pos = pos.below();
		grow(level, pos, leaves, 2 + (type == 3 ? 2 : type));
		grow(level, pos, leaves, 2, 1, 0);
		grow(level, pos.below(), leaves, 2, 0);
		if(type == 3) {
			grow(level, pos, leaves, 2, 1, 1);
			grow(level, pos, leaves, 2, 2, 1);
			grow(level, pos, leaves, 2, 2, 0);
			grow(level, pos, leaves, 2, 2, -1);
			grow(level, pos.below(), leaves, 2, 2);
			grow(level, pos.offset(0, -2, 0), leaves, 3, 0);
		}
	}
}