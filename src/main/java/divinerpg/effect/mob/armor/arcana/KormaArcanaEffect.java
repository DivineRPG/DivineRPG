package divinerpg.effect.mob.armor.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

public class KormaArcanaEffect extends ArmorEffect {
	public KormaArcanaEffect() {super(10991286);}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity instanceof ServerPlayer player) player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            arcana.fill(player, 1);
        });
	}
}