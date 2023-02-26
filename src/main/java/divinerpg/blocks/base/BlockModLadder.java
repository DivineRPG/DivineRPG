package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder() {
        super(Block.Properties.of(Material.WOOD)
                .strength(0.4F, 3.0F)
                .sound(SoundType.LADDER)
                .dynamicShape()
                .noOcclusion()
                .requiresCorrectToolForDrops());
    }

    public BlockModLadder(Properties properties) {
        super(properties);
    }
}
