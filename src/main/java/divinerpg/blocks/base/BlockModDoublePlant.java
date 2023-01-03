package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.util.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.*;

import javax.annotation.*;
import java.util.function.*;

public class BlockModDoublePlant extends DoublePlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private Supplier<Block> grassSupplier;

    public BlockModDoublePlant(Supplier<Block> grassSupplier, MaterialColor colour) {
        super(BlockBehaviour.Properties.of(Material.PLANT, colour).noOcclusion().instabreak().sound(SoundType.ROOTS).noCollission().randomTicks());
        this.grassSupplier = grassSupplier;
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, LevelAccessor p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        DoubleBlockHalf doubleblockhalf = p_196271_1_.getValue(HALF);
        if (p_196271_2_.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (p_196271_2_ == Direction.UP) || p_196271_3_.is(this) && p_196271_3_.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && p_196271_2_ == Direction.DOWN && !p_196271_1_.canSurvive(p_196271_4_, p_196271_5_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        BlockPos blockpos = p_196258_1_.getClickedPos();
        return blockpos.getY() < 255 && p_196258_1_.getLevel().getBlockState(blockpos.above()).canBeReplaced(p_196258_1_) ? super.getStateForPlacement(p_196258_1_) : null;
    }

    public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        p_180633_1_.setBlock(p_180633_2_.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(state, level, pos);
        } else {
            BlockState blockstate = level.getBlockState(pos.below());
            if (state.getBlock() != this) return super.canSurvive(state, level, pos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public void placeAt(LevelAccessor p_196390_1_, BlockPos p_196390_2_, int p_196390_3_) {
        p_196390_1_.setBlock(p_196390_2_, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER), p_196390_3_);
        p_196390_1_.setBlock(p_196390_2_.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), p_196390_3_);
    }

    public void playerWillDestroy(Level p_176208_1_, BlockPos p_176208_2_, BlockState p_176208_3_, Player p_176208_4_) {
        if (!p_176208_1_.isClientSide) {
            if (p_176208_4_.isCreative()) {
                preventCreativeDropFromBottomPart(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
            } else {
                dropResources(p_176208_3_, p_176208_1_, p_176208_2_, (BlockEntity)null, p_176208_4_, p_176208_4_.getMainHandItem());
            }
        }

        super.playerWillDestroy(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
    }

    public void playerDestroy(Level p_180657_1_, Player p_180657_2_, BlockPos p_180657_3_, BlockState p_180657_4_, @Nullable BlockEntity p_180657_5_, ItemStack p_180657_6_) {
        super.playerDestroy(p_180657_1_, p_180657_2_, p_180657_3_, Blocks.AIR.defaultBlockState(), p_180657_5_, p_180657_6_);
    }

    protected static void preventCreativeDropFromBottomPart(Level p_241471_0_, BlockPos p_241471_1_, BlockState p_241471_2_, Player p_241471_3_) {
        DoubleBlockHalf doubleblockhalf = p_241471_2_.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = p_241471_1_.below();
            BlockState blockstate = p_241471_0_.getBlockState(blockpos);
            if (blockstate.getBlock() == p_241471_2_.getBlock() && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                p_241471_0_.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                p_241471_0_.levelEvent(p_241471_3_, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return super.mayPlaceOn(state, worldIn, pos) || !worldIn.getBlockState(pos.below()).isAir() && worldIn.getBlockState(pos.below()).getBlock() != this && soil.getBlock() == grassSupplier.get();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(HALF);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    @OnlyIn(Dist.CLIENT)
    public long getSeed(BlockState p_209900_1_, BlockPos p_209900_2_) {
        return Mth.getSeed(p_209900_2_.getX(), p_209900_2_.below(p_209900_1_.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), p_209900_2_.getZ());
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }


}