package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModFood;
import net.divinerpg.api.items.ItemModOrb;
import net.divinerpg.api.items.ItemModPotion;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.items.arcana.ItemAquamarine;
import net.divinerpg.items.arcana.ItemArcanaProjectile;
import net.divinerpg.items.arcana.ItemArcanaSeeds;
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
import net.divinerpg.items.vanilla.ItemThrowable;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;

public class ArcanaItems {

    public static final int       HEAD               = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    public static Item      dungeonTokens;
    public static Item      arcanium;
    public static Item      staffStarlight;
    public static Item      starlight;
    public static Item      stormSword;
    public static Item      captainsSparkler;
    public static Item      strongArcanaPotion;
    public static Item      weakArcanaPotion;
    public static Item      collector;
    public static Item      chargedCollector;
    public static Item      wizardBook;
    public static Item      staffOfEnrichment;
    public static Item      orbOfLight;
	public static Item 	  meriksMissile;
	public static Item 	  grenade;
	public static Item 	  firefly;
	public static Item 	  laVekor;
	public static Item 	  enderScepter;
	public static Item 	  arcaniumSaber;
	public static Item 	  wraithbane;
	public static Item 	  reflector;
	public static Item 	  shadowSword;
	public static Item 	  liviciaSword;

    public static Item key1;
    public static Item key2;
    public static Item key3;
    public static Item key4;

	public static Item 	  golemSpawner;
	public static Item 	  seimerSpawner;
	public static Item 	  paratikuSpawner;
	public static Item 	  fyracryxSpawner;
	
    public static Item hitchak;
    public static Item hitchakSeeds;
    public static Item veilo;
    public static Item veiloSeeds;
    public static Item marsine;
    public static Item marsineSeeds;
    public static Item lamona;
    public static Item lamonaSeeds;
    public static Item firestock;
    public static Item firestockSeeds;
    public static Item pinfly;
    public static Item pinflySeeds;
    public static Item aquamarine;
    public static Item aquamarineSeeds;
    public static Item eucalyptusSeeds;

    
    private static final Object[] kormInfo           = new Object[] { ArmorInfo.ARCANA_REGEN };
    public static Item      kormaHelmet;
    public static Item      kormaBody;
    public static Item      kormaLegs;
    public static Item      kormaBoots;

    private static final Object[] vemInfo            = new Object[] { ArmorInfo.HEALTH_REGEN };
    public static Item      vemosHelmet;
    public static Item      vemosBody;
    public static Item      vemosLegs;
    public static Item      vemosBoots;
    
