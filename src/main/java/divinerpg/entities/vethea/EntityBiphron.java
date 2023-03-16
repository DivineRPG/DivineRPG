package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityBiphron extends EntityDivineMonster {

    private boolean gravity;

    public EntityBiphron(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();
        if (this.random.nextInt(50) == 0) {
            this.gravity = !this.gravity;
        }

        if (this.gravity) {
        	this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.4, getDeltaMovement().z);
        }
    }
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
    	return false;
    }

    @Override
    public void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    	//previously called fall(...)
    }
    
    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
    	return 0;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(source == damageSources().fall()) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BIPHRON.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BIPHRON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BIPHRON_HURT.get();
    }
}