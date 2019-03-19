package naturix.divinerpg.objects.blocks.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockTomatoPlant extends BlockCrops implements IHasModel {
    protected String name;

    public BlockTomatoPlant(String name) {
        super();
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    protected Item getSeed() {
        return ModItems.tomatoSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.tomato;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}