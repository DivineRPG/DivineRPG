package divinerpg.client.menu;

import divinerpg.registries.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;

public class WhitefireFurnaceMenu extends InfiniFurnaceMenu {
    public WhitefireFurnaceMenu(int p_i50082_1_, Inventory p_i50082_2_) {
        super(MenuTypeRegistry.WHITEFIRE_FURNACE.get(), p_i50082_1_, p_i50082_2_);
    }
    public WhitefireFurnaceMenu(int p_i50083_1_, Inventory p_i50083_2_, Container p_i50083_3_, ContainerData p_i50083_4_) {
        super(MenuTypeRegistry.WHITEFIRE_FURNACE.get(), p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
    }
    public WhitefireFurnaceMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}