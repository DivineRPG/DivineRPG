package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModWall extends WallBlock {
    public BlockModWall(String name, Block block, float hardness) {
        super(Block.Properties.of(block.defaultBlockState().getMaterial(), block.defaultBlockState().getMaterial().getColor())
                .requiresCorrectToolForDrops()
                .strength(hardness, 3600000.0F)
                .sound(block.defaultBlockState().getSoundType()));
        setRegistryName(name);
    }
}
