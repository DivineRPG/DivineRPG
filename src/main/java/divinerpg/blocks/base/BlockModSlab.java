package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModSlab extends SlabBlock {
    public BlockModSlab(String name, Block base, float hardness) {
        super(Block.Properties.of(base.defaultBlockState().getMaterial(), base.defaultBlockState().getMaterial().getColor())
                .requiresCorrectToolForDrops()
                .strength(hardness, 3.0F)
                .harvestTool(base.defaultBlockState().getHarvestTool())
                .sound(base.defaultBlockState().getSoundType()));
        setRegistryName(name);
    }
}