    public static void init() {
    	dungeonTokens    	     = new ItemMod("dungeonTokens");
        arcanium		   	     = new ItemMod("arcanium");
        staffStarlight   	     = new ItemStaffStarlight("staffOfStarlight");
        starlight        	     = new ItemStaffStarlight("starlight");
        stormSword        		 = new ItemStormSword("stormSword", ToolMaterialMod.Storm);
        captainsSparkler	     = new ItemCaptainsSparkler("captainsSparkler");
        strongArcanaPotion 		 = new ItemModPotion("strongArcanaPotion", 200);
        weakArcanaPotion   		 = new ItemModPotion("weakArcanaPotion", 100);
        collector         		 = new ItemMod("collector");
        chargedCollector   		 = new ItemChargedCollector("chargedCollector");
        wizardBook	     	  	 = new ItemWizardsBook("wizardsBook");
        staffOfEnrichment		 = new ItemStaffEnrichment("staffOfEnrichment");
        orbOfLight	 			 = new ItemModOrb("orbOfLight");//TODO: make this work.
    	meriksMissile 			 = new ItemMeriksMissile("meriksMissile", 1, -1, 50);
    	grenade		 			 = new ItemGrenade("grenade");
    	firefly 	 			 = new ItemArcanaProjectile("firefly", DivineRPGTabs.ranged, 1, -1, 5, 10);
    	laVekor		 			 = new ItemArcanaProjectile("laVekor", DivineRPGTabs.ranged, 1, -1, 5, 10);
    	enderScepter  			 = new ItemEnderScepter("enderScepter");
    	arcaniumSaber  			 = new ItemArcaniumSaber("arcaniumSaber", ToolMaterialMod.Saber);
    	wraithbane  	 		 = new ItemWraithbane("wraithbane");
    	reflector  	 	 		 = new ItemReflector("arcaniumReflector");
    	shadowSword  	 	 	 = new ItemShadowSword("shadowSaber", ToolMaterialMod.ShadowSaber);
    	liviciaSword  	 		 = new ItemModSword(ToolMaterialMod.LiviciaSword, "liviciaSword");

        key1 				 	 = new ItemKey("key1");
        key2 				 	 = new ItemKey("key2");
        key3 				 	 = new ItemKey("key3");
        key4 				 	 = new ItemKey("key4");

    	golemSpawner   	 		 = new ItemArcanaSpawnEgg("golemSpawner");
    	seimerSpawner   	 	 = new ItemArcanaSpawnEgg("seimerSpawner");
    	paratikuSpawner   		 = new ItemArcanaSpawnEgg("paratikuSpawner");
    	fyracryxSpawner    		 = new ItemArcanaSpawnEgg("fyracryxSpawner");

        hitchak		 		 	 = new ItemModFood(2, 3, false, "hitchak");
        hitchakSeeds 			 = new ItemArcanaSeeds("hitchakSeeds", ArcanaBlocks.hitchak);
        veilo		 		     = new ItemMod("veilo");
        veiloSeeds 			 	 = new ItemArcanaSeeds("veiloSeeds", ArcanaBlocks.veilo);
        marsine		 		 	 = new ItemMod("marsine");
        marsineSeeds 			 = new ItemArcanaSeeds("marsineSeeds", ArcanaBlocks.marsine);
        lamona		 			 = new ItemThrowable(0, "lamona");
        lamonaSeeds 			 = new ItemArcanaSeeds("lamonaSeeds", ArcanaBlocks.lamona);
        firestock		 		 = new ItemMod("firestock");
        firestockSeeds 		 	 = new ItemArcanaSeeds("firestockSeeds", ArcanaBlocks.firestock);
        pinfly 	 		     	 = new ItemModFood(2, 0.3F, false, "pinfly").setPotionEffect(Potion.moveSpeed.id, 10, 2, 1.0F);
        pinflySeeds 		     = new ItemArcanaSeeds("pinflySeeds", ArcanaBlocks.pinfly);
        aquamarine		 		 = new ItemAquamarine("aquamarine");
        aquamarineSeeds 		 = new ItemArcanaSeeds("aquamarineSeeds", ArcanaBlocks.aquamarine);
        eucalyptusSeeds    	 	 = new ItemArcanaSeeds("eucalyptusRootSeeds", ArcanaBlocks.eucalyptusRoot);

        
        kormaHelmet        = new ItemDivineArmor(EnumArmor.KORMA, HEAD, kormInfo);
        kormaBody          = new ItemDivineArmor(EnumArmor.KORMA, BODY, kormInfo);
        kormaLegs          = new ItemDivineArmor(EnumArmor.KORMA, LEGS, kormInfo);
        kormaBoots         = new ItemDivineArmor(EnumArmor.KORMA, BOOTS, kormInfo);

        vemosHelmet        = new ItemDivineArmor(EnumArmor.VEMOS, HEAD, "vemos", vemInfo);
        vemosBody          = new ItemDivineArmor(EnumArmor.VEMOS, BODY, "vemos", vemInfo);
        vemosLegs          = new ItemDivineArmor(EnumArmor.VEMOS, LEGS, "vemos", vemInfo);
        vemosBoots         = new ItemDivineArmor(EnumArmor.VEMOS, BOOTS, "vemos", vemInfo);
    }
    
}
