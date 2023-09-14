package divinerpg.world.feature;

import java.util.List;

import divinerpg.world.feature.config.EllipsoidConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class Ellipsoid extends Feature<EllipsoidConfig> {
	public Ellipsoid() {super(EllipsoidConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<EllipsoidConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(EllipsoidConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(canBeHere(config.replace, random, level.getBlockState(pos))) {
			int xSize = getSize(random, config.minSize, config.maxSize), ySize = getSize(random, config.minSize, config.maxSize), zSize = getSize(random, config.minSize, config.maxSize);
			for(int x = -xSize; x < xSize; x++) for(int y = -ySize; y < ySize; y++) for(int z = -zSize; z < zSize; z++)
				if((Math.pow(x, 2) / Math.pow(xSize, 2)) + (Math.pow(y, 2) / Math.pow(ySize, 2)) + (Math.pow(z, 2) / Math.pow(zSize, 2)) < 0.5 && canBeHere(config.replace, random, level.getBlockState(pos.offset(x, y, z)))) {
					BlockPos p = pos.offset(x, y, z);
					level.setBlock(p, config.block.getState(random, p), 3);
				}
			return true;
		}
		return false;
	}
	protected final int getSize(RandomSource random, int minSize, int maxSize) {
		return random.nextInt(minSize, maxSize + 1);
	}
	public final boolean canBeHere(List<RuleTest> replace, RandomSource random, BlockState state) {
		if(replace.isEmpty() && defaultReplace(state)) return true;
		for(RuleTest test : replace) if(test.test(state, random)) return true;
		return false;
	}
	/**
	 * only called when config.replace is empty
	 */
	public boolean defaultReplace(BlockState state) {
		return state.isAir();
	}
}