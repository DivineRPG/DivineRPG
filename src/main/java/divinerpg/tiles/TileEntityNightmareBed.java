package divinerpg.tiles;

import divinerpg.registries.TileRegistry;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.*;

public class TileEntityNightmareBed extends TileEntity {
    public TileEntityNightmareBed(TileEntityType<TileEntityNightmareBed> nightmareBed) {
        super(TileRegistry.NIGHTMARE_BED);
    }

    public TileEntityNightmareBed() {
        super(TileRegistry.NIGHTMARE_BED);

    }

    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 11, this.getUpdateTag());
    }

}
