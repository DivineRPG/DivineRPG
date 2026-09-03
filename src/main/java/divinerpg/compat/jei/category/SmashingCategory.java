package divinerpg.compat.jei.category;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.JEICompat;
import divinerpg.recipe.MaulSmashingRecipe;
import divinerpg.registries.ItemRegistry;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class SmashingCategory implements IRecipeCategory<RecipeHolder<MaulSmashingRecipe>> {

    public static final RecipeType<RecipeHolder<MaulSmashingRecipe>> RECIPE_TYPE = new RecipeType<>(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "maul_smashing"), (Class) RecipeHolder.class);
    private final IDrawable background;
    private final IDrawable icon;

    public SmashingCategory(IGuiHelper helper) {
        this.background = helper.createBlankDrawable(130, 40);
        this.icon = helper.createDrawableItemStack(new ItemStack(ItemRegistry.realmite_maul.get()));
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
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MaulSmashingRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(10, 11).addIngredients(recipe.value().input());
        var blockRegistry = Minecraft.getInstance().level.registryAccess().lookupOrThrow(Registries.BLOCK);
        TagKey<Block> baseTag = recipe.value().requiredBaseBlockTag();
        if (baseTag != null) {
            List<ItemStack> baseBlockStacks = blockRegistry.getOrThrow(baseTag).stream().map(Holder::value).map(Block::asItem).filter(item -> item != Items.AIR).map(ItemStack::new).toList();
            builder.addInputSlot(48, 11).addItemStacks(baseBlockStacks);
        }
        ItemStack outputStack = recipe.value().outputItem().getDefaultInstance();
        if (!outputStack.isEmpty()) {
            builder.addOutputSlot(96, 11).addItemStack(outputStack);
        }
    }
}