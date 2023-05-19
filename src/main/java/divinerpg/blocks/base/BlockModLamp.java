package divinerpg.blocks.base;

import net.minecraft.world.level.block.Block;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(Block.Properties properties) {
        super(properties.lightLevel((state) -> 15));
    }
}
