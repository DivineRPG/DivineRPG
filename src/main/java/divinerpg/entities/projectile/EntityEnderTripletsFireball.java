package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public class EntityEnderTripletsFireball extends DivineFireball {
    Entity shootingEntity;
    public EntityEnderTripletsFireball(EntityType<? extends FireballEntity> type, World world) {
        super(type, world);
    }

    public EntityEnderTripletsFireball(World world, LivingEntity entity, double i, double j, double k) {
        super(world, entity, i, j, k);
        this.shootingEntity=entity;
    }


    @Override
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.hitInfo != null) {
                Entity entity = (Entity) result.hitInfo;
                if (this.shootingEntity != null) {
                    entity.hurt(DamageSource.fireball(this, this.shootingEntity), 8);
                }
            }
            this.level.explode(null, this.xo, this.yo, this.zo, 2F, false, Explosion.Mode.DESTROY);
            this.kill();
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        level.addParticle(ParticleRegistry.ENDER_TRIPLET.get(),
                this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 6,
                this.yo + 0.5D + (this.random.nextDouble() - this.random.nextDouble()) / 6,
                this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 6, 0.0D, 0.0D, 0.0D);
    }
}
