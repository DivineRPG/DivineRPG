package naturix.divinerpg.objects.items;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemBase extends Item implements IHasModel {

	protected String name;
	public ArrayList arraylistOne = new ArrayList();

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DivineRPG.ItemsTab);

		ModItems.ITEMS.add(this);
	}

	public ItemBase(String name, CreativeTabs tab) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(tab);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}