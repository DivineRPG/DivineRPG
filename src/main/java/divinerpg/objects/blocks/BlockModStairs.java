package divinerpg.objects.blocks;

import divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemBlock;

public class BlockModStairs extends BlockStairs  {

    public BlockModStairs(Block base, String name) {
        super(base.getDefaultState());
        this.useNeighborBrightness = true;
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}