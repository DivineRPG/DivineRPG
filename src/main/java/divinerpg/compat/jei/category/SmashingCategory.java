package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.JEICompat;
import divinerpg.recipe.MaulSmashingRecipe;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

public class SmashingCategory implements IRecipeCategory<RecipeHolder<MaulSmashingRecipe>> {
    public static final ResourceLocation
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/smashing.png"),
        PLUS = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/plus.png");
    public static final RecipeType<RecipeHolder<MaulSmashingRecipe>> RECIPE_TYPE = RecipeType.createFromVanilla(RecipeRegistry.Types.MAUL_SMASHING.get());
    private final IDrawable icon, background, plus;
    public SmashingCategory(IGuiHelper helper) {
        background = helper.drawableBuilder(TEXTURE, 1, 1, 167, 78).setTextureSize(167, 78).build();
        plus = helper.drawableBuilder(PLUS, 1, 1, 167, 78).setTextureSize(167, 78).build();
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ItemRegistry.realmite_maul.toStack());
    }
    @Override
    public RecipeType<RecipeHolder<MaulSmashingRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override
    public Component getTitle() {
        return LocalizeUtils.i18n("jei.smashing");
    }
    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MaulSmashingRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(51, 12).addIngredients(recipe.value().input());
        if(recipe.value().requiredBaseBlockTag() != null) {
            BuiltInRegistries.BLOCK.getTag(recipe.value().requiredBaseBlockTag()).ifPresent(holders -> {
                builder.addSlot(RecipeIngredientRole.CATALYST, 51, 48).addIngredients(JEICompat.BLOCK_INGREDIENT_TYPE, holders.stream().map(Holder::value).toList());
                builder.addInvisibleIngredients(RecipeIngredientRole.CATALYST).addItemStacks(holders.stream().map(b -> b.value().asItem().getDefaultInstance()).toList());
            });
        } builder.addOutputSlot(111, 30).addItemStack(recipe.value().output());
    }
    @Override
    public void draw(RecipeHolder<MaulSmashingRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
        if(recipe.value().requiredBaseBlockTag() != null) plus.draw(guiGraphics);
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
