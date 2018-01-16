package naturix.divinerpg;

import naturix.divinerpg.bases.*;
import naturix.divinerpg.bases.clock.MysteriousClock;
import naturix.divinerpg.utils.DivineRPGMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	private static final CreativeTabs tab = Divine.ItemsTab;
	public static SwordBase arlemiteSword = new SwordBase(DivineRPGMaterials.arlemiteToolMaterial, "sword_arlemite");
	public static ThrowableBase amthirmisDisk = new ThrowableBase("amthirmisDisk");
	public static BowBase hunterBow = new BowBase("bow_hunter");
	public static BowBase shadowBow = new BowBase("bow_shadow");
	public static BowBase enderBow = new BowBase("bow_ender");
	public static BowBase bluefireBow = new BowBase("bow_bluefire");
	public static BowBase infernoBow = new BowBase("bow_inferno");
	public static ItemBase arcanium = new ItemBase("arcanium");
	public static ItemBase ingotArlemite = new ItemBase("ingot_arlemite");
	public static ItemBase ingotAquatic = new ItemBase("ingot_aquatic");
	public static ItemBase ingotHellstone = new ItemBase("ingot_hellstone");
	public static ItemBase ingotNetherite = new ItemBase("ingot_netherite");
	public static ItemBase ingotRealmite = new ItemBase("ingot_realmite");
	public static ItemBase ingotRupee = new ItemBase("ingot_rupee");
	public static ItemBase gemApalachia = new ItemBase("gem_apalachia");
	public static ItemBase gemEden = new ItemBase("gem_eden");
	public static ItemBase gemSkythern = new ItemBase("gem_skythern");
	public static ItemBase gemWildwood = new ItemBase("gem_wildwood");
	public static MysteriousClock mysteriousClock = new MysteriousClock("clock_mysterious");
	public static MysteriousClock moonClock = new MysteriousClock("clock_moon");
	public static MysteriousClock twilightClock = new MysteriousClock("clock_twilight");
	
	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(
				arlemiteSword,
				amthirmisDisk,
				hunterBow,
				shadowBow,
				enderBow,
				bluefireBow,
				infernoBow,
				arcanium,
				ingotArlemite,
				ingotAquatic,
				ingotHellstone,
				ingotNetherite,
				ingotRealmite,
				ingotRupee,
				gemApalachia,
				gemEden,
				gemSkythern,
				gemWildwood,
				mysteriousClock,
				moonClock,
				twilightClock
				
				);
	}

	public static void registerModels() {
		arlemiteSword.registerItemModel(arlemiteSword);
		amthirmisDisk.registerItemModel(amthirmisDisk);
		hunterBow.registerItemModel(); 
		shadowBow.registerItemModel();
		enderBow.registerItemModel();
		bluefireBow.registerItemModel();
		infernoBow.registerItemModel();
		arcanium.registerItemModel();
		ingotArlemite.registerItemModel();
		ingotAquatic.registerItemModel();
		ingotHellstone.registerItemModel();
		ingotNetherite.registerItemModel();
		ingotRupee.registerItemModel();
		ingotRealmite.registerItemModel();
		gemApalachia.registerItemModel();
		gemEden.registerItemModel();
		gemSkythern.registerItemModel();
		gemWildwood.registerItemModel();
		mysteriousClock.registerItemModel();
		moonClock.registerItemModel();
		twilightClock.registerItemModel();
		System.out.print("DivineRPG items loaded");
	}
}