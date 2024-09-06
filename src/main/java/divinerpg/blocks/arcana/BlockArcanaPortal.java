package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.*;

import static divinerpg.blocks.arcana.BlockArcanaPortalFrame.getOrCreatePortalShape;

import java.util.*;

import javax.annotation.Nullable;

public class BlockArcanaPortal extends BlockMod implements Portal {
    protected static final VoxelShape SHAPE = Block.box(0, 5, 0, 16, 8, 16);
    public BlockArcanaPortal() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.END_PORTAL));
        this.registerDefaultState(this.stateDefinition.any());
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
    	if(entity.canUsePortal(false)) entity.setAsInsidePortal(this, pos);
    }
    @Override public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {return ItemStack.EMPTY;}
    @Override public boolean canBeReplaced(BlockState state, Fluid fluid) {return false;}
    @Override public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
        BlockPattern.BlockPatternMatch frame = getOrCreatePortalShape().find(world, pos);
        if(frame == null && world.dimension() != LevelRegistry.ARCANA) world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
    }
    @Override
    public int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return entity instanceof Player player ? Math.max(1, level.getGameRules().getInt(player.getAbilities().invulnerable ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY)) : 0;
    }
	@Override
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
		ResourceKey<Level> resourcekey = level.dimension() == LevelRegistry.ARCANA ? Level.OVERWORLD : LevelRegistry.ARCANA;
        ServerLevel serverlevel = level.getServer().getLevel(resourcekey);
        if(serverlevel == null) return null;
        else {
            boolean flag = serverlevel.dimension() == LevelRegistry.ARCANA;
            WorldBorder worldborder = serverlevel.getWorldBorder();
            double d0 = DimensionType.getTeleportationScale(level.dimensionType(), serverlevel.dimensionType());
            BlockPos blockpos = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
            return getExitPortal(serverlevel, entity, pos, blockpos, flag, worldborder);
        }
	}
	@Nullable
    protected DimensionTransition getExitPortal(ServerLevel level, Entity entity, BlockPos pos, BlockPos exitPos, boolean isNether, WorldBorder worldBorder) {
		Optional<BlockPos> optional = findClosestPortalPosition(exitPos, worldBorder, level);
        DimensionTransition.PostDimensionTransition dimensiontransition$postdimensiontransition;
        if(optional.isPresent()) dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(p_351967_ -> p_351967_.placePortalTicket(optional.get()));
        else {
            createPortal(pos, level);
            dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        } return new DimensionTransition(level, pos.getCenter(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), dimensiontransition$postdimensiontransition);
	}
	public void createPortal(BlockPos pos, ServerLevel level) {
        pos = new BlockPos(pos.getX(), Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 33, 255, 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ());
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
		}
    }
	public Optional<BlockPos> findClosestPortalPosition(BlockPos exitPos, WorldBorder worldBorder, ServerLevel level) {
		if(level.dimension() == LevelRegistry.ARCANA) {
			Optional<BlockPos> ruinedPortal = repairRuinedPortal(level, level.findNearestMapStructure(StructureTags.RUINED_PORTAL, exitPos, 128, false));
			if(!ruinedPortal.isEmpty()) return ruinedPortal;
		} PoiManager poimanager = level.getPoiManager();
        int i = 128;
        poimanager.ensureLoadedAndValid(level, exitPos, i);
        return poimanager.getInSquare(p_230634_ -> p_230634_.is(PointOfInterestRegistry.ARCANA_PORTAL.getKey()), exitPos, i, PoiManager.Occupancy.ANY).map(PoiRecord::getPos).filter(worldBorder::isWithinBounds)
            .filter(p_352047_ -> level.getBlockState(p_352047_).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
            .min(Comparator.<BlockPos>comparingDouble(p_352046_ -> p_352046_.distSqr(exitPos)).thenComparingInt(Vec3i::getY));
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