package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

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
				if(!entity.isAlive()) level.playSound(null, pos, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, .8F, 1.5F);
			}
		}
	}
	@Override public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override public BlockState getStateForPlacement(BlockPlaceContext context) {return defaultBlockState();}
	@Override public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {return canBurn(level.getBlockState(pos.below()));}
	@Override protected boolean canBurn(BlockState state) {return state.is(BlockTags.SNOW) || state.is(BlockTags.ICE);}
}