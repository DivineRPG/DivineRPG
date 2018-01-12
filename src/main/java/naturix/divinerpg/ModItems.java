package naturix.divinerpg;

import naturix.divinerpg.blocks.bases.*;
import naturix.divinerpg.utils.DivineRPGMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	private static final CreativeTabs tab = Divine.ItemsTab;
	public static ItemBase ingotArlemite = new ItemBase("ingot_arlemite");
	public static SwordBase arlemiteSword = new SwordBase(DivineRPGMaterials.arlemiteToolMaterial, "sword_arlemite");
	public static ThrowableBase amthirmisDisk = new ThrowableBase("amthirmisDisk");
	public static BowBase hunterBow = new BowBase("hunterBow");
	public static BowBase shadowBow = new BowBase("shadowBow");
	public static BowBase enderBow = new BowBase("enderBow");
	public static BowBase bluefireBow = new BowBase("bluefireBow");
	public static BowBase infernoBow = new BowBase("infernoBow");
	public static ItemBase arcanium = new ItemBase("arcanium");
	
	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(
				ingotArlemite,
				arlemiteSword,
				amthirmisDisk,
				hunterBow,
				shadowBow,
				enderBow,
				bluefireBow,
				infernoBow,
				arcanium
		);
	}

	public static void registerModels() {
		ingotArlemite.registerItemModel();
		arlemiteSword.registerItemModel(arlemiteSword);
		amthirmisDisk.registerItemModel(amthirmisDisk);
		hunterBow.registerItemModel(); 
		shadowBow.registerItemModel();
		enderBow.registerItemModel();
		bluefireBow.registerItemModel();
		infernoBow.registerItemModel();
		arcanium.registerItemModel();
		System.out.print("DivineRPG items loaded");
	}
}