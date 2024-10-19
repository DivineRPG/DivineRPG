package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;

public class AngelicFlightEffect extends ArmorEffect implements UpdatableArmorEffect {
	public AngelicFlightEffect() {super(10991286);}
	@SuppressWarnings("deprecation")
	@Override public void onEffectAdded(LivingEntity entity, int amplifier) {
		super.onEffectAdded(entity, amplifier);
		if(entity instanceof ServerPlayer player && !player.isCreative()) {
			player.getAbilities().mayfly = true;
			player.onUpdateAbilities();
		}
	}

	@SuppressWarnings("deprecation")
	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		super.onMobRemoved(entity, amplifier, reason);
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