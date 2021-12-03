package divinerpg.blocks.vethea;

import divinerpg.registries.*;
import divinerpg.tiles.*;
import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
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

import javax.annotation.*;

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

    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide) {
            if (worldIn.dimension().getRegistryName() == Dimension.OVERWORLD.getRegistryName()) {
                if (worldIn.getLightEmission(pos) < 7) {
                    player.changeDimension(player.getServer().getLevel(KeyRegistry.VETHEA_WORLD), new VetheaTeleporter(worldIn.getServer().getLevel(KeyRegistry.VETHEA_WORLD)));
                } else {
                    player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.nightmare_bed.restrict"), player.getUUID());
                }
            } else {
                player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.nightmare_bed.overworld_only"), player.getUUID());
            }
        }

        return ActionResultType.PASS;
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

}