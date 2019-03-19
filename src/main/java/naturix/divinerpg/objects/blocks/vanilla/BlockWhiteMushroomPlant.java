package naturix.divinerpg.objects.blocks.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWhiteMushroomPlant extends BlockCrops implements IHasModel {
    protected String name;

    public BlockWhiteMushroomPlant(String name) {
        super();
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    protected Item getSeed() {
        return ModItems.whiteMushroomSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.whiteMushroom;
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}