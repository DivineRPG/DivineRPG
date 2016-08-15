package net.divinerpg.entities.twilight.projectile;

import java.awt.Color;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTwilightMageShot extends EntityParticleBullet {
    
    public EntityTwilightMageShot(World world) {
        super(world);
        setMoreParticles();
    }

    public EntityTwilightMageShot(World world, EntityLivingBase e, int r, int g, int b) {
        super(world, e, (float)e.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue(), EntityResourceLocation.blank.toString(), new Color(r, g, b));
        setMoreParticles();
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote && this.ticksExisted>20)this.setDead();
    }
    
    @Override
    public void onImpact(MovingObjectPosition pos) {
        super.onImpact(pos);
    }
}
