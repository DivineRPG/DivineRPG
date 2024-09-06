package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class SkythernTree extends DivineTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_dirt"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_grass")));
	}
	protected void wideGrow(WorldGenLevel world, BlockPos pos, BlockState state, int width, int offset) {
		wideGrow(world, pos, state, width, offset, false);
	}
	protected void wideGrow(WorldGenLevel world, BlockPos pos, BlockState state, int width, int offset, boolean replace) {
    	setBlock(world, pos.offset(width + 1, 0, offset), state, replace);
		setBlock(world, pos.offset(-width, 0, 1 - offset), state, replace);
		setBlock(world, pos.offset(offset, 0, -width), state, replace);
		setBlock(world, pos.offset(1 - offset, 0, width + 1), state, replace);
    }
	protected void wideGrow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY, int width, int offset) {
		wideGrow(world, pos, state, maxY, width, offset, false);
	}
	protected void wideGrow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY, int width, int offset, boolean replace) {
    	for(int minY = 0; minY <= maxY; minY++) {
    		setBlock(world, pos.offset(width + 1, minY, offset), state, replace);
    		setBlock(world, pos.offset(-width, minY, 1 - offset), state, replace);
    		setBlock(world, pos.offset(offset, minY, -width), state, replace);
    		setBlock(world, pos.offset(1 - offset, minY, width + 1), state, replace);
    	}
    }
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight, extraHeight, treeType = random.nextInt(10), width = 1;
    		switch(treeType) {
    		case 0:
    			//Spike
    			treeHeight = 2 + random.nextInt(12);
    			extraHeight = treeHeight + 2;
    			break;
    		case 1: case 2:
    			//Stacking1, Stacking2
    			treeHeight = 3 + random.nextInt(6);
    			extraHeight = treeHeight + 3;
    			break;
    		case 3: case 4:
    			//Popsickle1, Popsickle2
    			treeHeight = 4 + random.nextInt(9);
    			extraHeight = treeHeight + 2;
    			break;
    		case 5: case 6: case 7:
    			//Tall1, Tall2, Tall3
    			width = 2;
    			treeHeight = 15 + random.nextInt(20);
    			extraHeight = treeHeight + 2;
    			break;
    		case 8:
    			//1.12.2
    			treeHeight = 13 + random.nextInt(8);
    			extraHeight = treeHeight + 1;
    			break;
    		default: return super.place(config, level, chunkGen, random, pos);
    		}
    		if(heightCheck(level, pos, treeHeight, width)) {
    			BlockState log = config.log, leaves = config.leaves;
    			BlockPos temp;
    			int tempInt = extraHeight - 1 - treeHeight;
    			//Main trunk
    			grow(level, pos, log, treeHeight);
    			grow(level, pos.offset(0, treeHeight + 1, 0), leaves, tempInt);
    			if(width == 2) {
    				MutableBlockPos mut = pos.offset(1, 0, 0).mutable();
    				for(int n = 0; n < 4 && hasSpace(level.getBlockState(mut.move(0, -1, 0))); n++) setBlock(level, mut, log, true);
    				grow(level, pos.offset(1, 0, 0), log, treeHeight);
    				grow(level, pos.offset(1, treeHeight + 1, 0), leaves, tempInt);
    				mut = pos.offset(0, 0, 1).mutable();
    				for(int n = 0; n < 4 && hasSpace(level.getBlockState(mut.move(0, -1, 0))); n++) setBlock(level, mut, log, true);
    				grow(level, pos.offset(0, 0, 1), log, treeHeight);
    				grow(level, pos.offset(0, treeHeight + 1, 1), leaves, tempInt);
    				mut = pos.offset(1, 0, 1).mutable();
    				for(int n = 0; n < 4 && hasSpace(level.getBlockState(mut.move(0, -1, 0))); n++) setBlock(level, mut, log, true);
    				grow(level, pos.offset(1, 0, 1), log, treeHeight);
    				grow(level, pos.offset(1, treeHeight + 1, 1), leaves, tempInt);
    			}
    			switch(treeType) {
    			case 0:
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 2, 1, 0);
    				break;
    			case 1: case 2:
    				int bottomHeight = random.nextInt(2), wideHeight = 2 - bottomHeight + random.nextInt(2);
    				boolean shift = random.nextBoolean(), even = treeHeight % 2 == bottomHeight ^ shift;
    				for(int y = 2 - bottomHeight; y <= treeHeight; y++) {
    					if(y == wideHeight && treeType == 2 && wideHeight != extraHeight - 3) {
    						temp = pos.offset(0, y, 0);
    						grow(level, temp, leaves, 1, 1);
    						grow(level, temp, leaves, 2, -1);
    						grow(level, temp, leaves, 2, 0);
    						grow(level, temp, leaves, 2, 1);
    						grow(level, temp, leaves, 2, 2);
    						for(int offset = -2; offset < 3; offset++) grow(level, temp, leaves, 3, offset);
    						if(y % 2 == bottomHeight ^ shift) shift = !shift;
    					} else if(y % 2 == bottomHeight ^ shift) {
    						temp = pos.offset(0, y, 0);
    						grow(level, temp, leaves, 1, 1);
    						grow(level, temp, leaves, 2, -1);
    						grow(level, temp, leaves, 2, 0);
    						grow(level, temp, leaves, 2, 1);
    					}
    				}
    				grow(level, pos.offset(0, treeHeight, 0), log, random.nextInt(even ? 2 : 3));
    				grow(level, pos.offset(0,  2 - bottomHeight, 0), leaves, treeHeight - (even ? 1 : 2) + bottomHeight, 1, 0);
    				grow(level, pos.offset(0, extraHeight - (even ? 0 : 1), 0), leaves, 1, 0);
    				break;
    			case 3:
    				width += random.nextInt(2);
    				grow(level, pos.offset(0, treeHeight - width, 0), leaves, width + 1, 1, 0);
    				grow(level, pos.offset(0, treeHeight - width + 1, 0), leaves, width - 1, 1, 1);
    				for(int offset = -1; offset < 2; offset++) grow(level, pos.offset(0, treeHeight - width + 1, 0), leaves, width - 1, 2, offset);
    				break;
    			case 4:
    				grow(level, pos.offset(0, treeHeight - 2, 0), leaves, 3, 1, 0);
    				grow(level, pos.offset(0, treeHeight - 2, 0), leaves, 2, 1, 1);
    				for(width = -2; width < 3; width++) {
    					if(Math.abs(width) < 2) grow(level, pos.offset(0, treeHeight - 2, 0), leaves, 2, 2, width);
    					grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 3, width);
    				}
    				grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 2, 2);
    				break;
    			case 5:
    				width = treeHeight - 3 - random.nextInt(3);
    				temp = pos.offset(0, width, 0);
    				tempInt = treeHeight - width;
    				wideGrow(level, temp, leaves, tempInt, 1, 0);
    				wideGrow(level, temp, leaves, tempInt, 1, 1);
    				extraHeight = treeHeight - 2 - width;
    				wideGrow(level, temp, leaves, extraHeight, 1, -1);
    				wideGrow(level, temp, leaves, extraHeight, 2, 0);
    				wideGrow(level, temp, leaves, extraHeight, 2, 1);
    				extraHeight -= 2;
    				wideGrow(level, temp, leaves, extraHeight, 2, -1);
    				wideGrow(level, temp, leaves, extraHeight, 2, 2);
    				wideGrow(level, temp, leaves, extraHeight, 3, 0);
    				wideGrow(level, temp, leaves, extraHeight, 3, 1);
    				break;
    			case 6:
    				width = treeHeight - 15;
    				temp = pos.offset(0, treeHeight, 0);
    				wideGrow(level, temp, leaves, 1, 0);
    				wideGrow(level, temp, leaves, 1, 1);
    				extraHeight = treeHeight - 3;
    				tempInt = extraHeight - width;
    				temp = pos.offset(0, width, 0);
    				wideGrow(level, temp, leaves, tempInt, 1, 0);
    				wideGrow(level, temp, leaves, tempInt, 1, 1);
    				extraHeight--;
    				while(extraHeight > treeHeight - 8) {
    					temp = pos.offset(0, extraHeight, 0);
    					wideGrow(level, temp, leaves, 1, -1);
        				wideGrow(level, temp, leaves, 2, 0);
        				wideGrow(level, temp, leaves, 2, 1);
        				extraHeight -= 2;
    				}
    				temp = pos.offset(0, width, 0);
    				wideGrow(level, temp, leaves, extraHeight - width, 1, -1);
    				wideGrow(level, temp, leaves, extraHeight - width, 2, 0);
    				wideGrow(level, temp, leaves, extraHeight - width, 2, 1);
    				while(extraHeight > treeHeight - 11) {
    					temp = pos.offset(0, extraHeight, 0);
    					wideGrow(level, temp, leaves, 2, -2);
        				wideGrow(level, temp, leaves, 2, -1);
        				wideGrow(level, temp, leaves, 2, 2);
        				wideGrow(level, temp, leaves, 2, 3);
        				wideGrow(level, temp, leaves, 3, 0);
        				wideGrow(level, temp, leaves, 3, 1);
        				extraHeight -= 2;
    				}
    				extraHeight = width + 2;
    				temp = pos.offset(0, width, 0);
    				wideGrow(level, temp, leaves, 2, 2, -2);
    				wideGrow(level, temp, leaves, 2, 2, -1);
    				wideGrow(level, temp, leaves, 2, 2, 2);
    				wideGrow(level, temp, leaves, 2, 2, 3);
    				wideGrow(level, temp, leaves, 2, 3, 0);
    				wideGrow(level, temp, leaves, 2, 3, 1);
    				temp = temp.above();
    				wideGrow(level, temp, leaves, 3, -2);
    				wideGrow(level, temp, leaves, 3, -1);
    				wideGrow(level, temp, leaves, 3, 2);
    				wideGrow(level, temp, leaves, 3, 3);
    				wideGrow(level, temp, leaves, 4, 0);
    				wideGrow(level, temp, leaves, 4, 1);
    				break;
    			case 7:
    				temp = pos.offset(0, treeHeight - 2, 0);
    				wideGrow(level, temp, leaves, 2, 1, 0);
    				wideGrow(level, temp, leaves, 2, 1, 1);
    				wideGrow(level, temp, leaves, 2, 1, -1);
    				wideGrow(level, temp, leaves, 2, 2, 0);
    				wideGrow(level, temp, leaves, 2, 2, 1);
    				wideGrow(level, temp, leaves, 2, 2);
    				wideGrow(level, temp, leaves, 2, -1);
    				wideGrow(level, temp, leaves, 2, -2);
    				wideGrow(level, temp, leaves, 3, 0);
    				wideGrow(level, temp, leaves, 3, 1);
    				break;
    			case 8:
    				grow(level, pos.offset(0, treeHeight - 10, 0), log, 1, 1, 0);
    				grow(level, pos.offset(0, treeHeight - 8, 0), leaves, 1, 1, 0);
    				grow(level, pos.offset(0, treeHeight - 6, 0), log, 1, 1, 0);
    				grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 0);
    				temp = pos.offset(0, treeHeight - 4, 0);
    				grow(level, temp, leaves, 2, 1, 0);
    				grow(level, temp, log, 2, 0);
    				grow(level, temp, leaves, 2, 1);
    				grow(level, temp, leaves, 2, -1);
    				grow(level, temp, leaves, 3, 0);
    				temp = pos.offset(0, treeHeight - 8, 0);
    				grow(level, temp, log, 2, 0);
    				grow(level, temp, log, 1, 1);
    				temp = temp.above();
    				grow(level, temp, leaves, 4, 1, 1);
    				grow(level, temp, leaves, 4, 2, 0);
    				grow(level, temp, leaves, 1, 2, 1);
    				grow(level, temp, leaves, 1, 2, -1);
    				grow(level, temp, log, 2, 2);
    				grow(level, temp, log, 3, 0);
    				grow(level, temp, log, 3, 3);
    				grow(level, temp, leaves, 3, -2);
    				grow(level, temp, leaves, 3, -1);
    				grow(level, temp, leaves, 3, 1);
    				grow(level, temp, leaves, 3, 2);
    				grow(level, temp, log, 4, 0);
    				grow(level, temp, leaves, 4, -3);
    				grow(level, temp, leaves, 4, -1);
    				grow(level, temp, leaves, 4, 1);
    				grow(level, temp, leaves, 4, 3);
    				grow(level, temp, leaves, 5, 0);
    				temp = temp.above();
    				grow(level, temp, leaves, 4, 0);
    				grow(level, temp, leaves, 3, 3);
    				grow(level, temp, leaves, 3, 0);
    				grow(level, temp, leaves, 2, 2);
    				break;
    			}
    			return true;
    		}
		}
		return false;
	}
}
