package divinerpg.util.teleport;

import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.BlockUtil;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.*;
import net.minecraft.tags.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import java.util.*;

public class ArcanaTeleporter extends DivineTeleporter {

	private static final int SEARCH_RADIUS = 256;
	public final StructureTemplate repairedPortal;

	public ArcanaTeleporter(ServerLevel level, StructureTemplate repairedPortal) {
		super(level, BlockRegistry.arcanaPortal.get(), BlockRegistry.arcanaPortalFrame.get(), true, PointOfInterestRegistry.ARCANA_PORTAL.getKey());
		this.repairedPortal = repairedPortal;
	}

	@Override
	public boolean isVanilla() {
		return false;
	}

	@Override
	public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
		entity.setPortalCooldown();
		if(destWorld.dimension() == LevelRegistry.ARCANA) {
			// Check for ruined portal
			PortalInfo ruinedPortal = repairRuinedPortal(destWorld, destWorld.findNearestMapStructure(StructureTags.RUINED_PORTAL, entity.blockPosition(), SEARCH_RADIUS, false), entity);
			if(ruinedPortal != null) return ruinedPortal;
		}
		// Check for player-made portal
		PortalInfo playerPortal = findPlayerMadePortal(destWorld, entity, SEARCH_RADIUS);
		if(playerPortal != null) return playerPortal;
		// Default portal behavior: Send player to world spawn
		return super.getPortalInfo(entity, destWorld, defaultPortalInfo);
	}

	private PortalInfo findPlayerMadePortal(ServerLevel level, Entity entity, int searchRadius) {
		BlockPos pos = entity.blockPosition();
		PoiManager poiManager = level.getPoiManager();
        poiManager.ensureLoadedAndValid(level, pos, searchRadius);
        Optional<PoiRecord> optional = poiManager.getInSquare((poiType) ->
                poiType.is(point), pos, searchRadius, PoiManager.Occupancy.ANY).sorted(Comparator.<PoiRecord>comparingDouble((poi) ->
                poi.getPos().distSqr(pos)).thenComparingInt((poi) ->
                poi.getPos().getY())).findFirst();
        BlockPos blockpos;
        if(optional.isEmpty()) {
        	FoundRectangle r = makePortal(pos, null).get();
        	blockpos = r.minCorner.offset(2, 0, 2);
        	level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
        	return new PortalInfo(new Vec3(r.minCorner.getX() + 2, r.minCorner.getY(), r.minCorner.getZ() + 2), Vec3.ZERO, entity.getXRot(), entity.getYRot());
        }
        blockpos = optional.get().getPos();
		return new PortalInfo(new Vec3(blockpos.getX(), blockpos.getY(), blockpos.getZ()), Vec3.ZERO, entity.getXRot(), entity.getYRot());
	}

	private PortalInfo repairRuinedPortal(ServerLevel level, BlockPos position, Entity entity) {
		if(position == null) return null;
		int surface = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 33, 255, 0, level, null, position.getX(), position.getZ());
		for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(new BlockPos(x, y, z)).is(portal))
			return new PortalInfo(new Vec3(x, y, z), Vec3.ZERO, entity.getXRot(), entity.getYRot());
		BlockPos pos = null;
		Block tile = BlockRegistry.ancientTile.get();
		loop: for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(pos = new BlockPos(x, y, z)).is(tile)) {
			Block brick = BlockRegistry.lightDegradedBrick.get();
			pos = level.getBlockState(pos.offset(-1, 0, -1)).is(brick) ? pos.offset(-5, 0, -5)
					: level.getBlockState(pos.offset(1, 0, -1)).is(brick) ? pos.offset(-1, 0, -5)
							: level.getBlockState(pos.offset(-1, 0, 1)).is(brick) ? pos.offset(-5, 0, -1)
									: level.getBlockState(pos.offset(1, 0, 1)).is(brick) ? pos.offset(-1, 0, -1) : null;
			break loop;
		}
		if(pos == null) return null;
		repairedPortal.placeInWorld(level, pos, pos, new StructurePlaceSettings(), level.random, 2);
		return new PortalInfo(new Vec3(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2), Vec3.ZERO, entity.getXRot(), entity.getYRot());
	}
	@Override
	public Optional<FoundRectangle> makePortal(BlockPos pos, Axis axis) {
		pos = new BlockPos(pos.getX(), getHeight(world, pos.getX(), pos.getZ()), pos.getZ());
		for (int x = -2; x < 3; x++)
			for (int z = -2; z < 3; z++) {
				if (Math.abs(x) < 2 && Math.abs(z) < 2)
					world.setBlock(pos.offset(x, 0, z), portal.defaultBlockState(), 3);
				else if (Math.abs(z) < 2) {
					if (x == -2)
						world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), 3);
					else if (x == 2)
						world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), 3);
				} else if (Math.abs(x) < 2) {
					if (z == -2)
						world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), 3);
					else
						world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), 3);
				}
			}
		return Optional.of(new BlockUtil.FoundRectangle(pos, 3, 3));
	}
	protected int getHeight(ServerLevel level, int posX, int posZ) {
		for (int y = level.getHeight(); y > 32; y--) {
			BlockState block = level.getBlockState(new BlockPos(posX, y, posZ));
			if (block.is(BlockRegistry.arcaniteSand.get()))
				return y;
			if (block.is(BlockRegistry.arcaniteStone.get()))
				return ++y;
		}
		return level.getHeight(Types.MOTION_BLOCKING, posX, posZ);
	}
}