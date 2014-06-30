package net.divinerpg.items.vethea;

import net.divinerpg.entity.vethea.projectile.EntityAmthirmisDisk;
import net.divinerpg.entity.vethea.projectile.EntityArksianeDisk;
import net.divinerpg.entity.vethea.projectile.EntityCermileDisk;
import net.divinerpg.entity.vethea.projectile.EntityDarvenDisk;
import net.divinerpg.entity.vethea.projectile.EntityHeliosisDisk;
import net.divinerpg.entity.vethea.projectile.EntityKarosDisk;
import net.divinerpg.entity.vethea.projectile.EntityPardimalDisk;
import net.divinerpg.entity.vethea.projectile.EntityQuadroticDisk;
import net.divinerpg.entity.vethea.projectile.EntityTeakerDisk;
import net.divinerpg.helper.items.VetheanItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDisk extends ItemVetheanDisk{

	private int dam;
	
	public ItemDisk(int par1, String name) {
		super(par1, name);
		dam = par1;
	}

	public void shoot(ItemStack var1, World var2, EntityPlayer var3){
		if(var1.getItem() == VetheanItems.teakerDisk){
			var2.spawnEntityInWorld(new EntityTeakerDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.amthrimisDisk){
			var2.spawnEntityInWorld(new EntityAmthirmisDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.darvenDisk){
			var2.spawnEntityInWorld(new EntityDarvenDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.cermileDisk){
			var2.spawnEntityInWorld(new EntityCermileDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.pardimalDisk){
			var2.spawnEntityInWorld(new EntityPardimalDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.quadroticDisk){
			var2.spawnEntityInWorld(new EntityQuadroticDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.karosDisk){
			var2.spawnEntityInWorld(new EntityKarosDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.heliosisDisk){
			var2.spawnEntityInWorld(new EntityHeliosisDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheanItems.arksianeDisk){
			var2.spawnEntityInWorld(new EntityArksianeDisk(var2, var3, dam, this));
		}
	}
}