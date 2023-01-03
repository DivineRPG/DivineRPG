package divinerpg.world.placement;

import com.mojang.serialization.Codec;

import divinerpg.registries.PlacementModifierRegistry;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.placement.*;

public class Underground extends PlacementFilter {
	private static final Underground INSTANCE = new Underground();
	public static Codec<Underground> CODEC = Codec.unit(() -> INSTANCE);
	private Underground() {}
	public static Underground underground() {return INSTANCE;}
	protected boolean shouldPlace(PlacementContext context, RandomSource source, BlockPos pos) {
		return isUnderground(context.getLevel(), pos);
	}
	public static boolean isUnderground(LevelAccessor level, BlockPos pos) {
		return !level.canSeeSkyFromBelowWater(pos.above());
	}
	public PlacementModifierType<?> type() {
		return PlacementModifierRegistry.UNDERGROUND;
	}
}