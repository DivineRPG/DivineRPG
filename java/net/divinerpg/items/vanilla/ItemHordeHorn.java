package net.divinerpg.items.vanilla;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.EntityAyeracoBlue;
import net.divinerpg.entities.vanilla.EntityAyeracoGreen;
import net.divinerpg.entities.vanilla.EntityAyeracoPurple;
import net.divinerpg.entities.vanilla.EntityAyeracoRed;
import net.divinerpg.entities.vanilla.EntityAyeracoYellow;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemHordeHorn extends ItemMod {
	private int spawnTick;

	public ItemHordeHorn(String name) {
		super(name);
		this.maxStackSize = 1;
		this.spawnTick = 600;
		this.setCreativeTab(DivineRPGTabs.spawner);
	}

	public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
		if(var3.isRemote) {
			return true;
		} else {
			var4 += Facing.offsetsXForSide[var7];
			var5 += Facing.offsetsYForSide[var7];
			var6 += Facing.offsetsZForSide[var7];

			if (var3.provider.dimensionId == 1) {
				if (this.spawnTick == 600) {
					var3.playSoundAtEntity(var2, Sounds.ayeracoSpawn.getPrefixedName(), 20.0F, 1.0F);
					var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.GREEN, "The Green Ayeraco Has Been Called Upon"));
				}
				else if (this.spawnTick == 430) 
					var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.BLUE, "The Blue Ayeraco Has Been Called Upon"));

				else if (this.spawnTick == 280) 
					var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "The Red Ayeraco Has Been Called Upon"));

				else if (this.spawnTick == 210) 
					var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "The Yellow Ayeraco Has Been Called Upon"));

				else if (this.spawnTick == 145) 
					var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "The Purple Ayeraco Has Been Called Upon"));

				else if (this.spawnTick == 0) {
					if (this.spawn(var3, var2, var4, var5, var6)) {
						var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "The Ayeraco Horde Has Arrived!"));
						var2.inventory.consumeInventoryItem(this);
						return true;
					}
				}
				this.spawnTick -= 5;
			} else 
				var2.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "The Ayeraco Horde Can Only Be Spawned In The End"));
			return false;
		}
	}

	public boolean spawn(World par1, EntityPlayer par2, double par3, double par4, double par5) {
		EntityAyeracoBlue var1 = new EntityAyeracoBlue(par1);
		EntityAyeracoGreen var2 = new EntityAyeracoGreen(par1);
		EntityAyeracoRed var3 = new EntityAyeracoRed(par1);
		EntityAyeracoYellow var4 = new EntityAyeracoYellow(par1);
		EntityAyeracoPurple var5 = new EntityAyeracoPurple(par1);

		var1.setLocationAndAngles(par3 + 15, par4 + 4, par5, par1.rand.nextFloat() * 360.0F, 0.0F);
		var2.setLocationAndAngles(par3 + 8, par4 + 4, par5 + 8, par1.rand.nextFloat() * 360.0F, 0.0F);
		var3.setLocationAndAngles(par3 + 5, par4 + 4, par5 - 12, par1.rand.nextFloat() * 360.0F, 0.0F);
		var4.setLocationAndAngles(par3 - 5, par4 + 4, par5 - 12, par1.rand.nextFloat() * 360.0F, 0.0F);
		var5.setLocationAndAngles(par3 - 8, par4 + 4, par5 + 8, par1.rand.nextFloat() * 360.0F, 0.0F);

		par1.setBlock((int)(par3 + 15), (int)(par4),(int)(par5), VanillaBlocks.ayeracoBeamBlue);
		par1.setBlock((int)(par3 + 8), (int)(par4),(int)(par5 + 8), VanillaBlocks.ayeracoBeamGreen);
		par1.setBlock((int)(par3 + 5), (int)(par4),(int)(par5 - 12), VanillaBlocks.ayeracoBeamRed);
		par1.setBlock((int)(par3 - 5), (int)(par4),(int)(par5 - 12), VanillaBlocks.ayeracoBeamYellow);
		par1.setBlock((int)(par3 - 8), (int)(par4),(int)(par5 + 8), VanillaBlocks.ayeracoBeamPurple);

		var1.initOthers(var2, var3, var4, var5);
		var2.initOthers(var1, var3, var4, var5);
		var3.initOthers(var1, var2, var4, var5);
		var4.initOthers(var1, var2, var3, var5);
		var5.initOthers(var1, var2, var3, var4);

		var1.setBeamLocation((int)(par3 + 15), (int)(par4),(int)(par5));
		var2.setBeamLocation((int)(par3 + 8), (int)(par4),(int)(par5 + 8));
		var3.setBeamLocation((int)(par3 + 5), (int)(par4),(int)(par5 - 12));
		var4.setBeamLocation((int)(par3 - 5), (int)(par4),(int)(par5 - 12));
		var5.setBeamLocation((int)(par3 - 8), (int)(par4),(int)(par5 + 8));

		par1.spawnEntityInWorld(var1);
		par1.spawnEntityInWorld(var2);
		par1.spawnEntityInWorld(var3);
		par1.spawnEntityInWorld(var4);
		par1.spawnEntityInWorld(var5);
		return true;
	}
}