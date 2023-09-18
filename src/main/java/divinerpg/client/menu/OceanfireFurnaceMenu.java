package divinerpg.client.menu;

import divinerpg.registries.*;
import net.minecraft.network.*;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class OceanfireFurnaceMenu extends InfiniFurnaceMenu {
    public OceanfireFurnaceMenu(int p_i50082_1_, Inventory p_i50082_2_) {
        super(MenuTypeRegistry.OCEANFIRE_FURNACE.get(), p_i50082_1_, p_i50082_2_);
    }

    public OceanfireFurnaceMenu(int p_i50083_1_, Inventory p_i50083_2_, Container p_i50083_3_, ContainerData p_i50083_4_) {
        super(MenuTypeRegistry.OCEANFIRE_FURNACE.get(), p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
    }

    public OceanfireFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}