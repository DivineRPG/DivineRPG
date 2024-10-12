package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.PortalBlock;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.Mode;
import divinerpg.world.placement.Surface.Surface_Type;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.portal.DimensionTransition;

public class VetheaPortal extends PortalBlock {
	public VetheaPortal() {
		super(Properties.ofFullCopy(Blocks.NETHER_PORTAL), LevelRegistry.VETHEA, TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "vethea_portal_frame")));
	}
	@Override
	public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
		if(level.dimension() == rootDimension) return new BlockPos(pos.getX(), Surface.getSurface(Surface_Type.LOWEST_GROUND, Mode.FULL, level.getMinBuildHeight(), 32, 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ());
		if(entity instanceof ServerPlayer p && p.getRespawnDimension() == level.dimension()) {
			DimensionTransition d = p.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
			if(d != null) return UniversalPosition.toBlockPos(d.pos());
		} return pos;
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