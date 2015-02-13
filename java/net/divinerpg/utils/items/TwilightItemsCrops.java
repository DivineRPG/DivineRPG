package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemFastFood;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.twilight.ItemTwilightSeeds;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TwilightItemsCrops {
    
    public static Item moonbulb;
    public static Item moonbulbSeeds;
    public static Item purpleGlowbone, pinkGlowbone;
    public static Item purpleGlowboneSeeds, pinkGlowboneSeeds;
    
    public static void init() {
    	moonbulb		 		 = new ItemFastFood(1, 5, false, "moonbulb");
        moonbulbSeeds  		 	 = new ItemTwilightSeeds("moonbulbSeeds", TwilightBlocks.moonbulb, Blocks.grass);
        purpleGlowbone		 	 = new ItemFastFood(3, 5, false, "purpleGlowbone");
        purpleGlowboneSeeds  	 = new ItemTwilightSeeds("purpleGlowboneSeeds", TwilightBlocks.purpleGlowbone, Blocks.grass);
        pinkGlowbone		 	 = new ItemFastFood(3, 5, false, "pinkGlowbone");
        pinkGlowboneSeeds  	 	 = new ItemTwilightSeeds("pinkGlowboneSeeds", TwilightBlocks.pinkGlowbone, Blocks.grass);
    }
}
