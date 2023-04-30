package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityZone extends EntityDivineMonster {

    public EntityZone(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		this.setHealth(this.getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.1875F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();

        Player player = level.getNearestPlayer(this, 32);
        if(player != null && !player.isCreative()) {
            this.setTarget(player);

            LivingEntity target = this.getTarget();
            if(!this.level.isClientSide && target != null && this.tickCount % 40 == 0) {
                this.shootEntity(target);
            }
        }
    }

    private void shootEntity(LivingEntity target) {if (isAlive() && getTarget() != null && !level.isClientSide) {
        EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), this.level, ArrowType.KAROS_ARROW, this, target, 1.6f, 1.2F);
        double d0 = getTarget().getX() - this.getX();
        double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
        double d2 = getTarget().getZ() - this.getZ();
        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
        projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
        this.level.addFreshEntity(projectile);
    }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ZONE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ZONE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ZONE_HURT.get();
    }
}