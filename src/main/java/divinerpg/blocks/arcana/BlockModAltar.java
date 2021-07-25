package divinerpg.blocks.arcana;

import divinerpg.registries.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockModAltar extends ContainerBlock {

    public BlockModAltar(String name) {
        super(AbstractBlock.Properties.of(Material.STONE).strength(6000000F, 6000000F).noOcclusion());
        setRegistryName(name);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return VoxelShapes.create(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9D, 1.0D));
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader world) {
        return this == BlockRegistry.dramixAltar ? new TileEntityDramixAltar() : new TileEntityParasectaAltar();
    }
}
