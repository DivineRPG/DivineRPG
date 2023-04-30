package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntitySeng extends EntityDivineMonster {

    public EntitySeng(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.59375F;
    }

    @Override public boolean isAggressive() {return true;}


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SENG_AMBIENT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SENG_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SENG_GROWL.get();
    }
}
