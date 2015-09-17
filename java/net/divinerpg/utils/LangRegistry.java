package net.divinerpg.utils;

import java.util.ArrayList;

import net.divinerpg.blocks.vanilla.IDivineMetaBlock;
import net.divinerpg.items.base.IDivineMetaItem;
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
        instance.addToFile("achievement.petCollector.desc=Spawn a pet from the Livestock Merchant");
        
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
        instance.addToFile("achievement.petCollector=Pet Collector");
    }
    
    public static void addDeaths() {
        instance.addToFile("death.attack.arcana=%1$s was killed by magic");
        instance.addToFile("death.attack.trap=%1$s fell into a trap");
        instance.addToFile("death.attack.acid=%1$s melted in acid");
        instance.addToFile("death.attack.spikes=%1$s walked on spikes");
    }
    
    public static void addTooltips() {
        instance.addToFile("tooltip.uses=# Uses Remaining");
        instance.addToFile("tooltip.uses.infinite=Infinite Uses");
        instance.addToFile("tooltip.arcana=Consumes # Arcana");
        instance.addToFile("tooltip.arcana.regen=Replenishes # Arcana");
        instance.addToFile("tooltip.damage.melee=# Melee Damage");
        instance.addToFile("tooltip.damage.ranged=# Ranged Damage");
        instance.addToFile("tooltip.damage.both=# Ranged and Melee Damage");
        instance.addToFile("tooltip.damage.arcana=# Arcana Damage");
        instance.addToFile("tooltip.damage.reduction=|percent| Damage Reduction (|percentFull| Full)");
        instance.addToFile("tooltip.ammo=Ammo: |item|");
        instance.addToFile("tooltip.ammo.infinite=Infinite Ammo");
        instance.addToFile("tooltip.shots.explosive=Explosive Projectiles");
        instance.addToFile("tooltip.shots.homing=Homing Projectiles");
        instance.addToFile("tooltip.fullset=Full Set Perks: ");
        instance.addToFile("tooltip.noprotection=No Protection");
        instance.addToFile("tooltip.vethean=Vethean");
        instance.addToFile("tooltip.efficiency=Efficiency: #");
        instance.addToFile("tooltip.noblock=Cannot Block");
        instance.addToFile("tooltip.effect.poisons=Poisons mobs for |seconds| seconds");
        instance.addToFile("tooltip.effect.burns=Burns mobs for |seconds| seconds");
        instance.addToFile("tooltip.effect.slows=Slows mobs for |seconds| seconds");
    }
    
    public static void addMessages() {
        instance.addToFile("message.vatticus.feel=Can you feel the empowerment of the arcanium around you?");
        instance.addToFile("message.vatticus.noend=I hear there's no end to this place, there's no end to me either.");
        instance.addToFile("message.vatticus.strength=Arcana come upon me, give me the ultimate strength!");
        instance.addToFile("message.vatticus.discover=I've discovered how to awake the ancient leader of the dungeon.");
        instance.addToFile("message.vatticus.magic=Hurr drah drah, magic.");
        instance.addToFile("message.general.weapons=My weapons will conquer any foe.");
        instance.addToFile("message.general.1=Do not buy from Captain Merik. He does not care about quality.");
        instance.addToFile("message.general.2=The Arcanite Blade is incredibly powerful.");
        instance.addToFile("message.merchant.ho=Hohoho.");
        instance.addToFile("message.merchant.out=It's cold outside.");
        instance.addToFile("message.merchant.in=It's cold inside.");
        instance.addToFile("message.merchant.burr=Burr!");
        instance.addToFile("message.jackoman.boo=BOO!");
        instance.addToFile("message.jackoman.lost=I seem to have lost my head.");
        instance.addToFile("message.jackoman.hurah=HURAH!");
        instance.addToFile("message.jackoman.seen=Have you seen my head?");
        instance.addToFile("message.guardian.up=You are moving upwards, beware of the imminent danger.");
        instance.addToFile("message.guardian.places=These places aren't for you.");
        instance.addToFile("message.guardian.doing=This is dangerous, what are you doing here?");
        instance.addToFile("message.guardian.temples=Temples are suited for humans.");
        instance.addToFile("message.guardian.closer=They are getting closer to killing you.");
        instance.addToFile("message.developer=Welcome DivineRPG developer!");
        instance.addToFile("message.standard=Thank you # for downloading and playing &!");
        instance.addToFile("message.version=[New Version: #]");
        instance.addToFile("message.version.internet=Unable to check for latest version, you may want to check your internet connection!");
        instance.addToFile("message.version.update=A DivineRPG update is avaliable.");
        instance.addToFile("message.version.unable=Unable to remotely read version.");
        instance.addToFile("message.ayeraco.green=The Green Ayeraco has been called upon");
        instance.addToFile("message.ayeraco.blue=The Blue Ayeraco has been called upon");
        instance.addToFile("message.ayeraco.red=The Red Ayeraco has been called upon");
        instance.addToFile("message.ayeraco.yellow=The Yellow Ayeraco has been called upon");
        instance.addToFile("message.ayeraco.purple=The Purple Ayeraco has been called upon");
        instance.addToFile("message.ayeraco.spawn=The Ayeraco Horde has arrived!");
        instance.addToFile("message.karos.game=So you came to play a game?");
        instance.addToFile("message.karos.begin=Let the game begin!");
        instance.addToFile("message.karos.explosion=I heard you like explosions! Hahaha");
        instance.addToFile("message.karos.laugh=Hahahaha");
        instance.addToFile("message.karos.doom=I'm here for you to meet your doom!");
        instance.addToFile("message.karos.cmon=C'mon c'mon get me, try your best!");
        instance.addToFile("message.karos.weak=You can't kill me! You weak excuse for a human");
        instance.addToFile("message.quadro.die=Die before me!");
        instance.addToFile("message.quadro.enough=Enough of you! You don't deserve my kill!");
        instance.addToFile("message.quadro.punch=Incoming punch!");
        instance.addToFile("message.quadro.next=Looks like I'm done with this. You're next!");
        instance.addToFile("message.quadro.mine=This kill is mine!");
        instance.addToFile("message.quadro.kill=You're my kill!");
        instance.addToFile("message.quadro.no=No! Die before me!");
        instance.addToFile("message.quadro.sit=Sit down human!");
        instance.addToFile("message.quadro.deserve=You don't deserve to be near a guardian of Arksiane!");
        instance.addToFile("message.quadro.taste=Taste fist!");
        instance.addToFile("message.raglok.dare=You dare wake me from my slumber?!");
        instance.addToFile("message.raglok.think=You think you can fight me?");
        instance.addToFile("message.raglok.great=I am the great guardian of Heliosis!");
        instance.addToFile("message.raglok.future=Your future is dark.");
        instance.addToFile("message.raglok.rain=Rain rain come my way");
        instance.addToFile("message.raglok.kill=Kill this human, kill it today!");
        instance.addToFile("message.raglok.compare=You're nothing compared to me! Nothing!");
        instance.addToFile("message.raglok.avenge=Heliosis! Avenge me!");
        instance.addToFile("message.wreck.run=You should run while you still have the chance to live.");
        instance.addToFile("message.wreck.smell=I do love the smell of death!");
        instance.addToFile("message.wreck.charge=CHARRGEE!");
        instance.addToFile("message.wreck.pull=Come feel the Soul of Arksiane.");
        instance.addToFile("message.wreck.fire=Arksiane, give me fire!");
        instance.addToFile("message.wreck.freeze=Stop at once in the name of the great Arksiane!");
        instance.addToFile("message.wreck.speed=Speed!");
        instance.addToFile("message.wreck.explosion=Explosions!");
        instance.addToFile("message.wreck.strength=Strength!");
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
            if(!(item instanceof IDivineMetaItem))localizeName("item", item.getUnlocalizedName());
            else ((IDivineMetaItem)item).addNames();
        addKeyItemNames();
        addMobNames();
        addAchievements();
        addDeaths();
        addTooltips();
        addMessages();
        instance.write();
    }

    public static void addMobNames() {
        for (int i = 0; i < mobs.size(); i++) {
            String mob = mobs.get(i);
            instance.addToFile("entity.divinerpg." + mob + ".name=" + getLocalizedMobName(mob));
            instance.addToFile("entity.DRPG" + mob + ".name=" + getLocalizedMobName(mob));
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
