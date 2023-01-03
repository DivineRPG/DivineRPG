package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.Material;

public class BlockLights extends BlockModLadder {

    public BlockLights() {
        super(Block.Properties.of(Material.WOOD)
                .strength(0.4F, 3.0F)
                .sound(SoundType.LADDER)
                .dynamicShape()
                .noOcclusion());
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
        return false;
    }


}
