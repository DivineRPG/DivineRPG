package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityGorgosion extends EntityDivineMonster {
	public EntityGorgosion(EntityType<? extends EntityGorgosion> type, Level worldIn) {super(type, worldIn);}
	@Override public void tick() {
		super.tick();
		Player closestPlayer = level().getNearestPlayer(this, 10);
		if(closestPlayer != null && !closestPlayer.isCreative() && random.nextInt(30) == 0)
			setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 1, getDeltaMovement().z);
	}

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		if(fallDistance > 2) {
			level().explode(this, getX(), getY(), getZ(), 3, false, Level.ExplosionInteraction.NONE);
			return false;
		} return super.causeFallDamage(fallDistance, damageModifier, damageSource);
    }
	@Override protected SoundEvent getAmbientSound() {return SoundRegistry.GORGOSION.get();}
	@Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GORGOSION_HURT.get();}
	@Override protected SoundEvent getDeathSound() {return SoundRegistry.GORGOSION_HURT.get();}
}