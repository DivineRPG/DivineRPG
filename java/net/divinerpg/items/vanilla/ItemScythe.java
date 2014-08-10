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
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.entities.vanilla.projectile.EntityShuriken;
import net.divinerpg.entities.vanilla.projectile.EntityVileStorm;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemScythe extends ItemMod {
	
	public ItemScythe(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){
			var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			var2.spawnEntityInWorld(new EntityScythe(var2, var3));
		}
		return var1;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add((int)EntityScythe.damage + " Ranged damage");
		par3List.add("Infinite ammo and durability");
		par3List.add(ChatFormats.DIVINERPG);
	}
}
