package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemFastFood;
import net.divinerpg.items.twilight.ItemTwilightSeeds;
import net.divinerpg.items.vanilla.ItemSkyFlower;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TwilightItemsCrops {

	public static Item moonbulb = new ItemFastFood(1, 5, false, "moonbulb");
	public static Item moonbulbSeeds = new ItemTwilightSeeds("moonbulbSeeds", TwilightBlocks.moonbulb, Blocks.grass);
	public static Item purpleGlowbone = new ItemFastFood(3, 5, false, "purpleGlowbone");
	public static Item purpleGlowboneSeeds = new ItemTwilightSeeds("purpleGlowboneSeeds", TwilightBlocks.purpleGlowbone, Blocks.grass);
	public static Item pinkGlowbone = new ItemFastFood(3, 5, false, "pinkGlowbone");
	public static Item pinkGlowboneSeeds = new ItemTwilightSeeds("pinkGlowboneSeeds", TwilightBlocks.pinkGlowbone, Blocks.grass);
	public static Item skyFlower = new ItemSkyFlower();
    public static Item skyPlantSeeds = new ItemTwilightSeeds("skyPlantSeeds", TwilightBlocks.skyPlant, Blocks.grass);
	
	public static void init(){}
}
