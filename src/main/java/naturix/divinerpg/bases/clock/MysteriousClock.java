package naturix.divinerpg.bases.clock;

import naturix.divinerpg.Divine;
import net.minecraft.item.Item;

public class MysteriousClock extends Item {

			protected String name;

			public MysteriousClock(String name) {
				this.name = name;
				setUnlocalizedName(name);
				setRegistryName(name);
				this.setCreativeTab(Divine.ItemsTab);
			}
			
			public void registerItemModel() {
				Divine.proxy.registerItemRenderer(this, 0, name);
			}
}
