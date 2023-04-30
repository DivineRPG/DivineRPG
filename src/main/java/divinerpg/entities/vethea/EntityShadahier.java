package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityShadahier extends EntityDivineMonster {

    public EntityShadahier(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.25F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public boolean doHurtTarget(Entity target) {
        if(super.doHurtTarget(target)) {
            if(!this.level.isClientSide && target instanceof LivingEntity) {
                ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1, 1));
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHADAHIER.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHADAHIER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHADAHIER_HURT.get();
    }
}