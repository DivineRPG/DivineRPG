package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate(MapColor color) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(color), WoodType.OAK);
    }

}
