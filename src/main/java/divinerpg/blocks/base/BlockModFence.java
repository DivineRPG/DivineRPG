package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BlockModFence extends FenceBlock {
    public BlockModFence(MapColor color, SoundType sound) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(color).sound(sound));
    }

}
