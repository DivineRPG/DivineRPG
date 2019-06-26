package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockArcanaCrop extends BlockModCrop {

    public BlockArcanaCrop(String name, int stages, String crop) {
    	//FIXME - Staging needs work
//        super(name, stages, crop);
    	super(name);
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == ModBlocks.arcanaGrass;
    }
    
    @Override
    public boolean canPlaceBlockAt(World w, BlockPos pos) {
            return Utils.bordersTar(w, new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
    }
    
    public boolean canBlockStay(World w, int x, int y, int z) {
    	BlockPos pos = new BlockPos(x, y, z);
    	IBlockState soil = w.getBlockState(pos.down());
        
        return super.canBlockStay(w, new BlockPos(x, y, z), soil) && Utils.bordersTar(w, new BlockPos(x, y-1, z));
    }

}
