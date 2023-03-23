package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.Material;

public class BlockModFence extends FenceBlock {
    public BlockModFence() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).dynamicShape());
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }
}
