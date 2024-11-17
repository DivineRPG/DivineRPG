package net.divinerpg.entities.vanilla.projectile;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCorruptedBullet extends EntityThrowable {
	
	public static float damage = 10.0F;
	public List<Entity> toExcludeList = new ArrayList<Entity>();

	public EntityCorruptedBullet(World var1) {
        super(var1);
    }

    public EntityCorruptedBullet(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    public EntityCorruptedBullet(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            if(!this.toExcludeList.contains(var1.entityHit))var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
            List<Entity> surrounding = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1, 1, 1));
            for(Entity e : surrounding){
            	if(e instanceof EntityCorruptedBullet)((EntityCorruptedBullet) e).toExcludeList.add(var1.entityHit);
            }
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}