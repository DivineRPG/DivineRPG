package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.PortalBlock;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.phys.shapes.*;

import java.util.*;

public class BlockArcanaPortal extends PortalBlock {
    protected static final VoxelShape SHAPE = Block.box(0, 5, 0, 16, 8, 16);
    public BlockArcanaPortal() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.END_PORTAL), LevelRegistry.ARCANA, TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "arcana_portal_frame")));
        this.registerDefaultState(this.stateDefinition.any());
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    	return supportedBy(level.getBlockState(pos.north())) && supportedBy(level.getBlockState(pos.east())) && supportedBy(level.getBlockState(pos.south())) && supportedBy(level.getBlockState(pos.west()));
    }
    @Override
    public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
    	if(level.dimension() == LevelRegistry.ARCANA) {
			Optional<BlockPos> ruinedPortal = repairRuinedPortal(level, level.findNearestMapStructure(StructureTags.RUINED_PORTAL, pos, 128, false));
			if(!ruinedPortal.isEmpty()) return ruinedPortal.get();
		} return super.applyPlacementLocationPreference(level, entity, pos);
    }
    @Override
    public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
    	if(level.dimension() == LevelRegistry.ARCANA && level.getBlockState(pos.offset(2, 0, 2)).is(this)) return pos;
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
	private Optional<BlockPos> repairRuinedPortal(ServerLevel level, BlockPos position) {
		if(position == null) return Optional.empty();
		int surface = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 33, 255, 0, level, null, position.getX(), position.getZ());
		for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(new BlockPos(x, y, z)).is(this))
			return Optional.of(new BlockPos(x, y, z));
		BlockPos pos = null;
		Block tile = BlockRegistry.ancientTile.get();
		loop: for(int x = position.getX() - 11; x < position.getX() + 11; x++) for(int y = surface - 7; y < surface + 7; y++) for(int z = position.getZ() - 11; z < position.getZ() + 11; z++) if(level.getBlockState(pos = new BlockPos(x, y, z)).is(tile)) {
			Block brick = BlockRegistry.lightDegradedBrick.get();
			pos = level.getBlockState(pos.offset(-1, 0, -1)).is(brick) ? pos.offset(-5, 0, -5)
					: level.getBlockState(pos.offset(1, 0, -1)).is(brick) ? pos.offset(-1, 0, -5)
							: level.getBlockState(pos.offset(-1, 0, 1)).is(brick) ? pos.offset(-5, 0, -1)
									: level.getBlockState(pos.offset(1, 0, 1)).is(brick) ? pos.offset(-1, 0, -1) : null;
			break loop;
		} if(pos == null) return Optional.empty();
		level.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "arcana/portal")).placeInWorld(level, pos, pos, new StructurePlaceSettings(), level.random, 2);
		return Optional.of(new BlockPos(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2));
	}
}