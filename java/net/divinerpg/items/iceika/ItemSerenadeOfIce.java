package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemSerenadeOfIce extends ItemMod {
	
	public ItemSerenadeOfIce(String name){
		super(name);
		setCreativeTab(DivineRPGTabs.tools);
		setMaxDamage(100);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		final double eyeHeight = 1.62;
		final double reachDistance = 300;
		Vec3 startPos = Vec3.createVectorHelper(player.posX, player.posY + eyeHeight, player.posZ);
		Vec3 look = player.getLook(1.0F);
		Vec3 endPos = startPos.addVector(look.xCoord * reachDistance, look.yCoord * reachDistance, look.zCoord * reachDistance);
		MovingObjectPosition rarTrace = world.rayTraceBlocks(startPos, endPos);

		if (rarTrace != null) {
			int x = rarTrace.blockX;
			int y = rarTrace.blockY;
			int z = rarTrace.blockZ;
			List e = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(x-1, y-1, z-1, x+1, y+1, z+1));
			if(Math.abs(Math.sqrt(player.posX*player.posX + player.posY*player.posY + player.posZ*player.posZ) - Math.sqrt(x*x+y*y+z*z)) < 100){
				if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
				for(Object o : e){
					if(o instanceof EntityLivingBase)((EntityLivingBase)o).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2, false));
				}
			}
		}
		return stack;
	}

	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add("Slows mobs for 5 seconds");
	}
}
