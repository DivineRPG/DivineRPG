package divinerpg.recipe.brewing;

import divinerpg.DivineRPG;
import divinerpg.registries.PotionRegistry;
import divinerpg.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.registries.ForgeRegistries;

public class TeaRecipe implements IBrewingRecipe {
	private static final Item winterberry = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry"));
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