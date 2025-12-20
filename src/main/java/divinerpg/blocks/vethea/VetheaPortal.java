package divinerpg.blocks.vethea;

import divinerpg.blocks.base.SimplePortalBlock;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;

public class VetheaPortal extends SimplePortalBlock {
	public VetheaPortal() {
		super(LevelRegistry.VETHEA, LevelRegistry.MORTUM, BlockRegistry.mortumBlock.get(), null);
	}
	@Override
	public ResourceKey<Level> getTargetDimension(ResourceKey<Level> sourceDimension, Entity entity) {
		return entity instanceof ServerPlayer p && sourceDimension == rootDimension ? p.getRespawnDimension() : super.getTargetDimension(sourceDimension, entity);
	}
	@Override
	public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        if(entity instanceof ServerPlayer p && p.getRespawnDimension() == level.dimension()) {
            DimensionTransition d = p.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
            if(d != null) return UniversalPosition.toBlockPos(d.pos());
        } return super.applyPlacementLocationPreference(level, entity, pos).above();
	}
	@Override
	public boolean hasRoomForPortal(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos).isAir() || level.getBlockState(pos.above()).isAir();
	}
	@Override
	public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
		return pos;
	}
}