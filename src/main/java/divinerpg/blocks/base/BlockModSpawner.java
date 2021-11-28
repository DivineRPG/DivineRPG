package divinerpg.blocks.base;

import divinerpg.tiles.spawner.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

public class BlockModSpawner extends ContainerBlock {

    private EntityType type;

    public BlockModSpawner(String name, EntityType type) {
        super(Properties.copy(Blocks.SPAWNER).strength(5.0F, 5.0F).randomTicks().noOcclusion());
        setRegistryName(name);
        this.type=type;
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntitySpawner(type);
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }
}