package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.entities.twilight.projectile.EntitySlicerApalachia;
import net.divinerpg.entities.twilight.projectile.EntitySlicerEden;
import net.divinerpg.entities.twilight.projectile.EntitySlicerHalite;
import net.divinerpg.entities.twilight.projectile.EntitySlicerMortum;
import net.divinerpg.entities.twilight.projectile.EntitySlicerSkythern;
import net.divinerpg.entities.twilight.projectile.EntitySlicerWildwood;
import net.divinerpg.entities.vanilla.projectile.EntityDeath;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.entities.vanilla.projectile.EntityShuriken;
import net.divinerpg.entities.vanilla.projectile.EntityVileStorm;
import net.divinerpg.items.base.ItemMod;
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
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			world.playSoundAtEntity(player, Sounds.serenade.getPrefixedName(), 1, 1);
			world.spawnEntityInWorld(new EntityDeath(world, player));
			stack.damageItem(1, player);
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("12 Ranged damage");
		list.add("Poisons target for 2 seconds");
		list.add(getMaxDamage() - stack.getItemDamage() + " Uses");
	}
}
