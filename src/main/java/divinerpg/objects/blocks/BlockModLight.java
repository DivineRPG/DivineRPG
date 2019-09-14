package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockModLight extends BlockModPowered {

    public BlockModLight(String name, float hardness) {
        super(EnumBlockType.GLASS, name, hardness);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
}
