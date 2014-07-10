package net.divinerpg.blocks.vanilla;

import net.divinerpg.api.blocks.BlockModCrop;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.item.Item;

public class BlockMushroom extends BlockModCrop{

	public BlockMushroom(String name) {
		super(name, 1, "mushroom");
	}

	@Override
	public Item getSeeds() {
		return VanillaItemsOther.mushroomSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return ItemsFood.whiteMushroom;
	}
}