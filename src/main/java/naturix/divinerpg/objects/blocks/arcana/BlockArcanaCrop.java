package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockArcanaCrop extends BlockModCrop {

    public BlockArcanaCrop(String name) {
        super(name);
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == ModBlocks.arcanaGrass;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return Utils.bordersTar(world, pos.down());
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState soil = world.getBlockState(pos.down());

        return super.canBlockStay(world, pos, soil) && Utils.bordersTar(world, pos.down());
    }
}
