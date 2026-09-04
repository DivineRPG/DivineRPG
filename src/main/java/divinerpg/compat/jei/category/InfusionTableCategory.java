package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.recipe.InfusionTableRecipe;
import divinerpg.registries.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

public class InfusionTableCategory implements IRecipeCategory<RecipeHolder<InfusionTableRecipe>> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/infusion_table.png");

    public static final RecipeType<RecipeHolder<InfusionTableRecipe>> RECIPE_TYPE = new RecipeType<>(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "infusion_table"), (Class) RecipeHolder.class);


    private final IDrawable icon;
    private final IDrawable background;

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
        builder.addInputSlot(12, 34).addItemStack(new ItemStack(recipe.value().inputItem(), recipe.value().inputCount()));
        builder.addInputSlot(12, 54).addIngredients(recipe.value().template());
        builder.addOutputSlot(57, 44).addItemStack(new ItemStack(recipe.value().outputItem(), recipe.value().outputCount()));
    }

    @Override
    public void draw(RecipeHolder<InfusionTableRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, 0, 0);
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