package divinerpg.world.gen.tree.decorator;

import divinerpg.registries.*;
import net.minecraft.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.treedecorator.*;

import java.util.*;

public class WildwoodVineTrunkDecorator extends TrunkVineTreeDecorator {
    public static final WildwoodVineTrunkDecorator INSTANCE = new WildwoodVineTrunkDecorator();

    protected void placeVine(IWorldWriter p_227424_1_, BlockPos p_227424_2_, BooleanProperty p_227424_3_, Set<BlockPos> p_227424_4_, MutableBoundingBox p_227424_5_) {
        this.setBlock(p_227424_1_, p_227424_2_, BlockRegistry.wildwoodVine.defaultBlockState().setValue(p_227424_3_, true), p_227424_4_, p_227424_5_);
    }
}
