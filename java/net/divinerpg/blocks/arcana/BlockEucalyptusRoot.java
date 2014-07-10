package net.divinerpg.blocks.arcana;

import net.divinerpg.api.blocks.BlockModCrop;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockEucalyptusRoot extends BlockModCrop{

	public BlockEucalyptusRoot(String name) {
		super(name, 3, "eucalyptusRoot");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.eucalyptusSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return ArcanaItems.eucalyptusSeeds;
	}
}