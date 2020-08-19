package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;

public class BlockModLadder extends BlockLadder  {
    public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        setCreativeTab(DivineRPGTabs.BLOCKS);
        setHardness(0.4F);
        this.setSoundType(SoundType.LADDER);
    }
}