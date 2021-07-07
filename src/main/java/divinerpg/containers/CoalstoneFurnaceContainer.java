package divinerpg.containers;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.crafting.*;

public class CoalstoneFurnaceContainer extends DivineFurnaceContainer {
    protected CoalstoneFurnaceContainer(ContainerType<?> p_i241921_1_, IRecipeType<? extends AbstractCookingRecipe> p_i241921_2_, RecipeBookCategory p_i241921_3_, int p_i241921_4_, PlayerInventory p_i241921_5_) {
        super(p_i241921_1_, p_i241921_2_, p_i241921_3_, p_i241921_4_, p_i241921_5_);
    }

//    public CoalstoneFurnaceContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, IIntArray fields) {
//        super(ContainerRegistry.COALSTONE_FURNACE.get(), IRecipeType.SMELTING, RecipeBookCategory.FURNACE, windowId, playerInventory);
//    }
//
//    public CoalstoneFurnaceContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, IIntArray fields) {
//        super(ContainerRegistry.COALSTONE_FURNACE.get(), windowId, world, pos, playerInventory, player, fields);
//    }

}