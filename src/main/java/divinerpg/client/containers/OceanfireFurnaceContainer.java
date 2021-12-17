package divinerpg.client.containers;

import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.*;
import net.minecraft.util.*;

public class OceanfireFurnaceContainer extends AbstractFurnaceContainer {
    public OceanfireFurnaceContainer(int p_i50082_1_, PlayerInventory p_i50082_2_) {
        super(ContainerRegistry.OCEANFIRE_FURNACE.get(), IRecipeType.SMELTING, RecipeBookCategory.FURNACE, p_i50082_1_, p_i50082_2_);
    }

    public OceanfireFurnaceContainer(int p_i50083_1_, PlayerInventory p_i50083_2_, IInventory p_i50083_3_, IIntArray p_i50083_4_) {
        super(ContainerRegistry.OCEANFIRE_FURNACE.get(), IRecipeType.SMELTING, RecipeBookCategory.FURNACE, p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
    }

    public OceanfireFurnaceContainer(int i, PlayerInventory playerInventory, PacketBuffer buffer) {
        this(i, playerInventory);
    }
}