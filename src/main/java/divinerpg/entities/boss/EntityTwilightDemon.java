package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.magic.EntityTwilightDemonShot;
import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityTwilightDemon extends EntityDivineBoss {

    int shooting;

    public EntityTwilightDemon(EntityType<? extends EntityTwilightDemon> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 40.0F, 50));
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            if (this.tickCount % 160 == 0)
                this.shooting = 100;
            this.setTarget(this.level().getNearestPlayer(this, 40.0D));
            if (this.getTarget() != null && this.shooting > 0) {
                double tx = this.getTarget().getX() - this.getX();
                double ty = this.getTarget().getBoundingBox().minY - this.getY() - 2;
                double tz = this.getTarget().getZ() - this.getZ();
                double angle = Math.atan(-(tx) / (tz));
                EntityTwilightDemonShot e = EntityRegistry.TWILIGHT_DEMON_SHOT.get().create(level());
                e.setOwner(this);
                e.setPos(position());
                if(random.nextBoolean()) e.particle = ParticleRegistry.TWILIGHT_PORTAL::value;
                e.zo += Math.sin(angle);
                e.xo += Math.cos(angle);
                e.shoot(tx - Math.cos(angle), ty, tz - Math.sin(angle), 1.6f, 0);
                this.level().addFreshEntity(e);

                e = EntityRegistry.TWILIGHT_DEMON_SHOT.get().create(level());
                e.setOwner(this);
                e.setPos(position());
                if(random.nextBoolean()) e.particle = ParticleRegistry.TWILIGHT_PORTAL::value;
                e.zo -= Math.sin(angle);
                e.xo -= Math.cos(angle);
                e.shoot(tx + Math.cos(angle), ty, tz + Math.sin(angle), 1.6f, 0);
                this.level().addFreshEntity(e);
            }
            if (this.shooting > 0) {
                this.shooting--;
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT.get();
    }

}
