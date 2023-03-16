package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class WildwoodTree extends DivineTree {
	public static BlockState westVines, eastVines, southVines, northVines;
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_dirt"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_grass")));
	}
	private void growLeavesWithVines(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState leaves, int maxY, int width, int offset, float leavesChance, float vineChance) {
		for(int minY = 0; minY <= maxY; minY++) {
			chanceSetBlock(world, random, pos.offset(width, minY, offset), leaves, leavesChance);
			if(!world.getBlockState(pos.offset(width, minY, offset)).isAir()) setBlockSensitive(world, random, pos.offset(width + 1, minY, offset), westVines, vineChance);
			chanceSetBlock(world, random, pos.offset(-width, minY, -offset), leaves, leavesChance);
			if(!world.getBlockState(pos.offset(-width, minY, -offset)).isAir()) setBlockSensitive(world, random, pos.offset(-width - 1, minY, -offset), eastVines, vineChance);
			chanceSetBlock(world, random, pos.offset(offset, minY, -width), leaves, leavesChance);
			if(!world.getBlockState(pos.offset(offset, minY, -width)).isAir()) setBlockSensitive(world, random, pos.offset(offset, minY, -width - 1), southVines, vineChance);
			chanceSetBlock(world, random, pos.offset(-offset, minY, width), leaves, leavesChance);
			if(!world.getBlockState(pos.offset(-offset, minY, width)).isAir()) setBlockSensitive(world, random, pos.offset(-offset, minY, width + 1), northVines, vineChance);
		}
	}
	protected void growVines(WorldGenLevel world, RandomSource random, BlockPos pos, int maxY, int width, int offset, float chance) {
    	for(int minY = 0; minY <= maxY; minY++) {
    		setBlockSensitive(world, random, pos.offset(width, minY, offset), westVines, chance);
    		setBlockSensitive(world, random, pos.offset(-width, minY, -offset), eastVines, chance);
    		setBlockSensitive(world, random, pos.offset(offset, minY, -width), southVines, chance);
    		setBlockSensitive(world, random, pos.offset(-offset, minY, width), northVines, chance);
    	}
    }
    private void growTheLeaves(WorldGenLevel world, RandomSource random,  BlockPos pos, BlockState leaves, int maxY, float vineChance) {
    	for(byte offset = -1; offset < 2; offset++) {
			grow(world, pos, leaves, maxY, 2, offset);
			growVines(world, random, pos, maxY, 3, offset, vineChance);
		}
    }
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			if(northVines == null) {
				northVines = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_vine")).defaultBlockState().setValue(VineBlock.NORTH, true);
				eastVines = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_vine")).defaultBlockState().setValue(VineBlock.EAST, true);
				southVines = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_vine")).defaultBlockState().setValue(VineBlock.SOUTH, true);
				westVines = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_vine")).defaultBlockState().setValue(VineBlock.WEST, true);
			}
			int treeHeight, extraHeight, treeType = random.nextInt(7);
    		switch(treeType) {
    		case 0:
    			//Swamp
    			treeHeight = 1 + random.nextInt(4);
    			extraHeight = treeHeight + 3;
    			break;
    		case 1:
    			//Shroomcap tree
    			treeHeight = 6 + random.nextInt(4);
    			extraHeight = treeHeight + 1;
    			break;
    		case 2:
    			//BranchTree
    			if(random.nextInt(32) == 0) {
    				treeHeight = 15;
    				extraHeight = 16;
    			} else {
    				treeHeight = 5 + random.nextInt(2);
        			extraHeight = treeHeight + 1;
    			}
    			break;
    		case 3:
    			//Big Jungle-Mangrove tree
    			treeHeight = 7 + random.nextInt(4);
    			extraHeight = treeHeight + 2;
    			break;
    		case 4:
    			//Small bush
    			treeHeight = 1 + random.nextInt(2);
    			extraHeight = treeHeight + 1;
    			break;
    		case 5:
    			//Mangrove
    			treeHeight = 2 + random.nextInt(6);
    			extraHeight = treeHeight + 1;
    			break;
    		default:
    			//Vanilla
    			treeHeight = 3 + random.nextInt(3);
            	extraHeight = treeHeight + 1;
    		}
    		if (heightCheck(level, pos, extraHeight, 1)) {
    			BlockState log = config.log, leaves = config.leaves;
    			BlockPos p;
    	        switch(treeType) {
    	        case 0:
    	        	//Roots
    	        	p = pos.offset(0, -2, 0);
    	        	grow(level, p, log, 1, 0, true);
    	        	for(int offset = -1; offset < 2; offset++) grow(level, pos.offset(0, -2, 0), log, 2, offset, true);
    	        	//Trunk
    	        	grow(level, p, log, treeHeight + 2, true);
    	        	grow(level, pos.offset(0, -1, 0), log, 2, 1, 0, true);
	        		grow(level, p, log, 2, 1, 1, true);
	        		//Leaves
	        		setBlock(level, pos.offset(0, extraHeight, 0), leaves);
	        		p = pos.offset(0, treeHeight, 0);
	        		grow(level, p, leaves, 2, 1, 0);
	        		for(int offset = -1; offset < 2; offset++) growLeavesWithVines(level, random, p, leaves, 0, 2, offset, 0.5F, 0.5F);
	        		p = p.above();
	        		grow(level, p, leaves, 1, 1, 1);
	        		growTheLeaves(level, random, p, leaves, 0, 0.5F);
	        		grow(level, random, pos, leaves, treeHeight, 1, 1, 0.5F);
	        		grow(level, random, pos, leaves, treeHeight + 1, 2, 2, 0.5F);
    	        	break;
    	        case 1:
    	        	p = pos.offset(0, -1, 0);
    	        	//Roots
    	        	grow(level, p, log, 3, 1, true);
    	        	grow(level, p, log, 3, -1, true);
    	        	grow(level, pos.offset(0, -2, 0), log, 1, 2, 2, true);
    	        	//Trunk
    	        	grow(level, pos.offset(0, -treeHeight/2, 0), log, treeHeight + treeHeight/2, true);
    	        	grow(level, pos.offset(0, -treeHeight/3, 0), log, 1 + treeHeight/3, 1, 0);
    	        	grow(level, pos.offset(0, -treeHeight/4, 0), log, treeHeight/4, 1, 1);
    	        	grow(level, p, log, 1, 2, 0, true);
    	        	growVines(level, random, pos, 0, 3, 0, 1);
    	        	growVines(level, random, pos, 0, 2, 1, 0.5F);
    	        	growVines(level, random, pos, 0, 2, -1, 0.5F);
    	        	//Leaves
    	        	int w = random.nextInt(2);
    	        	grow(level, pos.offset(0, treeHeight - 1, 0), log, 1, 0);
    	        	grow(level, pos.offset(0, treeHeight - 3, 0), log, 1, 0);
    	        	p = pos.offset(0, treeHeight - 4, 0);
    	        	grow(level, p, log, 2 + w, 1);
    	        	grow(level, p, log, 2 + w, -1);
    	        	growVines(level, random, p, 0, -1 - w, 1, 0.5F);
    	        	growVines(level, random, p, 0, -1 - w, -1, 0.5F);
    	        	p = p.below();
    	        	grow(level, p, log, 3 + w, 0);
    	        	grow(level, p, log, 3 + w, 2);
    	        	grow(level, p, log, 3 + w, -2);
    	        	growVines(level, random, p, 0, -2 - w, 0, 0.5F);
    	        	growVines(level, random, p, 0, -2 - w, 2, 0.5F);
    	        	growVines(level, random, p, 0, -2 - w, -2, 0.5F);
    	        	grow(level, p, leaves, 3 + w, 1);
    	        	grow(level, p, leaves, 3 + w, -1);
    	        	if(w == 1) {
    	        		grow(level, pos.offset(0, treeHeight - 3, 0), log, 2, 0);
    	        		grow(level, p, leaves, 4, 3);
    	        		grow(level, p, leaves, 4, -3);
    	        		p = p.above();
    	        		grow(level, p, leaves, 3, 2);
    	        		grow(level, p, leaves, 3, -2);
    	        		grow(level, p, leaves, 3, 3);
    	        		p = p.above();
    	        		grow(level, p, leaves, 2, 2);
    	        		grow(level, p, leaves, 2, 1);
    	        		grow(level, p, leaves, 2, -1);
    	        	} else grow(level, p.above(), leaves, 2, 2);
    	        	p = pos.offset(0, treeHeight - 5, 0);
	        		grow(level, p, leaves, 3, 3);
	        		growVines(level, random, p, 0, 4, 3 + w, 0.5F);
	        		grow(level, pos.offset(0, treeHeight - 3, 0), leaves, 2, 1, 1);
	        		p = pos.offset(0, treeHeight - 2, 0);
	        		grow(level, p, leaves, 1, 2, 0);
	        		setBlock(level, p, leaves);
	        		grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 0);
	        		setBlock(level, pos.offset(0, extraHeight, 0), leaves);
	        		p = pos.offset(0, treeHeight - 5, 0);
    	        	for(byte i = -2; i < 3; i++) {
    	        		grow(level, p, leaves, 4 + w, i);
    	        		growVines(level, random, p, 0, 5 + w, i, 0.5F);
    	        		grow(level, p.above(), leaves, 3 + w, i);
    	        		if(i > -2 && i < 2) grow(level, p.above().above(), leaves, 2 + w, i);
    	        	}
    	        	break;
    	        case 2:
    	        	int trunkY = treeHeight/3;
    	        	//Trunk
    	        	grow(level, pos, log, trunkY);
    	        	//Leaves
    	        	if(treeHeight == 15) {
    	        		p = pos.offset(0, trunkY + 1, 0);
    	        		grow(level, p, log, 1, 0);
    	        		grow(level, p.above(), log, 2, 1);
    	        		int offset = 1, width;
    	        		for(int y = trunkY + 3; y < treeHeight + 1; y++) {
    	        			offset++;
    	        			if(offset == 2) {
    	        				offset = -2;
    	        				width = 2;
    	        			} else width = 3;
    	        			grow(level, pos.offset(0, y, 0), log, width, offset);
    	        			grow(level, pos.offset(0, y + 1, 0), leaves, width, offset);
    	        			growLeavesWithVines(level, random, pos.offset(width, y, offset), leaves, 0, 1, 0, 1F, 0.5F);
    	        			growLeavesWithVines(level, random, pos.offset(-width, y, -offset), leaves, 0, 1, 0, 1F, 0.5F);
    	        			growLeavesWithVines(level, random, pos.offset(offset, y, -width),  leaves, 0, 1, 0, 1F, 0.5F);
    	        			growLeavesWithVines(level, random, pos.offset(-offset, y, width), leaves, 0, 1, 0, 1F, 0.5F);
    	        		}
    	        		grow(level, p, leaves, 1);
    	        		grow(level, p, leaves, 1, 1, 1);
    	        		grow(level, p, leaves, 1, 2, 0);
    	        		p = p.above();
    	        		grow(level, p, leaves, 1, 0);
    	        		grow(level, p, leaves, 3, 1);
    	        		grow(level, p, leaves, 2, 2);
    	        		grow(level, pos.offset(0, extraHeight, 0), leaves, 3, offset);
    	        	} else {
    	        		int length = treeHeight - trunkY;
	    	        	for(int i = random.nextInt(4) == 0 ? 0 : 1; i < 3; i++) {
	    	        		if(i == 2) treeHeight -= random.nextInt(3);
	    	        		double stepX = (double) ((-3D + random.nextDouble() * 7D)/length), stepZ = (double) ((-3D + random.nextDouble() * 7D)/length);
	        	        	double x = 0D, z = 0D;
	        	        	for(int y = 1; y < length + 1; y++) {
	        	        		x += stepX;
	        	        		z += stepZ;
	    	        			setBlock(level, pos.offset((int) x, trunkY + y, (int) z), log);
	        	        		grow(level, pos.offset((int) x, trunkY + y, (int) z), leaves, 1, 0);
	        	        		growLeavesWithVines(level, random, pos.offset((int) x, trunkY + y, (int) z), leaves, 0, 1, 1, 0.5F, 0.3F);
	        	        		if(y > 1 && trunkY + y < treeHeight) growLeavesWithVines(level, random, pos.offset((int) x, trunkY + y, (int) z), leaves, 0, 2, 0, 0.3F, 0.5F);
	        	        	}
	        	        	setBlock(level, pos.offset((int) x, extraHeight, (int) z), leaves);
	    	        	}
    	        	}
    	        	break;
    	        case 3:
    	        	//Trunk
    	        	int destX = -3 + random.nextInt(7), destZ = -3 + random.nextInt(7);
    	        	double stepX = (double) destX / (treeHeight + 1), stepZ = (double) destZ / (treeHeight + 1),
    	        	x = 0, z = 0;
    	        	for(int y = 1; y < treeHeight + 1; y++) {
    	        		long pX = Math.round(x), pZ = Math.round(z);
    	        		setBlock(level, pos.offset((int) pX, y, (int) pZ), log);
    	        		grow(level, pos.offset((int) pX, y, (int) pZ), log, 1, 0);
    	        		growVines(level, random, pos.offset((int) pX, y, (int) pZ), 0, 2, 0, 0.3F);
    	        		x += stepX;
    	        		z += stepZ;
    	        	}
    	        	grow(level, pos.offset(0, 2, 0), log, 1, 0);
    	        	grow(level, pos.offset(0, -1, 0), log, 1, true);
    	        	grow(level, pos.offset(0, 1, 0), log, 1, 1, 1);
    	        	grow(level, pos.offset(0, -2, 0), log, 3, 2, 0, true);
    	        	grow(level, pos.offset(0, -2, 0), log, 2, 2, 2, true);
    	        	//Leaves
    	        	p = pos.offset(destX, treeHeight, destZ);
    	        	setBlock(level, p, log);
    	        	setBlock(level, p.offset(0, 1, 0), leaves);
    	        	grow(level, p, leaves, 1, 1, 0);
    	        	grow(level, p, log, 1, 1);
    	        	grow(level, p.above(), leaves, 1, 1);
    	        	for(int i = -2; i < 2; i++) {
    	        		if(Math.abs(i) == 1) {
    	        			grow(level, p, log, 2, i);
    	        			grow(level, p.above(), leaves, 2, i);
    	        		} else grow(level, p, leaves, 1, 2, i);
    	        		growLeavesWithVines(level, random, p, leaves, 0, 3, i, 1F, 0.5F);
    	        		growLeavesWithVines(level, random, p.below(), leaves, 0, 3, i, 0.3F, 1F);
    	        	}
    	        	growLeavesWithVines(level, random, p, leaves, 0, 3, 2, 1F, 0.5F);
    	        	grow(level, p.offset(0, 2, 0), leaves, 1, 0);
    	        	setBlock(level, p.offset(0, 2, 0), leaves);
    	        	break;
    	        case 4:
    	        	grow(level, pos, log, treeHeight, true);
    	        	grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 0);
    	        	setBlock(level, pos.offset(0, extraHeight, 0), leaves);
    	        	break;
    	        case 5:
	        		//Roots
    	        	grow(level, pos.offset(0, -3, 0), log, treeHeight - 2, 2, 0, true);
    	        	grow(level, pos.offset(0, -2, 0), log, 1, 1, 1, true);
    	        	grow(level, pos.offset(0, treeHeight - 4, 0), log, 1, 1, 0, true);
    	        	growVines(level, random, pos.offset(0, treeHeight - 4, 0), 1, 1, 1, 0.5F);
    	        	pos = pos.offset(0, treeHeight - 4, 0);
    	        	//Fall-Through
    	        default:
    	        	grow(level, pos, log, treeHeight);
    	        	setBlock(level, pos.offset(0, extraHeight, 0), leaves);
                	grow(level, pos.offset(0, treeHeight - 2, 0), leaves, extraHeight + 2 - treeHeight, 1, 0);
                	grow(level, pos.offset(0, treeHeight - 2, 0), leaves, 1, 1, 1);
                	grow(level, random, pos.offset(0, treeHeight - 2, 0), leaves, 1, 2, 2, 0.5F);
                	growTheLeaves(level, random, pos.offset(0, treeHeight - 2, 0), leaves, 1, 0.25F);
                	grow(level, random, pos.offset(0, treeHeight, 0), leaves, 1, 1, 0.5F);
                	for(int offset = -1; offset < 2; offset++) growLeavesWithVines(level, random, pos.offset(0, treeHeight - 3, 0), leaves, 0, 2, offset, 0.3F, 1F);
    	        }
    	        return true;
    		}
		}
		return false;
	}
}