package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.*;

public class BlockLights extends BlockModLadder {

    public BlockLights() {
        super();
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
        return false;
    }


}
