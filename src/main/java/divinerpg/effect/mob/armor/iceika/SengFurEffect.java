package divinerpg.effect.mob.armor.iceika;

import divinerpg.effect.mob.armor.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import static divinerpg.registries.LevelRegistry.ICEIKA;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED;

public class SengFurEffect extends ArmorEffect implements UpdatableArmorEffect {
	public SengFurEffect() {super(3623051);}

	@Override public void onEffectAdded(LivingEntity entity, int amplifier) {
		super.onEffectAdded(entity, amplifier);
		update(entity.level().dimension(), entity);
	}
	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		if(entity.hasEffect(MOVEMENT_SPEED) && entity.getEffect(MOVEMENT_SPEED).isInfiniteDuration()) entity.removeEffect(MOVEMENT_SPEED);
	}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.level().dimension() == ICEIKA && entity instanceof ServerPlayer player && player.getFoodData().needsFood()) player.getFoodData().eat(1, 0);
		return true;
	}
	@Override public void update(ResourceKey<Level> level, LivingEntity entity) {
		if(level == ICEIKA) {
			if(!entity.hasEffect(MOVEMENT_SPEED)) entity.addEffect(new ArmorEffectInstance(MOVEMENT_SPEED, 1, true, false));
		} else if(entity.hasEffect(MOVEMENT_SPEED) && entity.getEffect(MOVEMENT_SPEED).isInfiniteDuration()) entity.removeEffect(MOVEMENT_SPEED);
	}
}