package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.recipe.InfusionTableRecipe;
import divinerpg.registries.*;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

public class InfusionTableCategory implements IRecipeCategory<RecipeHolder<InfusionTableRecipe>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/infusion_table.png");
    public static final RecipeType<RecipeHolder<InfusionTableRecipe>> RECIPE_TYPE = RecipeType.createFromVanilla(RecipeRegistry.Types.INFUSIION_TABLE_RECIPE_TYPE.get());
    private final IDrawable icon, background;
    public InfusionTableCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 1, 1, 166, 76);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, BlockRegistry.infusionTable.toStack());
    }
    @Override
    public RecipeType<RecipeHolder<InfusionTableRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId());
    }
    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<InfusionTableRecipe> recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 34).addItemStack(recipe.value().input());
        builder.addSlot(RecipeIngredientRole.CATALYST, 12, 54).addIngredients(recipe.value().template());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 44).addItemStack(recipe.value().getResultItem(null));
    }
    @Override
    public void draw(RecipeHolder<InfusionTableRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
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