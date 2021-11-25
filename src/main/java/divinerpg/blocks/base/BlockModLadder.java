package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder(String name) {
        super(Block.Properties.of(Material.WOOD)
                .strength(0.4F, 3.0F)
                .sound(SoundType.LADDER)
                .dynamicShape()
                .noOcclusion()
                .requiresCorrectToolForDrops());
        setRegistryName(name);
    }
}
