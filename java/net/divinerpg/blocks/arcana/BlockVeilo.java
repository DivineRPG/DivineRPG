package net.divinerpg.blocks.arcana;

import net.divinerpg.api.blocks.BlockModCrop;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.item.Item;

public class BlockVeilo extends BlockModCrop{

	public BlockVeilo(String name) {
		super(name, 3, "veilo");
	}

	@Override
	public Item getSeeds() {
		return ArcanaItems.veiloSeeds;
	}
	
	@Override
	public Item getDropItem() {
		return ArcanaItems.veilo;
	}
}