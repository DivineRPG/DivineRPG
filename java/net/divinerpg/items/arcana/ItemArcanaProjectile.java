package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcanaProjectile extends ItemMod {

	private int arcana;

	public ItemArcanaProjectile(String name, DivineRPGTabs tab, int size, int uses, int arcana) {
		super(name, tab);
		this.maxStackSize = size;
		this.setMaxDurability(uses);
		this.arcana = arcana;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Item item = stack.getItem();
			if(item == ArcanaItems.firefly && !world.isRemote && ArcanaHelper.getProperties(player).useBar(arcana)){
				Sounds.playSound(player, world, Sounds.firefly);
				EntityFirefly e = new EntityFirefly(world, player, 0.6F, 50);
				e.setDamage(15);
				world.spawnEntityInWorld(e);
			}
			if(item == ArcanaItems.laVekor) {
				if((player.inventory.hasItem(ArcanaItems.grenade) || player.capabilities.isCreativeMode) && ArcanaHelper.getProperties(player).useBar(arcana)) {
				if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(ArcanaItems.grenade);
				if(!world.isRemote){
					Sounds.playSound(player, world, Sounds.laVekor);
					world.spawnEntityInWorld(new EntityGrenade(world, player));
				}
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
		if(stack.getItem() == ArcanaItems.laVekor) list.add("Launches Explosive Projectiles");
		list.add(this == ArcanaItems.laVekor ? "Ammo: " + StatCollector.translateToLocal(ArcanaItems.grenade.getUnlocalizedName() + ".name") : "Infinite Ammo");
		list.add(arcana == 0 ? "" : "Uses " + arcana + " Arcana");
		if(stack.getItem() == ArcanaItems.firefly) list.add("15 Ranged Damage");
		list.add(this.getMaxDurability() == -1 ? "Unlimited Uses" : stack.getMaxDurability() - stack.getMetadata() + " Uses Remaining");
	}
}