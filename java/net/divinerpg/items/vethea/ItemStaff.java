package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.vethea.projectile.EntityBouncingProjectile;
import net.divinerpg.entities.vethea.projectile.EntityEvernightProjectile;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStaff extends ItemMod {
	protected int damage;
	protected int cost;

	public ItemStaff(int dam, int cos, String name) {
		super(name);
		this.maxStackSize = 1;
		this.damage = dam;
		this.cost = cos;
		this.setCreativeTab(DivineRPGTabs.vethea);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Deals " + this.damage + " Arcana Damage");
		par3List.add("Bouncing Projectile");
		if(par1ItemStack.getItem() == VetheaItems.evernight){
			par3List.add("Consumes All Of Your Arcana");
		} else {
			par3List.add("Consumes " + this.cost + " Arcana");
		}
		par3List.add(Util.GREEN + "Vethean");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
		if (!par2.isRemote && ArcanaHelper.useBar(this.cost)) {		
			if(par1.getItem() == VetheaItems.evernight){
				par3.attackEntityFrom(new EntityDamageSourceIndirect("arcana", par3, par3).setMagicDamage(), 16);
				par2.spawnEntityInWorld(new EntityEvernightProjectile(par2, par3, this.damage));
			} else {
				par2.spawnEntityInWorld(new EntityBouncingProjectile(par2, par3, this.damage));
			}
			par2.playSoundAtEntity(par3, Sounds.staff.getPrefixedName(), 1.0F, 1.0F);
		}
		return par1;
	}
}