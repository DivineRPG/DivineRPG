package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockAquaMarine extends BlockArcanaCrop {

	public BlockAquaMarine(String name) {
		super(name, 3);
	}

	@Override
	public Item getSeed() {
		return ModSeeds.aquamarineSeeds;
	}

	@Override
	public Item getCrop() {
		return ModItems.aquamarine;
	}
}