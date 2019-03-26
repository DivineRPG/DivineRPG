package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockModCrop extends BlockCrops implements IHasModel {
    protected String name;
    private Item seed;
    private Item crop;
    private int maxAge;

    public BlockModCrop(String name, int maxAge, Item seed, Item crop) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.maxAge = maxAge;
        this.seed = seed;
        this.crop = crop;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int getMaxAge() {
        return this.maxAge;
    }

    @Override
    protected Item getSeed() {
        return this.seed;
    }

    @Override
    protected Item getCrop() {
        return this.crop;
    }

    @Override
    public int quantityDropped(Random r) {
        return r.nextInt(2) + 1;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}