package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockModLight extends BlockModPowered {

    public BlockModLight(String name, float hardness) {
        super(name, hardness, Material.REDSTONE_LIGHT);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
}
