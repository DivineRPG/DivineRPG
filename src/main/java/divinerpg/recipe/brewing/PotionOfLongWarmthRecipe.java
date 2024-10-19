package divinerpg.recipe.brewing;

import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class PotionOfLongWarmthRecipe implements IBrewingRecipe {
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, PotionRegistry.WARMTH);
	}
	@Override public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(Items.REDSTONE);
	}
	@Override public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionContents.createItemStack(input.copy().getItem(), PotionRegistry.LONG_WARMTH);
		return ItemStack.EMPTY;
	}
}