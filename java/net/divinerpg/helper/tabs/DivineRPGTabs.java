package net.divinerpg.helper.tabs;

import net.divinerpg.helper.Util;
import net.divinerpg.helper.blocks.TwilightBlocks;
import net.divinerpg.helper.items.ItemsFood;
import net.divinerpg.helper.items.VanillaItemsArmor;
import net.divinerpg.helper.items.VanillaItemsOther;
import net.divinerpg.helper.items.VanillaItemsTools;
import net.divinerpg.helper.items.VanillaItemsWeapons;
import net.divinerpg.helper.items.VetheanItems;
import net.divinerpg.helper.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DivineRPGTabs extends CreativeTabs {

    private Item                icon;
    private String              name;

    public static DivineRPGTabs blocks  = new DivineRPGTabs("Blocks");
    public static DivineRPGTabs ranged  = new DivineRPGTabs("Ranged", "Ranged Weapons");
    public static DivineRPGTabs swords  = new DivineRPGTabs("Swords", "Melee Weapons");
    public static DivineRPGTabs tools   = new DivineRPGTabs("Tools");
    public static DivineRPGTabs items   = new DivineRPGTabs("Materials", "Raw Materials");
    public static DivineRPGTabs armor   = new DivineRPGTabs("Armor");
    public static DivineRPGTabs spawner = new DivineRPGTabs("Spawner");
    public static DivineRPGTabs utility = new DivineRPGTabs("Utility");
    public static DivineRPGTabs food    = new DivineRPGTabs("Herbalism");
    public static DivineRPGTabs vethea  = new DivineRPGTabs("Vethea");

    public DivineRPGTabs(String lable) {
        this(lable, lable);
    }

    public DivineRPGTabs(String lable, String name) {
        super(getNextID(), lable);
        this.name = name;
        LangRegistry.addTab(this);
    }

    public void setIcon(Item icon) {
        this.icon = icon;
    }

    public void setIcon(Block icon) {
        this.icon = Util.toItem(icon);
    }

    @Override
    public Item getTabIconItem() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public static void init() {
        blocks.setIcon(TwilightBlocks.edenOre);
        ranged.setIcon(VanillaItemsWeapons.vileStorm);
        swords.setIcon(VanillaItemsWeapons.aquaton);
        tools.setIcon(VanillaItemsTools.rupeeShickaxe);
        items.setIcon(VanillaItemsOther.rupeeIngot);
        armor.setIcon(VanillaItemsArmor.angelicHelmet);
        spawner.setIcon(VanillaItemsOther.callWatcher);
        utility.setIcon(VanillaItemsOther.tarBucket);
        food.setIcon(ItemsFood.bacon);
        vethea.setIcon(VetheanItems.karosStaff);
    }
}
