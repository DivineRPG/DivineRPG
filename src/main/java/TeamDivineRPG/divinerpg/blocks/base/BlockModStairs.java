package TeamDivineRPG.divinerpg.blocks.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.block.*;

public class BlockModStairs extends StairsBlock {
    public BlockModStairs(String name, Block base) {
        super(base.getDefaultState(), AbstractBlock.Properties.from(base));
        setRegistryName(DivineRPG.MODID, name);
    }
}