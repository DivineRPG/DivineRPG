package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.tiles.spawner.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockArcanaSpawner extends BlockMod implements ITileEntityProvider {
    private EntityType mob;

    public BlockArcanaSpawner(String name, EntityType mob) {
        super(name, -1);
        this.mob = mob;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader world) {
        return new TileEntityArcanaSpawner(mob);
    }
}
