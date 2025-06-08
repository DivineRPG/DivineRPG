package divinerpg.compat.jei.ingredient;

import divinerpg.compat.jei.JEICompat;
import mezz.jei.api.ingredients.*;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class BlockIngredientHelper implements IIngredientHelper<Block> {
    @Override public IIngredientType<Block> getIngredientType() {return JEICompat.BLOCK_INGREDIENT_TYPE;}
    @Override
    public String getDisplayName(Block ingredient) {
        return ingredient.getName().getString();
    }
    @Override @SuppressWarnings({"deprecated", "removal"})
    public String getUniqueId(Block ingredient, UidContext context) {
        return ingredient.getDescriptionId();
    }
    @Override
    public ResourceLocation getResourceLocation(Block ingredient) {
        return BuiltInRegistries.BLOCK.getKey(ingredient);
    }
    @Override
    public Block copyIngredient(Block ingredient) {
        return ingredient;
    }
    @Override
    public String getErrorInfo(@Nullable Block ingredient) {
        return (ingredient == null ? "null" : ingredient.getDescriptionId()) + " block ingredient error";
    }
}