package divinerpg.items.base;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.RecipeType;

public class ItemModFuel extends ItemMod {
	final int burnTime;
	public ItemModFuel(int burnTime) {
        super();
        this.burnTime = burnTime;
    }
    public ItemModFuel(Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }
    public ItemModFuel(Rarity rarity, int burnTime) {
        super(rarity);
        this.burnTime = burnTime;
    }
    public ItemModFuel(boolean hasGlint, int burnTime) {
        super(hasGlint);
        this.burnTime = burnTime;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
    	return burnTime;
    }
}