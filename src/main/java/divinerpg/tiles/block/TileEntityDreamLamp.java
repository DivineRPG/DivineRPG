package divinerpg.tiles.block;

import divinerpg.blocks.vethea.*;
import divinerpg.client.containers.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class TileEntityDreamLamp extends TileEntity implements INamedContainerProvider, ITickableTileEntity {
    public static final int NUMBER_OF_SLOTS = 1;

    public TileEntityDreamLamp() {
        super(TileRegistry.DREAM_LAMP);
        chestContents = TileInventoryHelper.createForTileEntity(NUMBER_OF_SLOTS,
                this::canPlayerAccessInventory, this::setChanged);
    }

    public boolean canPlayerAccessInventory(PlayerEntity player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) return false;
        final double X_CENTRE_OFFSET = 0.5;
        final double Y_CENTRE_OFFSET = 0.5;
        final double Z_CENTRE_OFFSET = 0.5;
        final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
        return player.distanceToSqr(worldPosition.getX() + X_CENTRE_OFFSET, worldPosition.getY() + Y_CENTRE_OFFSET, worldPosition.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
    }

    private static final String CHESTCONTENTS_INVENTORY_TAG = "contents";

    @Override
    public CompoundNBT save(CompoundNBT parentNBTTagCompound) {
        super.save(parentNBTTagCompound);
        CompoundNBT inventoryNBT = chestContents.serializeNBT();
        parentNBTTagCompound.put(CHESTCONTENTS_INVENTORY_TAG, inventoryNBT);
        return parentNBTTagCompound;
    }

    @Override
    public void load(BlockState blockState, CompoundNBT parentNBTTagCompound) {
        super.load(blockState, parentNBTTagCompound);
        CompoundNBT inventoryNBT = parentNBTTagCompound.getCompound(CHESTCONTENTS_INVENTORY_TAG);
        chestContents.deserializeNBT(inventoryNBT);
        if (chestContents.getContainerSize() != NUMBER_OF_SLOTS)
            throw new IllegalArgumentException("Corrupted NBT: Number of inventory slots did not match expected.");
    }

    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        save(nbtTagCompound);
        int tileEntityType = 42;
        return new SUpdateTileEntityPacket(this.worldPosition, tileEntityType, nbtTagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        BlockState blockState = level.getBlockState(worldPosition);
        load(blockState, pkt.getTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        save(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void handleUpdateTag(BlockState blockState, CompoundNBT tag) {
        this.load(blockState, tag);
    }


    public void dropAllContents(World world, BlockPos blockPos) {
        InventoryHelper.dropContents(world, blockPos, chestContents);
    }



    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(BlockRegistry.dreamLamp.getDescriptionId());
    }

    public final TileInventoryHelper chestContents;


    @Nullable
    @Override
    public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity menu) {
        return new DreamLampContainer(windowID, playerInventory, chestContents);
    }


    @Override
    public void tick() {
        if (!this.level.isClientSide) {
            ItemStack acidStack = this.chestContents.getItem(0);
            Block block = this.level.getBlockState(this.worldPosition).getBlock();
            int tick = Ticker.tick;
            if (acidStack.getItem() == ItemRegistry.acid) {
                ((BlockDreamLamp) block).setOn(this.level, this.worldPosition);
                if (tick > 300) {
                    tick = 0;
                    acidStack.shrink(1);
                }
            }
            if (acidStack.getItem() != ItemRegistry.acid) {
                ((BlockDreamLamp) block).setOff(this.level, this.worldPosition);
            }

            this.setChanged();
        }
    }
}