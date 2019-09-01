package divinerpg.objects.entities.entity.projectiles;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityHeatSeekingProjectile extends EntityThrowable {

    private EntityLivingBase target = null;
    private boolean onlyPlayers = false;

    public EntityHeatSeekingProjectile(World w) {
        super(w);
    }

    public EntityHeatSeekingProjectile(World w, EntityLivingBase e) {
        super(w, e);
    }

    public void setPlayersOnly() {
        this.onlyPlayers = true;
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote)
            return;
        List<EntityLivingBase> mobs = this.world.getEntitiesWithinAABB(EntityLivingBase.class,
                this.getEntityBoundingBox().grow(30, 30, 30));
        boolean findNewTarget = this.target == null || (this.target != null && this.target.isDead);
        for (EntityLivingBase e : mobs) {
            if (e != this.getThrower() && (!this.onlyPlayers || (this.onlyPlayers && e instanceof EntityPlayer))) {
                float targetDist = target == null ? 0 : this.getDistance(target);
                float compareDist = this.getDistance(e);
                if (findNewTarget
                        && (target == null || (target != null && this.getDistance(e) < this.getDistance(target))))
                    target = e;
            }
        }
        if (target != null) {
            Vec3d dir = new Vec3d(target.posX - this.posX, (target.posY + target.getEyeHeight()) - this.posY,
                    target.posZ - this.posZ).normalize();
            this.motionX = dir.x / 1.5;
            this.motionY = dir.y / 1.5;
            this.motionZ = dir.z / 1.5;
        }

        if (this.ticksExisted > 50)
            this.setDead();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
    }
}