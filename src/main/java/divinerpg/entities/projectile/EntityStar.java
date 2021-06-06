package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.awt.*;

public class EntityStar extends DivineThrowable {
	
    private Color colour;

    public EntityStar(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }

    public EntityStar(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }

    public EntityStar(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }

    public Color getColour() {
        return this.colour;
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if(result.hitInfo != null) {
            ((LivingEntity)result.hitInfo).hurt(DamageSource.thrown(this, this.getOwner()), 20);
        }

        if(!this.level.isClientSide) {
            this.kill();
        }
    }
}