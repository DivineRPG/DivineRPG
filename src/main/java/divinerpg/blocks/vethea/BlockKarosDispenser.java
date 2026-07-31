package divinerpg.blocks.vethea;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.KarosDispenser;
import divinerpg.entities.projectile.arrows.KarosArrow;
import divinerpg.registries.ItemRegistry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.entity.DropperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Map;

public class BlockKarosDispenser extends BaseEntityBlock {
    public static final MapCodec<BlockKarosDispenser> CODEC = simpleCodec(BlockKarosDispenser::new);
    public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;

    private static final Map<Item, DispenseItemBehavior> DISPENSER_REGISTRY = Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.defaultReturnValue(new DefaultDispenseItemBehavior());
    });

    public static void registerBehavior(ItemLike provider, DispenseItemBehavior behavior) {
        DISPENSER_REGISTRY.put(provider.asItem(), behavior);
    }

    public BlockKarosDispenser(Properties properties) {
        super(properties.mapColor(MapColor.PLANT)
                .strength(-1.0F, 3600000.0F)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .noLootTable());
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TRIGGERED, false));
    }

    @Override
    public MapCodec<BlockKarosDispenser> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof DispenserBlockEntity dispenser) {
                player.openMenu(dispenser);
                if (blockEntity instanceof DropperBlockEntity) {
                    player.awardStat(Stats.INSPECT_DROPPER);
                } else {
                    player.awardStat(Stats.INSPECT_DISPENSER);
                }
            }
            return InteractionResult.CONSUME;
        }
    }

    public void dispenseFrom(ServerLevel level, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        Direction direction = level.getBlockState(pos).getValue(FACING);

        KarosArrow arrow = new KarosArrow(level, x + 0.5D + direction.getStepX(), y + 0.5D, z + 0.5D + direction.getStepZ(), new ItemStack(ItemRegistry.karos_arrow.get()), null);
        arrow.powerMultiplier = 1.7143F;

        double speedMod = level.getRandom().nextDouble() * 0.1D + 0.9D;
        arrow.setDeltaMovement((double) direction.getStepX() * speedMod, 0, (double) direction.getStepZ() * speedMod);

        level.addFreshEntity(arrow);
    }

    protected DispenseItemBehavior getDispenseMethod(ItemStack stack) {
        return DISPENSER_REGISTRY.get(stack.getItem());
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());
        boolean isTriggered = state.getValue(TRIGGERED);

        if (hasSignal && !isTriggered) {
            level.scheduleTick(pos, this, 4);
            level.setBlock(pos, state.setValue(TRIGGERED, true), 4);
        } else if (!hasSignal && isTriggered) {
            level.setBlock(pos, state.setValue(TRIGGERED, false), 4);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.dispenseFrom(level, pos);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KarosDispenser(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    public static Position getDispensePosition(BlockSource source) {
        Direction direction = source.state().getValue(FACING);
        double x = source.pos().getX() + 0.7D * (double) direction.getStepX();
        double y = source.pos().getY() + 0.7D * (double) direction.getStepY();
        double z = source.pos().getZ() + 0.7D * (double) direction.getStepZ();
        return new Vec3(x, y, z);
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TRIGGERED);
    }
}