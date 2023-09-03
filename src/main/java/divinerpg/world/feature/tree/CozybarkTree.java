package divinerpg.world.feature.tree;

import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class CozybarkTree extends ShiverspineTree {
	protected void flatCanopy(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves, int size) {
		int posX = pos.getX(), posZ = pos.getZ(), y = pos.getY();
		for(int x = posX - size; x <= posX + size; x++) for(int z = posZ - size; z <= posZ + size; z++) {
			setBlockSensitive(level, random, pos = new BlockPos(x, y, z), leaves, size - (float) Math.sqrt(Math.pow(posX - x, 2) + Math.pow(posZ - z, 2)));
			if(level.getBlockState(pos).is(leaves.getBlock()) && random.nextFloat() <= .2F) {
				setBlockSensitive(level, random, new BlockPos(x, y - 1, z), leaves, 1F);
				setBlockSensitive(level, random, new BlockPos(x, y - 2, z), leaves, .5F);
			}
		}
	}
	protected void branch(WorldGenLevel level, RandomSource random, MutableBlockPos pos, BlockState log, BlockState leaves, int directionX, int directionZ, int maxY) {
		int distance = 0;
		boolean hasLeaves = false;
		do {
			setBlock(level, pos, log, true);
			if(distance > 2 && hasLeaves) flatCanopy(level, random, pos, leaves, 3);
			else hasLeaves = random.nextBoolean();
			pos.move(random.nextInt(2) - directionX, random.nextInt(2), random.nextInt(2) - directionZ);
			distance++;
		} while(random.nextFloat() <= .7F && distance < 7 && pos.getY() < maxY);
		setBlock(level, pos, log, true);
		flatCanopy(level, random, pos, leaves, 3);
		flatCanopy(level, random, pos.above(), leaves, 2);
	}
	protected void root(WorldGenLevel level, RandomSource random, MutableBlockPos pos, BlockState log, int directionX, int directionZ) {
		if(random.nextFloat() <= .3F) setBlock(level, pos.above(), log);
		int distance = 0;
		do {
			setBlock(level, pos, log, true);
			pos.move(random.nextInt(2) - directionX, random.nextInt(2) - 1, random.nextInt(2) - directionZ);
			distance++;
		} while(distance < 6 && random.nextFloat() <= .8F);
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeType = random.nextInt(3) == 0 ? random.nextInt(3) : random.nextInt(2) + 1, treeHeight = switch(treeType) {
			case 2 -> 13 + random.nextInt(4);
			case 1 -> 9 + random.nextInt(6);
			default -> 5 + random.nextInt(5);
			}, extraHeight = treeHeight + 1;
			if(heightCheck(level, pos, treeHeight, treeType + 1)) {
				BlockState log = config.log, leaves = config.leaves;
				switch(treeType) {
				case 2:
					grow(level, pos.below(), log, extraHeight, true);
					grow(level, pos.offset(-1, -1, -1), log, extraHeight, true);
					grow(level, pos.offset(0, -1, -1), log, extraHeight, true);
					grow(level, pos.offset(1, -1, -1), log, extraHeight, true);
					grow(level, pos.offset(-1, -1, 0), log, extraHeight, true);
					grow(level, pos.offset(1, -1, 0), log, extraHeight, true);
					grow(level, pos.offset(-1, -1, 1), log, extraHeight, true);
					grow(level, pos.offset(0, -1, 1), log, extraHeight, true);
					grow(level, pos.offset(1, -1, 1), log, extraHeight, true);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY(), pos.getZ() - 1), log, 1, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY(), pos.getZ()), log, 1, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY(), pos.getZ() + 1), log, 1, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ() - 1), log, 0, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ()), log, 0, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ() + 1), log, 0, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 2), log, random.nextInt(2), 1);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() - 2), log, random.nextInt(2), 1);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 2), log, random.nextInt(2), 1);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
					treeType = treeHeight;
					for(treeHeight = extraHeight - 6 - random.nextInt(5); treeHeight < extraHeight; treeHeight++) {
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY() + treeHeight, pos.getZ() - 1), log, leaves, 1, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY() + treeHeight, pos.getZ()), log, leaves, 1, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() - 2, pos.getY() + treeHeight, pos.getZ() + 1), log, leaves, 1, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY() + treeHeight, pos.getZ() - 1), log, leaves, 0, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY() + treeHeight, pos.getZ()), log, leaves, 0, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY() + treeHeight, pos.getZ() + 1), log, leaves, 0, random.nextInt(2), treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY() + treeHeight, pos.getZ() - 2), log, leaves, random.nextInt(2), 1, treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX(), pos.getY() + treeHeight, pos.getZ() - 2), log, leaves, random.nextInt(2), 1, treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY() + treeHeight, pos.getZ() - 2), log, leaves, random.nextInt(2), 1, treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY() + treeHeight, pos.getZ() + 2), log, leaves, random.nextInt(2), 0, treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX(), pos.getY() + treeHeight, pos.getZ() + 2), log, leaves, random.nextInt(2), 0, treeType);
						if(random.nextFloat() <= .17F)branch(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY() + treeHeight, pos.getZ() + 2), log, leaves, random.nextInt(2), 0, treeType);
					}
					BlockPos origin = pos.mutable();
					for(treeHeight = -1; treeHeight < 2; treeHeight++) for(treeType = -1; treeType < 2; treeType++) {
						flatCanopy(level, random, pos = origin.offset(treeHeight, extraHeight, treeType), leaves, 3);
						flatCanopy(level, random, pos = pos.below(), leaves, 4);
						flatCanopy(level, random, pos = pos.below(), leaves, 5);
						flatCanopy(level, random, pos = pos.below(), leaves, 6);
						flatCanopy(level, random, pos = pos.below(), leaves, 7);
						flatCanopy(level, random, pos.below(), leaves, 7);
					}
					break;
				case 1:
					wideGrow(level, pos, log, treeHeight, 0, 0, true);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), log, 1, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1), log, 1, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), log, random.nextInt(2), 1);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1), log, random.nextInt(2), 1);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ()), log, 0, random.nextInt(2));
					if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ() + 1), log, 0, random.nextInt(2));
					for(treeType = extraHeight - 5 - random.nextInt(5); treeType < extraHeight; treeType++) {
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY() + treeType, pos.getZ()), log, leaves, 1, random.nextInt(2), treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY() + treeType, pos.getZ() + 1), log, leaves, 1, random.nextInt(2), treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX(), pos.getY() + treeType, pos.getZ() - 1), log, leaves, random.nextInt(2), 1, treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY() + treeType, pos.getZ() - 1), log, leaves, random.nextInt(2), 1, treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX(), pos.getY() + treeType, pos.getZ() + 2), log, leaves, random.nextInt(2), 0, treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY() + treeType, pos.getZ() + 2), log, leaves, random.nextInt(2), 0, treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY() + treeType, pos.getZ()), log, leaves, 0, random.nextInt(2), treeHeight);
						if(random.nextFloat() <= .25F)branch(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY() + treeType, pos.getZ() + 1), log, leaves, 0, random.nextInt(2), treeHeight);
					}
					flatCanopy(level, random, pos = pos.offset(0, extraHeight, 0), leaves, 3);
					flatCanopy(level, random, pos = pos.below(), leaves, 4);
					flatCanopy(level, random, pos = pos.below(), leaves, 5);
					flatCanopy(level, random, pos = pos.below(), leaves, 6);
					flatCanopy(level, random, pos.below(), leaves, 6);
					break;
				default:
					grow(level, pos, log, treeHeight, true);
					flatCanopy(level, random, pos = pos.offset(0, extraHeight, 0), leaves, 2);
					flatCanopy(level, random, pos = pos.below(), leaves, 3);
					flatCanopy(level, random, pos = pos.below(), leaves, 4);
					flatCanopy(level, random, pos = pos.below(), leaves, 5);
					for(treeHeight = -1; treeHeight < 2; treeHeight++) for(extraHeight = -1; extraHeight < 2; extraHeight++) if(random.nextFloat() <= .4F) {
						MutableBlockPos m = new MutableBlockPos(pos.getX() + treeHeight, pos.getY(), pos.getZ() + extraHeight);
						setBlock(level, m, log, true);
						flatCanopy(level, random, m, leaves, 3);
					}
					break;
				}
				return true;
			}
		} return false;
	}
}