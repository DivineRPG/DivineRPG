package divinerpg.tiles.block;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class TileEntityStructureAir extends TileEntity implements ITickableTileEntity {
    public TileEntityStructureAir() {
        super(TileRegistry.STRUCTURE_AIR);
    }

    @Override
    public void tick() {
        if(level.isClientSide){
            if(level.isLoaded(getBlockPos())) {
            for (int time = 0; time < 1000; time++) {
                    level.setBlock(getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
                    this.setRemoved();
                }
            }
        }
    }
}
