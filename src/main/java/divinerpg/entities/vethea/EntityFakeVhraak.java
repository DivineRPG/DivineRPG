package divinerpg.entities.vethea;


import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityFakeVhraak extends EntityDivineMonster {

    private int lifeTick = 20;

    public EntityFakeVhraak(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();

        this.lifeTick--;
        if(this.lifeTick <= 0) {
            this.kill();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VHRAAK.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VHRAAK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VHRAAK_HURT.get();
    }
}