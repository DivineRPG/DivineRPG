package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.recipe.InfusionTableRecipe;
import divinerpg.registries.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class InfusionTableCategory
        implements IRecipeCategory<InfusionTableRecipe>
{
    public static final RecipeType<InfusionTableRecipe> INFUSION_TABLE_TYPE = RecipeType.create(DivineRPG.MODID, "infusion_table", InfusionTableRecipe.class);
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/infusion_table.png");


    private final IDrawable back, icon;
//    private final ICraftingGridHelper craftingGridHelper;

    public InfusionTableCategory(IGuiHelper helper) {
        this.back = helper.createDrawable(TEXTURE, 1, 1, 166, 76);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.infusionTable.asItem()));
        helper.createCraftingGridHelper();
    }
    @Override
    public RecipeType<InfusionTableRecipe> getRecipeType() {
        return RecipeType.create(DivineRPG.MODID, "infusion_table", InfusionTableRecipe.class);
    }

    @Override
    public Component getTitle() {
        return Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId());
    }

    @Override
    public IDrawable getBackground() {
        return back;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @SuppressWarnings("resource")
	@Override
    public void setRecipe(IRecipeLayoutBuilder builder, InfusionTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 34).addIngredients(Ingredient.of(recipe.input));
        builder.addSlot(RecipeIngredientRole.CATALYST, 12, 54).addIngredients(Ingredient.of(recipe.template));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 44).addItemStack(recipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
    }

}