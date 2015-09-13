package net.divinerpg.blocks.twilight;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockTwilightCrop extends BlockModCrop {
    
    private Block placeOn;

    public BlockTwilightCrop(String name, int stages, String crop, Block grass) {
        super(name, stages, crop);
        placeOn = grass;
    }
    
    @Override
    public boolean canPlaceBlockOn(Block block) {
        return block == placeOn;
    }
}