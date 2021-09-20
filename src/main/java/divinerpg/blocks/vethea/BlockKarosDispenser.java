package divinerpg.blocks.vethea;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.dispenser.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class BlockKarosDispenser extends ContainerBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;
    private static final Map<Item, IDispenseItemBehavior> DISPENSER_REGISTRY = Util.make(new Object2ObjectOpenHashMap<>(), (p_212564_0_) -> {
        p_212564_0_.defaultReturnValue(new DefaultDispenseItemBehavior());
    });

    public static void registerBehavior(IItemProvider provider, IDispenseItemBehavior behavior) {
        DISPENSER_REGISTRY.put(provider.asItem(), behavior);
    }

    public BlockKarosDispenser(String name) {
        super(AbstractBlock.Properties.of(Material.STONE).strength(-1, 6000000F));
        setRegistryName(name);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TRIGGERED, Boolean.valueOf(false)));
    }

    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (p_225533_2_.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
            if (tileentity instanceof DispenserTileEntity) {
                p_225533_4_.openMenu((DispenserTileEntity)tileentity);
                if (tileentity instanceof DropperTileEntity) {
                    p_225533_4_.awardStat(Stats.INSPECT_DROPPER);
                } else {
                    p_225533_4_.awardStat(Stats.INSPECT_DISPENSER);
                }
            }

            return ActionResultType.CONSUME;
        }
    }

    public void dispenseFrom(ServerWorld world, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();
        ProxyBlockSource proxyblocksource = new ProxyBlockSource(world, pos);
        Direction direction = proxyblocksource.getBlockState().getValue(FACING);
        EntityDivineArrow var11 = new EntityDivineArrow(EntityRegistry.ARROW_SHOT, world, ArrowType.KAROS_ARROW, var5 + 0.5D + direction.getStepX(), var7 + 0.5D, var9 + 0.5D + direction.getStepZ());
        var11.damageMin = var11.damageMax = 12;
        double var12 = world.random.nextDouble() * 0.1D + 0.9D;
        var11.setDeltaMovement((double)direction.getStepX() * var12, 0, (double)direction.getStepZ() * var12);
        var11.setDeltaMovement(var11.getDeltaMovement().x, var11.getDeltaMovement().y + 0, var11.getDeltaMovement().z);
        world.addFreshEntity(var11);
    }

    protected IDispenseItemBehavior getDispenseMethod(ItemStack stack) {
        return DISPENSER_REGISTRY.get(stack.getItem());
    }

    public void neighborChanged(BlockState p_220069_1_, World p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
        boolean flag = p_220069_2_.hasNeighborSignal(p_220069_3_) || p_220069_2_.hasNeighborSignal(p_220069_3_.above());
        boolean flag1 = p_220069_1_.getValue(TRIGGERED);
        if (flag && !flag1) {
            p_220069_2_.getBlockTicks().scheduleTick(p_220069_3_, this, 4);
            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(TRIGGERED, Boolean.valueOf(true)), 4);
        } else if (!flag && flag1) {
            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(TRIGGERED, Boolean.valueOf(false)), 4);
        }

    }

    public void tick(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
        this.dispenseFrom(p_225534_2_, p_225534_3_);
    }

    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new DispenserTileEntity();
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getNearestLookingDirection().getOpposite());
    }

    public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        if (p_180633_5_.hasCustomHoverName()) {
            TileEntity tileentity = p_180633_1_.getBlockEntity(p_180633_2_);
            if (tileentity instanceof DispenserTileEntity) {
                ((DispenserTileEntity)tileentity).setCustomName(p_180633_5_.getHoverName());
            }
        }

    }

    public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (tileentity instanceof DispenserTileEntity) {
                InventoryHelper.dropContents(p_196243_2_, p_196243_3_, (DispenserTileEntity)tileentity);
                p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, this);
            }

            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
        }
    }

    public static IPosition getDispensePosition(IBlockSource p_149939_0_) {
        Direction direction = p_149939_0_.getBlockState().getValue(FACING);
        double d0 = p_149939_0_.x() + 0.7D * (double)direction.getStepX();
        double d1 = p_149939_0_.y() + 0.7D * (double)direction.getStepY();
        double d2 = p_149939_0_.z() + 0.7D * (double)direction.getStepZ();
        return new Position(d0, d1, d2);
    }

    public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState p_180641_1_, World p_180641_2_, BlockPos p_180641_3_) {
        return Container.getRedstoneSignalFromBlockEntity(p_180641_2_.getBlockEntity(p_180641_3_));
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING, TRIGGERED);
    }
}