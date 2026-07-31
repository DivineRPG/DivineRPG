package divinerpg.entities.base;

import divinerpg.block_entities.block.InserterBlockEntity;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;

import static divinerpg.block_entities.block.InserterBlockEntity.*;

public class EntityInserterMinecart extends AbstractMinecart implements Hopper {
    protected ItemStack stack = ItemStack.EMPTY;
    protected boolean enabled = true;

    public EntityInserterMinecart(EntityType<? extends EntityInserterMinecart> entityType, Level level) {
        super(entityType, level);
    }

    public EntityInserterMinecart(Level level, double x, double y, double z) {
        super(EntityRegistry.INSERTER_MINECART.get(), level, x, y, z);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(getDropItem());
    }

    @Override
    protected Item getDropItem() {
        return ItemRegistry.inserter_minecart.get();
    }

    @Override
    public double getLevelX() {
        return getX();
    }

    @Override
    public double getLevelY() {
        return getY() + 0.5D;
    }

    @Override
    public double getLevelZ() {
        return getZ();
    }

    @Override
    public boolean isGridAligned() {
        return false;
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public ItemStack getItem() {
        return this.stack;
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.stack;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        return removeItem(amount);
    }

    protected ItemStack removeItem(int amount) {
        if (amount <= 0 || this.stack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        setChanged();
        if (amount >= this.stack.getCount()) {
            ItemStack removed = this.stack;
            this.stack = ItemStack.EMPTY;
            return removed;
        }
        return this.stack.split(amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack removed = this.stack;
        this.stack = ItemStack.EMPTY;
        return removed;
    }

    protected void setItem(ItemStack stack) {
        this.stack = stack == null ? ItemStack.EMPTY : stack;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        setItem(stack);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player player) {
        return !player.isSpectator();
    }

    @Override
    public void clearContent() {
        this.stack = ItemStack.EMPTY;
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return BlockRegistry.inserter.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN);
    }

    @Override
    public int getDefaultDisplayOffset() {
        return 1;
    }

    @Override
    public void activateMinecart(ServerLevel level, int x, int y, int z, boolean receivingPower) {
        this.enabled = !receivingPower;
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("Enabled", this.enabled);
        if (!this.stack.isEmpty()) {
            output.store("item", ItemStack.OPTIONAL_CODEC, this.stack);
        }
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.enabled = input.getBooleanOr("Enabled", true);
        this.stack = input.read("item", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    public void destroy(ServerLevel level, DamageSource source) {
        super.destroy(level, source);
        if (level.getGameRules().get(GameRules.ENTITY_DROPS)) {
            dropItems();
            if (!level().isClientSide()) {
                Entity entity = source.getDirectEntity();
                if (entity instanceof Player player) {
                    PiglinAi.angerNearbyPiglins(level, player, true);
                }
            }
        }
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        if (!level().isClientSide() && reason.shouldDestroy()) {
            dropItems();
        }
        super.remove(reason);
    }

    private void dropItems() {
        NonNullList<ItemStack> drops = NonNullList.create();
        if (!this.stack.isEmpty()) {
            drops.add(this.stack.copy());
        }
        Containers.dropContents(level(), blockPosition(), drops);
    }

    @Override
    protected Vec3 applyNaturalSlowdown(Vec3 movement) {
        float f = 0.98F;
        int i = 15 - AbstractContainerMenu.getRedstoneSignalFromContainer(this);
        f += i * 0.001F;
        if (isInWater()) {
            f *= 0.95F;
        }
        setDeltaMovement(getDeltaMovement().multiply(f, 0.0D, f));
        return movement;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && isAlive() && this.enabled && !isEmpty()) {
            if (insertHook(level(), blockPosition(), getDirection(), null)) return;

            Container container = HopperBlockEntity.getContainerAt(level(), blockPosition().below());
            if (container == null) return;
            if (InserterBlockEntity.isFullContainer(container, Direction.UP)) return;

            ItemStack itemstack = getItem();
            if (!itemstack.isEmpty()) {
                int count = itemstack.getCount();
                ItemStack remainder = HopperBlockEntity.addItem(this, container, removeItem(1), Direction.UP);
                if (remainder.isEmpty()) {
                    container.setChanged();
                    return;
                }
                itemstack.setCount(count);
                if (count == 1) {
                    setItem(itemstack);
                }
            }
        }
    }

    static boolean insertHook(Level level, BlockPos pos, Direction facing, Hopper hopper) {
        return getAttachedItemHandler(level, pos, facing).map((destinationResult) -> {
            ResourceHandler<ItemResource> itemHandler = destinationResult.getKey();
            if (isFull(itemHandler)) return false;

            ItemStack currentStack = hopper.getItem(0);
            if (!currentStack.isEmpty()) {
                ItemStack insertStack = currentStack.copyWithCount(1);

                int remaining = putStackInInventoryAllSlots(itemHandler, insertStack);
                if (remaining == 0) {
                    hopper.removeItem(0, 1);
                    return true;
                }
            }
            return false;
        }).orElse(false);
    }
}