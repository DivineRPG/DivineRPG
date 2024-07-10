package divinerpg.world.feature.tree;

import java.util.ArrayList;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.phys.Vec3;

public class FractalTree extends DivineTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(BlockTags.SNOW) || state.is(BlockTags.ICE) || state.is(BlockRegistry.frozenGrass.get()) || state.is(BlockRegistry.frozenDirt.get());
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			if(level.getBlockState(pos.below()).is(BlockTags.SNOW)) pos = pos.below();
			boolean treeType = random.nextBoolean() ? true : random.nextBoolean();
			int treeHeight = (treeType ? 4 : 6) + random.nextInt(5);
			if(heightCheck(level, pos, treeHeight, 1)) {
				BlockState packed_ice = config.log;
				grow(level, pos, packed_ice, treeHeight, true);
				MutableBlockPos position = pos.mutable();
				if(treeType) {
					int shift = random.nextInt(2);
					boolean rotation = random.nextBoolean(), longBranches = random.nextBoolean();
					for(int y = 0; y < treeHeight; y++) {
						if(y % 2 == shift) {
							boolean turned = random.nextBoolean();
							BlockState state = getState(config, turned);
							if(rotation) {
								setBlock(level, position.north(), state, false);
								setBlock(level, position.south(), state, false);
								if(!turned) state = getState(config, turned = random.nextBoolean());
								setBlock(level, position.north(2).above(), state, false);
								setBlock(level, position.south(2).above(), state, false);
								if(!turned) state = getState(config, turned = random.nextBoolean());
								setBlock(level, position.north(3).above(2), state, false);
								setBlock(level, position.south(3).above(2), state, false);
								if(longBranches) {
									if(!turned) state = getState(config, turned = random.nextBoolean());
									setBlock(level, position.north(4).above(3), state, false);
									setBlock(level, position.south(4).above(3), state, false);
								}
							} else {
								setBlock(level, position.east(), state, false);
								setBlock(level, position.west(), state, false);
								if(!turned) state = getState(config, turned = random.nextBoolean());
								setBlock(level, position.east(2).above(), state, false);
								setBlock(level, position.west(2).above(), state, false);
								if(!turned) state = getState(config, turned = random.nextBoolean());
								setBlock(level, position.east(3).above(2), state, false);
								setBlock(level, position.west(3).above(2), state, false);
								if(longBranches) {
									if(!turned) state = getState(config, turned = random.nextBoolean());
									setBlock(level, position.east(4).above(3), state, false);
									setBlock(level, position.west(4).above(3), state, false);
								}
							} rotation = !rotation;
						} position.move(0, 1, 0);
					}
				} else if(random.nextBoolean()) {
					int shift = random.nextInt(2);
					boolean rotation = random.nextBoolean();
					for(int y = 0; y < treeHeight; y++) {
						if(y % 2 == shift) {
							BlockState state = getState(config, random.nextBoolean());
							if(rotation) {
								setBlock(level, position.north(), state, false);
								setBlock(level, position.south(), state, false);
							} else {
								setBlock(level, position.east(), state, false);
								setBlock(level, position.west(), state, false);
							} rotation = !rotation;
						} position.move(0, 1, 0);
					}
				} else {
					position.move(0, treeHeight, 0);
					for(int i = 0; i < 3; i++) {
						position.move(0, -2, 0);
						for(BlockPos p : fullSnowflake(position, treeHeight / (i + 0.9D), 2)) setBlock(level, p, getState(config, random.nextBoolean()), false);
						grow(level, position, getState(config, random.nextBoolean()), 1, 1);
						if(i < 2) {
							grow(level, position, getState(config,random.nextBoolean()),2,2);
							if(i == 0) grow(level, position, getState(config, random.nextBoolean()), 3, 3);
						}
					}
				} return true;
			}
		} return false;
	}
	protected BlockState getState(TreeConfig config, boolean b) {
		return b ? config.leaves : config.log;
	}
	protected Vec3 pos = null, left = null, right = null, upright = null, downright = null, downleft = null, upleft = null, current = null;
	protected ArrayList<BlockPos> fullSnowflake(BlockPos center, double size, int detail) {
		pos = center.getCenter().add(-size / 1.55, 0D, -size / 3D);
		left = new Vec3(-1D, 0D, 0D);
		right = new Vec3(1D, 0D, 0D);
		upright = new Vec3(.5D, 0D, Math.sqrt(3D) / 2D);
		downright = new Vec3(.5D, 0D, -Math.sqrt(3D) / 2D);
		downleft = new Vec3(-.5D, 0D, -Math.sqrt(3D) / 2D);
		upleft = new Vec3(-.5D, 0D, Math.sqrt(3D) / 2D);
		current = upright;
		ArrayList<BlockPos> result = new ArrayList<>();
		snowflake(result, size, detail);
		turnRight();
		snowflake(result, size, detail);
		turnRight();
		snowflake(result, size, detail);
		return result;
	}
	protected void snowflake(ArrayList<BlockPos> map, double sideLength, int level) {
		if(level == 0) {
			Vec3 movement = current.multiply(sideLength, 0D, sideLength);
			BlockPos position;
			if(movement.x >= 1D || movement.z >= 1D) {
				int steps = (int)(movement.x > movement.z ? movement.x * 2D : movement.z * 2D);
				Vec3 step = new Vec3(movement.x / steps, 0D, movement.z / steps);
				for(int i = 0; i < steps; i++) {
					position = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
					if(!map.contains(position)) map.add(position);
					pos = pos.add(step);
				}
				position = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
				if(!map.contains(position)) map.add(position);
			} else {
				position = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
				if(!map.contains(position)) map.add(position);
				pos = pos.add(movement);
				position = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
				if(!map.contains(position)) map.add(position);
			}
		} else {
			sideLength /= 3D;
			level--;
			snowflake(map, sideLength, level);
			turnLeft();
			snowflake(map, sideLength, level);
			turnRight();
			snowflake(map, sideLength, level);
			turnLeft();
			snowflake(map, sideLength, level);
		}
	}
	protected void turnLeft() {
		current = current.equals(right) ? upright
				: current.equals(upright) ? upleft
				: current.equals(upleft) ? left
				: current.equals(left) ? downleft
				: current.equals(downleft) ? downright
				: right;
	}
	protected void turnRight() {
		current = current.equals(right) ? downleft
				: current.equals(downleft) ? upleft
				: current.equals(upleft) ? right
				: current.equals(left) ? upright
				: current.equals(upright) ? downright
				: left;
	}
}