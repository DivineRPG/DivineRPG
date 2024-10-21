package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.blocks.base.PortalBlock;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

public class BlockArcanaPortal extends PortalBlock {
    protected static final VoxelShape SHAPE = Block.box(0, 5, 0, 16, 8, 16);
    public BlockArcanaPortal() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.END_PORTAL), LevelRegistry.ARCANA, TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "portal_frames/arcana_portal")));
        this.registerDefaultState(this.stateDefinition.any());
    }
	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override
    public boolean isSupported(BlockState state, LevelReader level, BlockPos pos) {
    	return supportedBy(level.getBlockState(pos.north())) && supportedBy(level.getBlockState(pos.east())) && supportedBy(level.getBlockState(pos.south())) && supportedBy(level.getBlockState(pos.west()));
    }
    @Override
    public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
    	if(level.dimension() == rootDimension) {
			BlockPos ruinedPortal = repairRuinedPortal(level, level.findNearestMapStructure(StructureTags.RUINED_PORTAL, pos, 128, false));
			if(ruinedPortal != null) return ruinedPortal;
		} return super.applyPlacementLocationPreference(level, entity, pos);
    }
    @Override
    public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
    	if(level.dimension() == rootDimension && level.getBlockState(pos.offset(2, 0, 2)).is(this)) return pos;
        Block frame = BlockRegistry.arcanaPortalFrame.get();
		for(int x = -2; x < 3; x++) for(int z = -2; z < 3; z++) {
			if(Math.abs(x) < 2 && Math.abs(z) < 2) level.setBlock(pos.offset(x, 0, z), this.defaultBlockState(), 3);
			else if(Math.abs(z) < 2) {
				if(x == -2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), 3);
				else if(x == 2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), 3);
			} else if(Math.abs(x) < 2) {
				if(z == -2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), 3);
				else level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), 3);
			}
		} return pos;
    }
	private BlockPos repairRuinedPortal(ServerLevel level, BlockPos position) {
		if(position == null) return null;
		int surface = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 33, 255, 0, level, null, position.getX(), position.getZ());
		for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(new BlockPos(x, y, z)).is(this))
			return new BlockPos(x, y, z);
		BlockPos pos = null;
		Block tile = BlockRegistry.ancientTile.get();
		loop: for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(pos = new BlockPos(x, y, z)).is(tile)) {
			Block brick = BlockRegistry.lightDegradedBrick.get();
			pos = level.getBlockState(pos.offset(-1, 0, -1)).is(brick) ? pos.offset(-5, 0, -5)
					: level.getBlockState(pos.offset(1, 0, -1)).is(brick) ? pos.offset(-1, 0, -5)
							: level.getBlockState(pos.offset(-1, 0, 1)).is(brick) ? pos.offset(-5, 0, -1)
									: level.getBlockState(pos.offset(1, 0, 1)).is(brick) ? pos.offset(-1, 0, -1) : null;
			break loop;
		} if(pos == null) return null;
		level.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "arcana/portal")).placeInWorld(level, pos, pos, new StructurePlaceSettings(), level.random, 2);
		return new BlockPos(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
	}
	@Override
	public void linkPortals(MinecraftServer server, UniversalPosition origin, UniversalPosition target) {
		if(!hasPortal(server, origin) || !hasPortal(server, target)) {
//			DivineRPG.LOGGER.error("portal linking failed");
			return;
		} connectTo(origin.level(server), origin.blockPos(), target, null);
		connectTo(target.level(server), target.blockPos(), origin, null);
	}
	@Override
	public void connectTo(ServerLevel level, BlockPos pos, @NotNull UniversalPosition connection, Axis axis) {
		if(level.getBlockEntity(pos) instanceof PortalBlockEntity portal && !connection.equals(portal.targetPosition)) {
			portal.targetPosition = connection;
			connectTo(level, pos.north(), connection, axis);
			connectTo(level, pos.east(), connection, axis);
			connectTo(level, pos.south(), connection, axis);
			connectTo(level, pos.west(), connection, axis);
		}
	}
}