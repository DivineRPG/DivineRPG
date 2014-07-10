package net.divinerpg.entities.vanilla.projectile;

import net.divinerpg.api.entity.EntityModArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityKingOfScorchersShot extends EntityModArrow{

	public EntityKingOfScorchersShot(World par1World) {
		super(par1World, 0.0D, null);
	}
	
	public EntityKingOfScorchersShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6, 0.0D, null);
    }
    
    public EntityKingOfScorchersShot(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)  {
        super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5, 0.0D, null);
    }

    public EntityKingOfScorchersShot(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
        super(par1World, par2EntityLivingBase, par3, 0.0D, null);
    }

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if(!worldObj.isRemote)
			this.worldObj.createExplosion(par1EntityPlayer, posX, posY, posZ, 3.0F, false); 
	}
}