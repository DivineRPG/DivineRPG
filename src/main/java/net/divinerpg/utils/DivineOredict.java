package net.divinerpg.utils;

import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class DivineOredict {
    
    public static void init() {
        OreDictionary.registerOre("plankWood", VanillaBlocks.divinePlanks);
        OreDictionary.registerOre("plankWood", IceikaBlocks.frozenPlanks);
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
    }

}
