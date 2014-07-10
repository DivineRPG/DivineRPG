package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.iceika.projectile.EntityFrostclaw;
import net.divinerpg.entities.vanilla.projectile.EntityModSnowball;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFrostclawCannon extends ItemMod {
	
	public ItemFrostclawCannon(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(10000);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote) {
				var2.spawnEntityInWorld(new EntityFrostclaw(var2, var3));
				Sounds.getSoundName(Sounds.frostclawCannon);
				var1.damageItem(1, var3);			
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("21 Ranged damage");
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
	}

}
