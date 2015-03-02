package net.divinerpg.items.vethea;

import java.util.ArrayList;
import java.util.List;

import net.divinerpg.entities.vethea.projectile.EntityBouncingProjectile;
import net.divinerpg.entities.vethea.projectile.EntityEvernightProjectile;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStaff extends ItemMod {
	
	public static List<Item> staffList = new ArrayList<Item>();
	
	protected int damage;
	protected int cost;

	public ItemStaff(int dam, int cos, String name) {
		super(name);
		this.maxStackSize = 1;
		this.damage = dam;
		this.cost = cos;
		this.setCreativeTab(DivineRPGTabs.vethea);
		this.setFull3D();
		staffList.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Deals " + this.damage + " Arcana Damage");
		list.add("Bouncing Projectile");
		if(stack.getItem() == VetheaItems.evernight){
			list.add("Consumes All Of Your Arcana");
			list.add("Deals 16 Damage to Player");
		} else {
			list.add("Consumes " + this.cost + " Arcana");
		}
		list.add(Util.GREEN + "Vethean");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
		if (!par2.isRemote && ArcanaHelper.getProperties(par3).useBar(this.cost)) {		
			if(par1.getItem() == VetheaItems.evernight){
				par3.attackEntityFrom(new EntityDamageSourceIndirect("arcana", par3, par3).setMagicDamage(), 20);
				par2.spawnEntityInWorld(new EntityEvernightProjectile(par2, par3, this.damage));
			} else {
				par2.spawnEntityInWorld(new EntityBouncingProjectile(par2, par3, this.damage));
			}
			par2.playSoundAtEntity(par3, Sounds.staff.getPrefixedName(), 1.0F, 1.0F);
		}
		return par1;
	}
}