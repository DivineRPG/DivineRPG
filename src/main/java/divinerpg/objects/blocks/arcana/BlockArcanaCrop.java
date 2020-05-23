package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.BlockRegistry;
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
        if (BlockRegistry.arcaniteGrass == null)
            return false;

        return state == BlockRegistry.arcaniteGrass.getDefaultState();
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        BlockPos down = pos.down();
        return canSustainBush(world.getBlockState(down)) && Utils.bordersTar(world, down);
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return super.canBlockStay(worldIn, pos, state)
                && Utils.bordersTar(worldIn, pos.down());
    }
}
