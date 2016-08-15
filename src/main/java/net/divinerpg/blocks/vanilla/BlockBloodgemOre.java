package net.divinerpg.blocks.vanilla;

import java.util.Random;

import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.item.Item;


public class BlockBloodgemOre extends VanillaBlock {

    public BlockBloodgemOre() {
        super(EnumBlockType.ROCK, "bloodgemOre", 3.0F, 3);
        setResistance(2000.0F);
    }
    
    @Override
    public Item getItemDropped(int i, Random rand, int i2) {
        return VanillaItemsOther.bloodgem;
    }
}