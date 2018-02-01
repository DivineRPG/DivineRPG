package naturix.divinerpg.bases;

import naturix.divinerpg.Divine;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	protected String name;
	private CreativeTabs combattab;
	
	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(Divine.ItemsTab);
		
	}public ItemBase(String name, CreativeTabs combattab) {
		this.name = name;
		this.combattab = combattab;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		Divine.proxy.registerItemRenderer(this, 0, name);
	}

}