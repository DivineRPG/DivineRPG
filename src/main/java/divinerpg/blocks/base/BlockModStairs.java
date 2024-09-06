package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockModStairs extends StairBlock {
    private static int flammability, fireSpread;
    public BlockModStairs(Block base) {
        super(base::defaultBlockState, Properties.copy(base));
        if(base instanceof BlockModPlanks) {
            flammability = 20;
            fireSpread = 5;
        }
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return flammability;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return fireSpread;}
}