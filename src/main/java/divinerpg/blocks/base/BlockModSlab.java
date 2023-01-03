package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;

public class BlockModSlab extends SlabBlock {
    public BlockModSlab(Block base, float hardness) {
        super(Block.Properties.of(base.defaultBlockState().getMaterial(), base.defaultBlockState().getMaterial().getColor())
                .requiresCorrectToolForDrops()
                .strength(hardness, 3.0F)
                .sound(base.defaultBlockState().getSoundType()));
    }
}
