package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockPinkGlowbone extends BlockModDoubleCrop {
    public BlockPinkGlowbone() {
        super("pink_glowbone_plant");
    }
    @Override
    public int getMaxAge() {
        return 1;
    }
    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.pinkGlowboneSeeds;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 3;
    }

}
