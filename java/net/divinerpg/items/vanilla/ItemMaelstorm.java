package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityMaelstorm;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMaelstorm extends ItemMod {
	
	public ItemMaelstorm(String name) {
		super(name);
		setMaxDamage(100);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){
			var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			var2.spawnEntityInWorld(new EntityMaelstorm(var2, var3));
			var1.damageItem(1, var3);
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add((int)EntityScythe.damage + " Ranged damage");
		par3List.add(getMaxDamage() - var1.getItemDamage() + " Uses");
		par3List.add(ChatFormats.DIVINERPG);
	}
}
