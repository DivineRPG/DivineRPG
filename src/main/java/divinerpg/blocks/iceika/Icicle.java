package divinerpg.blocks.iceika;

import net.minecraft.world.level.block.SpeleothemBlock;
import net.minecraft.world.level.block.state.*;

public class Icicle extends SpeleothemBlock {
    public Icicle(BlockState blockToGrowOn, Properties properties) {super(blockToGrowOn, properties);}
    protected int getStalactiteLandingSound() {
        return 2002;
    }
    protected int getMaxGrowthLength() {
        return 2;
    }
}