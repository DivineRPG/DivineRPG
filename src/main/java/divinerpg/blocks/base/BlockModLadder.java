package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder() {
        super(Block.Properties.of(Material.DECORATION)
                .strength(0.4F)
                .sound(SoundType.LADDER)
                .dynamicShape()
                .noOcclusion());
    }
    public BlockModLadder(Properties properties) {
        super(properties);
    }
}