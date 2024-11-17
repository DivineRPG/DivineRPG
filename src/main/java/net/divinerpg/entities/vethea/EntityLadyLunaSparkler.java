package net.divinerpg.entities.vethea;

import java.awt.Color;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.fx.EntityColoredFX;
import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.divinerpg.utils.Util;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLadyLunaSparkler extends EntityParticleBullet {

    public EntityLadyLunaSparkler(World world) {
        super(world);
        setMoreParticles();
        this.setSize(0.7f, 0.7f);
    }

    public EntityLadyLunaSparkler(World world, EntityLivingBase e) {
        super(world, e, 12, EntityResourceLocation.blank.toString(), new Color(139, 103, 255));
        setMoreParticles();
        this.motionX = this.motionY = this.motionZ = 0;
        this.setSize(0.7f, 0.7f);
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getThrower() != null && this.getThrower() instanceof EntityLiving && ((EntityLiving) this.getThrower()).getAttackTarget() != null) {
            double tx = ((EntityLiving) this.getThrower()).getAttackTarget().posX - this.getThrower().posX;
            double ty = ((EntityLiving) this.getThrower()).getAttackTarget().boundingBox.minY - this.getThrower().posY;
            double tz = ((EntityLiving) this.getThrower()).getAttackTarget().posZ - this.getThrower().posZ;
            if (!this.worldObj.isRemote && this.ticksExisted > 30) this.setThrowableHeading(tx, ty, tz, 0.5f, 0);
        }
        if (!this.worldObj.isRemote && this.ticksExisted > 80) this.setDead();
    }
    
    @Override
    public void onImpact(MovingObjectPosition pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(Util.causeArcanaDamage(this, this.getThrower()), damage);
    }
}
