package net.divinerpg.entities.arcana.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntitySnowball {
	
    public EntityGrenade(World var1) {
        super(var1);
    }

    public EntityGrenade(World var1, EntityPlayer par3EntityPlayer) {
        super(var1, par3EntityPlayer);
    }

    public EntityGrenade(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (!this.worldObj.isRemote) {
        	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
            this.setDead();
        }
    }
}