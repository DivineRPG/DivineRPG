package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.ForgeRegistries;

public class ApalachiaTree extends DivineTree {
	public static NormalNoise vegetation;
	public static long seed;
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_dirt"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_grass")));
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			long newSeed = level.getSeed();
			if(seed != newSeed) {
				vegetation = NormalNoise.create(new XoroshiroRandomSource(newSeed), -2, 1.25);
				seed = newSeed;
			}
			int treeHeight = random.nextInt(10) + (int)(vegetation.getValue(pos.getX(), pos.getY(), pos.getZ()) * 8), extraHeight, treeType = random.nextInt(13);
			if(treeHeight<0){
				treeHeight = 1;
			}
    		switch(treeType) {
    		case 0: case 1:
    			//Javelin
    			extraHeight = treeHeight + 3;
    			break;
    		case 2: case 3: case 4: case 5:
    			//Spike & BigBall
    			extraHeight = treeHeight + 2;
    			break;
    		case 6: case 7: case 8: case 9: case 10: case 11:
    			//Minimalist & Ball & FlatBall
    			extraHeight = treeHeight + 1;
    			break;
    		default:
    			if(random.nextBoolean()) return super.place(config, level, chunkGen, random, pos);
    			//Cozy
    			treeHeight = 3 + random.nextInt(3);
    			extraHeight = treeHeight + 4;
    		}
    		if(heightCheck(level, pos, extraHeight, 1)) {
    			BlockState log = config.log, leaves = config.leaves;
    			if(treeType != 12) grow(level, pos, log, treeHeight);
    			switch(treeType) {
    			case 0:
    				grow(level, random, pos.offset(0, treeHeight - 1, 0), leaves, 2, 0, 0.5F);
    				//Fall-Through
    			case 1:
    				grow(level, pos.offset(0, treeHeight - 2, 0), leaves, 3, 1, 0);
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 1, 1, 1);
    				grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
    				break;
    			case 2:
    				grow(level, random, pos.offset(0, treeHeight - 1, 0), leaves, 1, 1, 0.5F);
    				//Fall-Through
    			case 3:
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 1, 1, 0);
    				grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
    				break;
    			case 4: case 5:
    				grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
    				grow(level, pos.offset(0, treeHeight - 2, 0), leaves, extraHeight + 2 - treeHeight, 1, 0);
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 2, 1, 1);
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 2, 2, 0);
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 2, 1);
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 2, -1);
    				break;
    			case 6: case 7:
    				setBlock(level, pos.offset(0, extraHeight, 0), leaves);
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 0);
    				break;
    			case 8: case 9: case 10: case 11:
    				setBlock(level, pos.offset(0, extraHeight, 0), leaves);
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, extraHeight + 1 - treeHeight, 1, 0);
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 1);
    				if(treeType == 8 || treeType == 9) break;
    				for(int offset = -1; offset < 2; offset++) grow(level, pos.offset(0, treeHeight, 0), leaves, 2, offset);
    				break;
    			default:
    				//Roots
    				BlockPos temp = pos.offset(0, -2, 0);
    				grow(level, temp, log, 1, true);
    				grow(level, temp, log, 1, 1, 0, true);
    				temp = temp.above();
    				grow(level, temp, log,  1, 1, true);
    				grow(level, temp, log, 1, 2, 0, true);
    				grow(level, temp, log, 2, 2, -1, true);
    				grow(level, temp, log, 2, 2, 1, true);
    				grow(level, temp, log, 2, 2, true);
    				grow(level, temp, log, 3, 0, true);
    				//Trunk
    				temp = pos.above();
    				grow(level, temp, leaves, 2, 0);//Yes, that is intended
    				grow(level, temp.above(), log, 2, 0);
    				grow(level, temp, log, 2, 1, 1);
    				grow(level, temp.above(), log, treeHeight - 2, 1, 0);
    				//Leaves
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 1, 1);
    				grow(level, pos.offset(0, extraHeight - 1, 0), log, 1, 1);//Holds the leaves
    				setBlock(level, pos.offset(0, extraHeight, 0), leaves);
    				grow(level, pos.offset(0, extraHeight, 0), leaves, 1, 0);
    				grow(level, pos.offset(0, extraHeight, 0), leaves, 1, 1);
    				for(int offset = -1; offset < 2; offset++) grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 2 - treeHeight, 2, offset);
    			}
    			return true;
    		}
		}
		return false;
	}
}