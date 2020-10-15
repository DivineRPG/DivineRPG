package TeamDivineRPG.divinerpg.blocks.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class BlockModStairs extends StairsBlock {
    public BlockModStairs(String name, Block base){
        super(base.getDefaultState(), AbstractBlock.Properties.from(base));
        setRegistryName(DivineRPG.MODID, name);
    }
}