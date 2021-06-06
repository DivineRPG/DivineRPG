package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityReflector extends DivineThrowable {
    
    int age;

    public EntityReflector(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityReflector(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        setDeltaMovement(getDeltaMovement().x*3, getDeltaMovement().y*3, getDeltaMovement().z*3);
    }

    @Override
    protected void onHit(RayTraceResult pos) {
        if(pos.hitInfo != null && this.getOwner() != null && pos.hitInfo instanceof Entity) {
            Entity ent = (Entity) pos.hitInfo;
            double xDist = (ent.xo-this.getOwner().xo)/5, yDist = (ent.yo-this.getOwner().yo)/5, zDist = (ent.zo-this.getOwner().zo)/5;
            ent.setDeltaMovement(xDist, yDist, zDist);
        }
        this.kill();
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