package naturix.divinerpg;

import naturix.divinerpg.bases.ArmorBase;
import naturix.divinerpg.bases.AxeBase;
import naturix.divinerpg.bases.BowBase;
import naturix.divinerpg.bases.FoodBase;
import naturix.divinerpg.bases.ItemBase;
import naturix.divinerpg.bases.SpawnerBase;
import naturix.divinerpg.bases.SwordBase;
import naturix.divinerpg.bases.ThrowableBase;
import naturix.divinerpg.bases.armor.Angelic;
import naturix.divinerpg.bases.clock.MysteriousClock;
import naturix.divinerpg.utils.DivineRPGMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	private static EntitySlime EntitySlime;
	private static final CreativeTabs tab = Divine.ItemsTab;
	
	public static SwordBase arlemiteSword = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "sword_arlemite");
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
	public static ItemBase acid = new ItemBase("acid");
	public static FoodBase advancedMushroomStew = new FoodBase("advanced_mushroom_stew", 7, false);
	public static ItemBase aquamarine = new ItemBase("aquamarine");
	public static ItemBase aquaticBlazeRod = new ItemBase("rod_aquatic_blaze");
	public static ItemBase aquaton = new ItemBase("aquaton", Divine.CombatTab);
	public static SpawnerBase arcanaSpawnEgg = new SpawnerBase("spawn_egg_arcana", EntitySlime);
	public static SwordBase amthrimisBackSword = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "sword_amthirmis_back");
	public static SwordBase aquatoothSword = new SwordBase(DivineRPGMaterials.aquatoothSwordMaterial, "sword_aquatooth");
	public static SwordBase arksianeWrathSword = new SwordBase(DivineRPGMaterials.arksianeSwordMaterial, "sword_arksiane_wrath");
	public static SwordBase bedrockSword = new SwordBase(DivineRPGMaterials.bedrockSwordMaterial, "sword_bedrock");
	public static SwordBase blackEnderSword = new SwordBase(DivineRPGMaterials.blackEnderSwordMaterial, "sword_black_ender");
	public static SwordBase bloodgemSword = new SwordBase(DivineRPGMaterials.bloodgemSwordMaterial, "sword_bloodgem");
	public static SwordBase blueDivineSword = new SwordBase(DivineRPGMaterials.blueDivineSwordMaterial, "sword_blue_divine");
	public static SwordBase stormSword = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "sword_storm");
	public static FoodBase chickenDinner = new FoodBase("winner_winner", 18, false);
	public static AxeBase corruptedAxe = new AxeBase(DivineRPGMaterials.stormSwordMaterial, "axe_corrupted", 18F, 1F);
	public static Angelic angelicHelmet = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.HEAD, "angelic_helmet");
	public static Angelic angelicChestplate = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.CHEST, "angelic_chestplate");
	public static Angelic angelicLeggings = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.LEGS, "angelic_leggings");
	public static Angelic angelicBoots = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.FEET, "angelic_boots");
	
	
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
				twilightClock,
				acid,
				advancedMushroomStew,
				aquamarine,
				aquaticBlazeRod,
				aquaton,
				arcanaSpawnEgg,
				amthrimisBackSword,
				aquatoothSword,
				arksianeWrathSword,
				bedrockSword,
				blackEnderSword,
				bloodgemSword,
				blueDivineSword,
				stormSword,
				chickenDinner,
				corruptedAxe,
				angelicHelmet,
				angelicChestplate,
				angelicLeggings,
				angelicBoots
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
		acid.registerItemModel();
		advancedMushroomStew.registerItemModel();
		aquamarine.registerItemModel();
		aquamarine.registerItemModel();
		aquaticBlazeRod.registerItemModel();
		aquaton.registerItemModel();
		arcanaSpawnEgg.registerItemModel();
		amthrimisBackSword.registerItemModel(amthrimisBackSword);
		aquatoothSword.registerItemModel(aquatoothSword);
		arksianeWrathSword.registerItemModel(arksianeWrathSword);
		bedrockSword.registerItemModel(bedrockSword);
		blackEnderSword.registerItemModel(blackEnderSword);
		bloodgemSword.registerItemModel(bloodgemSword);
		blueDivineSword.registerItemModel(blueDivineSword);
		stormSword.registerItemModel(stormSword);
		chickenDinner.registerItemModel();
		corruptedAxe.registerItemModel(corruptedAxe);
		angelicHelmet.registerItemModel(angelicHelmet);
		angelicChestplate.registerItemModel(angelicChestplate);
		angelicLeggings.registerItemModel(angelicLeggings);
		angelicBoots.registerItemModel(angelicBoots);
		System.out.print("DivineRPG items loaded");
	}
}