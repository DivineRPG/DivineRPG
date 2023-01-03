package divinerpg.effect.mob;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.GameType;

public class HeavyAirEffect extends MobEffect {
	public HeavyAirEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		if(entity instanceof ServerPlayer && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.ADVENTURE) ((ServerPlayer) entity).setGameMode(GameType.SURVIVAL);
	}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		if(entity instanceof ServerPlayer && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.SURVIVAL) {
			super.addAttributeModifiers(entity, map, i);
			((ServerPlayer) entity).setGameMode(GameType.ADVENTURE);
		}
	}
	@Override public void applyEffectTick(LivingEntity entity, int i) {}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
}