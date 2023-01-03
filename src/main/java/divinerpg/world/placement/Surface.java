package divinerpg.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.PlacementModifierRegistry;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.stream.Stream;

public class Surface extends PlacementModifier {
	public static enum Surface_Type {HIGHEST_CEILING, HIGHEST_GROUND, LOWEST_CEILING, LOWEST_GROUND}
	public static enum Mode {FULL, RANDOM_SECTION, SLICE}
	public static final Codec<Surface> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.STRING.fieldOf("surface").forGetter((config) -> {
	        return config.surface;
		}),  Codec.STRING.optionalFieldOf("mode", "full").forGetter((config) -> {
			return config.mode;
		}), Codec.INT.fieldOf("min_height").forGetter((config) -> {
		   return config.minHeight;
		}), Codec.INT.fieldOf("max_height").forGetter((config) -> {
		   return config.maxHeight;
		}), Codec.INT.fieldOf("bury").forGetter((config) -> {
			   return config.maxHeight;
		})).apply(instance, Surface::new);
	});
	public final String surface, mode;
	public final int minHeight, maxHeight, bury;
	public Surface(String surface, String mode, int minHeight, int maxHeight, int bury) {
		this.surface = surface;
		this.mode = mode;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.bury = bury;
	}
	public static int getSurface(Surface_Type type, Mode mode, int minHeight, int maxHeight, int bury, WorldGenLevel level, RandomSource random, int x, int z) {
		final int minY, maxY;
		if(mode == Mode.RANDOM_SECTION) {
			minY = random.nextInt(minHeight, maxHeight + 1);
			maxY = random.nextInt(minY, maxHeight + 1);
		} else {
			minY = minHeight;
			maxY = maxHeight;
		}
    	MutableBlockPos pos = new MutableBlockPos(x, mode == Mode.SLICE ? random.nextInt(minY, maxY + 1) : type == Surface_Type.LOWEST_CEILING || type == Surface_Type.LOWEST_GROUND ? minY : maxY, z);
    	return switch(type) {
    	case HIGHEST_CEILING:
        	if(hasSpace(level, pos)) do{pos.move(Direction.DOWN);} while(pos.getY() > minY - 2 && hasSpace(level, pos));
        	while(pos.getY() > minY - 2 && !hasSpace(level, pos)) pos.move(Direction.DOWN);
        	yield pos.getY() + bury;
    	case HIGHEST_GROUND:
        	if(!hasSpace(level, pos)) do{pos.move(Direction.DOWN);} while(pos.getY() > minY - 2 && !hasSpace(level, pos));
        	while(pos.getY() > minY - 2 && hasSpace(level, pos)) pos.move(Direction.DOWN);
    		yield pos.getY() - bury + 1;
    	case LOWEST_CEILING:
        	if(!hasSpace(level, pos)) do{pos.move(Direction.UP);} while(pos.getY() < maxY + 2 && !hasSpace(level, pos));
        	while(pos.getY() < maxY + 2 && hasSpace(level, pos)) pos.move(Direction.UP);
    		yield pos.getY() + bury - 1;
    	case LOWEST_GROUND:
        	if(hasSpace(level, pos)) do{pos.move(Direction.UP);} while(pos.getY() < maxY + 2 && hasSpace(level, pos));
        	while(pos.getY() < maxY + 2 && !hasSpace(level, pos)) pos.move(Direction.UP);
    		yield pos.getY() - bury;
    	};
	}
	public static boolean hasSpace(WorldGenLevel level, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		return state.isAir() || state.is(Blocks.WATER);
	}
	@Override
	public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos pos) {
		final int minY, maxY, y;
		Mode modus = Mode.valueOf(mode.toUpperCase());
		if(modus == Mode.RANDOM_SECTION) {
			minY = random.nextInt(minHeight, maxHeight + 1);
			maxY = random.nextInt(minY, maxHeight + 1);
			y = getSurface(Surface_Type.valueOf(surface.toUpperCase()), Mode.FULL, minY, maxY, bury, context.getLevel(), random, pos.getX(), pos.getZ());
		} else {
			minY = minHeight;
			maxY = maxHeight;
			y = getSurface(Surface_Type.valueOf(surface.toUpperCase()), modus, minY, maxY, bury, context.getLevel(), random, pos.getX(), pos.getZ());
		}
		if(y > maxY || y < minY) return Stream.of();
		return Stream.of(pos.atY(y));
	}
	@Override
	public PlacementModifierType<?> type() {
		return PlacementModifierRegistry.SURFACE_PLACEMENT;
	}
}