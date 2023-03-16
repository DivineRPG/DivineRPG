package divinerpg.blocks.iceika;

import com.google.common.annotations.VisibleForTesting;
import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.*;

public class BlockIcicle extends Block implements Fallable, SimpleWaterloggedBlock {
    public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
//    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
//    private static final int DELAY_BEFORE_FALLING = 2;
//    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02F;
//    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12F;
//    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
//    private static final float WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.17578125F;
//    private static final float LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.05859375F;
//    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE = 0.6D;
//    private static final float STALACTITE_DAMAGE_PER_FALL_DISTANCE_AND_SIZE = 1.0F;
//    private static final int STALACTITE_MAX_DAMAGE = 40;
//    private static final int MAX_STALACTITE_HEIGHT_FOR_DAMAGE_CALCULATION = 6;
//    private static final float STALAGMITE_FALL_DISTANCE_OFFSET = 2.0F;
//    private static final int STALAGMITE_FALL_DAMAGE_MODIFIER = 2;
//    private static final float AVERAGE_DAYS_PER_GROWTH = 5.0F;
//    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778F;
//    private static final int MAX_GROWTH_LENGTH = 7;
//    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
//    private static final float STALACTITE_DRIP_START_PIXEL = 0.6875F;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
//    private static final float MAX_HORIZONTAL_OFFSET = 0.125F;
//    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public BlockIcicle() {
        super(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.TERRACOTTA_WHITE).noOcclusion().sound(SoundType.GLASS).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
        this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP).setValue(THICKNESS, DripstoneThickness.TIP).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_154157_) {
        p_154157_.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    public boolean canSurvive(BlockState p_154137_, LevelReader p_154138_, BlockPos p_154139_) {
        return isValidPointedDripstonePlacement(p_154138_, p_154139_, p_154137_.getValue(TIP_DIRECTION));
    }

    public BlockState updateShape(BlockState p_154147_, Direction p_154148_, BlockState p_154149_, LevelAccessor p_154150_, BlockPos p_154151_, BlockPos p_154152_) {
        if (p_154147_.getValue(WATERLOGGED)) {
            p_154150_.scheduleTick(p_154151_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154150_));
        }

        if (p_154148_ != Direction.UP && p_154148_ != Direction.DOWN) {
            return p_154147_;
        } else {
            Direction direction = p_154147_.getValue(TIP_DIRECTION);
            if (direction == Direction.DOWN && p_154150_.getBlockTicks().hasScheduledTick(p_154151_, this)) {
                return p_154147_;
            } else if (p_154148_ == direction.getOpposite() && !this.canSurvive(p_154147_, p_154150_, p_154151_)) {
                if (direction == Direction.DOWN) {
                    p_154150_.scheduleTick(p_154151_, this, 2);
                } else {
                    p_154150_.scheduleTick(p_154151_, this, 1);
                }

                return p_154147_;
            } else {
                boolean flag = p_154147_.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness dripstonethickness = calculateDripstoneThickness(p_154150_, p_154151_, direction, flag);
                return p_154147_.setValue(THICKNESS, dripstonethickness);
            }
        }
    }

    public void onProjectileHit(Level p_154042_, BlockState p_154043_, BlockHitResult p_154044_, Projectile p_154045_) {
        BlockPos blockpos = p_154044_.getBlockPos();
        if (!p_154042_.isClientSide && p_154045_.mayInteract(p_154042_, blockpos) && p_154045_ instanceof ThrownTrident && p_154045_.getDeltaMovement().length() > 0.6D) {
            p_154042_.destroyBlock(blockpos, true);
        }

    }

    public void fallOn(Level p_154047_, BlockState p_154048_, BlockPos p_154049_, Entity p_154050_, float p_154051_) {
        if (p_154048_.getValue(TIP_DIRECTION) == Direction.UP && p_154048_.getValue(THICKNESS) == DripstoneThickness.TIP) {
            p_154050_.causeFallDamage(p_154051_ + 2.0F, 2.0F, p_154047_.damageSources().stalagmite());
        } else {
            super.fallOn(p_154047_, p_154048_, p_154049_, p_154050_, p_154051_);
        }

    }

    public void tick(BlockState p_221865_, ServerLevel p_221866_, BlockPos p_221867_, RandomSource p_221868_) {
        if (isStalagmite(p_221865_) && !this.canSurvive(p_221865_, p_221866_, p_221867_)) {
            p_221866_.destroyBlock(p_221867_, true);
        } else {
            spawnFallingStalactite(p_221865_, p_221866_, p_221867_);
        }

        if(p_221868_.nextBoolean()){
            randomTick(p_221865_, p_221866_, p_221867_, p_221868_);
        }

    }

    public void randomTick(BlockState p_221883_, ServerLevel p_221884_, BlockPos p_221885_, RandomSource p_221886_) {
        if (p_221886_.nextFloat() < 0.011377778F && isStalactiteStartPos(p_221883_, p_221884_, p_221885_)) {
            growStalactiteOrStalagmiteIfPossible(p_221883_, p_221884_, p_221885_, p_221886_);
        }

    }



    public PushReaction getPistonPushReaction(BlockState p_154237_) {
        return PushReaction.DESTROY;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_154040_) {
        LevelAccessor levelaccessor = p_154040_.getLevel();
        BlockPos blockpos = p_154040_.getClickedPos();
        Direction direction = p_154040_.getNearestLookingVerticalDirection().getOpposite();
        Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
        if (direction1 == null) {
            return null;
        } else {
            boolean flag = !p_154040_.isSecondaryUseActive();
            DripstoneThickness dripstonethickness = calculateDripstoneThickness(levelaccessor, blockpos, direction1, flag);
            return dripstonethickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction1).setValue(THICKNESS, dripstonethickness).setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER));
        }
    }

    public FluidState getFluidState(BlockState p_154235_) {
        return p_154235_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    public VoxelShape getOcclusionShape(BlockState p_154170_, BlockGetter p_154171_, BlockPos p_154172_) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState p_154117_, BlockGetter p_154118_, BlockPos p_154119_, CollisionContext p_154120_) {
        DripstoneThickness dripstonethickness = p_154117_.getValue(THICKNESS);
        VoxelShape voxelshape;
        if (dripstonethickness == DripstoneThickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.TIP) {
            if (p_154117_.getValue(TIP_DIRECTION) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (dripstonethickness == DripstoneThickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3 vec3 = p_154117_.getOffset(p_154118_, p_154119_);
        return voxelshape.move(vec3.x, 0.0D, vec3.z);
    }

    public boolean isCollisionShapeFullBlock(BlockState p_181235_, BlockGetter p_181236_, BlockPos p_181237_) {
        return false;
    }

    public float getMaxHorizontalOffset() {
        return 0.125F;
    }

    public void onBrokenAfterFall(Level p_154059_, BlockPos p_154060_, FallingBlockEntity p_154061_) {
        if (!p_154061_.isSilent()) {
            p_154059_.levelEvent(1045, p_154060_, 0);
        }

    }


    public DamageSource getFallDamageSource(Entity entity) {
        return entity.level.damageSources().stalagmite();
    }

    public Predicate<Entity> getHurtsEntitySelector() {
        return EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
    }

    private static void spawnFallingStalactite(BlockState p_154098_, ServerLevel p_154099_, BlockPos p_154100_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_154100_.mutable();

        for(BlockState blockstate = p_154098_; isStalactite(blockstate); blockstate = p_154099_.getBlockState(blockpos$mutableblockpos)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(p_154099_, blockpos$mutableblockpos, blockstate);
            if (isTip(blockstate, true)) {
                int i = Math.max(1 + p_154100_.getY() - blockpos$mutableblockpos.getY(), 6);
                float f = 1.0F * (float)i;
                fallingblockentity.setHurtsEntities(f, 40);
                break;
            }

            blockpos$mutableblockpos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState p_221888_, ServerLevel p_221889_, BlockPos p_221890_, RandomSource p_221891_) {
        BlockState blockstate = p_221889_.getBlockState(p_221890_.above(1));
        BlockState blockstate1 = p_221889_.getBlockState(p_221890_.above(2));
        if (canGrow(blockstate, blockstate1)) {
            BlockPos blockpos = findTip(p_221888_, p_221889_, p_221890_, 7, false);
            if (blockpos != null) {
                BlockState blockstate2 = p_221889_.getBlockState(blockpos);
                if (canTipGrow(blockstate2, p_221889_, blockpos)) {
                    if (p_221891_.nextBoolean()) {
                        grow(p_221889_, blockpos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(p_221889_, blockpos);
                    }

                }

            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel p_154033_, BlockPos p_154034_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_154034_.mutable();

        for(int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = p_154033_.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, p_154033_, blockpos$mutableblockpos)) {
                grow(p_154033_, blockpos$mutableblockpos, Direction.UP);
                return;
            }

            if (isValidPointedDripstonePlacement(p_154033_, blockpos$mutableblockpos, Direction.UP) && !p_154033_.isWaterAt(blockpos$mutableblockpos.below())) {
                grow(p_154033_, blockpos$mutableblockpos.below(), Direction.UP);
                return;
            }
        }

    }

    private static void grow(ServerLevel p_154036_, BlockPos p_154037_, Direction p_154038_) {
        BlockPos blockpos = p_154037_.relative(p_154038_);
        BlockState blockstate = p_154036_.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, p_154038_.getOpposite())) {
            createMergedTips(blockstate, p_154036_, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            createDripstone(p_154036_, blockpos, p_154038_, DripstoneThickness.TIP);
        }

    }

    private static void createDripstone(LevelAccessor p_154088_, BlockPos p_154089_, Direction p_154090_, DripstoneThickness p_154091_) {
        BlockState blockstate = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")).defaultBlockState().setValue(TIP_DIRECTION, p_154090_).setValue(THICKNESS, p_154091_).setValue(WATERLOGGED, Boolean.valueOf(p_154088_.getFluidState(p_154089_).getType() == Fluids.WATER));
        p_154088_.setBlock(p_154089_, blockstate, 3);
    }

    private static void createMergedTips(BlockState p_154231_, LevelAccessor p_154232_, BlockPos p_154233_) {
        BlockPos blockpos;
        BlockPos blockpos1;
        if (p_154231_.getValue(TIP_DIRECTION) == Direction.UP) {
            blockpos1 = p_154233_;
            blockpos = p_154233_.above();
        } else {
            blockpos = p_154233_;
            blockpos1 = p_154233_.below();
        }

        createDripstone(p_154232_, blockpos, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createDripstone(p_154232_, blockpos1, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    @Nullable
    private static BlockPos findTip(BlockState p_154131_, LevelAccessor p_154132_, BlockPos p_154133_, int p_154134_, boolean p_154135_) {
        if (isTip(p_154131_, p_154135_)) {
            return p_154133_;
        } else {
            Direction direction = p_154131_.getValue(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> bipredicate = (p_202023_, p_202024_) -> {
                return p_202024_.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle"))) && p_202024_.getValue(TIP_DIRECTION) == direction;
            };
            return findBlockVertical(p_154132_, p_154133_, direction.getAxisDirection(), bipredicate, (p_154168_) -> {
                return isTip(p_154168_, p_154135_);
            }, p_154134_).orElse((BlockPos)null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader p_154191_, BlockPos p_154192_, Direction p_154193_) {
        Direction direction;
        if (isValidPointedDripstonePlacement(p_154191_, p_154192_, p_154193_)) {
            direction = p_154193_;
        } else {
            if (!isValidPointedDripstonePlacement(p_154191_, p_154192_, p_154193_.getOpposite())) {
                return null;
            }

            direction = p_154193_.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateDripstoneThickness(LevelReader p_154093_, BlockPos p_154094_, Direction p_154095_, boolean p_154096_) {
        Direction direction = p_154095_.getOpposite();
        BlockState blockstate = p_154093_.getBlockState(p_154094_.relative(p_154095_));
        if (isPointedDripstoneWithDirection(blockstate, direction)) {
            return !p_154096_ && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isPointedDripstoneWithDirection(blockstate, p_154095_)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness dripstonethickness = blockstate.getValue(THICKNESS);
            if (dripstonethickness != DripstoneThickness.TIP && dripstonethickness != DripstoneThickness.TIP_MERGE) {
                BlockState blockstate1 = p_154093_.getBlockState(p_154094_.relative(direction));
                return !isPointedDripstoneWithDirection(blockstate1, p_154095_) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    private static boolean canTipGrow(BlockState p_154195_, ServerLevel p_154196_, BlockPos p_154197_) {
        Direction direction = p_154195_.getValue(TIP_DIRECTION);
        BlockPos blockpos = p_154197_.relative(direction);
        BlockState blockstate = p_154196_.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() ? true : isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static boolean isValidPointedDripstonePlacement(LevelReader p_154222_, BlockPos p_154223_, Direction p_154224_) {
        BlockPos blockpos = p_154223_.relative(p_154224_.getOpposite());
        BlockState blockstate = p_154222_.getBlockState(blockpos);
        return blockstate.isFaceSturdy(p_154222_, blockpos, p_154224_) || isPointedDripstoneWithDirection(blockstate, p_154224_);
    }

    private static boolean isTip(BlockState p_154154_, boolean p_154155_) {
        if (!p_154154_.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")))) {
            return false;
        } else {
            DripstoneThickness dripstonethickness = p_154154_.getValue(THICKNESS);
            return dripstonethickness == DripstoneThickness.TIP || p_154155_ && dripstonethickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState p_154144_, Direction p_154145_) {
        return isTip(p_154144_, false) && p_154144_.getValue(TIP_DIRECTION) == p_154145_;
    }

    private static boolean isStalactite(BlockState p_154241_) {
        return isPointedDripstoneWithDirection(p_154241_, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState p_154243_) {
        return isPointedDripstoneWithDirection(p_154243_, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState p_154204_, LevelReader p_154205_, BlockPos p_154206_) {
        return isStalactite(p_154204_) && !p_154205_.getBlockState(p_154206_.above()).is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")));
    }

    public boolean isPathfindable(BlockState p_154112_, BlockGetter p_154113_, BlockPos p_154114_, PathComputationType p_154115_) {
        return false;
    }

    private static boolean isPointedDripstoneWithDirection(BlockState p_154208_, Direction p_154209_) {
        return p_154208_.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle"))) && p_154208_.getValue(TIP_DIRECTION) == p_154209_;
    }

    private static boolean canGrow(BlockState p_154141_, BlockState p_154142_) {
        return p_154141_.is(BlockTags.ICE) || p_154142_.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")));
    }


    private static Optional<BlockPos> findBlockVertical(LevelAccessor p_202007_, BlockPos p_202008_, Direction.AxisDirection p_202009_, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
        Direction direction = Direction.get(p_202009_, Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_202008_.mutable();

        for(int i = 1; i < p_202012_; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = p_202007_.getBlockState(blockpos$mutableblockpos);
            if (p_202011_.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }

            if (p_202007_.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !p_202010_.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }


}