package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockLights extends BlockModLadder {

    public BlockLights(String name) {
        super(name);
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return false;
    }


}
