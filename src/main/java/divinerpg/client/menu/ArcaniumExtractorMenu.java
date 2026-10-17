package divinerpg.client.menu;

import divinerpg.registries.ItemRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipePropertySet;

import static divinerpg.registries.MenuTypeRegistry.ARCANIUM_EXTRACTOR;

public class ArcaniumExtractorMenu extends AbstractFurnaceMenu {

    public ArcaniumExtractorMenu(int containerId, Inventory inv) {
        super(ARCANIUM_EXTRACTOR.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, containerId, inv);
    }

    public ArcaniumExtractorMenu(int containerId, Inventory inv, Container container, ContainerData data) {
        super(ARCANIUM_EXTRACTOR.get(), RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, containerId, inv, container, data);
        this.slots.set(1, new FurnaceFuelSlot(this, container, 1, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return isFuel(stack);
            }
        });
    }

    public ArcaniumExtractorMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(containerId, playerInventory);
    }

    @Override
    protected boolean isFuel(ItemStack stack) {
        return stack.is(ItemRegistry.collector.get());
    }
}