package divinerpg.client.containers;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class CoalstoneFurnaceContainer extends InfiniFurnaceContainer {
	public CoalstoneFurnaceContainer(int i, Inventory inv) {
        super(MenuTypeRegistry.COALSTONE_FURNACE.get(), i, inv);
    }
    public CoalstoneFurnaceContainer(int i, Inventory inv, Container container, ContainerData data) {
        super(MenuTypeRegistry.COALSTONE_FURNACE.get(), i, inv, container, data);
    }
    public CoalstoneFurnaceContainer(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}
