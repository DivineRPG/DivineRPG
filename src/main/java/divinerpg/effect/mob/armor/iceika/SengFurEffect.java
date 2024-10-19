package divinerpg.effect.mob.armor.iceika;

import divinerpg.effect.mob.armor.*;
import divinerpg.registries.LevelRegistry;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SengFurEffect extends ArmorEffect implements UpdatableArmorEffect {
	public SengFurEffect() {super(10991286);}

	@Override public void onEffectAdded(LivingEntity entity, int amplifier) {
		super.onEffectAdded(entity, amplifier);
		update(entity);
	}

	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		super.onMobRemoved(entity, amplifier, reason);
		if(entity.hasEffect(MobEffects.MOVEMENT_SPEED) && entity.getEffect(MobEffects.MOVEMENT_SPEED).isInfiniteDuration()) entity.removeEffect(MobEffects.MOVEMENT_SPEED);
	}

	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.level().dimension() == LevelRegistry.ICEIKA && entity instanceof ServerPlayer player && player.getFoodData().needsFood()) player.getFoodData().eat(1, 0);
		return false;
	}
	@Override
	public void update(LivingEntity entity) {
		if(entity.level().dimension() == LevelRegistry.ICEIKA) {
			if(!entity.hasEffect(MobEffects.MOVEMENT_SPEED)) entity.addEffect(new ArmorEffectInstance(Holder.direct(MobEffects.MOVEMENT_SPEED.value()), 1, true, false));
		} else entity.removeEffect(Holder.direct(this));
	}
}