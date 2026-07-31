package divinerpg.entities.projectile.magic;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class EntityBouncingProjectile extends DivineArcanaProjectile {
    int bounces = 0;
    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    @Override public void onHitBlock(BlockHitResult result) {
        hitBlockNoDiscard(result);
        Vec3 mv = getDeltaMovement();
        double x = mv.x, y = mv.y, z = mv.z;
        if(result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) lerpMotion(new Vec3(x * .8, y * -.8, z * .8));
        else if(result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) lerpMotion(new Vec3(x * -.8, y * .8, z * .8));
        else if(result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) lerpMotion(new Vec3(x * .8, y * .8, z * -.8));
        if(bounces > 6) discard();
        bounces++;
    }
}