package net.divinerpg.items.base;

import net.divinerpg.blocks.base.BlockModSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemModSlab extends ItemSlab {

    public ItemModSlab(Block thisOne, BlockModSlab single, BlockModSlab stack, Boolean stacked) {
        super(thisOne, single, stack, stacked);
    }

}
