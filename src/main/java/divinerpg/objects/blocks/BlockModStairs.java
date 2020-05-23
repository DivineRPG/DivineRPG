package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockModStairs extends BlockStairs  {
    
    public BlockModStairs(String name, Block base) {
        super(base.getDefaultState());
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.useNeighborBrightness = true;
    }
}