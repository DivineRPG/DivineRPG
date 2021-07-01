package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityHeatSeekingProjectile extends DivineThrowable {

    private LivingEntity target = null;
    private boolean onlyPlayers = false;

    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    public void setPlayersOnly() {
        this.onlyPlayers = true;
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide)
            return;
        List<LivingEntity> mobs = this.level.getEntitiesOfClass(LivingEntity.class,
                this.getBoundingBox().inflate(30, 30, 30));
        boolean findNewTarget = this.target == null || (this.target != null && this.target.isDeadOrDying());
        for (LivingEntity e : mobs) {
            if (e != this.getOwner() && (!this.onlyPlayers || (this.onlyPlayers && e instanceof PlayerEntity))) {
                float targetDist = target == null ? 0 : this.distanceTo(target);
                float compareDist = this.distanceTo(e);
                if (findNewTarget
                        && (target == null || (target != null && this.distanceTo(e) < this.distanceTo(target))))
                    target = e;
            }
        }
        if (target != null) {
            Vector3d dir = new Vector3d(target.xo - this.xo, (target.yo + target.getEyeHeight()) - this.yo,
                    target.zo - this.zo).normalize();
            setDeltaMovement(dir.x / 1.25, dir.y / 1.25, dir.z / 1.25);
        }

        if (this.tickCount > 50)
            this.kill();
    }
    @Override
    protected void onHit(RayTraceResult result) {
    }

}