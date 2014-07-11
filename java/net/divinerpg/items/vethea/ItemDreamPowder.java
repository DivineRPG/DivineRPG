package net.divinerpg.items.vethea;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDreamPowder extends ItemMod {
	
	public ItemDreamPowder(String name) {
		super(name);
		setCreativeTab(null);
	}

	@Override
	public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
		if (var7 != 1) 
			return false;

		else if (var2.canPlayerEdit(var4, var5, var6, var7, var1) && var2.canPlayerEdit(var4, var5 + 1, var6, var7, var1)) {
			Block var11 = var3.getBlock(var4, var5, var6);

			if(var11 == TwilightBlocks.mortumBlock && var3.isAirBlock(var4, var5 + 1, var6)) {
				var3.setBlock(var4, var5 + 1, var6, VetheaBlocks.vetheaFire);
				return true;
			} else {
				return false;
			}
		}  else {
			return false;
		}
	}
}
