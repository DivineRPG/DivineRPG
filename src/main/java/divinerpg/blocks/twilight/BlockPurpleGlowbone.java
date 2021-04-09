package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockPurpleGlowbone extends BlockModDoubleCrop {
    public BlockPurpleGlowbone() {
        super("purple_glowbone_plant");
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.purpleGlowboneSeeds;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 3;
    }
}