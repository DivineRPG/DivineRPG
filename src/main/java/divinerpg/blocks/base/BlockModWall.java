package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;

public class BlockModWall extends WallBlock {
    public BlockModWall(Block block, float hardness) {
        super(Block.Properties.of(block.defaultBlockState().getMaterial(), block.defaultBlockState().getMaterial().getColor())
                .requiresCorrectToolForDrops()
                .strength(hardness, 3600000.0F)
                .sound(block.defaultBlockState().getSoundType()));
    }
}
