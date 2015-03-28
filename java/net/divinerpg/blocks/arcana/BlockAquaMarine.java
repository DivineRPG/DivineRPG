package net.divinerpg.blocks.arcana;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockAquaMarine extends BlockArcanaCrop {

	public BlockAquaMarine(String name) {
		super(name, 3, "aquamarine");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.aquamarineSeeds;
	}

	@Override
	public Item getDropItem() {
		return ArcanaItems.aquamarine;
	}
}