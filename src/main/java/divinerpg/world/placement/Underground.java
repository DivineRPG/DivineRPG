package divinerpg.world.placement;

import com.mojang.serialization.Codec;

import divinerpg.registries.PlacementModifierRegistry;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.placement.*;

public class Underground extends PlacementFilter {
	private static final Underground INSTANCE = new Underground();
	public static final Codec<Underground> CODEC = Codec.unit(() -> INSTANCE);
	private Underground() {}
	public static Underground underground() {return INSTANCE;}
	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource source, BlockPos pos) {
		return isUnderground(context.getLevel(), pos);
	}
	public static boolean isUnderground(LevelAccessor level, BlockPos pos) {
		MutableBlockPos mut = pos.mutable();
		while(mut.getY() < level.getMaxBuildHeight() - 1) {
			BlockState state = level.getBlockState(mut.move(Direction.UP));
			if(state.canOcclude() && !state.is(BlockTags.LEAVES) && !state.is(Blocks.SNOW_BLOCK)) return level.getBrightness(LightLayer.SKY, pos.above()) < 7;
		} return false;
	}
	@Override
	public PlacementModifierType<?> type() {
		return PlacementModifierRegistry.UNDERGROUND;
	}
}