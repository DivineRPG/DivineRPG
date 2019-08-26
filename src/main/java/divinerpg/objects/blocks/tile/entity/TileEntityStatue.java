package divinerpg.objects.blocks.tile.entity;

import divinerpg.enums.StatueType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityStatue extends TileEntity {
    public StatueType statueType;

    public TileEntityStatue() {
    }

    public TileEntityStatue(StatueType statueType) {
        this.statueType = statueType;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("statueId", (short) this.statueType.ordinal());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("statueId")) {
            statueType = StatueType.getStatueFromId(compound.getInteger("statueId"));
        }
    }
}