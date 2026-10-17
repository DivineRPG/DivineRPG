package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.LevelRegistry;
import divinerpg.utils.UniversalPosition;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.Mode;
import divinerpg.world.placement.Surface.Surface_Type;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class BlockArcanaPortal extends BaseEntityBlock implements Portal {
    protected static final VoxelShape SHAPE = Block.column(16.0, 6.0, 12.0);

    public BlockArcanaPortal(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.PORTAL.get().create(pos, state);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getEntityInsideCollisionShape(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return state.getShape(level, pos);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (entity.canUsePortal(false)) {
            entity.setAsInsidePortal(this, pos);
        }
    }

    @Override
    public @Nullable TeleportTransition getPortalDestination(ServerLevel currentLevel, Entity entity, BlockPos portalEntryPos) {
        ResourceKey<Level> currentDimension = currentLevel.dimension();
        boolean isFromArcana = currentDimension == LevelRegistry.ARCANA;
        ResourceKey<Level> targetDimension = isFromArcana ? Level.OVERWORLD : LevelRegistry.ARCANA;
        ServerLevel targetLevel = currentLevel.getServer().getLevel(targetDimension);
        if (targetLevel == null) {
            return null;
        }
        BlockPos targetPos = findSuitableLocation(targetLevel, entity, portalEntryPos, 0);
        if (targetPos == null) {
            targetPos = portalEntryPos;
        }
        if (!isFromArcana) {
            targetPos = placeAndLink(currentLevel, portalEntryPos, targetLevel, targetPos, entity);
        }
        Vec3 spawnPos = Vec3.atBottomCenterOf(targetPos);
        Set<Relative> relatives = Relative.union(new Set[]{Relative.DELTA, Relative.ROTATION});
        return new TeleportTransition(targetLevel, spawnPos, Vec3.ZERO, entity.getYRot(), entity.getXRot(), relatives, TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
    }

    public boolean isSupported(BlockState state, LevelReader level, BlockPos pos) {
        Block frame = BlockRegistry.arcanaPortalFrame.get();
        return level.getBlockState(pos.north()).is(frame) && level.getBlockState(pos.east()).is(frame) && level.getBlockState(pos.south()).is(frame) && level.getBlockState(pos.west()).is(frame);
    }

    public BlockPos findSuitableLocation(ServerLevel level, Entity entity, BlockPos center, int attempt) {
        if (level.dimension() == Level.OVERWORLD && attempt == 0) {
            BlockPos ruinedPortal = repairRuinedPortal(level, level.findNearestMapStructure(StructureTags.RUINED_PORTAL, center, 128, false));
            if (ruinedPortal != null) return ruinedPortal;
        }
        return center;
    }
    public BlockPos placeAndLink(ServerLevel originLevel, BlockPos originPos, ServerLevel level, BlockPos pos, Entity entity) {
        UniversalPosition link = new UniversalPosition(originLevel, originPos);
        Block frame = BlockRegistry.arcanaPortalFrame.get();
        for (int x = -2; x < 3; x++) {
            for (int z = -2; z < 3; z++) {
                if (Math.abs(x) < 2 && Math.abs(z) < 2) {
                    BlockPos p = pos.offset(x, 0, z);
                    level.setBlock(p, defaultBlockState(), Block.UPDATE_KNOWN_SHAPE);
                    BlockEntity blockEntity = level.getBlockEntity(p);
                    if (blockEntity instanceof PortalBlockEntity portal) {
                        portal.targetPosition = link;
                    }
                } else if (Math.abs(z) < 2) {
                    if (x == -2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), Block.UPDATE_KNOWN_SHAPE);
                    else if (x == 2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), Block.UPDATE_KNOWN_SHAPE);
                } else if (Math.abs(x) < 2) {
                    if (z == -2) level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), Block.UPDATE_KNOWN_SHAPE);
                    else level.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), Block.UPDATE_KNOWN_SHAPE);
                }
            }
        }
        return pos;
    }

    public BlockPos repairRuinedPortal(ServerLevel level, BlockPos position) {
        if (position == null) return null;
        int surface = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 33, 255, 0, level, null, position.getX(), position.getZ());
        for (int x = position.getX() - 11; x < position.getX() + 11; x++) {
            for (int y = surface - 7; y < surface + 7; y++) {
                for (int z = position.getZ() - 11; z < position.getZ() + 11; z++) {
                    if (level.getBlockState(new BlockPos(x, y, z)).is(this)) {
                        return new BlockPos(x, y, z);
                    }
                }
            }
        }
        BlockPos pos = null;
        Block tile = BlockRegistry.ancientTile.get();
        loop:
        for (int x = position.getX() - 11; x < position.getX() + 11; x++) {
            for (int y = surface - 7; y < surface + 7; y++) {
                for (int z = position.getZ() - 11; z < position.getZ() + 11; z++) {
                    pos = new BlockPos(x, y, z);
                    if (level.getBlockState(pos).is(tile)) {
                        Block brick = BlockRegistry.lightDegradedBrick.get();
                        pos = level.getBlockState(pos.offset(-1, 0, -1)).is(brick) ? pos.offset(-5, 0, -5) : level.getBlockState(pos.offset(1, 0, -1)).is(brick) ? pos.offset(-1, 0, -5) : level.getBlockState(pos.offset(-1, 0, 1)).is(brick) ? pos.offset(-5, 0, -1) : level.getBlockState(pos.offset(1, 0, 1)).is(brick) ? pos.offset(-1, 0, -1) : null;
                        break loop;
                    }
                }
            }
        }

        if (pos == null) return null;
        final BlockPos finalPos = pos;
        level.getStructureTemplateManager().get(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "arcana/portal")).ifPresent(template -> template.placeInWorld(level, finalPos, finalPos, new StructurePlaceSettings(), level.getRandom(), 2));

        return new BlockPos(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
    }
}