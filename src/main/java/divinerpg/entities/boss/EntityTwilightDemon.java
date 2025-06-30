package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.magic.EntityTwilightDemonShot;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.TWILIGHT_DEMON_SHOT;
import static divinerpg.registries.ParticleRegistry.TWILIGHT_PORTAL;
import static divinerpg.registries.SoundRegistry.INSECT;

public class EntityTwilightDemon extends EntityDivineBoss {
    int shooting;
    public EntityTwilightDemon(EntityType<? extends EntityTwilightDemon> type, Level worldIn) {super(type, worldIn);}
    @Override public int getArmorValue() {return 10;}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide) {
            if(tickCount % 160 == 0) shooting = 100;
            if(getTarget() != null && shooting > 0) {
                double tx = getTarget().getX() - getX();
                double ty = getTarget().getBoundingBox().minY - getY() - 2;
                double tz = getTarget().getZ() - getZ();
                double angle = Math.atan(-(tx) / (tz));
                EntityTwilightDemonShot e = TWILIGHT_DEMON_SHOT.get().create(level());
                e.setOwner(this);
                e.setPos(getEyePosition());
                if(random.nextBoolean()) e.particle = TWILIGHT_PORTAL::value;
                e.zo += Math.sin(angle);
                e.xo += Math.cos(angle);
                e.shoot(tx - Math.cos(angle), ty, tz - Math.sin(angle), 1.6F, 0);
                this.level().addFreshEntity(e);
                e = TWILIGHT_DEMON_SHOT.get().create(level());
                e.setOwner(this);
                e.setPos(getEyePosition());
                if(random.nextBoolean()) e.particle = TWILIGHT_PORTAL::value;
                e.zo -= Math.sin(angle);
                e.xo -= Math.cos(angle);
                e.shoot(tx + Math.cos(angle), ty, tz + Math.sin(angle), 1.6F, 0);
                level().addFreshEntity(e);
            } if(shooting > 0) shooting--;
        }
    }
    @Override protected SoundEvent getAmbientSound() {return INSECT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return INSECT.get();}
}