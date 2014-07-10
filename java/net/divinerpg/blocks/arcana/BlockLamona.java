package net.divinerpg.blocks.arcana;

import net.divinerpg.api.blocks.BlockModCrop;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockLamona extends BlockModCrop{

	public BlockLamona(String name) {
		super(name, 3, "lamona");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.lamonaSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return ArcanaItems.lamona;
	}
}