package net.divinerpg.items.arcana;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.EntityDramix;
import net.divinerpg.entities.arcana.EntityParasecta;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWizardsBook extends ItemMod {

	public ItemWizardsBook(String name) {
		super(name, DivineRPGTabs.spawner);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer p, World w, int x, int y, int z, int i, float f, float f1, float f2) {
		EntityParasecta parasecta = new EntityParasecta(w);
		EntityDramix dramix = new EntityDramix(w);
		Block block = w.getBlock(x, y, z);

		if(!w.isRemote){
			if(block == ArcanaBlocks.parasectaAltar){
				parasecta.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(parasecta);
				Util.sendMessageToAll(p.getDisplayName() + " Spawned the Parasecta!");
				return true;
			} 

			if(block == ArcanaBlocks.dramixAltar){
				dramix.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(dramix);
				Util.sendMessageToAll(p.getDisplayName() + " Spawned the Dramix!");
				return true;
			}
		}
		return false;
	}
}