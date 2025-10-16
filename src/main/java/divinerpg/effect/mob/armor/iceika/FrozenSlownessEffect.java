package divinerpg.effect.mob.armor.iceika;

import java.util.List;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.phys.AABB;

import static net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN;

public class FrozenSlownessEffect extends ArmorEffect {
	public FrozenSlownessEffect() {super(10414049);}
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
        if(entity.level() instanceof ServerLevel s) {
            List<Mob> entities = s.getEntitiesOfClass(Mob.class, new AABB(entity.position().add(-6, -6, -6), entity.position().add(6, 6, 6)));
            for(Mob e : entities) e.addEffect(new MobEffectInstance(MOVEMENT_SLOWDOWN, 2 * 20, 1, true, true, false));
        } return true;
    }
}