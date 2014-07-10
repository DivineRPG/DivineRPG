package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcanaProjectile extends ItemMod {

	private int arcana, damage;

	public ItemArcanaProjectile(String name, DivineRPGTabs tab, int size, int uses, int arcana, int damage) {
		super(name, tab);
		this.maxStackSize = size;
		this.setMaxDamage(uses);
		this.arcana = arcana;
		this.damage = damage;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		Item item = par1ItemStack.getItem();
		if(!par2World.isRemote){
			if(item == ArcanaItems.firefly){
				if(ArcanaHelper.useBar(arcana)) {
					Sounds.playSound(par3EntityPlayer, par2World, Sounds.firefly);
					par2World.spawnEntityInWorld(new EntityFirefly(par2World, par3EntityPlayer, 0.6F, 50));
				}
			}
			if(item == ArcanaItems.grenadeLauncher){
				par3EntityPlayer.inventory.consumeInventoryItem(ArcanaItems.grenade);
				Sounds.playSound(par3EntityPlayer, par2World, Sounds.laVekor);
				par2World.spawnEntityInWorld(new EntityGrenade(par2World, par3EntityPlayer));
			}
		}
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(par1ItemStack.getItem() == ArcanaItems.firefly) par3List.add("Homing Shots");
		if(par1ItemStack.getItem() == ArcanaItems.grenadeLauncher){ par3List.add("Launches explosive projectiles"); par3List.add("Ammo: Grenade"); }
		par3List.add(arcana == 0 ? "" : "Uses " + arcana + " arcana");
		par3List.add(this.getMaxDamage() == -1 ? "Unlimited uses" : par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() + " Uses");
		par3List.add(ChatFormats.DIVINERPG);
	}
}