package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.recipe.ArcaniumExtractorRecipe;
import divinerpg.registries.*;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

public class ArcaniumExtractorCategory implements IRecipeCategory<RecipeHolder<ArcaniumExtractorRecipe>> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/arcanium_extractor.png");
    public static final RecipeType<RecipeHolder<ArcaniumExtractorRecipe>> RECIPE_TYPE = RecipeType.createFromVanilla(RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get());

    private final IDrawable icon;
    private final IDrawable background;

    public ArcaniumExtractorCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 1, 1, 167, 78);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, BlockRegistry.arcaniumExtractor.toStack());
    }

    @Override
    public RecipeType<RecipeHolder<ArcaniumExtractorRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable(BlockRegistry.arcaniumExtractor.get().getDescriptionId());
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ArcaniumExtractorRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(51, 12).add(recipe.value().getExtractorInput());
        builder.addInputSlot(51, 48).addItemStack(ItemRegistry.collector.toStack());
        builder.addOutputSlot(111, 30).addItemStack(new ItemStack(recipe.value().getExtractorResult().item())); // Or recipe.value().getExtractorResult().toStack() depending on ItemStackTemplate methods
    }

    @Override
    public void draw(RecipeHolder<ArcaniumExtractorRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
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