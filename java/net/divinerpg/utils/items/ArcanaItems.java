package net.divinerpg.utils.items;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.items.arcana.ItemAquamarine;
import net.divinerpg.items.arcana.ItemArcanaPotion;
import net.divinerpg.items.arcana.ItemArcanaSeeds;
import net.divinerpg.items.arcana.ItemArcanaSpawnEgg;
import net.divinerpg.items.arcana.ItemArcaniteBlade;
import net.divinerpg.items.arcana.ItemArcaniteBlaster;
import net.divinerpg.items.arcana.ItemArcaniumSaber;
import net.divinerpg.items.arcana.ItemAttractor;
import net.divinerpg.items.arcana.ItemCaptainsSparkler;
import net.divinerpg.items.arcana.ItemChargedCollector;
import net.divinerpg.items.arcana.ItemDivineAccumulator;
import net.divinerpg.items.arcana.ItemEnderScepter;
import net.divinerpg.items.arcana.ItemFirefly;
import net.divinerpg.items.arcana.ItemGeneralsStaff;
import net.divinerpg.items.arcana.ItemGrenade;
import net.divinerpg.items.arcana.ItemKey;
import net.divinerpg.items.arcana.ItemLaVekor;
import net.divinerpg.items.arcana.ItemLamona;
import net.divinerpg.items.arcana.ItemMeriksMissile;
import net.divinerpg.items.arcana.ItemMeteorMash;
import net.divinerpg.items.arcana.ItemOrbOfLight;
import net.divinerpg.items.arcana.ItemReflector;
import net.divinerpg.items.arcana.ItemShadowSword;
import net.divinerpg.items.arcana.ItemStaffEnrichment;
import net.divinerpg.items.arcana.ItemStaffStarlight;
import net.divinerpg.items.arcana.ItemStormSword;
import net.divinerpg.items.arcana.ItemWizardsBook;
import net.divinerpg.items.arcana.ItemGhostbane;
import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModFood;
import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.items.twilight.ItemTwilightSeeds;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
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
	public static Item	  meteorMash;
	public static Item	  divineAccumulator;
	public static Item 	  arcaniteBlaster;
	public static Item	  arcaniteBlade;
	public static Item	  generalsStaff;
	public static Item	  attractor;

    public static Item sludgeKey;
    public static Item ancientKey;
    public static Item soulKey;
    public static Item degradedKey;

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
        strongArcanaPotion 		 = new ItemArcanaPotion("strongArcanaPotion", 200);
        weakArcanaPotion   		 = new ItemArcanaPotion("weakArcanaPotion", 100);
        collector         		 = new ItemMod("collector");
        chargedCollector   		 = new ItemChargedCollector("chargedCollector");
        wizardBook	     	  	 = new ItemWizardsBook("wizardsBook");
        staffOfEnrichment		 = new ItemStaffEnrichment("staffOfEnrichment");
        orbOfLight	 			 = new ItemOrbOfLight();
    	meriksMissile 			 = new ItemMeriksMissile("meriksMissile", 1, -1, 50);
    	grenade		 			 = new ItemGrenade("grenade");
    	firefly 	 			 = new ItemFirefly();
    	laVekor		 			 = new ItemLaVekor();
    	enderScepter  			 = new ItemEnderScepter("enderScepter");
    	arcaniumSaber  			 = new ItemArcaniumSaber("arcaniumSaber", ToolMaterialMod.Saber);
    	wraithbane  	 		 = new ItemGhostbane();
    	reflector  	 	 		 = new ItemReflector();
    	shadowSword  	 	 	 = new ItemShadowSword("shadowSaber", ToolMaterialMod.ShadowSaber);
    	liviciaSword  	 		 = new ItemModSword(ToolMaterialMod.LiviciaSword, "liviciaSword");
    	meteorMash				 = new ItemMeteorMash();
    	divineAccumulator		 = new ItemDivineAccumulator();
    	arcaniteBlaster			 = new ItemArcaniteBlaster();
    	arcaniteBlade  	 		 = new ItemArcaniteBlade();
    	generalsStaff			 = new ItemGeneralsStaff();
    	attractor				 = new ItemAttractor();

        sludgeKey 				 = new ItemKey("sludgeKey");
        ancientKey 				 = new ItemKey("ancientKey");
        soulKey 				 = new ItemKey("soulKey");
        degradedKey 			 = new ItemKey("degradedKey");

    	golemSpawner   	 		 = new ItemArcanaSpawnEgg("golemEgg");
    	seimerSpawner   	 	 = new ItemArcanaSpawnEgg("seimerEgg");
    	paratikuSpawner   		 = new ItemArcanaSpawnEgg("paratikuEgg");
    	fyracryxSpawner    		 = new ItemArcanaSpawnEgg("fyracryxEgg");

        hitchak		 		 	 = new ItemModFood(2, 3, false, "hitchak");
        hitchakSeeds 			 = new ItemArcanaSeeds("hitchakSeeds", (BlockModCrop)ArcanaBlocks.hitchak);
        veilo		 		     = new ItemMod("veilo");
        veiloSeeds 			 	 = new ItemArcanaSeeds("veiloSeeds", (BlockModCrop)ArcanaBlocks.veilo);
        marsine		 		 	 = new ItemMod("marsine");
        marsineSeeds 			 = new ItemArcanaSeeds("marsineSeeds", (BlockModCrop)ArcanaBlocks.marsine);
        lamona		 			 = new ItemLamona();
        lamonaSeeds 			 = new ItemArcanaSeeds("lamonaSeeds", (BlockModCrop)ArcanaBlocks.lamona);
        firestock		 		 = new ItemMod("firestock");
        firestockSeeds 		 	 = new ItemTwilightSeeds("firestockSeeds", ArcanaBlocks.firestock, ArcanaBlocks.arcanaGrass);
        pinfly 	 		     	 = new ItemModFood(2, 0.3F, false, "pinfly").setPotionEffect(Potion.moveSpeed.id, 10, 2, 1.0F);
        pinflySeeds 		     = new ItemTwilightSeeds("pinflySeeds", ArcanaBlocks.pinfly, ArcanaBlocks.arcanaGrass);
        aquamarine		 		 = new ItemAquamarine("aquamarine");
        aquamarineSeeds 		 = new ItemArcanaSeeds("aquamarineSeeds", (BlockModCrop)ArcanaBlocks.aquamarine);
        eucalyptusSeeds    	 	 = new ItemArcanaSeeds("eucalyptusRootSeeds", (BlockModCrop)ArcanaBlocks.eucalyptusRoot);

        
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
