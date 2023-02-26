package divinerpg.client.containers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;

public class EdenChestMenu extends ChestMenu {
    public EdenChestMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
    public EdenChestMenu(int i, Inventory inv) {
        this(MenuType.GENERIC_9x6, i, inv, 6);
    }
    public EdenChestMenu(MenuType<?> type, int i, Inventory inv, int rows) {
        this(type, i, inv, new SimpleContainer(9 * rows), rows);
    }
    public EdenChestMenu(MenuType<?> type, int i, Inventory inv, Container container, int rows) {
        super(type, i, inv, container, rows);
    }
}