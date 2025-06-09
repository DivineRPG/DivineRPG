package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.JEICompat;
import divinerpg.recipe.FireConversionRecipe;
import divinerpg.registries.*;
import divinerpg.registries.RecipeRegistry;
import divinerpg.util.LocalizeUtils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.*;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import javax.annotation.Nullable;

public class FireConversionCategory implements IRecipeCategory<RecipeHolder<FireConversionRecipe>> {
    public static final ResourceLocation
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/conversion.png"),
        PLUS = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/plus.png"),
        SLOT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/slot.png");
    public static final RecipeType<RecipeHolder<FireConversionRecipe>> RECIPE_TYPE = RecipeType.createFromVanilla(RecipeRegistry.Types.FIRE_CONVERSION.get());
    private static final RandomSource random = RandomSource.create();
    private final IDrawable icon, background, plus, slot;
    public FireConversionCategory(IGuiHelper helper) {
        background = helper.drawableBuilder(TEXTURE, 1, 1, 167, 78).setTextureSize(167, 78).build();
        plus = helper.drawableBuilder(PLUS, -60, 1, 167, 78).setTextureSize(167, 78).build();
        slot = helper.drawableBuilder(SLOT, 1, 1, 167, 78).setTextureSize(167, 78).build();
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, BlockRegistry.divineFlame.toStack());
    }
    @Override
    public RecipeType<RecipeHolder<FireConversionRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override
    public Component getTitle() {
        return LocalizeUtils.i18n("jei.fire_conversion");
    }
    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<FireConversionRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(51, 12).addIngredients(recipe.value().inputItem());

        RuleTest test = recipe.value().inputState();
        IRecipeSlotBuilder slot = builder.addSlot(RecipeIngredientRole.INPUT, 51, 48);
        var ingredients = builder.addInvisibleIngredients(RecipeIngredientRole.INPUT);
        BuiltInRegistries.FLUID.forEach(f -> {if(test.test(f.defaultFluidState().createLegacyBlock(), random)) slot.addFluidStack(f);});
        BuiltInRegistries.BLOCK.getTag(BlockTags.FIRE).ifPresent(tag -> tag.forEach(block -> {
            Block b = block.value();
            if(test.test(b.defaultBlockState(), random)) {
                slot.addIngredient(JEICompat.BLOCK_INGREDIENT_TYPE, b);
                ingredients.addItemStack(b.asItem().getDefaultInstance());
            }
        }));

        recipe.value().outputItem().ifPresent(stack -> {if(!stack.isEmpty()) builder.addOutputSlot(111, 12).addItemStack(stack);});

        recipe.value().outputState().ifPresent(s -> {
            BlockState state = s.getState(random, BlockPos.ZERO);
            if(!state.isAir()) {
                if(!state.getFluidState().isEmpty()) builder.addOutputSlot(111, 48).addFluidStack(state.getFluidState().getType());
                else builder.addOutputSlot(111, 48).addIngredient(JEICompat.BLOCK_INGREDIENT_TYPE, state.getBlock());
                builder.addInvisibleIngredients(RecipeIngredientRole.OUTPUT).addItemStack(state.getBlock().asItem().getDefaultInstance());
            }
        });
    }
    @Override
    public void draw(RecipeHolder<FireConversionRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
        if(recipe.value().outputItem().isPresent() && !recipe.value().outputItem().get().isEmpty()) {
            slot.draw(guiGraphics);
            if(recipe.value().outputState().isPresent() && !recipe.value().outputState().get().getState(random, BlockPos.ZERO).isAir()) plus.draw(guiGraphics);
        }
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