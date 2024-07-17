package divinerpg.recipe.brewing;

import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class GrogRecipe implements IBrewingRecipe {
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, Potions.AWKWARD.value());
	}
	@Override public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(ItemRegistry.cauldron_flesh.get());
	}
	@Override public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionContents.createItemStack(input.copy().getItem(), PotionRegistry.GROG);
		return ItemStack.EMPTY;
	}
}