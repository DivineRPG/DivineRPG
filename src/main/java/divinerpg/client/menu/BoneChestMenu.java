package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;

public class BoneChestMenu extends ChestMenu {
    public BoneChestMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory, new SimpleContainer(27));
    }
    public static BoneChestMenu threeRows(int i, Inventory in, Container c) {
        return new BoneChestMenu(i, in, c);
    }
    public BoneChestMenu(int i, Inventory in, Container c) {
        super(MenuTypeRegistry.BONE_CHEST.get(), i, in, c, 3);
    }
}