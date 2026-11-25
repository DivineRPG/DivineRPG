package divinerpg.compat.jei.category;

import divinerpg.recipe.ArcaniumExtractorRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.arcaniumExtractor;
import static divinerpg.registries.ItemRegistry.collector;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;
import static mezz.jei.api.constants.VanillaTypes.ITEM_STACK;

public class ArcaniumExtractorCategory implements IRecipeCategory<RecipeHolder<ArcaniumExtractorRecipe>> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/gui/jei/arcanium_extractor.png");
    public static final IRecipeType<RecipeHolder<ArcaniumExtractorRecipe>> RECIPE_TYPE = IRecipeType.create(ARCANIUM_EXTRACTOR_RECIPE_TYPE.get());
    private final IDrawable icon;
    private final IDrawable background;
    public ArcaniumExtractorCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 1, 1, 167, 78);
        icon = helper.createDrawableIngredient(ITEM_STACK, arcaniumExtractor.toStack());
    }
    @Override public IRecipeType<RecipeHolder<ArcaniumExtractorRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override public Component getTitle() {
        return Component.translatable(arcaniumExtractor.get().getDescriptionId());
    }
    @Override public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ArcaniumExtractorRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(51, 12).add(recipe.value().getExtractorInput());
        builder.addInputSlot(51, 48).add(collector.toStack());
        builder.addOutputSlot(111, 30).add(new ItemStack(recipe.value().getExtractorResult().item())); // Or recipe.value().getExtractorResult().toStack() depending on ItemStackTemplate methods
    }
    @Override public void draw(RecipeHolder<ArcaniumExtractorRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, 0, 0);
    }
    @Override public int getWidth() {
        return background.getWidth();
    }
    @Override public int getHeight() {
        return background.getHeight();
    }
}