package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
    }
}
