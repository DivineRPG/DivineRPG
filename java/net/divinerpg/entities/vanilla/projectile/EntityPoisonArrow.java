package net.divinerpg.entities.vanilla.projectile;

import net.divinerpg.api.entity.EntityModArrow;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPoisonArrow extends EntityModArrow {
	
	private static Item arrow = VanillaItemsWeapons.poisonArrow;
	private static double damage = 11.0D;
	
	public EntityPoisonArrow(World par1World) {
		super(par1World, damage, arrow);
	}
	
	public EntityPoisonArrow(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6, damage, arrow);
    }
    
    public EntityPoisonArrow(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)  {
        super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5, damage, arrow);
    }

    public EntityPoisonArrow(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
        super(par1World, par2EntityLivingBase, par3, damage, arrow);
    }    
}
