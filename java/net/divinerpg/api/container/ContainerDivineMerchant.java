package net.divinerpg.api.container;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotMerchantResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDivineMerchant extends ContainerMerchant {

    public ContainerDivineMerchant(InventoryPlayer par1InventoryPlayer, IMerchant par2IMerchant, World par3World) {
    	super(par1InventoryPlayer, par2IMerchant, par3World);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return true;
    }
}