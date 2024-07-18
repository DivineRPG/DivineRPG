package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class AngelicFlightEffect extends ArmorEffect implements UpdatableArmorEffect {
	public AngelicFlightEffect() {super(10991286);}
	@SuppressWarnings("deprecation")
	@Override public void addAttributeModifiers(AttributeMap map, int i) {
		super.addAttributeModifiers(map, i);
		if(entity instanceof ServerPlayer player && !player.isCreative()) {
			player.getAbilities().mayfly = true;
			player.onUpdateAbilities();
		}
	}
	@SuppressWarnings("deprecation")
	@Override public void removeAttributeModifiers(AttributeMap map) {
		super.removeAttributeModifiers(map);
		if(entity instanceof ServerPlayer player && !player.isCreative()) {
			player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
		}
	}
//	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
	@SuppressWarnings("deprecation")
	@Override public void update(LivingEntity entity) {
		if(entity instanceof ServerPlayer player && !player.isCreative() && !player.getAbilities().mayfly) {
			player.getAbilities().mayfly = true;
			player.onUpdateAbilities();
		}
	}
}