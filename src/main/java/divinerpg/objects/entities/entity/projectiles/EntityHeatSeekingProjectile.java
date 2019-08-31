package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

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
                getTowards());
        // remove thrower
        mobs.remove(getThrower());

        boolean findNewTarget = this.target == null || this.target.isDead;

        for (EntityLivingBase e : mobs) {
            if (!this.onlyPlayers || e instanceof EntityPlayer) {
                if (findNewTarget && (target == null || this.getDistance(e) < this.getDistance(target)))
                    target = e;
            }
        }
        if (target != null) {
            Vec3d dir = new Vec3d(target.posX - this.posX, (target.posY + target.getEyeHeight()) - this.posY,
                    target.posZ - this.posZ).normalize().scale(1 / 1.5);
            setVelocity(dir.x, dir.y, dir.z);
        }

        if (this.ticksExisted > 50)
            this.setDead();
    }

    /**
     * Get correct towards area when entity can find enemy to attack
     * Expanding only towards where entity looks
     */
    private AxisAlignedBB getTowards() {
        AxisAlignedBB box = this.getEntityBoundingBox();
        int expand = 30;
        EnumFacing horizontalFacing = getHorizontalFacing();

        BlockPos min = new BlockPos(box.minX, box.minY - expand, box.minZ);
        BlockPos max = new BlockPos(box.maxX, box.maxY + expand, box.maxZ);

        // expanding towards
        max = max.offset(horizontalFacing, expand)
                // expanding to sides
                .offset(horizontalFacing.rotateY(), expand)
                .offset(horizontalFacing.rotateY().getOpposite(), expand);

        // expanding to sides
        min = min.offset(horizontalFacing.rotateY(), expand)
                .offset(horizontalFacing.rotateY().getOpposite(), expand);


        box = new AxisAlignedBB(min, max);
        return box;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
    }
}