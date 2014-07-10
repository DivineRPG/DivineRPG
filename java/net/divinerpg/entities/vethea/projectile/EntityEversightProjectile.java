package net.divinerpg.entities.vethea.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;


public class EntityEversightProjectile extends EntityVetheanCannonShot
{
    public EntityEversightProjectile(World par1)
    {
        super(par1);
    }

    public EntityEversightProjectile(World par1, EntityLivingBase par2, int par3)
    {
        super(par1, par2, par3);
    }

    public EntityEversightProjectile(World par1, double par2, double par4, double par6)
    {
        super(par1, par2, par4, par6);
    }
}