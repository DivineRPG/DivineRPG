package net.divinerpg.client.render;

import net.divinerpg.libs.Reference;
import net.minecraft.util.ResourceLocation;


public class EntityResourceLocation {

    public static final String     PREFIX            = Reference.PREFIX + "textures/mobs/";
    public static final String     PREFIX_PROJECTILE = Reference.PREFIX + "textures/projectiles/";
    public static final String 	   modelPrefix 		 = Reference.PREFIX + "textures/model/";

    public static ResourceLocation enderWatcher      = addMob("enderWatcher");
    public static ResourceLocation crab              = addMob("crab");
    public static ResourceLocation kingCrab          = addMob("kingCrab");
    public static ResourceLocation caveCrawler       = addMob("caveCrawler");
    public static ResourceLocation desertCrawler     = addMob("desertCrawler");
    public static ResourceLocation jungleDramcryx    = addMob("jungleDramcryx");
    public static ResourceLocation cyclops           = addMob("cyclops");
    public static ResourceLocation caveclops         = addMob("caveclops");
    public static ResourceLocation ancient           = addMob("ancientEntity");
    public static ResourceLocation scorcher          = addMob("scorcher");
    public static ResourceLocation hellSpider        = addMob("hellSpider");
    public static ResourceLocation whale             = addMob("whale");
    public static ResourceLocation enderSpider       = addMob("enderSpider");
    public static ResourceLocation enderTriplets     = addMob("enderTriplets");
    public static ResourceLocation miner 			 = addMob("miner");
    public static ResourceLocation jackOMan 		 = addMob("jackOMan");
    public static ResourceLocation jungleBat 		 = addMob("jungleBat");
    public static ResourceLocation hellPig 		 	 = addMob("hellPig");
    public static ResourceLocation hellPigMad 		 = addMob("hellPigMad");
    public static ResourceLocation hellPigTame 		 = addMob("hellPigTame");
    public static ResourceLocation aridWarrior       = addMob("aridWarrior");
    public static ResourceLocation ayeraco_Blue      = addMob("ayeracoBlue");
    public static ResourceLocation ayeraco_Green     = addMob("ayeracoGreen");
    public static ResourceLocation ayeraco_Purple    = addMob("ayeracoPurple");
    public static ResourceLocation ayeraco_Red       = addMob("ayeracoRed");
    public static ResourceLocation ayeraco_Yellow    = addMob("ayeracoYellow");
    public static ResourceLocation caveDramcryx      = addMob("caveDramcryx");
    public static ResourceLocation theEye            = addMob("theEye");
    public static ResourceLocation frost             = addMob("frost");
    public static ResourceLocation iceMan            = addMob("iceMan");
    public static ResourceLocation kingOfScorchers   = addMob("kingOfScorchers");
    public static ResourceLocation rainbour          = addMob("rainbour");
    public static ResourceLocation rotatick          = addMob("rotatick");
    public static ResourceLocation shark             = addMob("shark");
    public static ResourceLocation netherWatcher     = addMob("watcher");
    public static ResourceLocation wildFire          = addMob("wildFire");

    public static ResourceLocation phaserHalite      = addProjectile("halitePhaser");
    public static ResourceLocation phaserWild        = addProjectile("wildPhaser");
    public static ResourceLocation phaserSkythern    = addProjectile("skythernPhaser");
    public static ResourceLocation phaserEden        = addProjectile("edenPhaser");
    public static ResourceLocation phaserMortum      = addProjectile("mortumPhaser");
    public static ResourceLocation phaserApalachia   = addProjectile("apalachiaPhaser");

    public static ResourceLocation blitzHalite       = addProjectile("haliteBlitz");
    public static ResourceLocation blitzWild         = addProjectile("wildBlitz");
    public static ResourceLocation blitzSkythern     = addProjectile("skythernBlitz");
    public static ResourceLocation blitzEden         = addProjectile("edenBlitz");
    public static ResourceLocation blitzMortum       = addProjectile("mortumBlitz");
    public static ResourceLocation blitzApalachia    = addProjectile("apalachiaBlitz");

