package net.divinerpg.utils;

import java.util.ArrayList;

import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry extends RegistryFile {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Item> key = new ArrayList<Item>();
    private static ArrayList<DivineRPGTabs> tabs = new ArrayList<DivineRPGTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();

    private static final RegistryFile instance = new LangRegistry();

    public LangRegistry() {
        super("./src/main/resources/assets/divinerpg/lang/en_US.lang");
    }

    public static void registerNames() {
        instance.addNames();
        instance.closeFile();
    }

    public static void addAchievements() {
        instance.addToFile("achievement.divineIntervention.desc=Spawn The Watcher");
        instance.addToFile("achievement.possibilities.desc=Enter the Eden dimension");
        instance.addToFile("achievement.friendOrFoe.desc=Kill a bunny");
        instance.addToFile("achievement.darkAnotherDay.desc=Enter the Mortum Dimension");
        instance.addToFile("achievement.whenPigsFly.desc=Wear a full Angelic armor set");
        instance.addToFile("achievement.offKey.desc=Shoot a Sound of Music");
        instance.addToFile("achievement.enrichment.desc=");
        instance.addToFile("achievement.littleCreature.desc=Spawn a Golem Of Rejuv'");
        instance.addToFile("achievement.halloweenSpirit.desc=Trade with a Jack-O-Man");
        instance.addToFile("achievement.feedingOnTheFish.desc=Kill a Shark");
        instance.addToFile("achievement.frozenLand.desc=Enter the Iceika dimension");
        instance.addToFile("achievement.frozenGoods.desc=Open a frozen chest");
        instance.addToFile("achievement.lilTinkerin.desc=Trade with a Tinkerer");
        instance.addToFile("achievement.lilGift.desc=Open a gift Box");
        instance.addToFile("achievement.divinePlan.desc=");
        instance.addToFile("achievement.liesWithin.desc=Enter The Dungeon Of Arcana");
        instance.addToFile("achievement.perfectlyCorrupted.desc=Use the Altar Of Corruption");
        instance.addToFile("achievement.totalDemonization.desc=Use the Demon Furnace");
        instance.addToFile("achievement.evilDisease.desc=Kill the Parasecta");
        instance.addToFile("achievement.dungeonMaster.desc=Kill the Dramix");
        instance.addToFile("achievement.eyeOfEvil.desc=Look into the eye of The Eye");
        instance.addToFile("achievement.tripleDanger.desc=Kill an Ender Triplet");
        instance.addToFile("achievement.hotterThanHell.desc=Step on a hot block in Arcana");
        instance.addToFile("achievement.mealToRemember.desc=Eat a chicken dinner");
        instance.addToFile("achievement.yuk.desc=Use an Arcana potion");
        instance.addToFile("achievement.spawnDAR.desc=Spawn Densos and Reyvor");
        instance.addToFile("achievement.dramcryxDeath.desc=Kill a Jungle Dramcryx");

        instance.addToFile("achievement.divineIntervention=Divine intervention");
        instance.addToFile("achievement.possibilities=Possibilities");
        instance.addToFile("achievement.friendOrFoe=Friend or foe?");
        instance.addToFile("achievement.darkAnotherDay=Dark another day");
        instance.addToFile("achievement.whenPigsFly=When pigs fly");
        instance.addToFile("achievement.offKey=Off key");
        instance.addToFile("achievement.enrichment=Enrichment");
        instance.addToFile("achievement.littleCreature=Little creature");
        instance.addToFile("achievement.halloweenSpirit=Halloween spirit");
        instance.addToFile("achievement.oneLamp=One lamp");
        instance.addToFile("achievement.feedingOnTheFish=Feeding on the fish");
        instance.addToFile("achievement.hotterThanHell=Hotter than hell");
        instance.addToFile("achievement.mealToRemember=Meal to remember");
        instance.addToFile("achievement.yuk=Yuk!");
        instance.addToFile("achievement.frozenLand=Frozen land");
        instance.addToFile("achievement.frozenGoods=Frozen goods");
        instance.addToFile("achievement.lilTinkerin=Lil' tinkerin");
        instance.addToFile("achievement.divineDlan=Divine plan");
        instance.addToFile("achievement.liesWithin=Lies within");
        instance.addToFile("achievement.perfectlyCorrupted=Perfectly corrupted");
        instance.addToFile("achievement.totalDemonization=Total demonization");
        instance.addToFile("achievement.evilDisease=Evil disease");
        instance.addToFile("achievement.dungeonMaster=Dungeon master");
        instance.addToFile("achievement.eyeOfEvil=Eye of evil");
        instance.addToFile("achievement.tripleDanger=Triplet danger");
        instance.addToFile("achievement.lilGift=Lil' Gift");
        instance.addToFile("achievement.spawnDAR=Ten heads are better than one!");
        instance.addToFile("achievement.dramcryxDeath=Death to all Jungle Stegosaurous!");

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
            localizeName("tile", block.getUnlocalizedName());
        for (Item item : items)
            localizeName("item", item.getUnlocalizedName());
        addKeyItemNames();
        addMobNames();
        addAchievements();
    }

    public static void addMobNames() {
        for (int i = 0; i < mobs.size(); i++) {
            String mob = mobs.get(i);
            instance.addToFile("entity." + mob + ".name=" + mob);
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
