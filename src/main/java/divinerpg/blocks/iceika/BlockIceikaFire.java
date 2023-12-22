package divinerpg.blocks.iceika;

import java.util.*;

import divinerpg.registries.LevelRegistry;
import net.minecraft.core.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.portal.PortalShape;

public class BlockIceikaFire extends BaseFireBlock {
	public BlockIceikaFire() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).replaceable().pushReaction(PushReaction.DESTROY).randomTicks().noCollission().instabreak().lightLevel((state) -> 15).sound(SoundType.WOOL), 1F);
	}
	private static boolean inPortalDimension(Level level) {
		return level.dimension() == Level.OVERWORLD || level.dimension() == LevelRegistry.ICEIKA;
	}
	@Override
	public void entityInside(BlockState p_49260_, Level level, BlockPos p_49262_, Entity entity) {
		if(entity.canFreeze()) {
			entity.setTicksFrozen(entity.getTicksFrozen() + 4);
			if(entity.tickCount % 15 == 0) entity.hurt(level.damageSources().freeze(), 1);
		}
	}
	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean p_49283_) {
		if(!s.is(state.getBlock())) {
			if(inPortalDimension(level)) {
				Optional<PortalShape> optional = PortalShape.findEmptyPortalShape(level, pos, Direction.Axis.X);
	            optional = net.minecraftforge.event.ForgeEventFactory.onTrySpawnPortal(level, pos, optional);
	            if (optional.isPresent()) {
	               optional.get().createPortalBlocks();
	               return;
	            }
			}
			if(!canBurn(level.getBlockState(pos.below()))) level.removeBlock(pos, false);
		}
	}
	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
		return canBurn(level.getBlockState(pos.below()));
	}
	@Override
	protected boolean canBurn(BlockState state) {
		return state.is(BlockTags.SNOW) || state.is(BlockTags.ICE);
	}
}