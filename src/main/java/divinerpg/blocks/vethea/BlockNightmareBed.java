package divinerpg.blocks.vethea;

import divinerpg.registries.*;
import divinerpg.tiles.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.pathfinding.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import org.apache.commons.lang3.*;

import javax.annotation.*;
import java.util.*;

public class BlockNightmareBed extends HorizontalBlock implements ITileEntityProvider {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    protected static final VoxelShape BASE = Block.box(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D);
    protected static final VoxelShape LEG_NORTH_WEST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D);
    protected static final VoxelShape LEG_SOUTH_WEST = Block.box(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D);
    protected static final VoxelShape LEG_NORTH_EAST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D);
    protected static final VoxelShape LEG_SOUTH_EAST = Block.box(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_WEST, LEG_NORTH_EAST);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(BASE, LEG_SOUTH_WEST, LEG_SOUTH_EAST);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_WEST, LEG_SOUTH_WEST);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_EAST, LEG_SOUTH_EAST);
    private static TileEntityType<TileEntityNightmareBed> NIGHTMARE_BED = null;

    public BlockNightmareBed() {
        super(Properties.of(Material.CLOTH_DECORATION)
                .sound(SoundType.WOOL
                ));
        setRegistryName("nightmare_bed_block");
        NIGHTMARE_BED = TileRegistry.NIGHTMARE_BED;
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, BedPart.FOOT).setValue(OCCUPIED, Boolean.valueOf(false)));
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static Direction getBedOrientation(IBlockReader p_220174_0_, BlockPos p_220174_1_) {
        BlockState blockstate = p_220174_0_.getBlockState(p_220174_1_);
        return blockstate.getBlock() instanceof BlockNightmareBed ? blockstate.getValue(FACING) : null;
    }

    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!worldIn.isClientSide) {
        //TODO - vethean teleporter
    }
        return ActionResultType.PASS;
    }

    public static boolean canSetSpawn(World p_235330_0_) {
        return p_235330_0_.dimensionType().bedWorks();
    }

    private boolean kickVillagerOutOfBed(World p_226861_1_, BlockPos p_226861_2_) {
        List<VillagerEntity> list = p_226861_1_.getEntitiesOfClass(VillagerEntity.class, new AxisAlignedBB(p_226861_2_), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            list.get(0).stopSleeping();
            return true;
        }
    }

    public void fallOn(World p_180658_1_, BlockPos p_180658_2_, Entity p_180658_3_, float p_180658_4_) {
        super.fallOn(p_180658_1_, p_180658_2_, p_180658_3_, p_180658_4_ * 0.5F);
    }

    public void updateEntityAfterFallOn(IBlockReader p_176216_1_, Entity p_176216_2_) {
        if (p_176216_2_.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(p_176216_1_, p_176216_2_);
        } else {
            this.bounceUp(p_176216_2_);
        }

    }

    private void bounceUp(Entity p_226860_1_) {
        Vector3d vector3d = p_226860_1_.getDeltaMovement();
        if (vector3d.y < 0.0D) {
            double d0 = p_226860_1_ instanceof LivingEntity ? 1.0D : 0.8D;
            p_226860_1_.setDeltaMovement(vector3d.x, -vector3d.y * (double)0.66F * d0, vector3d.z);
        }

    }

    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (p_196271_2_ == getNeighbourDirection(p_196271_1_.getValue(PART), p_196271_1_.getValue(FACING))) {
            return p_196271_3_.is(this) && p_196271_3_.getValue(PART) != p_196271_1_.getValue(PART) ? p_196271_1_.setValue(OCCUPIED, p_196271_3_.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        }
    }

    private static Direction getNeighbourDirection(BedPart p_208070_0_, Direction p_208070_1_) {
        return p_208070_0_ == BedPart.FOOT ? p_208070_1_ : p_208070_1_.getOpposite();
    }

    public void playerWillDestroy(World p_176208_1_, BlockPos p_176208_2_, BlockState p_176208_3_, PlayerEntity p_176208_4_) {
        if (!p_176208_1_.isClientSide && p_176208_4_.isCreative()) {
            BedPart bedpart = p_176208_3_.getValue(PART);
            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = p_176208_2_.relative(getNeighbourDirection(bedpart, p_176208_3_.getValue(FACING)));
                BlockState blockstate = p_176208_1_.getBlockState(blockpos);
                if (blockstate.getBlock() == this && blockstate.getValue(PART) == BedPart.HEAD) {
                    p_176208_1_.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    p_176208_1_.levelEvent(p_176208_4_, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }

        super.playerWillDestroy(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        Direction direction = p_196258_1_.getHorizontalDirection();
        BlockPos blockpos = p_196258_1_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        return p_196258_1_.getLevel().getBlockState(blockpos1).canBeReplaced(p_196258_1_) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        Direction direction = getConnectedDirection(p_220053_1_).getOpposite();
        switch(direction) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return EAST_SHAPE;
        }
    }

    public static Direction getConnectedDirection(BlockState p_226862_0_) {
        Direction direction = p_226862_0_.getValue(FACING);
        return p_226862_0_.getValue(PART) == BedPart.HEAD ? direction.getOpposite() : direction;
    }

    @OnlyIn(Dist.CLIENT)
    public static TileEntityMerger.Type getBlockType(BlockState p_226863_0_) {
        BedPart bedpart = p_226863_0_.getValue(PART);
        return bedpart == BedPart.HEAD ? TileEntityMerger.Type.FIRST : TileEntityMerger.Type.SECOND;
    }

    private static boolean isBunkBed(IBlockReader p_242657_0_, BlockPos p_242657_1_) {
        return p_242657_0_.getBlockState(p_242657_1_.below()).getBlock() instanceof BlockNightmareBed;
    }

    public static Optional<Vector3d> findStandUpPosition(EntityType<?> p_242652_0_, ICollisionReader p_242652_1_, BlockPos p_242652_2_, float p_242652_3_) {
        Direction direction = p_242652_1_.getBlockState(p_242652_2_).getValue(FACING);
        Direction direction1 = direction.getClockWise();
        Direction direction2 = direction1.isFacingAngle(p_242652_3_) ? direction1.getOpposite() : direction1;
        if (isBunkBed(p_242652_1_, p_242652_2_)) {
            return findBunkBedStandUpPosition(p_242652_0_, p_242652_1_, p_242652_2_, direction, direction2);
        } else {
            int[][] aint = bedStandUpOffsets(direction, direction2);
            Optional<Vector3d> optional = findStandUpPositionAtOffset(p_242652_0_, p_242652_1_, p_242652_2_, aint, true);
            return optional.isPresent() ? optional : findStandUpPositionAtOffset(p_242652_0_, p_242652_1_, p_242652_2_, aint, false);
        }
    }

    private static Optional<Vector3d> findBunkBedStandUpPosition(EntityType<?> p_242653_0_, ICollisionReader p_242653_1_, BlockPos p_242653_2_, Direction p_242653_3_, Direction p_242653_4_) {
        int[][] aint = bedSurroundStandUpOffsets(p_242653_3_, p_242653_4_);
        Optional<Vector3d> optional = findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, p_242653_2_, aint, true);
        if (optional.isPresent()) {
            return optional;
        } else {
            BlockPos blockpos = p_242653_2_.below();
            Optional<Vector3d> optional1 = findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, blockpos, aint, true);
            if (optional1.isPresent()) {
                return optional1;
            } else {
                int[][] aint1 = bedAboveStandUpOffsets(p_242653_3_);
                Optional<Vector3d> optional2 = findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, p_242653_2_, aint1, true);
                if (optional2.isPresent()) {
                    return optional2;
                } else {
                    Optional<Vector3d> optional3 = findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, p_242653_2_, aint, false);
                    if (optional3.isPresent()) {
                        return optional3;
                    } else {
                        Optional<Vector3d> optional4 = findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, blockpos, aint, false);
                        return optional4.isPresent() ? optional4 : findStandUpPositionAtOffset(p_242653_0_, p_242653_1_, p_242653_2_, aint1, false);
                    }
                }
            }
        }
    }

    private static Optional<Vector3d> findStandUpPositionAtOffset(EntityType<?> p_242654_0_, ICollisionReader p_242654_1_, BlockPos p_242654_2_, int[][] p_242654_3_, boolean p_242654_4_) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int[] aint : p_242654_3_) {
            blockpos$mutable.set(p_242654_2_.getX() + aint[0], p_242654_2_.getY(), p_242654_2_.getZ() + aint[1]);
            Vector3d vector3d = TransportationHelper.findSafeDismountLocation(p_242654_0_, p_242654_1_, blockpos$mutable, p_242654_4_);
            if (vector3d != null) {
                return Optional.of(vector3d);
            }
        }

        return Optional.empty();
    }

    public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
        return PushReaction.DESTROY;
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING, PART, OCCUPIED);
    }

    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityNightmareBed();
    }

    public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        super.setPlacedBy(p_180633_1_, p_180633_2_, p_180633_3_, p_180633_4_, p_180633_5_);
        if (!p_180633_1_.isClientSide) {
            BlockPos blockpos = p_180633_2_.relative(p_180633_3_.getValue(FACING));
            p_180633_1_.setBlock(blockpos, p_180633_3_.setValue(PART, BedPart.HEAD), 3);
            p_180633_1_.blockUpdated(p_180633_2_, Blocks.AIR);
            p_180633_3_.updateNeighbourShapes(p_180633_1_, p_180633_2_, 3);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public long getSeed(BlockState p_209900_1_, BlockPos p_209900_2_) {
        BlockPos blockpos = p_209900_2_.relative(p_209900_1_.getValue(FACING), p_209900_1_.getValue(PART) == BedPart.HEAD ? 0 : 1);
        return MathHelper.getSeed(blockpos.getX(), p_209900_2_.getY(), blockpos.getZ());
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    private static int[][] bedStandUpOffsets(Direction p_242656_0_, Direction p_242656_1_) {
        return ArrayUtils.addAll((int[][])bedSurroundStandUpOffsets(p_242656_0_, p_242656_1_), (int[][])bedAboveStandUpOffsets(p_242656_0_));
    }

    private static int[][] bedSurroundStandUpOffsets(Direction p_242658_0_, Direction p_242658_1_) {
        return new int[][]{{p_242658_1_.getStepX(), p_242658_1_.getStepZ()}, {p_242658_1_.getStepX() - p_242658_0_.getStepX(), p_242658_1_.getStepZ() - p_242658_0_.getStepZ()}, {p_242658_1_.getStepX() - p_242658_0_.getStepX() * 2, p_242658_1_.getStepZ() - p_242658_0_.getStepZ() * 2}, {-p_242658_0_.getStepX() * 2, -p_242658_0_.getStepZ() * 2}, {-p_242658_1_.getStepX() - p_242658_0_.getStepX() * 2, -p_242658_1_.getStepZ() - p_242658_0_.getStepZ() * 2}, {-p_242658_1_.getStepX() - p_242658_0_.getStepX(), -p_242658_1_.getStepZ() - p_242658_0_.getStepZ()}, {-p_242658_1_.getStepX(), -p_242658_1_.getStepZ()}, {-p_242658_1_.getStepX() + p_242658_0_.getStepX(), -p_242658_1_.getStepZ() + p_242658_0_.getStepZ()}, {p_242658_0_.getStepX(), p_242658_0_.getStepZ()}, {p_242658_1_.getStepX() + p_242658_0_.getStepX(), p_242658_1_.getStepZ() + p_242658_0_.getStepZ()}};
    }

    private static int[][] bedAboveStandUpOffsets(Direction p_242655_0_) {
        return new int[][]{{0, 0}, {-p_242655_0_.getStepX(), -p_242655_0_.getStepZ()}};
    }
}