    public static ResourceLocation staffProjectile 	 = addProjectile("bouncing");
    public static ResourceLocation evernight 	 	 = addProjectile("evernight");
    public static ResourceLocation cannon 			 = addProjectile("cannon");
    public static ResourceLocation eversightCannon 	 = addProjectile("cannon");
    public static ResourceLocation eversight 	 	 = addProjectile("eversight");
    public static ResourceLocation snowball 	 	 = addProjectile("snowball");
    public static ResourceLocation music	 	 	 = addProjectile("music");
    public static ResourceLocation frostclaw 	 	 = addProjectile("frostclawCannon");

    public static ResourceLocation edenArrow 	 	 = addProjectile("edenArrow");
    public static ResourceLocation wildArrow 	 	 = addProjectile("wildArrow");
    public static ResourceLocation apalachiaArrow 	 = addProjectile("apalachiaArrow");
    public static ResourceLocation skythernArrow 	 = addProjectile("skythernArrow");
    public static ResourceLocation mortumArrow 	 	 = addProjectile("mortumArrow");
    public static ResourceLocation haliteArrow 	 	 = addProjectile("haliteArrow");
    
    public static ResourceLocation scytheProjectile  = addProjectile("scythe");
    public static ResourceLocation starlight	     = addProjectile("starlight");
    public static ResourceLocation sparkler		     = addProjectile("sparkler");
    public static ResourceLocation death		     = addProjectile("serenadeOfDeath");
    public static ResourceLocation cave			     = addProjectile("caveRock");
    public static ResourceLocation coriShot 	     = addProjectile("weakCoriShot");
    public static ResourceLocation watcherShot 	     = addProjectile("watcherShot");
    public static ResourceLocation cyclopsShot 	     = addProjectile("cyclopsShot");
    public static ResourceLocation maelstorm 	     = addProjectile("maelstorm");

    public static ResourceLocation angryBunny		 = addMob("angryBunny");
    public static ResourceLocation angryBunnyTamed 	 = addMob("angryBunnyTamed");
    public static ResourceLocation densos			 = addMob("densos");
    public static ResourceLocation karot			 = addMob("karot");
    public static ResourceLocation reyvor			 = addMob("reyvor");
    public static ResourceLocation bunny			 = addMob("bunny");
    public static ResourceLocation bunnyTamed		 = addMob("bunnyTamed");
    public static ResourceLocation soulFiend		 = addMob("soulFiend");
    public static ResourceLocation twilightDemon	 = addMob("twilightDemon");
    public static ResourceLocation vamacheron		 = addMob("vamacheron");
    public static ResourceLocation edenTomo			 = addMob("edenTomo");
    public static ResourceLocation cadillion		 = addMob("cadillion");
    public static ResourceLocation edenCori			 = addMob("edenCori");
    public static ResourceLocation nesro			 = addMob("nesro");
    public static ResourceLocation madivel			 = addMob("madivel");
    public static ResourceLocation wildWoodGolem	 = addMob("wildWoodGolem");
    public static ResourceLocation wildWoodTomo		 = addMob("wildWoodTomo");
    public static ResourceLocation varek			 = addMob("varek");
    public static ResourceLocation wildWoodWolf		 = addMob("wildWoodWolf");
    public static ResourceLocation apalachiaCadillion= addMob("apalachiaCadillion");
    public static ResourceLocation apalachiaTomo	 = addMob("apalachiaTomo");
    public static ResourceLocation apalachiaGolem	 = addMob("apalachiaGolem");
    public static ResourceLocation apalachiaWarrior	 = addMob("apalachiaWarrior");
    public static ResourceLocation apalachiaArcher	 = addMob("apalachiaArcher");
    public static ResourceLocation skythernArcher	 = addMob("skythernArcher");
    public static ResourceLocation samek			 = addMob("samek");
    public static ResourceLocation skythernGolem	 = addMob("skythernGolem");
    public static ResourceLocation skythernCori		 = addMob("skythernCori");
    public static ResourceLocation skythernFiend 	 = addMob("skythernFiend");
    public static ResourceLocation mortumCadillion	 = addMob("mortumCadillion");
    public static ResourceLocation mortumDemon		 = addMob("mortumDemon");
    public static ResourceLocation basalisk			 = addMob("basalisk");
    public static ResourceLocation soulStealer		 = addMob("soulStealer");
    public static ResourceLocation glacon			 = addMob("glacon");
    
