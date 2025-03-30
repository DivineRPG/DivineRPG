package divinerpg.entities.base;

import divinerpg.block_entities.block.InserterBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.items.IItemHandler;

public class EntityInserterMinecart extends AbstractMinecart implements Hopper {
    protected ItemStack stack = ItemStack.EMPTY;
    protected boolean enabled = true;
    public EntityInserterMinecart(EntityType<? extends EntityInserterMinecart> entityType, Level level) {
        super(entityType, level);
    }
    public EntityInserterMinecart(Level level, double x, double y, double z) {
        super(EntityRegistry.INSERTER_MINECART.get(), level, x, y, z);
    }
    @Override public Type getMinecartType() {return Type.HOPPER;}
    @Override public ItemStack getPickResult() {return new ItemStack(getDropItem());}
    @Override protected Item getDropItem() {return ItemRegistry.inserter_minecart.get();}
    @Override public double getLevelX() {return getX();}
    @Override public double getLevelY() {return getY() + .5;}
    @Override public double getLevelZ() {return getZ();}
    @Override public boolean isGridAligned() {return false;}
    @Override public int getContainerSize() {return 1;}
    @Override public boolean isEmpty() {return stack.isEmpty();}
    public ItemStack getItem() {return stack;}
    @Override public ItemStack getItem(int i) {return stack;}
    @Override public ItemStack removeItem(int i, int amount) {return removeItem(amount);}
    protected ItemStack removeItem(int amount) {
        if(amount > 0) setChanged();
        else return ItemStack.EMPTY;
        int c = stack.getCount();
        if(amount > c) {
            ItemStack s = stack;
            stack = ItemStack.EMPTY;
            return s;
        } ItemStack s = stack.copyWithCount(amount);
        stack.setCount(stack.getCount() - amount);
        return s;
    }
    @Override public ItemStack removeItemNoUpdate(int i) {
        ItemStack s = stack;
        stack = ItemStack.EMPTY;
        return s;
    }
    protected void setItem(ItemStack s) {stack = s == null ? ItemStack.EMPTY : s;}
    @Override public void setItem(int i, ItemStack s) {setItem(s);}
    @Override public void setChanged() {}
    @Override public boolean stillValid(Player player) {return !player.isSpectator();}
    @Override public void clearContent() {stack = ItemStack.EMPTY;}

    @Override public BlockState getDefaultDisplayBlockState() {return BlockRegistry.inserter.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN);}
    @Override public int getDefaultDisplayOffset() {return 1;}

    @Override public void activateMinecart(int x, int y, int z, boolean receivingPower) {enabled = !receivingPower;}

    @Override protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Enabled", this.enabled);
        if(stack != null && !stack.isEmpty()) compound.put("item", getItem().save(registryAccess()));
    }
    @Override protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        enabled = !compound.contains("Enabled") || compound.getBoolean("Enabled");
        if(compound.contains("item")) stack = ItemStack.parseOptional(registryAccess(), compound.getCompound("item"));
    }

    @Override public void destroy(DamageSource source) {
        super.destroy(source);
        if(level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            Containers.dropContents(level(), this, this);
            if(!level().isClientSide) {
                Entity entity = source.getDirectEntity();
                if(entity != null && entity.getType() == EntityType.PLAYER) PiglinAi.angerNearbyPiglins((Player)entity, true);
            }
        }
    }
    @Override public void remove(Entity.RemovalReason reason) {
        if(!level().isClientSide && reason.shouldDestroy()) Containers.dropContents(level(), this, this);
        super.remove(reason);
    }
    @Override protected void applyNaturalSlowdown() {
        float f = .98F;
        int i = 15 - AbstractContainerMenu.getRedstoneSignalFromContainer(this);
        f += i * .001F;
        if(isInWater()) f *= .95F;
        setDeltaMovement(getDeltaMovement().multiply(f, 0D, f));
    }

    @Override public void tick() {
        super.tick();
        if(!level().isClientSide && isAlive() && enabled && !isEmpty()) {
            if(insertHook()) return;
//            DivineRPG.LOGGER.info("regular insert");
            Container container = HopperBlockEntity.getContainerAt(level(), blockPosition().below());
            if(container == null) return;
            if(InserterBlockEntity.isFullContainer(container, Direction.UP)) return;
            ItemStack itemstack = getItem();
            if(!itemstack.isEmpty()) {
                int j = itemstack.getCount();
                ItemStack itemstack1 = HopperBlockEntity.addItem(this, container, removeItem(1), Direction.UP);
                if(itemstack1.isEmpty()) {
                    container.setChanged();
                    return;
                } itemstack.setCount(j);
                if(j == 1) setItem(itemstack);
            }
        }
    }
    boolean insertHook() {
        return InserterBlockEntity.getAttachedItemHandler(level(), blockPosition(), Direction.DOWN).map((destinationResult) -> {
            IItemHandler itemHandler = destinationResult.getKey();
            if(InserterBlockEntity.isFull(itemHandler)) return false;
            if(!getItem().isEmpty()) {
                ItemStack originalSlotContents = getItem().copy();
                ItemStack insertStack = removeItem(1);
                ItemStack remainder = InserterBlockEntity.putStackInInventoryAllSlots(itemHandler, insertStack);
                if(remainder.isEmpty()) return true;
                setItem(originalSlotContents);
            } return false;
        }).orElse(false);
    }
}