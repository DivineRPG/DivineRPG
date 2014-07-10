package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcaniumSaber extends ItemModSword {

	public ItemArcaniumSaber(String name, ToolMaterial var2) {
		super(var2, name);
		this.maxStackSize = 1;
		this.setMaxDamage(-1);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack var1, World var2, Block var3, int x, int y, int z, EntityLivingBase var6) {
		if(ArcanaHelper.useBar(12)) {
			Sounds.playSound(var6, var2, Sounds.arcaniumSaber);
			return true;
		}
		return false;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (ArcanaHelper.useBar(12)) {
			Sounds.playSound(player, player.worldObj, Sounds.arcaniumSaber);
			return false;
		}
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(ArcanaHelper.useBar(12)) {
			Sounds.playSound(var3, var2, Sounds.arcaniumSaber);
			var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
		}
		return var1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("12 Arcana");
		par3List.add("28 Melee Damage");
		par3List.add(ChatFormats.DIVINERPG);
	}
}