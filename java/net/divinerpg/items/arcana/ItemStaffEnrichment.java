package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStaffEnrichment extends ItemMod {

	public ItemStaffEnrichment(String name) {
		super(name, DivineRPGTabs.tools);
		this.maxStackSize = 1;
		this.setMaxDamage(100);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			Block var11 = par3World.getBlock(par4, par5, par6);
			Block var12 = par3World.getBlock(par4, par5 + 1, par6);

			if(var11 == ArcanaBlocks.arcanaDirt) {
				Block var13 = ArcanaBlocks.arcanaGrass;
				par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepResourcePath(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);
				par2EntityPlayer.triggerAchievement(DivineRPGAchievements.enrichment);
				if (par3World.isRemote) {
					return true;
				} else {
					par3World.setBlock(par4, par5, par6, var13);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
			return false;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Use on arcana dirt to purify.");
		par3List.add(par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() + " Uses");
		par3List.add(ChatFormats.DIVINERPG);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
}