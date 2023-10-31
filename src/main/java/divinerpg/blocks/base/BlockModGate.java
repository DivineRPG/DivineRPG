package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate(MapColor color, WoodType type) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(color), type);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }
}
