package divinerpg.client.containers;

import divinerpg.registries.*;
import net.minecraft.network.*;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class MoltenFurnaceContainer extends InfiniFurnaceContainer {
    public MoltenFurnaceContainer(int p_i50082_1_, Inventory p_i50082_2_) {
        super(MenuTypeRegistry.MOLTEN_FURNACE.get(), p_i50082_1_, p_i50082_2_);
    }

    public MoltenFurnaceContainer(int p_i50083_1_, Inventory p_i50083_2_, Container p_i50083_3_, ContainerData p_i50083_4_) {
        super(MenuTypeRegistry.MOLTEN_FURNACE.get(), p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
    }

    public MoltenFurnaceContainer(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}