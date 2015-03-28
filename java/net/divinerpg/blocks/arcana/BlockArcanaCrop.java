package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockArcanaCrop extends BlockModCrop {

    public BlockArcanaCrop(String name, int stages, String crop) {
        super(name, stages, crop);
    }
    
    @Override
    public boolean canPlaceBlockOn(Block block) {
        return block == ArcanaBlocks.arcanaGrass;
    }

}