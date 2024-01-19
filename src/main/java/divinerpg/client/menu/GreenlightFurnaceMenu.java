package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.*;

public class GreenlightFurnaceMenu extends DivineFurnaceMenu {
    private final Container container;
    public GreenlightFurnaceMenu(int p_i50082_1_, Inventory p_i50082_2_) {
        super(MenuTypeRegistry.GREENLIGHT_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, p_i50082_1_, p_i50082_2_);
        this.container = new SimpleContainer(2);
    }
    public GreenlightFurnaceMenu(int p_i50083_1_, Inventory p_i50083_2_, Container container, ContainerData p_i50083_4_) {
        super(MenuTypeRegistry.GREENLIGHT_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, p_i50083_1_, p_i50083_2_, container, p_i50083_4_);
        this.container = container;
    }
    public GreenlightFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }

    @Override
    public boolean recipeMatches(RecipeHolder<? extends Recipe<Container>> recipe) {
        return recipe.value().matches(container, level);
    }
}