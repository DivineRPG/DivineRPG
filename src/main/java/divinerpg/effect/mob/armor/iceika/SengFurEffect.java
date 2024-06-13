package divinerpg.effect.mob.armor.iceika;

import divinerpg.effect.mob.armor.*;
import divinerpg.registries.LevelRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class SengFurEffect extends ArmorEffect implements UpdatableArmorEffect {
	public SengFurEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		update(entity);
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		if(entity.hasEffect(MobEffects.MOVEMENT_SPEED) && entity.getEffect(MobEffects.MOVEMENT_SPEED).isInfiniteDuration()) entity.removeEffect(MobEffects.MOVEMENT_SPEED);
	}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.level().dimension() == LevelRegistry.ICEIKA && entity instanceof ServerPlayer player && player.getFoodData().needsFood()) player.getFoodData().eat(1, 0);
	}
	@Override
	public void update(LivingEntity entity) {
		if(entity.level().dimension() == LevelRegistry.ICEIKA) {
			if(!entity.hasEffect(MobEffects.MOVEMENT_SPEED)) entity.addEffect(new ArmorEffectInstance(MobEffects.MOVEMENT_SPEED, 1, true, false));
		} else entity.removeEffect(this);
	}
}