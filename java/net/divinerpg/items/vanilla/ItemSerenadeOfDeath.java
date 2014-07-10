package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.twilight.projectile.EntitySlicerApalachia;
import net.divinerpg.entities.twilight.projectile.EntitySlicerEden;
import net.divinerpg.entities.twilight.projectile.EntitySlicerHalite;
import net.divinerpg.entities.twilight.projectile.EntitySlicerMortum;
import net.divinerpg.entities.twilight.projectile.EntitySlicerSkythern;
import net.divinerpg.entities.twilight.projectile.EntitySlicerWildWoods;
import net.divinerpg.entities.vanilla.projectile.EntityDeath;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.entities.vanilla.projectile.EntityShuriken;
import net.divinerpg.entities.vanilla.projectile.EntityVileStorm;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSerenadeOfDeath extends ItemMod {
	
	public ItemSerenadeOfDeath(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(500);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){
			Sounds.getSoundName(Sounds.serenade);
			var2.spawnEntityInWorld(new EntityDeath(var2, var3));
			var1.damageItem(1, var3);
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("12 Ranged damage");
		par3List.add(getMaxDamage() - var1.getItemDamage() + " Uses");
	}
}
