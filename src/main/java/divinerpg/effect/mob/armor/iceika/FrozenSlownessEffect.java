package divinerpg.effect.mob.armor.iceika;

import java.util.List;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.AABB;

public class FrozenSlownessEffect extends ArmorEffect {
	public FrozenSlownessEffect() {super(10991286);}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		List<Mob> entities = entity.getCommandSenderWorld().getEntitiesOfClass(Mob.class, new AABB(entity.blockPosition().offset(-6, -6, -6), entity.blockPosition().offset(6, 6, 6)));
        for(Mob e : entities) e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, true, true, false));
	}
}