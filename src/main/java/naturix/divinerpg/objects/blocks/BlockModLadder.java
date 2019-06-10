package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.itemblock.ItemBlockDoor;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.item.Item;

public class BlockModLadder extends BlockLadder implements IHasModel {
    public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DRPGCreativeTabs.BlocksTab);
        setHardness(0.4F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}