package net.divinerpg.blocks.twilight;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.items.TwilightItemsCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockSkyPlant extends BlockTwilightCrop {

    public BlockSkyPlant() {
        super("skyPlant", 3, "skyPlant", Blocks.grass);
    }

    @Override
    public Item getSeeds() {
        return TwilightItemsCrops.skyPlantSeeds;
    }
    
    @Override
    public Item getDropItem() {
        return TwilightItemsCrops.skyFlower;
    }
}