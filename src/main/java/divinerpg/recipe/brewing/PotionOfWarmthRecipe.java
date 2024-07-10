package divinerpg.recipe.brewing;

import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class PotionOfWarmthRecipe implements IBrewingRecipe {
	private static final Item olivine = ItemRegistry.olivine.get();
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, PotionRegistry.TEA.get());
	}
	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(olivine);
	}
	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionUtils.setPotion(input.copy(), PotionRegistry.WARMTH.get());
		return ItemStack.EMPTY;
	}
}