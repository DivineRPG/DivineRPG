package divinerpg.block_entities.block;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.items.IItemHandler;

public class DistributorBlockEntity extends InserterBlockEntity {
    public DistributorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DISTRIBUTOR.get(), pos, state);
    }
    @Override
    public void setBlockState(BlockState blockState) {
        oldSetBlockState(blockState);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, DistributorBlockEntity block) {
        if(!block.isEmpty() && state.getValue(BlockStateProperties.ENABLED)) {
            if(block.cooldown < 1) {
                BlockPos p;
                for(int i = 0; i < 5; i++) {
                    p = switch(block.facing) {
                    case DOWN, UP:
                        block.facing = Direction.NORTH;
//                        DivineRPG.LOGGER.info("setting dir to north");
                        yield pos.north();
                    case NORTH:
                        block.facing = Direction.EAST;
//                        DivineRPG.LOGGER.info("setting dir to east");
                        yield pos.east();
                    case EAST:
                        block.facing = Direction.SOUTH;
//                        DivineRPG.LOGGER.info("setting dir to south");
                        yield pos.south();
                    case SOUTH:
                        block.facing = Direction.WEST;
//                        DivineRPG.LOGGER.info("setting dir to west");
                        yield pos.west();
                    case WEST:
//                        DivineRPG.LOGGER.info("setting dir to down");
                        block.facing = Direction.DOWN;
                        yield pos;
                    }; if(level.getBlockState(p).is(BlockRegistry.distributor) && eject(level, p, block)) break;
                } block.cooldown = 6;
            } else block.cooldown--;
        }
    }
    static boolean eject(Level level, BlockPos pos, DistributorBlockEntity blockEntity) {
        if(insertHook(blockEntity, pos)) return true;
        Container container = getAttachedContainer(level, pos, Direction.DOWN);
        if(container == null) return false;
        if(isFullContainer(container, Direction.UP)) return false;
        ItemStack itemstack = blockEntity.getItem();
        if(!itemstack.isEmpty()) {
            int j = itemstack.getCount();
            ItemStack itemstack1 = HopperBlockEntity.addItem(blockEntity, container, blockEntity.removeItem(1), Direction.UP);
            if(itemstack1.isEmpty()) {
                container.setChanged();
                return true;
            } itemstack.setCount(j);
            if(j == 1) blockEntity.setItem(itemstack);
        } return false;
    }
    static boolean insertHook(DistributorBlockEntity hopper, BlockPos pos) {
        return getAttachedItemHandler(hopper.getLevel(), pos, Direction.DOWN).map((destinationResult) -> {
            IItemHandler itemHandler = destinationResult.getKey();
            if(isFull(itemHandler)) return false;
            if(!hopper.getItem().isEmpty()) {
                ItemStack originalSlotContents = hopper.getItem().copy();
                ItemStack insertStack = hopper.removeItem(1);
                ItemStack remainder = putStackInInventoryAllSlots(itemHandler, insertStack);
                if(remainder.isEmpty()) return true;
                hopper.setItem(originalSlotContents);
            } return false;
        }).orElse(false);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putByte("split_order", (byte)facing.ordinal());
    }
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("split_order")) facing = Direction.values()[tag.getByte("split_order")];
    }
}