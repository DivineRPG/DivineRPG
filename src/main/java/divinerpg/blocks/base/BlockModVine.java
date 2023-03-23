package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;

public class BlockModVine extends VineBlock {
    public BlockModVine() {
        super(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .dynamicShape()
                .randomTicks()
                .noCollission()
                .noOcclusion()
                .strength(2.0F, 3.0F)
                .sound(SoundType.WET_GRASS));
    }


    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }
}
