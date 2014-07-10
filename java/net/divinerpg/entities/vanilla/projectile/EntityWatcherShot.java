package net.divinerpg.entities.vanilla.projectile;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWatcherShot extends EntityThrowable {

    public EntityWatcherShot(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 20.0F);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}