    public static ResourceLocation roamer            = addMob("roamer");
    public static ResourceLocation deathcryx         = addMob("deathcryx");
    public static ResourceLocation death_hound       = addMob("deathHound");
    public static ResourceLocation leorna            = addMob("leorna");
    public static ResourceLocation razorback         = addMob("razorback");
    public static ResourceLocation constructor       = addMob("constructor");
    public static ResourceLocation living_statue     = addMob("livingStatue");
    public static ResourceLocation dungeon_prisoner  = addMob("dungeonPrisoner");
    public static ResourceLocation dungeon_demon     = addMob("dungeonDemon");
    public static ResourceLocation captain_merik     = addMob("captainMerik");
    public static ResourceLocation datticon          = addMob("datticon");
    public static ResourceLocation vatticus          = addMob("vatticus");
    public static ResourceLocation zelus             = addMob("zelus");
    public static ResourceLocation fyracryx          = addMob("fyracryx");
    public static ResourceLocation paratiku          = addMob("paratiku");
    public static ResourceLocation golem_rejuv       = addMob("healingGolem");
    public static ResourceLocation seimer            = addMob("seimer");
    public static ResourceLocation wraith            = addMob("wraith");
    public static ResourceLocation dramix            = addMob("dramix");
    public static ResourceLocation parasecta         = addMob("parasecta");
    
