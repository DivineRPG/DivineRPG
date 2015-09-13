package net.divinerpg.utils;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class DivineOredict {
    
    public static void init() {
        OreDictionary.registerOre("plankWood", VanillaBlocks.divinePlank);
        OreDictionary.registerOre("plankWood", TwilightBlocks.edenPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.wildwoodPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.apalachiaPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.skythernPlanks);
        OreDictionary.registerOre("plankWood", TwilightBlocks.mortumPlanks);
    }

}
