package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.IHasModel;

public class ItemMysteriousClock extends ItemBase implements IHasModel {

	public ItemMysteriousClock(String name) {
		super(name);
		this.setCreativeTab(DRPGCreativeTabs.spawner);
	}

}
