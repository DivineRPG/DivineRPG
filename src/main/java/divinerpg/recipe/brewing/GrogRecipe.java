package divinerpg.recipe.brewing;

import divinerpg.DivineRPG;
import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class GrogRecipe implements IBrewingRecipe {
	private static final Item flesh = BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "cauldron_flesh"));
	@Override public boolean isInput(ItemStack input) {
		return Utils.isPotion(input, Potions.AWKWARD);
	}
	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return ingredient.is(flesh);
	}
	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(isInput(input) && isIngredient(ingredient)) return PotionUtils.setPotion(input.copy(), PotionRegistry.GROG.get());
		return ItemStack.EMPTY;
	}
}