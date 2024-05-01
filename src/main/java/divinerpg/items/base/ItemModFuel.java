package divinerpg.items.base;

import org.jetbrains.annotations.Nullable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class ItemModFuel extends ItemMod {
	final int burnTime;
	public ItemModFuel(int burnTime) {this.burnTime = burnTime;}
    @Override public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return burnTime;}
}