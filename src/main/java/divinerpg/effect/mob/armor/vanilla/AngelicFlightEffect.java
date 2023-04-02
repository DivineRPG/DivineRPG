package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.ArmorEffect;
import divinerpg.effect.mob.armor.UpdatableArmorEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class AngelicFlightEffect extends ArmorEffect implements UpdatableArmorEffect {
	public AngelicFlightEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		if(entity instanceof ServerPlayer player && !player.isCreative()) {
			player.abilities.mayfly = true;
			player.onUpdateAbilities();
		}
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		if(entity instanceof ServerPlayer player && !player.isCreative()) {
			player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.onUpdateAbilities();
		}
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
	@Override public void update(LivingEntity entity) {
		if(entity instanceof ServerPlayer player && !player.isCreative() && !player.abilities.mayfly) {
			player.abilities.mayfly = true;
			player.onUpdateAbilities();
		}
	}
}