package net.divinerpg.items.arcana;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.EntityConstructor;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChargedCollector extends ItemMod {

	public ItemChargedCollector(String name) {
		super(name, DivineRPGTabs.spawner);
	}


	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, int x, int y, int z, int par7, float par8, float par9, float par10) {
		EntityConstructor con = new EntityConstructor(w);
		Block block = w.getBlock(x, y, z);
		if(!w.isRemote){
			if(block == ArcanaBlocks.dramixAltar){
				con.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(con);
				return true;
			}
		}
		return false;
	}
}