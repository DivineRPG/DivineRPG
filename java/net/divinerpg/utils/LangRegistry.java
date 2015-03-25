package net.divinerpg.utils;

import java.util.ArrayList;

import net.divinerpg.blocks.vanilla.IDivineMetaBlock;
import net.divinerpg.utils.events.UpdateChecker;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry extends RegistryFile {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Item> key = new ArrayList<Item>();
    private static ArrayList<DivineRPGTabs> tabs = new ArrayList<DivineRPGTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();

    public static final RegistryFile instance = new LangRegistry();

    public LangRegistry() {
        super("en_US.lang");
    }

    public static void registerNames() {
        instance.addNames();
    }

    public static void addAchievements() {
        instance.addToFile("achievement.divineIntervention.desc=Spawn The Watcher");
        instance.addToFile("achievement.possibilities.desc=Enter the Eden dimension");
        instance.addToFile("achievement.friendOrFoe.desc=Make a Bunny angry");
        instance.addToFile("achievement.darkAnotherDay.desc=Enter the Mortum Dimension");
        instance.addToFile("achievement.whenPigsFly.desc=Wear a full Angelic armor set");
        instance.addToFile("achievement.offKey.desc=Shoot a Sound of Music");
        instance.addToFile("achievement.enrichment.desc=Use a Staff of Enrichment on Arcanite Dirt");
        instance.addToFile("achievement.littleCreature.desc=Spawn a pet from Zelus");
        instance.addToFile("achievement.halloweenSpirit.desc=Talk to a Jack-O-Man");
        instance.addToFile("achievement.feedingOnTheFish.desc=Kill a Shark");
        instance.addToFile("achievement.frozenLand.desc=Enter the Iceika dimension");
        instance.addToFile("achievement.frozenGoods.desc=Destroy a Frosted Chest");
        instance.addToFile("achievement.lilTinkerin.desc=Trade with a Workshop Tinkerer");
        instance.addToFile("achievement.lilGift.desc=Trade with a Workshop Merchant");
        instance.addToFile("achievement.divinePlan.desc=Craft a Divine Sword");
        instance.addToFile("achievement.whatLiesWithin.desc=Enter The Dungeon Of Arcana");
        instance.addToFile("achievement.perfectlyCorrupted.desc=Use the Altar Of Corruption");
        instance.addToFile("achievement.totalDemonization.desc=Use the Demon Furnace");
        instance.addToFile("achievement.evilDisease.desc=Kill Parasecta");
        instance.addToFile("achievement.dungeonMaster.desc=Kill Dramix");
        instance.addToFile("achievement.eyeOfEvil.desc=Look into the eye of The Eye");
        instance.addToFile("achievement.tripleTheDanger.desc=Kill an Ender Triplet");
        instance.addToFile("achievement.hotterThanHell.desc=Touch a Heat Trap");
        instance.addToFile("achievement.mealToRemember.desc=Eat a Chicken Dinner");
        instance.addToFile("achievement.yuk.desc=Drink an Arcana potion");
        instance.addToFile("achievement.spawnDAR.desc=Spawn Densos and Reyvor");
        instance.addToFile("achievement.dramcryxDeath.desc=Kill a Jungle Dramcryx");
        instance.addToFile("achievement.allHellLoose.desc=Use a Storm Sword");
        instance.addToFile("achievement.skyHigh.desc=Jump on an Elevantium Block");
        instance.addToFile("achievement.oneLampTwoLampRedLampBlueLamp.desc=Craft an Eden Lamp");
        instance.addToFile("achievement.sixInOne.desc=Spawn the Eternal Archer");
        instance.addToFile("achievement.arrowToTheKnee.desc=Get shot by a Twilight Archer");
        
        instance.addToFile("achievement.divineIntervention=Divine Intervention");
        instance.addToFile("achievement.possibilities=1001 Possibilities");
        instance.addToFile("achievement.friendOrFoe=Friend or Foe?");
        instance.addToFile("achievement.darkAnotherDay=Dark Another Day");
        instance.addToFile("achievement.whenPigsFly=When Pigs Fly");
        instance.addToFile("achievement.offKey=Off Key");
        instance.addToFile("achievement.enrichment=Enrichment");
        instance.addToFile("achievement.littleCreature=My Little Creature");
        instance.addToFile("achievement.halloweenSpirit=Halloween Spirit");
        instance.addToFile("achievement.oneLamp=One Lamp");
        instance.addToFile("achievement.feedingOnTheFish=Feeding on the Fish");
        instance.addToFile("achievement.hotterThanHell=Hotter than Hell");
        instance.addToFile("achievement.mealToRemember=A Meal to Remember");
        instance.addToFile("achievement.yuk=Yuk!");
        instance.addToFile("achievement.frozenLand=Frozen Land");
        instance.addToFile("achievement.frozenGoods=Frozen Goods");
        instance.addToFile("achievement.lilTinkerin=A Lil' Tinkerin'");
        instance.addToFile("achievement.divinePlan=A Divine Plan");
        instance.addToFile("achievement.whatLiesWithin=What Lies Within");
        instance.addToFile("achievement.perfectlyCorrupted=Perfectly Corrupted");
        instance.addToFile("achievement.totalDemonization=Total Demonization");
        instance.addToFile("achievement.evilDisease=Evil Disease");
        instance.addToFile("achievement.dungeonMaster=Dungeon Master");
        instance.addToFile("achievement.eyeOfEvil=Eye of Evil");
        instance.addToFile("achievement.tripleTheDanger=Triple The Danger");
        instance.addToFile("achievement.lilGift=A Lil' Gift");
        instance.addToFile("achievement.spawnDAR=Ten Heads are Better than One");
        instance.addToFile("achievement.dramcryxDeath=Death to all Jungle Stegosaurous!");
        instance.addToFile("achievement.allHellLoose=All Hell Loose");
        instance.addToFile("achievement.skyHigh=Sky High");
        instance.addToFile("achievement.oneLampTwoLampRedLampBlueLamp=One Lamp Two Lamp Red Lamp Blue Lamp");
        instance.addToFile("achievement.sixInOne=Six in One, Half a Dozen in the Other");
        instance.addToFile("achievement.arrowToTheKnee=Arrow to the Knee");
    }
    
    public static void addDeaths() {
        instance.addToFile("death.attack.arcana=%1$s was killed by magic");
        instance.addToFile("death.attack.trap=%1$s fell into a trap");
        instance.addToFile("death.attack.acid=%1$s melted in acid");
    }
    
    public static void addTooltips() {
        instance.addToFile("tooltip.uses=# Uses Remaining");
        instance.addToFile("tooltip.arcana=Consumes # Arcana");
        instance.addToFile("tooltip.meleeDam=# Melee Damage");
        instance.addToFile("tooltip.rangedDam=# Ranged Damage");
        instance.addToFile("tooltip.arcanaDam=# Arcana Damage");
        instance.addToFile("tooltip.ammo=Ammo: |item|");
        instance.addToFile("tooltip.infiniteAmmo=Infinite Ammo");
        instance.addToFile("tooltip.infiniteUses=Infinite Uses");
        instance.addToFile("tooltip.rangedAndMeleeDam=# Ranged and Melee Damage");
        instance.addToFile("tooltip.regensArcana=Replenishes # Arcana");
        instance.addToFile("tooltip.explosiveProjectiles=Explosive Projectiles");
        instance.addToFile("tooltip.homingProjectiles=Homing Projectiles");
        instance.addToFile("tooltip.fullSetPerks=Full Set Perks: ");
        instance.addToFile("tooltip.damageReduction=|percent| Damage Reduction (|percentFull| Full)");
        instance.addToFile("tooltip.noProtection=No Protection");
        instance.addToFile("tooltip.vethean=Vethean");
        instance.addToFile("tooltip.efficiency=Efficiency: #");
        instance.addToFile("tooltip.cannotBlock=Cannot Block");
    }
    
    public static void addMessages() {
        instance.addToFile("message.vatticus0=Can you feel the empowerment of the arcanium around you?");
        instance.addToFile("message.vatticus1=I hear there's no end to this place, there's no end to me either.");
        instance.addToFile("message.vatticus2=Arcana come upon me, give me the ultimate strength!");
        instance.addToFile("message.vatticus3=I've discovered how to awake the ancient leader of the dungeon.");
        instance.addToFile("message.vatticus4=Hurr drah drah, magic.");
        instance.addToFile("message.general0=My weapons will conquer any foe.");
        instance.addToFile("message.general1=");
        instance.addToFile("message.general2=");
        instance.addToFile("message.general3=");
        instance.addToFile("message.merchant0=Hohoho.");
        instance.addToFile("message.merchant1=It's cold outside.");
        instance.addToFile("message.merchant2=It's cold inside.");
        instance.addToFile("message.merchant3=Burr!");
        instance.addToFile("message.jackoman0=BOO!");
        instance.addToFile("message.jackoman1=I seem to have lost my head.");
        instance.addToFile("message.jackoman2=HURAH!");
        instance.addToFile("message.jackoman3=Have you seen my head?");
        instance.addToFile("message.guardian0=You are moving upwards, beware of the imminent danger.");
        instance.addToFile("message.guardian1=These places aren't for you.");
        instance.addToFile("message.guardian2=This is dangerous, what are you doing here?");
        instance.addToFile("message.guardian3=Temples are suited for humans.");
        instance.addToFile("message.guardian4=They are getting closer to killing you.");
        instance.addToFile("message.developer=Welcome DivineRPG developer!");
        instance.addToFile("message.standard=Thank you # for downloading and playing &!");
        instance.addToFile("message.internet=Unable to check for latest version, you may want to check your internet connection!");
        instance.addToFile("message.update=A DivineRPG update is avaliable.");
        instance.addToFile("message.version=[New Version: #]");
        instance.addToFile("message.ayeraco0=The Green Ayeraco has been called upon");
        instance.addToFile("message.ayeraco1=The Blue Ayeraco has been called upon");
        instance.addToFile("message.ayeraco2=The Red Ayeraco has been called upon");
        instance.addToFile("message.ayeraco3=The Yellow Ayeraco has been called upon");
        instance.addToFile("message.ayeraco4=The Purple Ayeraco has been called upon");
        instance.addToFile("message.ayeracospawn=The Ayeraco Horde has arrived!");
        instance.addToFile("message.karos0=So you came to play a game?");
        instance.addToFile("message.karos1=Let the game begin!");
        instance.addToFile("message.karos2=I heard you like explosions! Hahaha");
        instance.addToFile("message.karos3=Hahahaha");
        instance.addToFile("message.karos4=I'm here for you to meet your doom!");
        instance.addToFile("message.karos5=C'mon c'mon get me, try your best!");
        instance.addToFile("message.karos6=You can't kill me! You weak excuse for a human");
        instance.addToFile("message.quadro0=Die before me!");
        instance.addToFile("message.quadro1=Enough of you! You don't deserve my kill!");
        instance.addToFile("message.quadro2=Incoming punch!");
        instance.addToFile("message.quadro3=Looks like I'm done with this. You're next!");
        instance.addToFile("message.quadro4=This kill is mine!");
        instance.addToFile("message.quadro5=You're my kill!");
        instance.addToFile("message.quadro6=No! Die before me!");
        instance.addToFile("message.quadro7=Sit down human!");
        instance.addToFile("message.quadro8=You don't deserve to be near a guardian of Arksiane!");
        instance.addToFile("message.quadro9=Taste fist!");
        instance.addToFile("message.raglok0=You dare wake me from my slumber?!");
        instance.addToFile("message.raglok1=You think you can fight me?");
        instance.addToFile("message.raglok2=I am the great guardian of Heliosis!");
        instance.addToFile("message.raglok3=Your future is dark.");
        instance.addToFile("message.raglok4=Rain rain come my way");
        instance.addToFile("message.raglok5=Kill this human, kill it today!");
        instance.addToFile("message.raglok6=You're nothing compared to me! Nothing!");
        instance.addToFile("message.raglok7=Heliosis! Avenge me!");
        instance.addToFile("message.wreck0=You should run while you still have the chance to live.");
        instance.addToFile("message.wreck1=I do love the smell of death!");
        instance.addToFile("message.wreck2=CHARRGEE!");
        instance.addToFile("message.wreck3=Come feel the Soul of Arksiane.");
        instance.addToFile("message.wreck4=Arksiane, give me fire!");
        instance.addToFile("message.wreck5=Stop at once in the name of the great Arksiane!");
        instance.addToFile("message.wreck6=Speed!");
        instance.addToFile("message.wreck7=Explosions!");
        instance.addToFile("message.wreck8=Strength!");
    }

    public static void addMob(String name) {
        mobs.add(name);
    }

    public static void addBlock(Block block) {
        blocks.add(block);
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    public static void addKeyItem(Item item) {
        key.add(item);
    }

    public static void addTab(DivineRPGTabs tab) {
        tabs.add(tab);
    }

    @Override
    public void addNames() {
        addTabNames();
        for (Block block : blocks)
        	if(!(block instanceof IDivineMetaBlock))localizeName("tile", block.getUnlocalizedName());
        	else ((IDivineMetaBlock)block).addNames();
        for (Item item : items)
            localizeName("item", item.getUnlocalizedName());
        addKeyItemNames();
        addMobNames();
        addAchievements();
        addDeaths();
        addTooltips();
        instance.write();
    }

    public static void addMobNames() {
        for (int i = 0; i < mobs.size(); i++) {
            String mob = mobs.get(i);
            instance.addToFile("entity.divinerpg." + mob + ".name=" + getLocalizedMobName(mob));
            instance.addToFile("entity." + mob + ".name=" + getLocalizedMobName(mob));
        }
    }

    public static void addKeyItemNames() {
        for (int k = 0; k < key.size(); k++) {
            Item item = key.get(k);
            String name = item.getUnlocalizedName().substring(5);
            String finalName = "Key";
            instance.addToFile("item." + name + ".name=" + finalName, name);
        }
    }

    public static void addTabNames() {
        for (int i = 0; i < tabs.size(); i++) {
            String label = tabs.get(i).getTabLabel();
            String name = tabs.get(i).getName();
            instance.addToFile("itemGroup." + label + "=DivineRPG: " + name, label);
        }
    }

}
