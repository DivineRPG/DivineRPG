package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.Supplier;

public class FireBlock extends BaseFireBlock {
	public static final MapCodec<FireBlock> CODEC = simpleCodec(FireBlock::new);
	@Override public MapCodec<FireBlock> codec() {return CODEC;}
	public FireBlock() {
		super(Properties.ofFullCopy(Blocks.FIRE).mapColor(MapColor.FIRE), 8);
	}
	public FireBlock(Properties properties) {
		super(properties, 8);
	}
	public FireBlock(float fireDamage) {
		super(Properties.ofFullCopy(Blocks.FIRE).mapColor(MapColor.FIRE), fireDamage);
	}
	@Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		super.animateTick(state, level, pos, random);
		if((level.getGameTime() & 0b11) == 0) level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 0D, .04, 0D);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		BlockPos po = pos.below();
		BlockState st = level.getBlockState(po);
		return !st.isAir() && st.isFaceSturdy(level, po, Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
		BlockPos p = pos.below();
		BlockState state = level.getBlockState(p);
		return !state.isAir() && state.isFaceSturdy(level, p, Direction.UP);
	}
	@Override
	protected boolean canBurn(BlockState state) {
		return !state.isAir();
	}
	public static boolean convertFire(Level level, final BlockPos pos, Block fire, BlockState result) {
		List<Supplier<BlockPos>> positions = List.of(() -> pos, pos::below, pos::north, pos::east, pos::south, pos::west,
			() -> pos.offset(1, 0, 1), () -> pos.offset(1, 0, -1), () -> pos.offset(-1, 0, 1), () -> pos.offset(-1, 0, -1)//,
//			() -> pos.offset(0, -1, 1), () -> pos.offset(0, -1, -1), () -> pos.offset(-1, -1, 0), () -> pos.offset(1, -1, 0),
//			() -> pos.offset(1, -1, 1), () -> pos.offset(1, -1, -1), () -> pos.offset(-1, -1, 1), () -> pos.offset(-1, -1, -1)
		);
		for(Supplier<BlockPos> p : positions) if(level.getBlockState(p.get()).is(fire)) {
			level.setBlock(p.get(), result, 3);
			return true;
		} return false;
	}
}