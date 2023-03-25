package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class AngelicFlightEffect extends ArmorEffect {
	public AngelicFlightEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		if(entity instanceof ServerPlayer player) {
			player.abilities.mayfly = true;
			player.getPersistentData().putBoolean("flight_abilities", true);
			player.abilities.flying = true;
		}
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		if(entity instanceof ServerPlayer player) {
			player.abilities.mayfly = false;
            player.getPersistentData().putBoolean("flight_abilities", false);
            player.abilities.flying = false;
		}
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}