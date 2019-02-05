package naturix.divinerpg.bases.items;

import naturix.divinerpg.DivineRPG;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemBase extends Item {

	protected String name;
	public ArrayList arraylistOne = new ArrayList();

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DivineRPG.ItemsTab);
		arraylistOne.add(name);

	}

	public ItemBase(String name, CreativeTabs tab) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(tab);
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}