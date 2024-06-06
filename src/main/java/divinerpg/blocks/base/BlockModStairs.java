package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockModStairs extends StairBlock {
    private int flammability;
    private int fireSpread;
    public BlockModStairs(Block base) {
        super(base::defaultBlockState, Properties.copy(base));
        if(base instanceof BlockModPlanks) {
            flammability = BlockModPlanks.flammability;
            fireSpread = BlockModPlanks.fireSpread;
        }
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return flammability;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return fireSpread;}
}