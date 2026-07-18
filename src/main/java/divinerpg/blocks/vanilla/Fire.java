package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;

public class Fire extends BaseFireBlock {
	public static final MapCodec<Fire> CODEC = simpleCodec(Fire::new);
	@Override public MapCodec<Fire> codec() {return CODEC;}
	public Fire() {
		super(Properties.ofFullCopy(Blocks.FIRE).mapColor(MapColor.FIRE), 8);
	}
	public Fire(Properties properties) {
		super(properties, 8);
	}
	public Fire(float fireDamage) {
		super(Properties.ofFullCopy(Blocks.FIRE).mapColor(MapColor.FIRE), fireDamage);
	}
	public Fire(Properties properties, float fireDamage) {
		super(properties, fireDamage);
	}
	@Override
	protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		super.entityInside(state, level, pos, entity);
		if(!entity.isAlive()) level.playSound(entity, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.NEUTRAL, .6F, 1.3F);
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
}