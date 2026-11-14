package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class DemonFurnaceMenu extends InfiniFurnaceMenu {
    public DemonFurnaceMenu(int i, Inventory inv) {
        super(MenuTypeRegistry.DEMON_FURNACE.get(), i, inv);
    }
    public DemonFurnaceMenu(int i, Inventory inv, Container container, ContainerData data) {
        super(MenuTypeRegistry.DEMON_FURNACE.get(), i, inv, container, data);
    }
    public DemonFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}