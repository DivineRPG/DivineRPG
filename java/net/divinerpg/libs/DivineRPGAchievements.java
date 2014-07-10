package net.divinerpg.libs;

import net.divinerpg.utils.blocks.*;
import net.divinerpg.utils.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class DivineRPGAchievements {

    public static final Achievement divineInervention 		= addAchievement("divineIntervention"	, 0, 3, VanillaItemsOther.callWatcher, null, false);					//DONE
    public static final Achievement	divinePlan 		  		= addAchievement("divinePlan"			, 1, 4, VanillaItemsWeapons.divineSword, divineInervention, false);
    public static final Achievement liesWithin 		  		= addAchievement("liesWithin"			, 0, 5, ArcanaBlocks.arcanaPortalFrame, null, false);					//DONE
    public static final Achievement perfectlyCorrupted 		= addAchievement("perfectlyCorrupted"	, 6, 0, VanillaBlocks.altarOfCorruption, null, false);					//DONE
    public static final Achievement totalDemonization 		= addAchievement("totalDemonization"	, 3, 11, ArcanaBlocks.demonFurnace, liesWithin, false);					//DONE
    public static final Achievement greatBirdFire 			= addAchievement("evilDisease"			, 3, 9, ArcanaItems.dungeonTokens, liesWithin, false);
    public static final Achievement dungeonMaster 			= addAchievement("dungeonMaster"		, 3, 4, ArcanaItems.dungeonTokens, liesWithin, false);
    public static final Achievement eyeOfEvil 				= addAchievement("eyeOfEvil"			, 1, 0, VanillaItemsOther.rupeeIngot, null, false);						//DONE
    public static final Achievement tripleDanger 			= addAchievement("tripleDanger"			, 3, 0, VanillaItemsOther.enderShard, null, false);						//DONE
    public static final Achievement	possibilities 			= addAchievement("possibilities"		, 2, 3, VanillaBlocks.divineRock, divineInervention, false);			//DONE
    public static final Achievement friendOrFoe 			= addAchievement("friendOrFoe"			, 4, 3, TwilightItemsOther.edenSoul, possibilities, false);				//DONE
    public static final Achievement darkAnotherDay 			= addAchievement("darkAnotherDay"		, 6, 3, TwilightBlocks.mortumBlock, possibilities, false);				//DONE
    public static final Achievement tenHeadsIsBetterThanOne = addAchievement("spawnDAR"				, 6, 2, TwilightItemsOther.spawnDensos, darkAnotherDay, false);			//DONE
    public static final Achievement whenPigsFly 			= addAchievement("whenPigsFly"			, 3, 2, VanillaItemsArmor.angelicHelmet, divineInervention, false);		//DONE
    public static final Achievement offKey 					= addAchievement("offKey"				, 7, 0, IceikaItems.soundOfMusic, null, false);							//DONE
    //public static final Achievement skyHigh 				= addAchievement("skyHigh"				, 3, 5, VanillaBlocks.elevantium, liesWithin, false);
    public static final Achievement allHellLoose 			= addAchievement("allHellLoose"			, 3, 10, ArcanaItems.stormSword, liesWithin, false);					//DONE
    public static final Achievement enrichment 				= addAchievement("enrichment"			, 3, 7, ArcanaItems.staffOfEnrichment, liesWithin, false);				//DONE
    public static final Achievement hoterThanHell 			= addAchievement("hotterThanHell"		, 3, 9, ArcanaBlocks.heatTrapOn, liesWithin, false);					//DONE
    public static final Achievement	mealToRemember 			= addAchievement("mealToRemember"		, 2, 0, ItemsFood.chickenDinner, null, false);							//DONE
    public static final Achievement yuk						= addAchievement("yuk"					, 3, 8, ArcanaItems.weakArcanaPotion, liesWithin, false);				//DONE
    public static final Achievement littleCreature 			= addAchievement("littleCreature"		, 3, 6, ArcanaItems.seimerSpawner, liesWithin, false);					//DONE
    public static final Achievement	halloweenSpirit 		= addAchievement("halloweenSpirit"		, 5, 0, VanillaItemsWeapons.scythe, null, false);						//DONE
    public static final Achievement feedingOnTheFish 		= addAchievement("feedingOnTheFish"		, 4, 0, VanillaItemsOther.sharkFin, null, false);						//DONE
    public static final Achievement frozenLand				= addAchievement("frozenLand"			, 0, 1, IceikaBlocks.portal, null, false); 								//DONE
    public static final Achievement frozenGoods 			= addAchievement("frozenGoods"			, 8, 1, IceikaBlocks.frostedChest, frozenLand, false);					//DONE
    public static final Achievement lilTinkerin 			= addAchievement("lilTinkerin"			, 7, 2, IceikaItems.frozenMaul, frozenGoods, false);					//DONE
    public static final Achievement dramcryxDeath 			= addAchievement("dramcryxDeath"		, 0, 0, VanillaItemsOther.jungleShards, null, false);					//DONE
    
    private static Achievement addAchievement(String name, int x, int y, Block image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Item image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial();
	}
    
    public static AchievementPage page = new AchievementPage("DivineRPG", divinePlan, divineInervention, liesWithin, friendOrFoe,
			tenHeadsIsBetterThanOne, perfectlyCorrupted, totalDemonization, greatBirdFire, dungeonMaster,
			eyeOfEvil, tripleDanger, possibilities, enrichment, hoterThanHell, mealToRemember, yuk,
			littleCreature, halloweenSpirit, feedingOnTheFish, frozenLand, frozenGoods, 
			lilTinkerin, /*skyHigh,*/ whenPigsFly, offKey, allHellLoose, darkAnotherDay, dramcryxDeath);
    
    public static void init(){
		AchievementPage.registerAchievementPage(page);
	}
}