package naturix.divinerpg.objects.items.base;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemModSeeds extends ItemSeeds implements IHasModel {
    public String name;
    public BlockModCrop crop;

    public ItemModSeeds(String name, BlockModCrop block) {
        super(block, Blocks.FARMLAND);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.crop = block;
        this.setCreativeTab(DRPGCreativeTabs.food);
        ModItems.ITEMS.add(this);
    }

    public ItemModSeeds(String name, BlockModCrop block, Block placeOn) {
        super(block, placeOn);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.crop = block;
        setCreativeTab(DRPGCreativeTabs.food);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(this, 0, name);
    }
}