package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class MoonlightFurnaceMenu extends AbstractFurnaceMenu {
    public MoonlightFurnaceMenu(int i, Inventory inventory) {
        super(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, i, inventory);
    }
    public MoonlightFurnaceMenu(int id, Inventory inventory, Container container, ContainerData data) {
        super(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, id, inventory);

    }
    public MoonlightFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}