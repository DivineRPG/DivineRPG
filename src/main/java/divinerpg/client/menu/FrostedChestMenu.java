package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;

public class FrostedChestMenu extends ChestMenu {
    public FrostedChestMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory, new SimpleContainer(27));
    }
    public static FrostedChestMenu threeRows(int i, Inventory in, Container c) {
        return new FrostedChestMenu(i, in, c);
    }
    public FrostedChestMenu(int i, Inventory in, Container c) {
        super(MenuTypeRegistry.FROSTED_CHEST.get(), i, in, c, 3);
    }
}