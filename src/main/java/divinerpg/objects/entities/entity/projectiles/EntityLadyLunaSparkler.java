package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import divinerpg.utils.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLadyLunaSparkler extends EntityParticleBullet {

    public EntityLadyLunaSparkler(World world) {
        super(world);
        this.setSize(0.7f, 0.7f);
    }

    public EntityLadyLunaSparkler(World world, EntityLivingBase e) {
        super(world, e, BulletType.LUNA_SPARKLER);
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
            double ty = ((EntityLiving) this.getThrower()).getAttackTarget().getEntityBoundingBox().minY - this.getThrower().posY;
            double tz = ((EntityLiving) this.getThrower()).getAttackTarget().posZ - this.getThrower().posZ;
            if (!this.world.isRemote && this.ticksExisted > 30) this.shoot(tx, ty, tz, 0.5f, 0);
        }
        if (!this.world.isRemote && this.ticksExisted > 80) this.setDead();
    }

    @Override
    public void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(Utils.causeArcanaDamage(this, this.getThrower()), 12.0F);
    }
}