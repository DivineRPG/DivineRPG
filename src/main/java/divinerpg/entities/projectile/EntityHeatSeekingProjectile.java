package divinerpg.entities.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.List;

public class EntityHeatSeekingProjectile extends DivineThrowable {

    private LivingEntity target = null;
    private boolean onlyPlayers = false;

    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
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
        if (this.level().isClientSide)
            return;
        List<LivingEntity> mobs = this.level().getEntitiesOfClass(LivingEntity.class,
                this.getBoundingBox().inflate(30, 30, 30));
        boolean findNewTarget = this.target == null || (this.target != null && this.target.isDeadOrDying());
        for (LivingEntity e : mobs) {
            if (e != this.getOwner() && (!this.onlyPlayers || (this.onlyPlayers && e instanceof Player))) {
                float targetDist = target == null ? 0 : this.distanceTo(target);
                float compareDist = this.distanceTo(e);
                if (findNewTarget
                        && (target == null || (target != null && compareDist < targetDist)))
                    target = e;
            }
        }
        if (target != null) {
            Vec3 dir = new Vec3(target.xo - this.xo, (target.yo + target.getEyeHeight()) - this.yo,
                    target.zo - this.zo).normalize();
            setDeltaMovement(dir.x / 1.25, dir.y / 1.25, dir.z / 1.25);
        }

        if (this.tickCount > 50)
            this.kill();
    }
    @Override
    protected void onHitEntity(EntityHitResult result) {
    }

}