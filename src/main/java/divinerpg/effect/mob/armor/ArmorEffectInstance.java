package divinerpg.effect.mob.armor;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.*;
import net.neoforged.neoforge.common.EffectCure;

public class ArmorEffectInstance extends MobEffectInstance {
	public ArmorEffectInstance(Holder<MobEffect> effect, int amplifier) {
		super(effect, -1, amplifier, false, false);
	}
	public ArmorEffectInstance(Holder<MobEffect>  effect, int amplifier, boolean ambient, boolean visible) {
		super(effect, -1, amplifier, ambient, visible);
	}
	public ArmorEffectInstance(Holder<MobEffect>  effect, int amplifier, boolean ambient, boolean visible, boolean showIcon) {
		super(effect, -1, amplifier, ambient, visible, showIcon);
	}
	private static final Set<EffectCure> nocures = Sets.newIdentityHashSet();
	@Override
	public Set<EffectCure> getCures() {
		return nocures;
	}
	@Override public boolean isVisible() {return false;}
	@Override public boolean showIcon() {return false;}
}