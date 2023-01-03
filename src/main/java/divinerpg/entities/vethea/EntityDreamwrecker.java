package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.player.Player;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityDreamwrecker extends EntityDivineMonster {

    public EntityDreamwrecker(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 4.0F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();
        Player player = this.level.getNearestPlayer(this, 64.0D);

        if(player != null && !player.isCreative() && player.distanceTo(this) < 20) {
            this.setTarget(player);
        }

        Entity attackTarget = this.getTarget();
        if(attackTarget != null && attackTarget instanceof Player && !((Player)attackTarget).isCreative() && attackTarget.isAlive() && this.hasLineOfSight(attackTarget)) {
            attackTarget.setDeltaMovement(Math.signum(this.xo - attackTarget.xo) * 0.029, attackTarget.getDeltaMovement().y, Math.signum(this.zo - attackTarget.zo) * 0.029);
        }
        else {
            this.setTarget(null);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DREAMWRECKER.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DREAMWRECKER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DREAMWRECKER_HURT.get();
    }
}