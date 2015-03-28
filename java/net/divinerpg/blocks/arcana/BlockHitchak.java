package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockHitchak extends BlockArcanaCrop {

	public BlockHitchak(String name) {
		super(name, 3, "hitchak");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.hitchakSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return ArcanaItems.hitchak;
	}
}