package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityModSnowball;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.ChatFormats;
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

public class ItemFrostCannon extends ItemMod {
	
	public ItemFrostCannon(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(15000);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote) {
			boolean var4 = var3.capabilities.isCreativeMode;

			if (!var4 && !var3.inventory.hasItem(Items.snowball)) {
				return var1;
			} else {
				var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				var2.spawnEntityInWorld(new EntityModSnowball(var2, var3));
				var3.inventory.consumeInventoryItem(Items.snowball);
				var1.damageItem(100, var3);
			}
			
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("8 Ranged damage");
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
		par3List.add("Ammo: Snowballs");
		par3List.add(ChatFormats.DIVINERPG);
	}

}
