package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModSlab extends SlabBlock {
    private final int flammability;
    private final int fireSpread;

    public BlockModSlab(Block base, int flammability, int fireSpread) {
        super(BlockBehaviour.Properties.copy(base));
        this.flammability = flammability;
        this.fireSpread = fireSpread;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return fireSpread;
    }
}
