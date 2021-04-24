package divinerpg.tiles.bosses;

import divinerpg.enums.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;

public class TileEntityStatue extends TileEntity {
    public StatueType statueType;

    public TileEntityStatue() {
        super(TileRegistry.STATUE);
    }

    public TileEntityStatue(StatueType statueType) {
        super(TileRegistry.STATUE);
        this.statueType = statueType;
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        tag.putInt("statueId", (short) this.statueType.ordinal());
        return super.save(tag);
    }

    @Override
    public void load(BlockState state, CompoundNBT compound) {
        super.load(state, compound);
        if (compound.contains("statueId")) {
            statueType = StatueType.getStatueFromId(compound.getInt("statueId"));
        }
    }
}
