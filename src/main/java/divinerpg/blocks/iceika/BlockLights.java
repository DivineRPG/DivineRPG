package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockModLadder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockLights extends BlockModLadder {
    public BlockLights() {
        super(Block.Properties.of()
                .strength(0.4F)
                .sound(SoundType.WOOD)
                .dynamicShape()
                .noOcclusion());
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
        return false;
    }
}