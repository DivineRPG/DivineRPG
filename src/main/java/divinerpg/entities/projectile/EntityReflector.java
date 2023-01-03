package divinerpg.entities.projectile;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityReflector extends DivineThrowable {
    
    int age;

    public EntityReflector(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityReflector(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        setDeltaMovement(getDeltaMovement().x*3, getDeltaMovement().y*3, getDeltaMovement().z*3);
    }

    @Override
    protected void onHitEntity(EntityHitResult pos) {
        if (tickCount != 1 || tickCount != 0) {
            if (pos.getEntity() != null && this.getOwner() != null) {
                Entity ent = pos.getEntity();
                double xDist = (ent.xo - this.getOwner().xo) / 5, yDist = (ent.yo - this.getOwner().yo) / 5, zDist = (ent.zo - this.getOwner().zo) / 5;
                ent.setDeltaMovement(xDist, yDist, zDist);
            }
            this.kill();
        }
    }
    
    @Override
    public float getGravity() {
        return 0;
    }
    
    @Override
    public void tick() {
        super.tick();
        age++;
        if(age>18)this.kill();//I'm an Adult!
    }
}