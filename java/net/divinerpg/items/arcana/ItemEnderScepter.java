package net.divinerpg.items.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderScepter extends ItemMod {

	private Random rand = new Random();
	
	public ItemEnderScepter(String name) {
		super(name, DivineRPGTabs.swords);
	}

	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
		float var4 = par3.rotationPitch;
		float var5 = par3.rotationYaw;
		double var6 = par3.posX;
		double var8 = par3.posY + 1.62D - (double)par3.yOffset;
		double var10 = par3.posZ;
		Vec3 var12 = Vec3.createVectorHelper(var6, var8, var10);
		float var13 = MathHelper.cos(-var5 * 0.01745329F - (float)Math.PI);
		float var14 = MathHelper.sin(-var5 * 0.01745329F - (float)Math.PI);
		float var15 = -MathHelper.cos(-var4 * 0.01745329F);
		float var16 = MathHelper.sin(-var4 * 0.01745329F);
		float var17 = var14 * var15;
		float var18 = var13 * var15;
		double var19 = 30.0D;
		Vec3 var21 = var12.addVector((double)var17 * var19, (double)var16 * var19, (double)var18 * var19);
		MovingObjectPosition var22 = par2.rayTraceBlocks(var12, var21);

		if (var22 == null) {
			return par1;
		} else {
			if (var22.typeOfHit == MovingObjectType.BLOCK) {
				int var23 = var22.blockX;
				int var24 = var22.blockY;
				int var25 = var22.blockZ;
				int var26 = var22.sideHit;

				if (var26 == 0) --var24;                
				if (var26 == 1) ++var24;               
				if (var26 == 2) --var25;                
				if (var26 == 3) ++var25;                
				if (var26 == 4) --var23;                
				if (var26 == 5) ++var23;                

				if(ArcanaHelper.useBar(75)) {
					par3.getLook(1);
					this.teleportTo(par3, par2, (double)var23, (double)var24, (double)var25);
				}
			}
		}

		return par1;
	}

	protected void teleportTo(EntityPlayer par1, World par2, double par3, double par4, double par5) {
		par1.setPosition(par3, par4, par5);
		par2.playSoundAtEntity(par1, "mob.endermen.portal", 1.0F, 1.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("75 Arcana");
		par3List.add("On use: Teleports the player");
	}
}
