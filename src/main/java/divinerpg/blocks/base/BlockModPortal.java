package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public class BlockModPortal extends BlockMod {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public BlockModPortal(String name) {
        super(name, AbstractBlock.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((p_235463_0_) -> {
            return 11;
        }));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch((Direction.Axis)p_220053_1_.getValue(AXIS)) {
            case Z:
                return Z_AXIS_AABB;
            case X:
            default:
                return X_AXIS_AABB;
        }
    }


    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        Direction.Axis direction$axis = p_196271_2_.getAxis();
        Direction.Axis direction$axis1 = p_196271_1_.getValue(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && !p_196271_3_.is(this) && !(new PortalSize(p_196271_4_, p_196271_5_, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }

    public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        if (!p_196262_4_.isPassenger() && !p_196262_4_.isVehicle() && p_196262_4_.canChangeDimensions()) {
            //TODO - handle portal
//            p_196262_4_.handleInsidePortal(p_196262_3_);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        if (p_180655_4_.nextInt(100) == 0) {
            p_180655_2_.playLocalSound((double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, p_180655_4_.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double d0 = (double)p_180655_3_.getX() + p_180655_4_.nextDouble();
            double d1 = (double)p_180655_3_.getY() + p_180655_4_.nextDouble();
            double d2 = (double)p_180655_3_.getZ() + p_180655_4_.nextDouble();
            double d3 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
            int j = p_180655_4_.nextInt(2) * 2 - 1;
            if (!p_180655_2_.getBlockState(p_180655_3_.west()).is(this) && !p_180655_2_.getBlockState(p_180655_3_.east()).is(this)) {
                d0 = (double)p_180655_3_.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
            } else {
                d2 = (double)p_180655_3_.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
            }

            p_180655_2_.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

    }

    public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return ItemStack.EMPTY;
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        switch(p_185499_2_) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch((Direction.Axis)p_185499_1_.getValue(AXIS)) {
                    case Z:
                        return p_185499_1_.setValue(AXIS, Direction.Axis.X);
                    case X:
                        return p_185499_1_.setValue(AXIS, Direction.Axis.Z);
                    default:
                        return p_185499_1_;
                }
            default:
                return p_185499_1_;
        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AXIS);
    }
}
