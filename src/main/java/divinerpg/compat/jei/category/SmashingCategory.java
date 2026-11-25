package divinerpg.compat.jei.category;

import divinerpg.recipe.MaulSmashingRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;

import java.util.List;

import static divinerpg.registries.ItemRegistry.realmite_maul;
import static divinerpg.registries.RecipeRegistry.Types.MAUL_SMASHING;
import static net.minecraft.core.registries.Registries.BLOCK;
import static net.minecraft.world.item.Items.AIR;

public class SmashingCategory implements IRecipeCategory<RecipeHolder<MaulSmashingRecipe>> {
    public static final IRecipeType<RecipeHolder<MaulSmashingRecipe>> RECIPE_TYPE = IRecipeType.create(MAUL_SMASHING.get());
    private final IDrawable background;
    private final IDrawable icon;
    public SmashingCategory(IGuiHelper helper) {
        background = helper.createBlankDrawable(130, 40);
        icon = helper.createDrawableItemStack(new ItemStack(realmite_maul.get()));
    }
    @Override public IRecipeType<RecipeHolder<MaulSmashingRecipe>> getRecipeType() {
        return RECIPE_TYPE;
    }
    @Override public Component getTitle() {
        return Component.translatable("tooltip.divinerpg.jei.smashing");
    }
    @Override public int getWidth() {
        return background.getWidth();
    }
    @Override public int getHeight() {
        return background.getHeight();
    }
    @Override public IDrawable getIcon() {
        return this.icon;
    }
    @Override public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MaulSmashingRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(10, 11).add(recipe.value().input());
        var blockRegistry = Minecraft.getInstance().level.registryAccess().lookupOrThrow(BLOCK);
        TagKey<Block> baseTag = recipe.value().requiredBaseBlockTag();
        if(baseTag != null) {
            List<ItemStack> baseBlockStacks = blockRegistry.get(baseTag)
                .map(named -> named.stream()
                    .map(Holder::value)
                    .map(Block::asItem)
                    .filter(item -> item != AIR)
                    .map(ItemStack::new)
                    .toList())
                .orElse(List.of());
            if(!baseBlockStacks.isEmpty()) builder.addInputSlot(48, 11).addItemStacks(baseBlockStacks);
        } ItemStack outputStack = recipe.value().result().create();
        if(!outputStack.isEmpty()) builder.addOutputSlot(96, 11).add(outputStack);
    }
}