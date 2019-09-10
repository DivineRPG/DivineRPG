package divinerpg.objects.blocks;

import divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.BlockLadder;
import net.minecraft.item.ItemBlock;

public class BlockModLadder extends BlockLadder  {
    public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(0.4F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}