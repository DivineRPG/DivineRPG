package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.JEICompat;
import divinerpg.recipe.MaulSmashingRecipe;
import divinerpg.registries.*;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.*;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class SmashingCategory implements IRecipeCategory<RecipeHolder<MaulSmashingRecipe>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/smashing.png");
    public static final RecipeType<RecipeHolder<MaulSmashingRecipe>> RECIPE_TYPE = RecipeType.createFromVanilla(RecipeRegistry.Types.MAUL_SMASHING.get());
    private final IDrawable icon, background, plus;
    public SmashingCategory(IGuiHelper helper) {
        background = helper.drawableBuilder(TEXTURE, 0, 0, 74, 60).setTextureSize(74, 60).build();
        plus = helper.drawableBuilder(FireConversionCategory.PLUS, 0, 0, 13, 13).setTextureSize(13, 13).build();
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ItemRegistry.realmite_maul.toStack());
    }
    @Override
    public RecipeType<RecipeHolder<MaulSmashingRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.translatable("tooltip.divinerpg.jei.smashing");
    }
    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MaulSmashingRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(2, 2).addIngredients(recipe.value().input());
        if(recipe.value().requiredBaseBlockTag() != null) {
            BuiltInRegistries.BLOCK.getTag(recipe.value().requiredBaseBlockTag()).ifPresent(holders -> {
                IRecipeSlotBuilder slot = builder.addSlot(RecipeIngredientRole.CATALYST, 2, 38);
                var ingredients = builder.addInvisibleIngredients(RecipeIngredientRole.CATALYST);
                holders.forEach(block -> {
                    Block b = block.value();
                    if(b.defaultBlockState().getFluidState().isEmpty()) slot.addIngredient(JEICompat.BLOCK_INGREDIENT_TYPE, b);
                    else slot.addFluidStack(b.defaultBlockState().getFluidState().getType());
                    ingredients.addItemStack(b.asItem().getDefaultInstance());
                });
            });
        } builder.addOutputSlot(56, 20).addItemStack(recipe.value().output());
    }
    @Override
    public void draw(RecipeHolder<MaulSmashingRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
        if(recipe.value().requiredBaseBlockTag() != null) plus.draw(guiGraphics, 3, 22);
    }
    @Override
    public int getWidth() {
        return background.getWidth();
    }
    @Override
    public int getHeight() {
        return background.getHeight();
    }
}
