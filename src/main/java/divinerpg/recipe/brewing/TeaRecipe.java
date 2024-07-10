package divinerpg.recipe.brewing;

import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class TeaRecipe implements IBrewingRecipe {
	private static final Item winterberry = ItemRegistry.winterberry.get();
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, Potions.WATER);
	}
	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(winterberry) || ingredient.is(Items.SWEET_BERRIES);
	}
	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionUtils.setPotion(input.copy(), PotionRegistry.TEA.get());
		return ItemStack.EMPTY;
	}
}