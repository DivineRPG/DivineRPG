package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockModSlab extends SlabBlock {
    public BlockModSlab(Block base) {
        super(BlockBehaviour.Properties.copy(base));
    }

}
