package divinerpg.compat.jei.category;

import divinerpg.recipe.InfusionTableRecipe;
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
import static divinerpg.registries.BlockRegistry.infusionTable;
import static divinerpg.registries.RecipeRegistry.Types.INFUSION_TABLE_RECIPE_TYPE;
import static mezz.jei.api.constants.VanillaTypes.ITEM_STACK;

public class InfusionTableCategory implements IRecipeCategory<RecipeHolder<InfusionTableRecipe>> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/gui/jei/infusion_table.png");
    public static final IRecipeType<RecipeHolder<InfusionTableRecipe>> RECIPE_TYPE = IRecipeType.create(INFUSION_TABLE_RECIPE_TYPE.get());
    private final IDrawable icon;
    private final IDrawable background;
    public InfusionTableCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 1, 1, 166, 76);
        icon = helper.createDrawableIngredient(ITEM_STACK, infusionTable.toStack());
    }
    @Override public IRecipeType<RecipeHolder<InfusionTableRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override public Component getTitle() {
        return Component.translatable(infusionTable.get().getDescriptionId());
    }
    @Override public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<InfusionTableRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(12, 34).addItemStacks(recipe.value().input().getValues().stream().map(h -> new ItemStack(h.value(), recipe.value().inputCount())).toList());
        builder.addInputSlot(12, 54).add(recipe.value().template());
        builder.addOutputSlot(57, 44).add(recipe.value().result().create());
    }
    @Override public void draw(RecipeHolder<InfusionTableRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, 0, 0);
    }
    @Override public int getWidth() {
        return background.getWidth();
    }
    @Override public int getHeight() {
        return background.getHeight();
    }
}