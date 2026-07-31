package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import org.apache.commons.lang3.tuple.*;

import java.util.*;
import java.util.function.Predicate;

public class InserterBlockEntity extends BlockEntity implements Hopper {
    private ItemStack stack = ItemStack.EMPTY;
    protected int cooldown = 6;
    protected Direction facing = Direction.NORTH;

    public InserterBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityRegistry.INSERTER.get(), pos, state);
    }

    public InserterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.facing = state.hasProperty(BlockStateProperties.FACING)
                ? state.getValue(BlockStateProperties.FACING)
                : Direction.NORTH;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setBlockState(BlockState blockState) {
        super.setBlockState(blockState);
        facing = blockState.getValue(BlockStateProperties.FACING);
    }

    @SuppressWarnings("deprecation")
    protected void oldSetBlockState(BlockState state) {
        super.setBlockState(state);
    }

    @Override
    public boolean isGridAligned() {
        return false;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, InserterBlockEntity block) {
        if (!block.isEmpty() && state.getValue(BlockStateProperties.ENABLED)) {
            if (block.cooldown < 1) {
                if (ejectItems(level, pos, block, block.facing)) block.cooldown = 6;
            } else {
                block.cooldown--;
            }
        }
    }

    public static boolean ejectItems(Level level, BlockPos pos, Hopper blockEntity, Direction facing) {
        if (insertHook(level, pos, facing, blockEntity)) return true;
        Container container = getAttachedContainer(level, pos, facing);
        if (container == null) return false;
        Direction direction = facing.getOpposite();
        if (isFullContainer(container, direction)) return false;
        ItemStack itemstack = blockEntity.getItem(0);
        if (!itemstack.isEmpty()) {
            int j = itemstack.getCount();
            ItemStack itemstack1 = HopperBlockEntity.addItem(blockEntity, container, blockEntity.removeItem(0, 1), direction);
            if (itemstack1.isEmpty()) {
                container.setChanged();
                return true;
            }
            itemstack.setCount(j);
            if (j == 1) blockEntity.setItem(0, itemstack);
        }
        return false;
    }

    public static Container getAttachedContainer(Level level, BlockPos pos, Direction facing) {
        return HopperBlockEntity.getContainerAt(level, pos.relative(facing));
    }

    static boolean insertHook(Level level, BlockPos pos, Direction facing, Hopper hopper) {
        return getAttachedItemHandler(level, pos, facing).map((destinationResult) -> {
            ResourceHandler<ItemResource> itemHandler = destinationResult.getKey();
            if (isFull(itemHandler)) return false;
            ItemStack currentStack = hopper.getItem(0);
            if (!currentStack.isEmpty()) {
                ItemStack originalSlotContents = currentStack.copy();
                ItemStack insertStack = hopper.removeItem(0, 1);

                int remaining = putStackInInventoryAllSlots(itemHandler, insertStack);
                if (remaining == 0) return true;

                hopper.setItem(0, originalSlotContents);
            }
            return false;
        }).orElse(false);
    }

    public static int putStackInInventoryAllSlots(ResourceHandler<ItemResource> destInventory, ItemStack stack) {
        if (stack.isEmpty()) return 0;
        ItemResource resource = ItemResource.of(stack);
        int remainingToInsert = stack.getCount();

        try (Transaction tx = Transaction.openRoot()) {
            for (int slot = 0; slot < destInventory.size() && remainingToInsert > 0; slot++) {
                int inserted = destInventory.insert(slot, resource, remainingToInsert, tx);
                remainingToInsert -= inserted;
            }
            if (remainingToInsert < stack.getCount()) {
                tx.commit();
            }
        }

        return remainingToInsert;
    }

    public static boolean isFull(ResourceHandler<ItemResource> itemHandler) {
        for (int slot = 0; slot < itemHandler.size(); ++slot) {
            ItemResource res = itemHandler.getResource(slot);
            int amount = itemHandler.getAmountAsInt(slot);
            int capacity = itemHandler.getCapacityAsInt(slot, res);
            if (res.isEmpty() || amount < capacity) return false;
        }
        return true;
    }

    public static Optional<Pair<ResourceHandler<ItemResource>, Object>> getAttachedItemHandler(Level level, BlockPos pos, Direction direction) {
        return getItemHandlerAt(level, pos.getX() + direction.getStepX() + .5, pos.getY() + direction.getStepY() + .5, pos.getZ() + direction.getStepZ() + .5, direction.getOpposite());
    }

    static Optional<Pair<ResourceHandler<ItemResource>, Object>> getItemHandlerAt(Level worldIn, double x, double y, double z, Direction side) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        BlockState state = worldIn.getBlockState(blockpos);
        BlockEntity blockEntity = state.hasBlockEntity() ? worldIn.getBlockEntity(blockpos) : null;

        ResourceHandler<ItemResource> blockCap = worldIn.getCapability(Capabilities.Item.BLOCK, blockpos, state, blockEntity, side);
        if (blockCap != null) return Optional.of(ImmutablePair.of(blockCap, blockEntity));

        List<Entity> list = worldIn.getEntities((Entity) null, new AABB(x - .5, y - .5, z - .5, x + .5, y + .5, z + .5), EntitySelector.ENTITY_STILL_ALIVE);
        if (!list.isEmpty()) {
            Collections.shuffle(list);
            for (Entity entity : list) {
                ResourceHandler<ItemResource> entityCap = entity.getCapability(Capabilities.Item.ENTITY_AUTOMATION, side);
                if (entityCap != null) return Optional.of(ImmutablePair.of(entityCap, entity));
            }
        }
        return Optional.empty();
    }

    public static boolean isFullContainer(Container container, Direction direction) {
        if (container instanceof WorldlyContainer worldlycontainer) {
            int[] aint = worldlycontainer.getSlotsForFace(direction);
            for (int i : aint) {
                ItemStack itemstack = container.getItem(i);
                if (itemstack.getCount() < itemstack.getMaxStackSize()) return false;
            }
        } else {
            for (int i = 0; i < container.getContainerSize(); i++) {
                ItemStack itemstack = container.getItem(i);
                if (itemstack.getCount() < itemstack.getMaxStackSize()) return false;
            }
        }
        return true;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("Cooldown", this.cooldown);
        if (!this.stack.isEmpty()) {
            output.store("item", ItemStack.OPTIONAL_CODEC, this.stack);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.cooldown = input.getIntOr("Cooldown", 6);
        this.stack = input.read("item", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public void clearContent() {
        stack = ItemStack.EMPTY;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    protected ItemStack getItem() {
        return stack;
    }

    protected ItemStack removeItem(int amount) {
        if (amount > 0) setChanged();
        else return ItemStack.EMPTY;
        int c = stack.getCount();
        if (amount > c) {
            ItemStack s = stack;
            stack = ItemStack.EMPTY;
            return s;
        }
        ItemStack s = stack.copyWithCount(amount);
        stack.setCount(stack.getCount() - amount);
        return s;
    }

    @Override
    public ItemStack getItem(int i) {
        return stack;
    }

    @Override
    public ItemStack removeItem(int i, int amount) {
        return removeItem(amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        ItemStack s = stack;
        stack = ItemStack.EMPTY;
        return s;
    }

    protected void setItem(ItemStack s) {
        stack = s == null ? ItemStack.EMPTY : s;
    }

    @Override
    public void setItem(int i, ItemStack s) {
        setItem(s);
    }

    @Override
    public boolean stillValid(Player player) {
        return !player.isSpectator();
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        stack = ItemStack.EMPTY;
    }

    @Override
    public int countItem(Item i) {
        return stack.is(i) ? stack.getCount() : 0;
    }

    @Override
    public boolean hasAnyMatching(Predicate<ItemStack> predicate) {
        return predicate.test(stack);
    }

    @Override
    public boolean canTakeItem(Container c, int i, ItemStack s) {
        return level.getBlockState(worldPosition).getValue(BlockStateProperties.ENABLED);
    }

    public double getLevelX() {
        return worldPosition.getX() + .5;
    }

    public double getLevelY() {
        return worldPosition.getY() + .5;
    }

    public double getLevelZ() {
        return worldPosition.getZ() + .5;
    }
}