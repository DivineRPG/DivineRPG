package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMusicShooter extends ItemMod {
	
	public ItemMusicShooter(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(4000);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote) {
			if (this == IceikaItems.soundOfCarols) {
				var2.spawnEntityInWorld(new EntityCarol(var2, var3));
				Sounds.getSoundName(Sounds.soundOfCarols);
				var3.triggerAchievement(DivineRPGAchievements.divineInervention);
			} else {
				var2.spawnEntityInWorld(new EntityMusic(var2, var3));
				Sounds.getSoundName(Sounds.soundOfMusic);
			}
			var1.damageItem(1, var3);	
		}
		return var1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(this == IceikaItems.soundOfCarols) {
			par3List.add("16 Ranged damage");
		} else {
			par3List.add("10 Ranged damage");
		}
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
		par3List.add(Util.DARK_AQUA + Reference.MOD_NAME);
	}
}