package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.events.ArcanaHelper;
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

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Item item = stack.getItem();
		if(!world.isRemote){
			if(item == ArcanaItems.firefly){
				if(ArcanaHelper.getProperties(player).useBar(arcana)) {
					Sounds.playSound(player, world, Sounds.firefly);
					world.spawnEntityInWorld(new EntityFirefly(world, player, 0.6F, 50));
				}
			}
			if(item == ArcanaItems.grenadeLauncher){
				player.inventory.consumeInventoryItem(ArcanaItems.grenade);
				Sounds.playSound(player, world, Sounds.laVekor);
				world.spawnEntityInWorld(new EntityGrenade(world, player));
			}
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(stack.getItem() == ArcanaItems.firefly) list.add("Homing Shots");
		if(stack.getItem() == ArcanaItems.grenadeLauncher){ list.add("Launches explosive projectiles"); list.add("Ammo: Grenade"); }
		list.add(arcana == 0 ? "" : "Uses " + arcana + " arcana");
		list.add(this.damage + " Ranged Damage");
		list.add(this.getMaxDamage() == -1 ? "Unlimited uses" : stack.getMaxDamage() - stack.getItemDamage() + " Uses");
		list.add(ChatFormats.DIVINERPG);
	}
}