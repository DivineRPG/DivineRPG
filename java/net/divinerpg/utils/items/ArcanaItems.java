package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModPotion;
import net.divinerpg.api.items.ItemModSeeds;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.items.arcana.ItemArcanaProjectile;
import net.divinerpg.items.arcana.ItemArcanaSpawnEgg;
import net.divinerpg.items.arcana.ItemArcaniumSaber;
import net.divinerpg.items.arcana.ItemCaptainsSparkler;
import net.divinerpg.items.arcana.ItemChargedCollector;
import net.divinerpg.items.arcana.ItemEnderScepter;
import net.divinerpg.items.arcana.ItemGrenade;
import net.divinerpg.items.arcana.ItemKey;
import net.divinerpg.items.arcana.ItemMeriksMissile;
import net.divinerpg.items.arcana.ItemReflector;
import net.divinerpg.items.arcana.ItemShadowSword;
import net.divinerpg.items.arcana.ItemStaffEnrichment;
import net.divinerpg.items.arcana.ItemStaffStarlight;
import net.divinerpg.items.arcana.ItemStormSword;
import net.divinerpg.items.arcana.ItemWizardsBook;
import net.divinerpg.items.arcana.ItemWraithbane;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class ArcanaItems {

    public static final int       HEAD               = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    public static final Item      dungeonTokens      = new ItemMod("dungeonTokens");
    public static final Item      arcanium		     = new ItemMod("arcanium");
    public static final Item      staffStarlight     = new ItemStaffStarlight("staffOfStarlight");
    public static final Item      starlight          = new ItemStaffStarlight("starlight");
    public static final Item      stormSword         = new ItemStormSword("stormSword", ToolMaterialMod.Storm);
    public static final Item      captainsSparkler   = new ItemCaptainsSparkler("captainsSparkler");
    public static final Item      strongArcanaPotion = new ItemModPotion("strongArcanaPotion", 200);
    public static final Item      weakArcanaPotion   = new ItemModPotion("weakArcanaPotion", 100);
    public static final Item      collector          = new ItemMod("collector");
    public static final Item      chargedCollector   = new ItemChargedCollector("chargedCollector");
    public static final Item      wizardBook	     = new ItemWizardsBook("wizardsBook");
    public static final Item      staffOfEnrichment	 = new ItemStaffEnrichment("staffOfEnrichment");
    public static final Item      orbOfLight	 	 = new ItemMod("orbOfLight");
	public static final Item 	  meriksMissile 	 = new ItemMeriksMissile("meriksMissile", 1, -1, 50);
	public static final Item 	  grenade		 	 = new ItemGrenade("grenade");
	public static final Item 	  firefly 	 		 = new ItemArcanaProjectile("firefly", DivineRPGTabs.ranged, 1, -1, 5, 10);
	public static final Item 	  grenadeLauncher 	 = new ItemArcanaProjectile("laVekor", DivineRPGTabs.ranged, 1, -1, 5, 10);
	public static final Item 	  enderScepter  	 = new ItemEnderScepter("enderScepter");
	public static final Item 	  arcaniumSaber  	 = new ItemArcaniumSaber("arcaniumSaber", ToolMaterialMod.Saber);
	public static final Item 	  wraithbane  	 	 = new ItemWraithbane("wraithbane");
	public static final Item 	  reflector  	 	 = new ItemReflector("reflector");
	public static final Item 	  shadowSword  	 	 = new ItemShadowSword("shadowSaber", ToolMaterialMod.ShadowSaber);
	public static final Item 	  liviciaSword  	 = new ItemModSword(ToolMaterialMod.LiviciaSword, "liviciaSword");

    public static final Item key1 				 	 = new ItemKey("key1");
    public static final Item key2 				 	 = new ItemKey("key2");
    public static final Item key3 				 	 = new ItemKey("key3");
    public static final Item key4 				 	 = new ItemKey("key4");

	public static final Item 	  golemSpawner   	 = new ItemArcanaSpawnEgg("golemSpawner");
	public static final Item 	  seimerSpawner   	 = new ItemArcanaSpawnEgg("seimerSpawner");
	public static final Item 	  paratikuSpawner    = new ItemArcanaSpawnEgg("paratikuSpawner");
	public static final Item 	  fyracryxSpawner    = new ItemArcanaSpawnEgg("fyracryxSpawner");

    public static final Item hitchak		 		 = new ItemMod("hitchak");
    public static final Item hitchakSeeds 			 = new ItemModSeeds("hitchakSeeds", ArcanaBlocks.hitchak);
    public static final Item veilo		 		     = new ItemMod("veilo");
    public static final Item veiloSeeds 			 = new ItemModSeeds("veiloSeeds", ArcanaBlocks.veilo);
    public static final Item marsine		 		 = new ItemMod("marsine");
    public static final Item marsineSeeds 			 = new ItemModSeeds("marsineSeeds", ArcanaBlocks.marsine);
    public static final Item lamona		 			 = new ItemMod("lamona");
    public static final Item lamonaSeeds 			 = new ItemModSeeds("lamonaSeeds", ArcanaBlocks.lamona);
    public static final Item firestock		 		 = new ItemMod("firestock");
    public static final Item firestockSeeds 		 = new ItemModSeeds("firestockSeeds", ArcanaBlocks.firestock);
    public static final Item pinfly		 		     = new ItemMod("pinfly");
    public static final Item pinflySeeds 		     = new ItemModSeeds("pinflySeeds", ArcanaBlocks.pinfly);
    public static final Item moonbulb		 		 = new ItemMod("moonbulb");
    public static final Item moonbulbSeeds  		 = new ItemModSeeds("moonbulbSeeds", ArcanaBlocks.moonbulb);
    public static final Item aquamarine		 		 = new ItemMod("aquamarine");
    public static final Item aquamarineSeeds 		 = new ItemModSeeds("aquamarineSeeds", ArcanaBlocks.aquamarine);
    public static final Item eucalyptusSeeds    	 = new ItemModSeeds("eucalyptusRootSeeds", ArcanaBlocks.eucalyptusRoot);

    
    private static final Object[] kormInfo           = new Object[] { ArmorInfo.ARCANA_REGEN };
    public static final Item      kormaHelmet        = new ItemDivineArmor(EnumArmor.KORMA, HEAD, kormInfo);
    public static final Item      kormaBody          = new ItemDivineArmor(EnumArmor.KORMA, BODY, kormInfo);
    public static final Item      kormaLegs          = new ItemDivineArmor(EnumArmor.KORMA, LEGS, kormInfo);
    public static final Item      kormaBoots         = new ItemDivineArmor(EnumArmor.KORMA, BOOTS, kormInfo);

    private static final Object[] vemInfo            = new Object[] { ArmorInfo.HEALTH_REGEN };
    public static final Item      vemosHelmet        = new ItemDivineArmor(EnumArmor.KORMA, HEAD, "vemos", vemInfo);
    public static final Item      vemosBody          = new ItemDivineArmor(EnumArmor.KORMA, BODY, "vemos", vemInfo);
    public static final Item      vemosLegs          = new ItemDivineArmor(EnumArmor.KORMA, LEGS, "vemos", vemInfo);
    public static final Item      vemosBoots         = new ItemDivineArmor(EnumArmor.KORMA, BOOTS, "vemos", vemInfo);

    
    
}
