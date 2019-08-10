package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockModLadder extends BlockLadder implements IHasModel {
    public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(0.4F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}