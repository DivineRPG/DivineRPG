package net.divinerpg.items.iceika;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.items.twilight.ItemTwilightClock;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSnowGlobe extends ItemMod{

	public ItemSnowGlobe(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.utility);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (par7 != 1) 
			return false;

		else if (p.canPlayerEdit(x, y, z, par7, i) && p.canPlayerEdit(x, y + 1, z, par7, i)) {
			Block b = w.getBlock(x, y, z);

			if(b == Blocks.snow) {
				w.setBlock(x, y + 1, z, IceikaBlocks.iceikaFire);
				return true;
			}
		}
		return false;
	}
}