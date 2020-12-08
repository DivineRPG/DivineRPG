package divinerpg.blocks.vethea;

import divinerpg.registries.TileRegistry;
import divinerpg.tiles.TileEntityNightmareBed;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.util.*;

public class BlockNightmareBed extends HorizontalBlock implements ITileEntityProvider {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    protected static final VoxelShape BED_BASE_SHAPE = Block.makeCuboidShape(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D);
    protected static final VoxelShape CORNER_NW = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D);
    protected static final VoxelShape CORNER_SW = Block.makeCuboidShape(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D);
    protected static final VoxelShape CORNER_NE = Block.makeCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D);
    protected static final VoxelShape CORNER_SE = Block.makeCuboidShape(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D);
    protected static final VoxelShape NORTH_FACING_SHAPE = VoxelShapes.or(BED_BASE_SHAPE, CORNER_NW, CORNER_NE);
    protected static final VoxelShape SOUTH_FACING_SHAPE = VoxelShapes.or(BED_BASE_SHAPE, CORNER_SW, CORNER_SE);
    protected static final VoxelShape WEST_FACING_SHAPE = VoxelShapes.or(BED_BASE_SHAPE, CORNER_NW, CORNER_SW);
    protected static final VoxelShape EAST_FACING_SHAPE = VoxelShapes.or(BED_BASE_SHAPE, CORNER_NE, CORNER_SE);
    private static TileEntityType<TileEntityNightmareBed> NIGHTMARE_BED = null;

    public BlockNightmareBed() {
        super(Properties.create(Material.CARPET)
                .sound(SoundType.CLOTH));
        setRegistryName("nightmare_bed_block");
        NIGHTMARE_BED = TileRegistry.NIGHTMARE_BED;
        this.setDefaultState(this.stateContainer.getBaseState().with(PART, BedPart.FOOT).with(OCCUPIED, Boolean.valueOf(false)));
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static Direction getBedDirection(IBlockReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos);
        return blockstate.getBlock() instanceof BedBlock ? blockstate.get(HORIZONTAL_FACING) : null;
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
        //TODO - vethean teleporter
        }
        return ActionResultType.PASS;
    }

    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.5F);
    }

    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.onLanded(worldIn, entityIn);
        } else {
            this.bounceEntity(entityIn);
        }

    }

    private void bounceEntity(Entity entity) {
        Vector3d vector3d = entity.getMotion();
        if (vector3d.y < 0.0D) {
            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setMotion(vector3d.x, -vector3d.y * (double)0.66F * d0, vector3d.z);
        }

    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == getDirectionToOther(stateIn.get(PART), stateIn.get(HORIZONTAL_FACING))) {
            return facingState.isIn(this) && facingState.get(PART) != stateIn.get(PART) ? stateIn.with(OCCUPIED, facingState.get(OCCUPIED)) : Blocks.AIR.getDefaultState();
        } else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    private static Direction getDirectionToOther(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isRemote && player.isCreative()) {
            BedPart bedpart = state.get(PART);
            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = pos.offset(getDirectionToOther(bedpart, state.get(HORIZONTAL_FACING)));
                BlockState blockstate = worldIn.getBlockState(blockpos);
                if (blockstate.getBlock() == this && blockstate.get(PART) == BedPart.HEAD) {
                    worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
                    worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
                }
            }
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getPlacementHorizontalFacing();
        BlockPos blockpos = context.getPos();
        BlockPos blockpos1 = blockpos.offset(direction);
        return context.getWorld().getBlockState(blockpos1).isReplaceable(context) ? this.getDefaultState().with(HORIZONTAL_FACING, direction) : null;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = getFootDirection(state).getOpposite();
        switch(direction) {
            case NORTH:
                return NORTH_FACING_SHAPE;
            case SOUTH:
                return SOUTH_FACING_SHAPE;
            case WEST:
                return WEST_FACING_SHAPE;
            default:
                return EAST_FACING_SHAPE;
        }
    }

    public static Direction getFootDirection(BlockState state) {
        Direction direction = state.get(HORIZONTAL_FACING);
        return state.get(PART) == BedPart.HEAD ? direction.getOpposite() : direction;
    }

    @OnlyIn(Dist.CLIENT)
    public static TileEntityMerger.Type getMergeType(BlockState state) {
        BedPart bedpart = state.get(PART);
        return bedpart == BedPart.HEAD ? TileEntityMerger.Type.FIRST : TileEntityMerger.Type.SECOND;
    }

    private static boolean isBedBelow(IBlockReader blockReader, BlockPos pos) {
        return blockReader.getBlockState(pos.down()).getBlock() instanceof BedBlock;
    }

    public static Optional<Vector3d> func_242652_a(EntityType<?> type, ICollisionReader collisionReader, BlockPos pos, float orientation) {
        Direction direction = collisionReader.getBlockState(pos).get(HORIZONTAL_FACING);
        Direction direction1 = direction.rotateY();
        Direction direction2 = direction1.hasOrientation(orientation) ? direction1.getOpposite() : direction1;
        if (isBedBelow(collisionReader, pos)) {
            return func_242653_a(type, collisionReader, pos, direction, direction2);
        } else {
            int[][] aint = func_242656_a(direction, direction2);
            Optional<Vector3d> optional = func_242654_a(type, collisionReader, pos, aint, true);
            return optional.isPresent() ? optional : func_242654_a(type, collisionReader, pos, aint, false);
        }
    }

    private static Optional<Vector3d> func_242653_a(EntityType<?> type, ICollisionReader collisionReader, BlockPos pos, Direction direction1, Direction direction2) {
        int[][] aint = func_242658_b(direction1, direction2);
        Optional<Vector3d> optional = func_242654_a(type, collisionReader, pos, aint, true);
        if (optional.isPresent()) {
            return optional;
        } else {
            BlockPos blockpos = pos.down();
            Optional<Vector3d> optional1 = func_242654_a(type, collisionReader, blockpos, aint, true);
            if (optional1.isPresent()) {
                return optional1;
            } else {
                int[][] aint1 = func_242655_a(direction1);
                Optional<Vector3d> optional2 = func_242654_a(type, collisionReader, pos, aint1, true);
                if (optional2.isPresent()) {
                    return optional2;
                } else {
                    Optional<Vector3d> optional3 = func_242654_a(type, collisionReader, pos, aint, false);
                    if (optional3.isPresent()) {
                        return optional3;
                    } else {
                        Optional<Vector3d> optional4 = func_242654_a(type, collisionReader, blockpos, aint, false);
                        return optional4.isPresent() ? optional4 : func_242654_a(type, collisionReader, pos, aint1, false);
                    }
                }
            }
        }
    }

    private static Optional<Vector3d> func_242654_a(EntityType<?> type, ICollisionReader collisionReader, BlockPos pos, int[][] p_242654_3_, boolean p_242654_4_) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int[] aint : p_242654_3_) {
            blockpos$mutable.setPos(pos.getX() + aint[0], pos.getY(), pos.getZ() + aint[1]);
            Vector3d vector3d = TransportationHelper.func_242379_a(type, collisionReader, blockpos$mutable, p_242654_4_);
            if (vector3d != null) {
                return Optional.of(vector3d);
            }
        }

        return Optional.empty();
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PART, OCCUPIED);
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        //TODO - nightmarebed tile
        return new TileEntityNightmareBed(NIGHTMARE_BED);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (!worldIn.isRemote) {
            BlockPos blockpos = pos.offset(state.get(HORIZONTAL_FACING));
            worldIn.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
            worldIn.func_230547_a_(pos, Blocks.AIR);
            state.updateNeighbours(worldIn, pos, 3);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        BlockPos blockpos = pos.offset(state.get(HORIZONTAL_FACING), state.get(PART) == BedPart.HEAD ? 0 : 1);
        return MathHelper.getCoordinateRandom(blockpos.getX(), pos.getY(), blockpos.getZ());
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    private static int[][] func_242656_a(Direction direction1, Direction direction2) {
        return ArrayUtils.addAll((int[][])func_242658_b(direction1, direction2), (int[][])func_242655_a(direction1));
    }

    private static int[][] func_242658_b(Direction direction1, Direction direction2) {
        return new int[][]{{direction2.getXOffset(), direction2.getZOffset()}, {direction2.getXOffset() - direction1.getXOffset(), direction2.getZOffset() - direction1.getZOffset()}, {direction2.getXOffset() - direction1.getXOffset() * 2, direction2.getZOffset() - direction1.getZOffset() * 2}, {-direction1.getXOffset() * 2, -direction1.getZOffset() * 2}, {-direction2.getXOffset() - direction1.getXOffset() * 2, -direction2.getZOffset() - direction1.getZOffset() * 2}, {-direction2.getXOffset() - direction1.getXOffset(), -direction2.getZOffset() - direction1.getZOffset()}, {-direction2.getXOffset(), -direction2.getZOffset()}, {-direction2.getXOffset() + direction1.getXOffset(), -direction2.getZOffset() + direction1.getZOffset()}, {direction1.getXOffset(), direction1.getZOffset()}, {direction2.getXOffset() + direction1.getXOffset(), direction2.getZOffset() + direction1.getZOffset()}};
    }

    private static int[][] func_242655_a(Direction direction) {
        return new int[][]{{0, 0}, {-direction.getXOffset(), -direction.getZOffset()}};
    }
}
