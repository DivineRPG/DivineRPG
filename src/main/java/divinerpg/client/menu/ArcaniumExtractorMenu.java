package divinerpg.client.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.RecipePropertySet;

import static divinerpg.registries.MenuTypeRegistry.ARCANIUM_EXTRACTOR;

public class ArcaniumExtractorMenu extends AbstractFurnaceMenu {
    public ArcaniumExtractorMenu(int containerId, Inventory inv) {
        super(ARCANIUM_EXTRACTOR.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, containerId, inv);
    }

    public ArcaniumExtractorMenu(int containerId, Inventory inv, Container container, ContainerData data) {
        super(ARCANIUM_EXTRACTOR.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, containerId, inv, container, data);
    }

    public ArcaniumExtractorMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(containerId, playerInventory);
    }
}