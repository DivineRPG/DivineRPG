package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion.BlockInteraction;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityGorgosion extends EntityDivineMonster {

	public EntityGorgosion(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.2F;
    }
    @Override public boolean isAggressive() {return true;}
	@Override
	public void tick() {
		super.tick();
		Player closestPlayer = this.level.getNearestPlayer(this, 10);
		if(closestPlayer != null && !closestPlayer.isCreative() && this.random.nextInt(30) == 0) {
			this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 1, getDeltaMovement().z);
		}
	}
	
	@Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource damagesource) {
		if(distance > 2) {
			this.level.explode(this, this.getX(), this.getY(), this.getZ(), 3, false, BlockInteraction.NONE);
			return false;
		}
		return super.causeFallDamage(distance, damageMultiplier, damagesource);
    }

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundRegistry.GORGOSION.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundRegistry.GORGOSION_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundRegistry.GORGOSION_HURT.get();
	}
}