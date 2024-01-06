package divinerpg.recipe.brewing;

import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class PotionOfLongWarmthRecipe implements IBrewingRecipe {
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, PotionRegistry.WARMTH.get());
	}
	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(Items.REDSTONE);
	}
	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionUtils.setPotion(input.copy(), PotionRegistry.LONG_WARMTH.get());
		return ItemStack.EMPTY;
	}
}