package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockModStairs extends StairBlock {
    public BlockModStairs(Block base) {
        super(() -> base.defaultBlockState(), BlockBehaviour.Properties.copy(base));
    }

}