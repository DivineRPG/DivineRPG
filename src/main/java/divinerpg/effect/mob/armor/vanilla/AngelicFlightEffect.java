package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

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
	@SuppressWarnings("deprecation")
	@Override public void update(ResourceKey<Level> level, LivingEntity entity) {
		if(entity instanceof ServerPlayer player && !player.isCreative() && !player.getAbilities().mayfly) {
			player.getAbilities().mayfly = true;
			player.onUpdateAbilities();
		}
	}
}