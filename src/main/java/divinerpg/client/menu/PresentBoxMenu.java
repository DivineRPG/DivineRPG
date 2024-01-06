package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;

public class PresentBoxMenu extends ChestMenu {
    public PresentBoxMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory, new SimpleContainer(27));
    }
    public static PresentBoxMenu threeRows(int i, Inventory in, Container c) {
        return new PresentBoxMenu(i, in, c);
    }
    public PresentBoxMenu(int i, Inventory in, Container c) {
        super(MenuTypeRegistry.PRESENT_BOX.get(), i, in, c, 3);
    }
}