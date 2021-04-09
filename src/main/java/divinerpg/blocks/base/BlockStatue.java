package divinerpg.blocks.base;

import divinerpg.enums.*;
import divinerpg.tiles.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import javax.annotation.*;

public class BlockStatue extends BlockMod implements ITileEntityProvider {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public StatueType statueType;

    private SoundEvent statueSound;
    public BlockStatue(String name, StatueType statueType, SoundEvent soundIn) {
        super(name, AbstractBlock.Properties.of(Material.STONE).strength(6.0F, 6.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).noOcclusion());
        this.statueType = statueType;
        hasTileEntity(defaultBlockState());
        this.statueSound = soundIn;
    }

    @Override
    public boolean skipRendering(BlockState p_200122_1_, BlockState p_200122_2_, Direction p_200122_3_) {
        return true;
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntityStatue(this.statueType);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack stack) {
        world.setBlock(pos, state.setValue(FACING, player.getDirection().getOpposite()), 2);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, BlockState state) {
        if (!worldIn.isClientSide) {
            BlockState iblockstate = worldIn.getBlockState(pos.north());
            BlockState iblockstate1 = worldIn.getBlockState(pos.south());
            BlockState iblockstate2 = worldIn.getBlockState(pos.west());
            BlockState iblockstate3 = worldIn.getBlockState(pos.east());
            Direction enumfacing = state.getValue(FACING);

            if (enumfacing == Direction.NORTH) {
                enumfacing = Direction.SOUTH;
            } else if (enumfacing == Direction.SOUTH) {
                enumfacing = Direction.NORTH;
            } else if (enumfacing == Direction.WEST) {
                enumfacing = Direction.EAST;
            } else if (enumfacing == Direction.EAST) {
                enumfacing = Direction.WEST;
            }

            worldIn.setBlock(pos, state.setValue(FACING, enumfacing), 2);
        }
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult trace) {
        int hitX = trace.getBlockPos().getX(), hitY = trace.getBlockPos().getY(), hitZ = trace.getBlockPos().getZ();
        if (!player.isCrouching()) {
            if (this.statueSound != null) {
                world.playSound(null, pos, this.statueSound, SoundCategory.BLOCKS, 20.0F, 1.0F);
            }
        }
        return ActionResultType.PASS;
    }

//    @Override
//    @Deprecated
//    public BlockState mirror(BlockState state, Mirror mirror) {
//        return state.setValue(mirrorIn.toRotation(state.getValue(FACING)));
//    }
//
//    @Override
//    @Deprecated
//    public BlockState rotate(BlockState state, Rotation rot) {
//        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
//    }

    public static final VoxelShape WATCHER_AABB = VoxelShapes.create(new AxisAlignedBB(0.3F, 0.0F, 0.3F, 0.7F, 0.5F, 0.7F));
    public static final VoxelShape AYERACO_AABB = VoxelShapes.create(new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.4F, 0.8F));
    public static final VoxelShape TWILIGHT_DEMON_AABB = VoxelShapes.create(new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F));
    public static final VoxelShape VAMACHERON_AABB = VoxelShapes.create(new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.7F, 0.8F));
    public static final VoxelShape PARASECTA_AABB = VoxelShapes.create(new AxisAlignedBB(0.2F, 0.2F, 0.20F, 0.8F, 1.0F, 0.8F));
    public static final VoxelShape SOUL_FIEND_AABB = VoxelShapes.create(new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F));

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader source, BlockPos pos, ISelectionContext context) {

        if (statueType != null) {
            switch (this.statueType) {
                case RED_AYERACO_STATUE:
                case BLUE_AYERACO_STATUE:
                case GREEN_AYERACO_STATUE:
                case PURPLE_AYERACO_STATUE:
                case YELLOW_AYERACO_STATUE:
                    return AYERACO_AABB;

                case THE_WATCHER_STATUE:
                    return WATCHER_AABB;

                case TWILIGHT_DEMON_STATUE:
                    return TWILIGHT_DEMON_AABB;

                case VAMACHERON_STATUE:
                    return VAMACHERON_AABB;

                case PARASECTA_STATUE:
                    return PARASECTA_AABB;

                case SOUL_FIEND_STATUE:
                    return SOUL_FIEND_AABB;
            }
        }

        return VoxelShapes.block();
    }
}