package naturix.divinerpg.bases.items.clock;

import naturix.divinerpg.DivineRPG;
import net.minecraft.item.Item;

public class MysteriousClock extends Item {

			protected String name;

			public MysteriousClock(String name) {
				this.name = name;
				setUnlocalizedName(name);
				setRegistryName(name); 
				this.setCreativeTab(DivineRPG.ItemsTab);
			}
			
			public void registerItemModel() {
				DivineRPG.proxy.registerItemRenderer(this, 0, name);
			}
}
