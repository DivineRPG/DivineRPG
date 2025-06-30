package divinerpg.entities.projectile.bullet;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.List;

public class EntityHeatSeekingProjectile extends ThrowableProjectile {

    private LivingEntity target = null;
    private boolean onlyPlayers = false;
    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityHeatSeekingProjectile(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {super(type, entity, world);}
    public void setPlayersOnly() {onlyPlayers = true;}
    @Override public boolean isNoGravity() {return true;}
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
    @Override public void tick() {
        //TODO: to fix
        super.tick();
        if(level().isClientSide()) return;
        List<LivingEntity> mobs = level().getEntitiesOfClass(LivingEntity.class,
                getBoundingBox().inflate(30, 30, 30));
        boolean findNewTarget = target == null || target.isDeadOrDying();
        for(LivingEntity e : mobs) {
            if(e != getOwner() && (!onlyPlayers || e instanceof Player)) {
                float targetDist = target == null ? 0 : distanceTo(target);
                float compareDist = distanceTo(e);
                if(findNewTarget && (target == null || compareDist < targetDist)) target = e;
            }
        } if(target != null) {
            Vec3 dir = new Vec3(target.xo - xo, (target.yo + target.getEyeHeight()) - yo, target.zo - zo).normalize();
            setDeltaMovement(dir.x / 1.25, dir.y / 1.25, dir.z / 1.25);
        } if(tickCount > 50) discard();
    }
    @Override protected void onHitEntity(EntityHitResult result) {discard();}
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }
}