package divinerpg.recipe.brewing;

import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class TeaRecipe implements IBrewingRecipe {
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, Potions.WATER);
	}
	@Override public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(ItemRegistry.winterberry.get()) || ingredient.is(Items.SWEET_BERRIES);
	}
	@Override public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionContents.createItemStack(input.copy().getItem(), PotionRegistry.TEA);
		return ItemStack.EMPTY;
	}
}