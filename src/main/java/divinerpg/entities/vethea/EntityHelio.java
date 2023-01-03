package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.util.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityHelio extends EntityDivineMonster {

    public EntityHelio(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public boolean canAttack(LivingEntity target) {
        if(super.canAttack(target)) {
            target.setDeltaMovement(getDeltaMovement().x + Mth.sin(this.xRot * (float)Math.PI / 180.0F) * 7.0F * 0.5F, getDeltaMovement().y + 0.4D, getDeltaMovement().z + Mth.cos(this.xRot * (float)Math.PI / 180.0F) * 7.0F * 0.5F);
            //this.motionX *= 0.6D;
            //this.motionZ *= 0.6D;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELIO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HELIO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HELIO_HURT.get();
    }
}