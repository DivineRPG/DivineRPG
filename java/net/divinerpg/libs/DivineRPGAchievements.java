package net.divinerpg.libs;

import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class DivineRPGAchievements {

    public static final Achievement divineInervention 		= addAchievement("divineIntervention"	, 0, 3, VanillaItemsOther.callWatcher, null, true);					//DONE
    public static final Achievement	divinePlan 		  		= addAchievement("divinePlan"			, 1, 4, VanillaItemsWeapons.divineSword, divineInervention, false);
    public static final Achievement whatLiesWithin 		    = addAchievement("whatLiesWithin"		, 0, 5, ArcanaBlocks.arcanaPortalFrame, null, true);					//DONE
    public static final Achievement perfectlyCorrupted 		= addAchievement("perfectlyCorrupted"	, 6, 0, VanillaBlocks.altarOfCorruption, null, false);					//DONE
    public static final Achievement totalDemonization 		= addAchievement("totalDemonization"	, 3, 11, ArcanaBlocks.demonFurnace, whatLiesWithin, false);					//DONE
    public static final Achievement greatBirdFire 			= addAchievement("evilDisease"			, 3, 9, ArcanaItems.dungeonTokens, whatLiesWithin, false);
    public static final Achievement dungeonMaster 			= addAchievement("dungeonMaster"		, 3, 4, ArcanaItems.dungeonTokens, whatLiesWithin, false);
    public static final Achievement eyeOfEvil 				= addAchievement("eyeOfEvil"			, 1, 0, VanillaItemsOther.rupeeIngot, null, false);						//DONE
    public static final Achievement tripleDanger 			= addAchievement("tripleDanger"			, 3, 0, VanillaItemsOther.enderShard, null, false);						//DONE
    public static final Achievement	possibilities 			= addAchievement("possibilities"		, 2, 3, VanillaBlocks.divineRock, divineInervention, true);			//DONE
    public static final Achievement friendOrFoe 			= addAchievement("friendOrFoe"			, 4, 3, TwilightItemsOther.edenSoul, possibilities, false);				//DONE
    public static final Achievement darkAnotherDay 			= addAchievement("darkAnotherDay"		, 6, 3, TwilightBlocks.mortumBlock, possibilities, true);				//DONE
    public static final Achievement tenHeadsIsBetterThanOne = addAchievement("spawnDAR"				, 6, 2, TwilightItemsOther.spawnDensos, darkAnotherDay, true);			//DONE
    public static final Achievement whenPigsFly 			= addAchievement("whenPigsFly"			, 3, 2, VanillaItemsArmor.angelicHelmet, divineInervention, true);		//DONE
    public static final Achievement offKey 					= addAchievement("offKey"				, 7, 0, IceikaItems.soundOfMusic, null, false);							//DONE
    public static final Achievement skyHigh 				= addAchievement("skyHigh"				, 3, 5, ArcanaBlocks.elevantium, whatLiesWithin, false);
    public static final Achievement allHellLoose 			= addAchievement("allHellLoose"			, 3, 10, ArcanaItems.stormSword, whatLiesWithin, true);					//DONE
    public static final Achievement enrichment 				= addAchievement("enrichment"			, 3, 7, ArcanaItems.staffOfEnrichment, whatLiesWithin, true);				//DONE
    public static final Achievement hoterThanHell 			= addAchievement("hotterThanHell"		, 3, 9, ArcanaBlocks.heatTrapOn, whatLiesWithin, false);					//DONE
    public static final Achievement	mealToRemember 			= addAchievement("mealToRemember"		, 2, 0, ItemsFood.chickenDinner, null, false);							//DONE
    public static final Achievement yuk 					= addAchievement("yuk"					, 3, 8, ArcanaItems.weakArcanaPotion, whatLiesWithin, false);				//DONE
    public static final Achievement littleCreature 			= addAchievement("littleCreature"		, 3, 6, ArcanaItems.seimerSpawner, whatLiesWithin, false);					//DONE
    public static final Achievement	halloweenSpirit 		= addAchievement("halloweenSpirit"		, 5, 0, VanillaItemsWeapons.scythe, null, false);						//DONE
    public static final Achievement feedingOnTheFish 		= addAchievement("feedingOnTheFish"		, 4, 0, VanillaItemsOther.sharkFin, null, false);						//DONE
    public static final Achievement frozenLand				= addAchievement("frozenLand"			, 0, 1, IceikaBlocks.iceikaPortal, null, true); 								//DONE
    public static final Achievement frozenGoods 			= addAchievement("frozenGoods"			, 8, 1, IceikaBlocks.frostedChest, frozenLand, false);					//DONE
    public static final Achievement lilTinkerin 			= addAchievement("lilTinkerin"			, 7, 2, IceikaItems.frozenMaul, frozenGoods, false);					//DONE
    public static final Achievement dramcryxDeath 			= addAchievement("dramcryxDeath"		, 0, 0, VanillaItemsOther.jungleShards, null, false);					//DONE
    public static final Achievement oneLampTwoLampRedLampBlueLamp = addAchievement("oneLampTwoLampRedLampBlueLamp", 5, 2, VanillaBlocks.lamp1, 7, possibilities, false);
    
    private static Achievement addAchievement(String name, int x, int y, Block image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Item image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Block image, int meta, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, new ItemStack(image, 1, meta), (Achievement)haveFirst).registerStat().setSpecial() : new Achievement(name, name, x, y, new ItemStack(image, 1, meta), (Achievement)haveFirst).registerStat();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Item image, int meta, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, new ItemStack(image, 1, meta), (Achievement)haveFirst).registerStat().setSpecial() : new Achievement(name, name, x, y, new ItemStack(image, 1, meta), (Achievement)haveFirst).registerStat();
	}
    
    public static AchievementPage page = new AchievementPage("DivineRPG", divinePlan, divineInervention, whatLiesWithin, friendOrFoe,
			tenHeadsIsBetterThanOne, perfectlyCorrupted, totalDemonization, greatBirdFire, dungeonMaster,
			eyeOfEvil, tripleDanger, possibilities, enrichment, hoterThanHell, mealToRemember, yuk,
			littleCreature, halloweenSpirit, feedingOnTheFish, frozenLand, frozenGoods, 
			lilTinkerin, skyHigh, whenPigsFly, offKey, allHellLoose, darkAnotherDay, dramcryxDeath, oneLampTwoLampRedLampBlueLamp);
    
    public static void init(){
		AchievementPage.registerAchievementPage(page);
	}
}