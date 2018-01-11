package naturix.divinerpg;

import naturix.divinerpg.utils.DivineRPGMaterials;
import naturix.divinerpg.utils.blocknitems.BowBase;
import naturix.divinerpg.utils.blocknitems.ItemBase;
import naturix.divinerpg.utils.blocknitems.SwordBase;
import naturix.divinerpg.utils.blocknitems.ThrowableBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	private static final CreativeTabs tab = Divine.ItemsTab;
	public static ItemBase ingotArlemite = new ItemBase("ingot_arlemite").setCreativeTab(tab);
	public static SwordBase arlemiteSword = new SwordBase(DivineRPGMaterials.arlemiteToolMaterial, "sword_arlemite");
	public static ThrowableBase amthirmisDisk = new ThrowableBase("amthirmisDisk");
	public static BowBase amthirmisbow = new BowBase("amthirmisbow");
	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(
				ingotArlemite,
				arlemiteSword,
				amthirmisDisk,
				amthirmisbow
		);
	}

	public static void registerModels() {
		ingotArlemite.registerItemModel();
		arlemiteSword.registerItemModel(arlemiteSword);
		amthirmisDisk.registerItemModel(amthirmisDisk);
		amthirmisbow.registerItemModel();
		System.out.print("DivineRPG items loaded");
	}
}