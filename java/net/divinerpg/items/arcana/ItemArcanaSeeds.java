package net.divinerpg.items.arcana;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.items.base.ItemModSeeds;
import net.divinerpg.utils.blocks.ArcanaBlocks;

public class ItemArcanaSeeds extends ItemModSeeds{

	public ItemArcanaSeeds(String name, BlockModCrop block) {
		super(name, block, ArcanaBlocks.arcanaGrass);
	}

}
