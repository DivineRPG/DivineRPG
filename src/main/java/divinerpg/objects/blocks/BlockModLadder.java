package divinerpg.objects.blocks;

import divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockLadder;

public class BlockModLadder extends BlockLadder  {
    public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(0.4F);
    }
}