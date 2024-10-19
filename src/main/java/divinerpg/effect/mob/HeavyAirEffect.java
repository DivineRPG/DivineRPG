package divinerpg.effect.mob;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.GameType;

public class HeavyAirEffect extends MobEffect {
	public HeavyAirEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
	@Override public void onEffectAdded(LivingEntity entity, int amplifier) {
		super.onEffectAdded(entity, amplifier);
		if(entity instanceof ServerPlayer && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.SURVIVAL) {
			((ServerPlayer) entity).setGameMode(GameType.ADVENTURE);
		}
	}
	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		super.onMobRemoved(entity, amplifier, reason);
		if(entity instanceof ServerPlayer && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.ADVENTURE) ((ServerPlayer) entity).setGameMode(GameType.SURVIVAL);
	}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {return false;}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
//	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}