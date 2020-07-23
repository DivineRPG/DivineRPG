package divinerpg.objects.blocks.tile.entity;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.BlockModChest;
import divinerpg.objects.blocks.tile.container.ContainerModChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

public abstract class TileEntityModChest extends TileEntityLockableLoot implements ITickable {
    private NonNullList<ItemStack> chestContents = NonNullList.withSize(27, ItemStack.EMPTY);
    public int numPlayersUsing, ticksSinceSync;
    public float lidAngle, prevLidAngle;
    private String customName;

    abstract public String getChestName();

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : getChestName();
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    public void initChestContents() {
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : chestContents) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.initChestContents();

        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, chestContents);
        }
        if (compound.hasKey("CustomName", 8)) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, chestContents);
        }
        if (compound.hasKey("CustomName", 8)) {
            compound.setString("CustomName", this.customName);
        }

        return compound;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerModChest(playerInventory, this, playerIn);
    }

    @Override
    public String getGuiID() {
        return DivineRPG.MODID + this.customName;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    public void update() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;

        if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + i + j + k) % 200 == 0) {
            this.numPlayersUsing = 0;
            float f = 5.0F;
            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class,
                    new AxisAlignedBB((float) i - 5.0F, (float) j - 5.0F,
                            (float) k - 5.0F, (float) (i + 1) + 5.0F,
                            (float) (j + 1) + 5.0F, (float) (k + 1) + 5.0F))) {
                if (entityplayer.openContainer instanceof ContainerModChest) {
                    if (((ContainerModChest) entityplayer.openContainer).getChestInventory() == this) {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }

        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            double d1 = (double) pos.getX() + 0.5D;
            double d2 = (double) pos.getZ() + 0.5D;
            this.world.playSound(null, d1, (double) pos.getY() + 0.5D, d2,
                    SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 0.5F,
                    this.world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0F) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0F)) {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            } else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F) {
                double d3 = (double) pos.getX() + 0.5D;
                double d0 = (double) pos.getZ() + 0.5D;
                this.world.playSound(null, d3, (double) pos.getY() + 0.5D, d0,
                        SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 0.5F,
                        this.world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
        }
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        if (!player.isSpectator() && this.getBlockType() instanceof BlockModChest) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
        }
    }
}