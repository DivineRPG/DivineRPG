package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.iceika.projectile.EntityFractiteCannon;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFractiteCannon extends ItemMod {
	
	public ItemFractiteCannon(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){
			if(var3.inventory.hasItem(IceikaItems.iceShards) || var3.capabilities.isCreativeMode) {
				var2.spawnEntityInWorld(new EntityFractiteCannon(var2, var3));
				Sounds.getSoundName(Sounds.frostclawCannon);
				var1.damageItem(1, var3);
				if(!var3.capabilities.isCreativeMode)var3.inventory.consumeInventoryItem(IceikaItems.iceShards);
		}
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("15 Ranged damage");
		par3List.add("Ammo: Frozen Shards");
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
	}

}
