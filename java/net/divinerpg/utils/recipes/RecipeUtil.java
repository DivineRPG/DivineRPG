package net.divinerpg.utils.recipes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
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
	
	protected static void addStairRecipe(Block mat, Block stair) {
	    GameRegistry.addRecipe(new ItemStack(stair, 4), "X  ", "XX ", "XXX", 'X', mat);
	}
	
	protected static void addSlabRecipe(Block mat, Block slab) {
        GameRegistry.addRecipe(new ItemStack(slab, 6), "XXX", 'X', mat);
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
	
    public static void addOredictRecipe(ItemStack result, Object... materials) {
        GameRegistry.addRecipe(new ShapedOreRecipe(result, materials));
    }
    
    public static void addOredictRecipe(Item result, Object... materials) {
        GameRegistry.addRecipe(new ShapedOreRecipe(result, materials));
    }
    
    public static void addOredictRecipe(Block result, Object... materials) {
        GameRegistry.addRecipe(new ShapedOreRecipe(result, materials));
    }
	
	protected static void removeCraftingRecipe(Item removed) {
        ItemStack recipeResult = null;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int i = 0; i < recipes.size(); i++) {
            IRecipe tmpRecipe = (IRecipe) recipes.get(i);

            if (tmpRecipe instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes) tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }

            if (ItemStack.areItemStacksEqual(new ItemStack(removed), recipeResult)) {
                recipes.remove(i);
            }
        }
    }
}
