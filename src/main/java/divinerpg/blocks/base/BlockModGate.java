package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }
}
