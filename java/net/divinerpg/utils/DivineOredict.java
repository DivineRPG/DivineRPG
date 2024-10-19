package net.divinerpg.utils;

import net.divinerpg.utils.blocks.*;
import net.minecraftforge.oredict.OreDictionary;

public class DivineOredict {
    
    public static void init() {
        OreDictionary.registerOre("logWood", VanillaBlocks.divineWood);
        OreDictionary.registerOre("logWood", IceikaBlocks.frozenWood);
        OreDictionary.registerOre("logWood", ArcanaBlocks.eucalyptusWood);
        OreDictionary.registerOre("logWood", TwilightBlocks.edenLogs);
        OreDictionary.registerOre("logWood", TwilightBlocks.wildwoodLogs);
        OreDictionary.registerOre("logWood", TwilightBlocks.apalachiaLogs);
        OreDictionary.registerOre("logWood", TwilightBlocks.skythernLogs);
        OreDictionary.registerOre("logWood", TwilightBlocks.mortumLogs);

        OreDictionary.registerOre("plankWood", VanillaBlocks.divinePlanks);
        OreDictionary.registerOre("plankWood", IceikaBlocks.frozenPlanks);
        OreDictionary.registerOre("plankWood", ArcanaBlocks.eucalyptusPlank);
        OreDictionary.registerOre("plankWood", TwilightBlocks.edenPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.wildwoodPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.apalachiaPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.skythernPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.mortumPlanks);
        
        OreDictionary.registerOre("stairWood", VanillaBlocks.divineStairs);
        OreDictionary.registerOre("stairWood", IceikaBlocks.frozenStairs);
        OreDictionary.registerOre("stairWood", TwilightBlocks.edenStairs);
        OreDictionary.registerOre("stairWood", TwilightBlocks.wildwoodStairs);
        OreDictionary.registerOre("stairWood", TwilightBlocks.apalachiaStairs);
        OreDictionary.registerOre("stairWood", TwilightBlocks.skythernStairs);
        OreDictionary.registerOre("stairWood", TwilightBlocks.mortumStairs);

        OreDictionary.registerOre("slabWood", VanillaBlocks.divineSlab);
        OreDictionary.registerOre("slabWood", IceikaBlocks.frozenSlab);
        OreDictionary.registerOre("slabWood", TwilightBlocks.edenSlab);
        OreDictionary.registerOre("slabWood", TwilightBlocks.wildwoodSlab);
        OreDictionary.registerOre("slabWood", TwilightBlocks.apalachiaSlab);
        OreDictionary.registerOre("slabWood", TwilightBlocks.skythernSlab);
        OreDictionary.registerOre("slabWood", TwilightBlocks.mortumSlab);

        OreDictionary.registerOre("treeLeaves", VanillaBlocks.divineLeaves);
        OreDictionary.registerOre("treeLeaves", IceikaBlocks.brittleLeaves);
        OreDictionary.registerOre("treeLeaves", TwilightBlocks.edenLeaves);
        OreDictionary.registerOre("treeLeaves", TwilightBlocks.wildwoodLeaves);
        OreDictionary.registerOre("treeLeaves", TwilightBlocks.apalachiaLeaves);
        OreDictionary.registerOre("treeLeaves", TwilightBlocks.skythernLeaves);
        OreDictionary.registerOre("treeLeaves", TwilightBlocks.mortumLeaves);

        OreDictionary.registerOre("stone", VanillaBlocks.milkStone);
        OreDictionary.registerOre("stone", TwilightBlocks.twilightStone);
        OreDictionary.registerOre("stone", IceikaBlocks.frozenStone);

        OreDictionary.registerOre("cobblestone", VanillaBlocks.divineMossystone);
        OreDictionary.registerOre("cobblestone", IceikaBlocks.coalstone);

        OreDictionary.registerOre("stonebrick", IceikaBlocks.snowBricks);
    }

}
