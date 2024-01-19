package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.*;

public class MoonlightFurnaceMenu extends DivineFurnaceMenu {
    private final Container container;
    public MoonlightFurnaceMenu(int i, Inventory inventory) {
        super(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, i, inventory);
        this.container = new SimpleContainer(2);
    }
    public MoonlightFurnaceMenu(int id, Inventory inventory, Container container, ContainerData data) {
        super(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, id, inventory, container, data);
        this.container = container;

    }
    public MoonlightFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }

    @Override
    public boolean recipeMatches(RecipeHolder<? extends Recipe<Container>> recipe) {
        return recipe.value().matches(container, level);
    }
}