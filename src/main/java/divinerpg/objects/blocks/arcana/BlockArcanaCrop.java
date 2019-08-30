package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.Utils;
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

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return super.canBlockStay(worldIn, pos, state)
                && Utils.bordersTar(worldIn, pos.down());
    }
}
