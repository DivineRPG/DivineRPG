package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;

public class BlockModStairs extends StairsBlock {
    public BlockModStairs(String name, Block base) {
        super(base.defaultBlockState(), AbstractBlock.Properties.copy(base));
        setRegistryName(DivineRPG.MODID, name);
    }
}