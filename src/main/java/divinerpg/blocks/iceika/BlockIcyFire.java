package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.SoundRegistry.FREEZE;
import static divinerpg.registries.TagRegistry.BASE_BLOCKS_ICY_FIRE;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class BlockIcyFire extends BaseFireBlock {
	public static final MapCodec<BlockIcyFire> CODEC = simpleCodec(BlockIcyFire::new);
	@Override public MapCodec<BlockIcyFire> codec() {return CODEC;}
	public BlockIcyFire(Properties properties) {super(properties.lightLevel((state) -> 7), 1);}
	@Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if(!entity.isAlive()) return;
		if(entity.isOnFire()) entity.extinguishFire();
		if(entity.canFreeze() && !entity.isInLava()) {
			entity.setTicksFrozen(entity.getTicksFrozen() + 4);
			if(entity.tickCount % 15 == 0) {
				entity.hurt(level.damageSources().freeze(), 1);
				if(!entity.isAlive()) level.playSound(null, pos, FREEZE.get(), BLOCKS, .8F, 1.5F);
			}
		}
	}
	@Override public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override public BlockState getStateForPlacement(BlockPlaceContext context) {return defaultBlockState();}
	@Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockPos posBelow = pos.below();
		BlockState stateBelow = level.getBlockState(posBelow);
		return canBurn(stateBelow) && !stateBelow.isAir() && stateBelow.isFaceSturdy(level, posBelow, Direction.UP);
	}
	@Override protected boolean canBurn(BlockState state) {return state.is(BASE_BLOCKS_ICY_FIRE);}
}