package divinerpg.blocks.vethea;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import net.minecraft.core.*;
import net.minecraft.core.dispenser.*;
import net.minecraft.server.level.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

import javax.annotation.*;
import java.util.*;

public class BlockKarosDispenser extends BaseEntityBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;
    private static final Map<Item, DispenseItemBehavior> DISPENSER_REGISTRY = Util.make(new Object2ObjectOpenHashMap<>(), (p_212564_0_) -> {
        p_212564_0_.defaultReturnValue(new DefaultDispenseItemBehavior());
    });

    public static void registerBehavior(ItemLike provider, DispenseItemBehavior behavior) {
        DISPENSER_REGISTRY.put(provider.asItem(), behavior);
    }

    public BlockKarosDispenser() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(-1, 3600000F));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TRIGGERED, Boolean.valueOf(false)));
    }

    public InteractionResult use(BlockState p_225533_1_, Level p_225533_2_, BlockPos p_225533_3_, Player p_225533_4_, InteractionHand p_225533_5_, BlockHitResult p_225533_6_) {
        if (p_225533_2_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = p_225533_2_.getBlockEntity(p_225533_3_);
            if (blockEntity instanceof DispenserBlockEntity) {
                p_225533_4_.openMenu((DispenserBlockEntity)blockEntity);
                if (blockEntity instanceof DropperBlockEntity) {
                    p_225533_4_.awardStat(Stats.INSPECT_DROPPER);
                } else {
                    p_225533_4_.awardStat(Stats.INSPECT_DISPENSER);
                }
            }

            return InteractionResult.CONSUME;
        }
    }

    public void dispenseFrom(ServerLevel world, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();
        BlockSourceImpl proxyblocksource = new BlockSourceImpl(world, pos);
        Direction direction = proxyblocksource.getBlockState().getValue(FACING);
        EntityDivineArrow var11 = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), world, ArrowType.KAROS_ARROW, var5 + 0.5D + direction.getStepX(), var7 + 0.5D, var9 + 0.5D + direction.getStepZ());
        var11.damageMin = var11.damageMax = 12;
        double var12 = world.random.nextDouble() * 0.1D + 0.9D;
        var11.setDeltaMovement((double)direction.getStepX() * var12, 0, (double)direction.getStepZ() * var12);
        var11.setDeltaMovement(var11.getDeltaMovement().x, var11.getDeltaMovement().y + 0, var11.getDeltaMovement().z);
        world.addFreshEntity(var11);
    }

    protected DispenseItemBehavior getDispenseMethod(ItemStack stack) {
        return DISPENSER_REGISTRY.get(stack.getItem());
    }

    public void neighborChanged(BlockState p_220069_1_, Level p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
        boolean flag = p_220069_2_.hasNeighborSignal(p_220069_3_) || p_220069_2_.hasNeighborSignal(p_220069_3_.above());
        boolean flag1 = p_220069_1_.getValue(TRIGGERED);
        if (flag && !flag1) {
            p_220069_2_.getBlockTicks().willTickThisTick(p_220069_3_, this);
            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(TRIGGERED, Boolean.valueOf(true)), 4);
        } else if (!flag && flag1) {
            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(TRIGGERED, Boolean.valueOf(false)), 4);
        }

    }

    public void tick(BlockState p_225534_1_, ServerLevel p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
        this.dispenseFrom(p_225534_2_, p_225534_3_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new DispenserBlockEntity(p_153215_, p_153216_);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getNearestLookingDirection().getOpposite());
    }

    public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        if (p_180633_5_.hasCustomHoverName()) {
            BlockEntity blockEntity = p_180633_1_.getBlockEntity(p_180633_2_);
            if (blockEntity instanceof DispenserBlockEntity) {
                ((DispenserBlockEntity)blockEntity).setCustomName(p_180633_5_.getHoverName());
            }
        }

    }

    @SuppressWarnings("deprecation")
	public void onRemove(BlockState p_196243_1_, Level p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            BlockEntity blockEntity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (blockEntity instanceof DispenserBlockEntity) {
                Containers.dropContents(p_196243_2_, p_196243_3_, (DispenserBlockEntity)blockEntity);
                p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, this);
            }

            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
        }
    }

    public static Position getDispensePosition(BlockSource p_149939_0_) {
        Direction direction = p_149939_0_.getBlockState().getValue(FACING);
        double d0 = p_149939_0_.x() + 0.7D * (double)direction.getStepX();
        double d1 = p_149939_0_.y() + 0.7D * (double)direction.getStepY();
        double d2 = p_149939_0_.z() + 0.7D * (double)direction.getStepZ();
        return new PositionImpl(d0, d1, d2);
    }

    public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState p_180641_1_, Level p_180641_2_, BlockPos p_180641_3_) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(p_180641_2_.getBlockEntity(p_180641_3_));
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING, TRIGGERED);
    }
}