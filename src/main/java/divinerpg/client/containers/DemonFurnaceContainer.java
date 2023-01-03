package divinerpg.client.containers;

import divinerpg.registries.*;
import net.minecraft.network.*;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class DemonFurnaceContainer extends InfiniFurnaceContainer {
    public DemonFurnaceContainer(int i, Inventory inv) {
        super(MenuTypeRegistry.DEMON_FURNACE.get(), i, inv);
    }
    public DemonFurnaceContainer(int i, Inventory inv, Container container, ContainerData data) {
        super(MenuTypeRegistry.DEMON_FURNACE.get(), i, inv, container, data);
    }
    public DemonFurnaceContainer(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}