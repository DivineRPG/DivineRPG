package net.divinerpg.items.vethea;

import net.divinerpg.entities.vethea.projectile.EntityAmthirmisDisk;
import net.divinerpg.entities.vethea.projectile.EntityArksianeDisk;
import net.divinerpg.entities.vethea.projectile.EntityCermileDisk;
import net.divinerpg.entities.vethea.projectile.EntityDarvenDisk;
import net.divinerpg.entities.vethea.projectile.EntityHeliosisDisk;
import net.divinerpg.entities.vethea.projectile.EntityKarosDisk;
import net.divinerpg.entities.vethea.projectile.EntityPardimalDisk;
import net.divinerpg.entities.vethea.projectile.EntityQuadroticDisk;
import net.divinerpg.entities.vethea.projectile.EntityTeakerDisk;
import net.divinerpg.utils.items.VetheaItems;
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
		if(var1.getItem() == VetheaItems.teakerDisk){
			var2.spawnEntityInWorld(new EntityTeakerDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.amthrimisDisk){
			var2.spawnEntityInWorld(new EntityAmthirmisDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.darvenDisk){
			var2.spawnEntityInWorld(new EntityDarvenDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.cermileDisk){
			var2.spawnEntityInWorld(new EntityCermileDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.pardimalDisk){
			var2.spawnEntityInWorld(new EntityPardimalDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.quadroticDisk){
			var2.spawnEntityInWorld(new EntityQuadroticDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.karosDisk){
			var2.spawnEntityInWorld(new EntityKarosDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.heliosisDisk){
			var2.spawnEntityInWorld(new EntityHeliosisDisk(var2, var3, dam, this));
		}
		if(var1.getItem() == VetheaItems.arksianeDisk){
			var2.spawnEntityInWorld(new EntityArksianeDisk(var2, var3, dam, this));
		}
	}
}