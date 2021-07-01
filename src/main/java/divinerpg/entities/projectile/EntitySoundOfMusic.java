package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public class EntitySoundOfMusic extends DivineThrowable {
    Random r = new Random();
    int color = r.nextInt(25);

    public EntitySoundOfMusic(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySoundOfMusic(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntitySoundOfMusic(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        level.addParticle(ParticleTypes.NOTE, this.xo, this.yo, this.zo, (double) color / 24.0D, 0.0D,
                0.0D);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 10.0F);
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}