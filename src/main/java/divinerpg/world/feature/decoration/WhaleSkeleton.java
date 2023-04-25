package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class WhaleSkeleton extends Feature<NoneFeatureConfiguration> {
	public static BlockState xBone, yBone, zBone, coalstone;
	public WhaleSkeleton() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> config) {
		return place(null, config.level(), null, config.random(), config.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos origin) {
		if(xBone == null) {
			xBone = Blocks.BONE_BLOCK.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Axis.X);
			yBone = Blocks.BONE_BLOCK.defaultBlockState();
			zBone = Blocks.BONE_BLOCK.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Axis.Z);
			coalstone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState();
		}
		if(random.nextBoolean()) origin = origin.below();
		Direction direction = Direction.getRandom(random);
		while(direction.getAxis().isVertical()) direction = Direction.getRandom(random);
		boolean isZ = direction.getAxis() == Axis.Z;
		BlockState bone = isZ ? zBone : xBone;
		if(random.nextBoolean()) {//spine
			byte length = random.nextBoolean() ? (byte)(random.nextInt(21) + 1) : (byte)(random.nextInt(15) + 1), shift = (byte)random.nextInt(14),
					ribAmount = (byte)(((length % 15) / 2) - (shift / 2)), rib = 0, ribDir = random.nextBoolean() ? (byte)1 : -1;
			boolean flag = false;
			if(ribDir == -1 && shift < 11) {
				int i = random.nextInt(7 - (shift / 3));
				origin = origin.above(i);
				flag = i == 6;
			}
			if(shift > length) return false;
			MutableBlockPos mut = origin.mutable();
			BlockState otherbone = isZ ? xBone : zBone;
			Axis otherAx = isZ ? Axis.X : Axis.Z;
			for(byte b = 0; b < length; b++) {
				if(random.nextFloat() < .2F && !isSpace(level.getBlockState(mut)) && isSpace(level.getBlockState(mut.above()))) mut.move(Direction.UP);
				else if(random.nextFloat() < .4F && isSpace(level.getBlockState(mut.below()))) mut.move(Direction.DOWN);
				setBlock(level, mut, bone, random);
				setBlock(level, mut.relative(otherAx, 1), bone, random);
				byte bshift = (byte)(b + shift);
				if(rib < ribAmount && bshift % 2 == 0) {//put ribs
					for(byte r = -1; r < 3; r++) if(r == -1 || r == 2) {
						MutableBlockPos ribmut = mut.relative(otherAx, r).mutable();
						setBlock(level, ribmut, otherbone, random);
						if(bshift == 11) ribmut.move(0, ribDir, 0);
						if(flag && bshift < 13 && bshift > 5) {
							ribmut = ribmut.relative(otherAx, r == 2 ? 1 : -1).mutable();
							if(bshift != 11) ribmut.move(0, -1, 0);
							setBlock(level, ribmut, otherbone, random);
							ribmut = ribmut.move(0, -1, 0).relative(otherAx, r == 2 ? 1 : -1).mutable();
							for(byte d = 0; d < 4; d++) {
								setBlock(level, ribmut, yBone, random);
								ribmut.move(0, -1, 0);
							}
							setBlock(level, ribmut.relative(otherAx, r == 2 ? -1 : 1), otherbone, random);
						} else if(bshift != 13 && noBreak(random)) {
							ribmut = ribmut.relative(otherAx, r == 2 ? 1 : -1).mutable();
							if(bshift == 1) {
								setBlock(level, ribmut.move(0, ribDir, 0), yBone, random);
								if(noBreak(random)) {
									setBlock(level, ribmut.move(0, ribDir, 0), yBone, random);
									if(noBreak(random)) setBlock(level, ribmut.move(0, ribDir, 0).relative(otherAx, r == 2 ? -1 : 1), otherbone, random);
								}
							} else {
								if(bshift != 11 && bshift != 3) ribmut.move(0, ribDir, 0);
								setBlock(level, ribmut, otherbone, random);
								ribmut = ribmut.relative(otherAx, r == 2 ? 1 : -1).mutable();
								byte size = (byte)(bshift > 5 ? 4 : 3);
								boolean noBreak = true;
								for(byte d = 0; noBreak && d < size; d++) {
									if(noBreak(random)) setBlock(level, ribmut.move(0, ribDir, 0), yBone, random);
									else noBreak = false;
								}
								if(noBreak && noBreak(random)) setBlock(level, ribmut.move(0, ribDir, 0).relative(otherAx, r == 2 ? -1 : 1), otherbone, random);
							}
						}
					}
					rib++;
				}
				mut.move(direction);
				if(random.nextFloat() < .2F) mut = mut.relative(otherAx, random.nextBoolean() ? 1 : -1).mutable();
			}
		} else if(random.nextBoolean()) {//laying rib
			Direction dir = Direction.getRandom(random);
			while(dir == direction) dir = Direction.getRandom(random);
			BlockState otherbone = yBone.setValue(RotatedPillarBlock.AXIS, dir.getAxis());
			if(random.nextBoolean()) setBlock(level, origin.relative(direction, -1).relative(dir), otherbone, random);
			setBlock(level, origin, bone, random);
			MutableBlockPos mut = origin.mutable();
			setBlock(level, mut.move(direction), bone, random);
			if(random.nextBoolean()) setBlock(level, mut.move(direction), bone, random);
			if(random.nextBoolean()) setBlock(level, mut.move(direction).move(dir), otherbone, random);
		} else {//standing rib
			if(random.nextBoolean())  setBlock(level, origin.below(2).relative(direction), bone, random);
			setBlock(level, origin.below(), yBone, random);
			setBlock(level, origin, yBone, random);
			setBlock(level, origin.above(), yBone, random);
			if(random.nextBoolean()) setBlock(level, origin.above(2).relative(direction), bone, random);
		}
		return true;
	}
	protected boolean noBreak(RandomSource random) {
		return random.nextFloat() < .8F;
	}
	protected boolean isSpace(BlockState state) {
		return state.is(Blocks.WATER) || state.isAir();
	}
	protected void setBlock(WorldGenLevel level, BlockPos pos, BlockState state, RandomSource random) {
		BlockState s = level.getBlockState(pos);
		if(s.is(Blocks.WATER) || s.isAir() || s.is(BlockTags.MOSS_REPLACEABLE) || s.is(Blocks.KELP_PLANT) || s.is(Blocks.KELP)) {
			if(random.nextFloat() < .09F) setBlock(level, pos, coalstone);
			else setBlock(level, pos, state);
		}
	}
}