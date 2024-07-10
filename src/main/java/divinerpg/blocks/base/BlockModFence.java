package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModFence extends FenceBlock {
    public BlockModFence(MapColor color, SoundType sound) {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(color).sound(sound));
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }
}
