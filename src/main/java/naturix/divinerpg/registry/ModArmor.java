package naturix.divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ModArmor {
public static List<Item> DivineItemList = new ArrayList<>(30);
private Item item;
	
	public ModArmor(String name)
	{
		registerItem(name, item);
		
	}

	public static void registerItem(String name, Item item)
	{
		item.setRegistryName(name.toLowerCase());
		item.setUnlocalizedName(name.toLowerCase());
		//item.setCreativeTab(DivineRPG.ArmorTab);

		DivineItemList.add(item);
	}
}
