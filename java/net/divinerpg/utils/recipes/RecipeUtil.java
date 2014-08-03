package net.divinerpg.utils.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeUtil {

	protected static void addRecipe(ItemStack i, Object... o) {
        GameRegistry.addRecipe(i, o);
    }
	protected static void addRecipe(Item i, Object... o) {
        GameRegistry.addRecipe(new ItemStack(i, 1), o);
    }
	protected static void addRecipe(Block b, Object... o) {
        GameRegistry.addRecipe(new ItemStack(b, 1), o);
    }
	
	protected static void addShapelessRecipe(ItemStack i, Object... o) {
        GameRegistry.addShapelessRecipe(i, o);
    }
	protected static void addShapelessRecipe(Item i, Object... o) {
        GameRegistry.addShapelessRecipe(new ItemStack(i, 1), o);
    }
	protected static void addShapelessRecipe(Block b, Object... o) {
        GameRegistry.addShapelessRecipe(new ItemStack(b, 1), o);
    }
	
	protected static void addBigRecipe(ItemStack i, Object... o) {
        CraftingDivineTableManager.getInstance().addRecipe(i, o);
    }
	protected static void addBigRecipe(Item i, Object... o) {
        CraftingDivineTableManager.getInstance().addRecipe(new ItemStack(i, 1), o);
    }
	protected static void addBigRecipe(Block b, Object... o) {
        CraftingDivineTableManager.getInstance().addRecipe(new ItemStack(b, 1), o);
    }
	
	protected static void addBigShapelessRecipe(ItemStack i, Object... o) {
        CraftingDivineTableManager.getInstance().addShapelessRecipe(i, o);
    }
	protected static void addBigShapelessRecipe(Item i, Object... o) {
        CraftingDivineTableManager.getInstance().addShapelessRecipe(new ItemStack(i, 1), o);
    }
	protected static void addBigShapelessRecipe(Block b, Object... o) {
        CraftingDivineTableManager.getInstance().addShapelessRecipe(new ItemStack(b, 1), o);
    }

	protected static void addSmelting(ItemStack input, ItemStack output, float XP) {
        GameRegistry.addSmelting(input, output, XP);
    }
	protected static void addSmelting(Item input, Item output, float XP) {
        GameRegistry.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
    }
	protected static void addSmelting(Block input, Block output, float XP) {
        GameRegistry.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
    }
	protected static void addSmelting(Block input, Item output, float XP) {
        GameRegistry.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
    }
	protected static void addSmelting(Item input, Block output, float XP) {
        GameRegistry.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
    }
}
