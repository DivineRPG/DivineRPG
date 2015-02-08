package net.divinerpg.items.arcana;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.EntityConstructor;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlowingCollector extends ItemMod {

	public ItemGlowingCollector(String name) {
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
				if (!p.capabilities.isCreativeMode) --i.stackSize;
				return true;
			}
		}
		return false;
	}
	
	@Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Spawns a Constuctor when used on a Dramix Altar");
	}
}