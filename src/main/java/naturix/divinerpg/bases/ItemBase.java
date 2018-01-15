package naturix.divinerpg.bases;

import naturix.divinerpg.Divine;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(Divine.ItemsTab);
	}
	
	public void registerItemModel() {
		Divine.proxy.registerItemRenderer(this, 0, name);
	}

}