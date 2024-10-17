package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemSerenadeStriker extends ItemMod {
	
	public ItemSerenadeStriker(String name){
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxDamage(100);
		setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		final double eyeHeight = 1.62;
		final double reachDistance = 300;
		
		MovingObjectPosition rarTrace = Util.rayTrace(player, 100);

		if (rarTrace != null && rarTrace.typeOfHit == MovingObjectType.BLOCK) {
			int x = rarTrace.blockX;
			int y = rarTrace.blockY;
			int z = rarTrace.blockZ;

			if(Math.abs(Math.sqrt(player.posX*player.posX + player.posY*player.posY + player.posZ*player.posZ) - Math.sqrt(x*x+y*y+z*z)) < 100){
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
				if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
			}
		}
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Shoots Lightning");
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}
}
