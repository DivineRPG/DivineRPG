package net.divinerpg.blocks.twilight;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.api.entity.tileentity.container.ContainerModFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerTwilightFurnace extends ContainerModFurnace {

	public ContainerTwilightFurnace(InventoryPlayer player, TileEntityModFurnace furnace) {
		super(player, furnace, true);
	}
}