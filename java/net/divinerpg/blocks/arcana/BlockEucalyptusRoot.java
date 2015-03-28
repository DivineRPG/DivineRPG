package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockEucalyptusRoot extends BlockArcanaCrop {

	public BlockEucalyptusRoot(String name) {
		super(name, 3, "eucalyptusRoot");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.eucalyptusSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return Item.getItemFromBlock(ArcanaBlocks.eucalyptusWood);
	}
}