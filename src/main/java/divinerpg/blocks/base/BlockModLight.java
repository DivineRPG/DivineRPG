package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockModLight extends BlockModPowered {
    public BlockModLight(String name, float hardness) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(hardness, 3.0F).sound(SoundType.GLASS));
    }
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
}
