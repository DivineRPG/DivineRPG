package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockMarsine extends BlockArcanaCrop {

	public BlockMarsine(String name) {
		super(name, 2);
	}

	@Override
	public Item getSeed() {
		return ModSeeds.marsineSeeds;
	}
	
	@Override
	public Item getCrop() {
		return ModItems.marsine;
	}
}