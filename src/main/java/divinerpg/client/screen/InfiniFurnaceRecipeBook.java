package divinerpg.client.screen;

import divinerpg.client.menu.InfiniFurnaceMenu;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.display.*;

import java.util.List;

public class InfiniFurnaceRecipeBook extends RecipeBookComponent<InfiniFurnaceMenu> {
    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(new RecipeBookComponent.TabInfo(SearchRecipeBookCategory.FURNACE), new RecipeBookComponent.TabInfo(Items.PORKCHOP, RecipeBookCategories.FURNACE_FOOD), new RecipeBookComponent.TabInfo(Items.STONE, RecipeBookCategories.FURNACE_BLOCKS), new RecipeBookComponent.TabInfo(Items.LAVA_BUCKET, Items.EMERALD, RecipeBookCategories.FURNACE_MISC));
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.smeltable");
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(Identifier.withDefaultNamespace("recipe_book/furnace_filter_enabled"), Identifier.withDefaultNamespace("recipe_book/furnace_filter_disabled"), Identifier.withDefaultNamespace("recipe_book/furnace_filter_enabled_highlighted"), Identifier.withDefaultNamespace("recipe_book/furnace_filter_disabled_highlighted"));
    public InfiniFurnaceRecipeBook(InfiniFurnaceMenu menu) {
        super(menu, TABS);
    }
    protected WidgetSprites getFilterButtonTextures() {
        return FILTER_SPRITES;
    }
    protected boolean isCraftingSlot(Slot slot) {return slot.index < 2;}
    protected void fillGhostRecipe(GhostSlots ghostSlots, RecipeDisplay recipe, ContextMap context) {
        ghostSlots.setResult(menu.getResultSlot(), context, recipe.result());
        if(recipe instanceof FurnaceRecipeDisplay furnaceRecipe) {
            ghostSlots.setInput(menu.slots.get(0), context, furnaceRecipe.ingredient());
            Slot fuelSlot = menu.slots.get(1);
            if(fuelSlot.getItem().isEmpty()) ghostSlots.setInput(fuelSlot, context, furnaceRecipe.fuel());
        }
    }
    protected Component getRecipeFilterName() {
        return FILTER_NAME;
    }
    protected void selectMatchingRecipes(RecipeCollection collection, StackedItemContents stackedContents) {
        collection.selectRecipes(stackedContents, (display) -> display instanceof FurnaceRecipeDisplay);
    }
}