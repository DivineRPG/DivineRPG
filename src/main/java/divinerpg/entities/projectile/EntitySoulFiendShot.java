package divinerpg.entities.projectile;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public class EntitySoulFiendShot extends EntityShooterBullet {
    public EntitySoulFiendShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySoulFiendShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world, BulletType.SOUL_FIEND_SHOT);
    }


    @Override
    public void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.hitInfo != null) {
                for (int i = 0; i < 3; i++) {
                    //TODO - soul spider in soul fiend shot
//                    EntitySoulSpider soulSpider = new EntitySoulSpider(this.world);
//                    soulSpider.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
//                    this.world.spawnEntity(soulSpider);
                }
                this.kill();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        for (int cnt = 0; cnt < 8; ++cnt) {
            //TODO - coloured particles
//            DivineRPG.proxy.spawnColoredParticle(this.world, this.posX + (rand.nextDouble() - rand.nextDouble()) / 4,
//                    this.posY + (rand.nextDouble() - rand.nextDouble()) / 4,
//                    this.posZ + (rand.nextDouble() - rand.nextDouble()) / 4, new Color(0, 0, 0), true, false);
//            DivineRPG.proxy.spawnColoredParticle(this.world, this.posX + (rand.nextDouble() - rand.nextDouble()) / 4,
//                    this.posY + (rand.nextDouble() - rand.nextDouble()) / 4,
//                    this.posZ + (rand.nextDouble() - rand.nextDouble()) / 4, new Color(255, 0, 0), true, true);
        }
        if (!this.level.isClientSide && this.tickCount > 20) {
            this.kill();
        }
    }
}
