package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.objects.items.base.ItemModSeeds;
import naturix.divinerpg.registry.ModBlocks;

public class ItemArcanaSeeds extends ItemModSeeds{

	public ItemArcanaSeeds(String name, BlockModCrop block) {
		super(name, block, ModBlocks.arcanaGrass);
	}

}