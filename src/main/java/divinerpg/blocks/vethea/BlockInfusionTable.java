package divinerpg.blocks.vethea;

import divinerpg.tiles.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockInfusionTable extends ContainerBlock{

    public BlockInfusionTable(String name) {
        super(AbstractBlock.Properties.of(Material.STONE).strength(-1, 6000000F));
        setRegistryName(name);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(!world.isClientSide){
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof TileEntityInfusionTable) {
            playerEntity.openMenu((TileEntityInfusionTable) tileentity);
        }
        }
        return super.use(state, world, pos, playerEntity, hand, result);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityInfusionTable();
    }
}
