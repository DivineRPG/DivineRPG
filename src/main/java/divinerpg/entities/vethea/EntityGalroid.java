package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityGalroid extends EntityDivineMonster {

    private int protectionTimer;

    public EntityGalroid(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		this.protectionTimer = 200;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.5F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();

        if (this.getProtectionTimer() <= 0 && !this.isInvulnerable()) {
            this.setProtectionTimer(200);
            this.setInvulnerable(true);
        }
        else if (this.isInvulnerable() && this.getProtectionTimer() <= 0) {
            this.setProtectionTimer(200);
            this.setInvulnerable(false);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }

    private int getProtectionTimer() {
        return this.protectionTimer;
    }

    private void setProtectionTimer(int value) {
        this.protectionTimer = value;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GALROID.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GALROID_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GALROID_HURT.get();
    }
}