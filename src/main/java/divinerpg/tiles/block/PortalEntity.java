package divinerpg.tiles.block;

import divinerpg.registries.*;
import net.minecraft.tileentity.*;

public class PortalEntity extends TileEntity {
    public PortalEntity(TileEntityType<?> p_i48283_1_) {
        super(p_i48283_1_);
    }

    public PortalEntity() {
        this(TileRegistry.ARCANA_PORTAL);
    }


}