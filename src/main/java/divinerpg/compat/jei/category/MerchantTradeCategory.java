package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMerchant.*;
import divinerpg.registries.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.jetbrains.annotations.Nullable;

public class MerchantTradeCategory implements IRecipeCategory<DivineTrades> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/jei/merchant_trade.png");

    // Updated RecipeType constructor layout to match SmashingCategory
    public static final RecipeType<DivineTrades> RECIPE_TYPE = new RecipeType<>(
            Identifier.fromNamespaceAndPath(DivineRPG.MODID, "merchant_trades"),
            (Class) DivineTrades.class
    );

    static final int OFFSET = 6;
    private final IDrawable icon;
    private final IDrawable background;

    public MerchantTradeCategory(IGuiHelper helper) {
        background = helper.drawableBuilder(TEXTURE, 0, 0, 88, 36).setTextureSize(88, 36).build();
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ItemRegistry.olivine.toStack());
    }

    @Override
    public RecipeType<DivineTrades> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("tooltip.divinerpg.jei.merchant_trades");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getWidth() {
        return background.getWidth() + (OFFSET << 1);
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DivineTrades recipe, IFocusGroup focuses) {
        if (recipe.input1 != null) {
            builder.addInputSlot(5 + OFFSET, 17).addItemStack(recipe.input1);
        }
        if (recipe.input2 != null) {
            builder.addInputSlot(35 + OFFSET, 17).addItemStack(recipe.input2);
        }
        if (recipe instanceof DivineMapTrades m) {
            ItemStack itemstack = new ItemStack(Items.FILLED_MAP);
            MapItemSavedData.addTargetDecoration(itemstack, BlockPos.ZERO, "+", m.destinationType);
            itemstack.set(DataComponents.ITEM_NAME, Component.translatable(m.displayName));
            builder.addOutputSlot(68 + OFFSET, 17).addItemStack(itemstack);
        } else {
            builder.addOutputSlot(68 + OFFSET, 17).addItemStack(recipe.output);
        }
    }

    @Override
    public void draw(DivineTrades recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, OFFSET, 0);
        TextColor c = recipe.name.getStyle().getColor();
        guiGraphics.centeredText(Minecraft.getInstance().font, recipe.name, 44 + OFFSET, 1, c == null ? 0xFFFFFF : c.getValue());
    }
}