    public static ResourceLocation VERMENOUS 		 = addMob("vermenous");
    public static ResourceLocation ENT 				 = addMob("ent");
    public static ResourceLocation CYMESOID 		 = addMob("cymesoid");
    public static ResourceLocation DREAMWRECKER 	 = addMob("dreamwrecker");
    public static ResourceLocation SHADAHIER 		 = addMob("shadahier");
    public static ResourceLocation ACID_HAG 		 = addMob("acidHag");
    public static ResourceLocation KAZROTIC 		 = addMob("kazrotic");
    public static ResourceLocation HELIO 			 = addMob("helio");
    public static ResourceLocation GORGOSION 		 = addMob("gorgosion");
    public static ResourceLocation HOVER_STINGER 	 = addMob("hoverStinger");
    public static ResourceLocation ZONE 			 = addMob("zone");
    public static ResourceLocation ZORAGON 			 = addMob("zoragon");
    public static ResourceLocation DISSIMENT 		 = addMob("dissiment");
    public static ResourceLocation VHRAAK 			 = addMob("vhraak");
    public static ResourceLocation LADY_LUNA_RANGE 	 = addMob("ladyLunaRanged");
    public static ResourceLocation LADY_LUNA_ARCANIC = addMob("ladyLunaArcanic");
    public static ResourceLocation LADY_LUNA_MELEE 	 = addMob("ladyLunaMelee");
    public static ResourceLocation BOHEMITE 	     = addMob("boheimite");
    public static ResourceLocation WRECK_1 			 = addMob("wreckForm1");
    public static ResourceLocation WRECK_2 			 = addMob("wreckForm2");
    public static ResourceLocation WRECK_3 			 = addMob("wreckForm3");
    public static ResourceLocation HIVE_QUEEN 		 = addMob("hiveQueen");
    public static ResourceLocation HIVE_SOLDIER 	 = addMob("hiveSoldier");
    public static ResourceLocation BIPHRON 			 = addMob("biphron");
    public static ResourceLocation TWINS 			 = addMob("twins");
    public static ResourceLocation QUADRO 			 = addMob("quadro");
    public static ResourceLocation GALROID 			 = addMob("galroid");
    public static ResourceLocation HERBOMANCER 		 = addMob("herbomancer");
    public static ResourceLocation KAROS 		     = addMob("karos");
    public static ResourceLocation LHEIVA 		     = addMob("lheiva");
    public static ResourceLocation LORGA 			 = addMob("lorga");
    public static ResourceLocation LORGA_FLIGHT 	 = addMob("lorgaFlight");
    public static ResourceLocation MANDRAGORA 		 = addMob("mandragora");
    public static ResourceLocation RAGLOK 			 = addMob("raglokGogdure");
    public static ResourceLocation TOCAXIN 			 = addMob("tocaxin");
    public static ResourceLocation HUNGER_HUNGRY 	 = addMob("hungerHungry");
    public static ResourceLocation ENDIKU 		     = addMob("endiku");
    public static ResourceLocation TEMPLE_GUARDIAN 	 = addMob("templeGuardian");
    public static ResourceLocation MM1				 = addMob("mysteriousMan1");
    public static ResourceLocation MM2				 = addMob("mysteriousMan2");
    public static ResourceLocation MM3				 = addMob("mysteriousMan3");
    public static ResourceLocation CRYPT_KEEPER		 = TEMPLE_GUARDIAN;
    public static ResourceLocation DUO 				 = addMob("duo");
    public static ResourceLocation EHU 				 = addMob("ehu");
    public static ResourceLocation HUSK 			 = addMob("husk");
    public static ResourceLocation VERMSILLION 		 = addMob("vermsillion");
    public static ResourceLocation STONE_GOLEM 		 = addMob("stoneGolem");
    
    public static ResourceLocation KING_STATUE 		 = addModel("statueKos");
    public static ResourceLocation ANCIENT_STATUE 	 = addModel("statueAnchient");
    public static ResourceLocation AYERACO_STATUE	 = addModel("statueAyeraco");
    public static ResourceLocation DENSOS_STATUE	 = addModel("statueDensos");
    public static ResourceLocation DEX_STATUE		 = addModel("statueDex");
    public static ResourceLocation DRAMIX_STATUE	 = addModel("statueDramix");
    public static ResourceLocation PARASECTA_STATUE	 = addModel("statueParasecta");
    public static ResourceLocation SOUL_STATUE		 = addModel("statueSF");
    public static ResourceLocation TWILIGHT_STATUE	 = addModel("statueTwilightDemon");
    public static ResourceLocation VAMACHERON_STATUE = addModel("statueVamacheron");
    public static ResourceLocation WATCHER_STATUE	 = addModel("statueWatcher");
    
    public static ResourceLocation GLACON = addMob("glacon");
    public static ResourceLocation FROZEN_ARCHER = addMob("frozenArcher");
    public static ResourceLocation ROLLUM = addMob("rollum");
    public static ResourceLocation ALICANTO = addMob("alicanto");
    public static ResourceLocation FRACTITE = addMob("fractite");
    public static ResourceLocation HASTERUS = addMob("hastreus");
    public static ResourceLocation WORKSHOP_TINKER = addMob("workshopTinkerer");
    public static ResourceLocation WORKSHOP_MERCHANT = addMob("workshopMerchant");
    
    private static ResourceLocation addMob(String tex){
    	return new ResourceLocation(PREFIX + tex + ".png");
    }
    
    private static ResourceLocation addProjectile(String tex){
    	return new ResourceLocation(PREFIX_PROJECTILE + tex + ".png");
    }
    
    private static ResourceLocation addModel(String tex){
    	return new ResourceLocation(modelPrefix + tex + ".png");
    }
}
