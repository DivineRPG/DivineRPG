package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder() {
        super(Block.Properties.of()
                .strength(0.4F)
                .sound(SoundType.LADDER)
                .dynamicShape()
                .noOcclusion());
    }
    public BlockModLadder(Properties properties) {
        super(properties);
    }
}