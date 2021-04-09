package divinerpg.blocks.vanilla;

import divinerpg.tiles.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockAyeracoSpawn extends ContainerBlock {
    public BlockAyeracoSpawn() {
        super(AbstractBlock.Properties.of(Material.FIRE).strength(6000000F, 6000000F).randomTicks());
        setRegistryName("ayeraco_spawn");
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityAyeracoSpawn();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return VoxelShapes.empty();
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 0;
    }
}
