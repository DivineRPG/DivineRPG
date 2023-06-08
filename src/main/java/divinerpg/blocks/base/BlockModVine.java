package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;

public class BlockModVine extends VineBlock {
    public BlockModVine(MapColor color) {
        super(Block.Properties.of()
                .mapColor(color)
                .dynamicShape()
                .randomTicks()
                .noCollission()
                .noOcclusion()
                .strength(0.2F)
                .sound(SoundType.VINE));
    }


    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 15;
    }
}
