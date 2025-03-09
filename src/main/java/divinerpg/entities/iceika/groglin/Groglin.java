package divinerpg.entities.iceika.groglin;

import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public abstract class Groglin extends EntityIceikaNPC {
	public Groglin(EntityType<? extends Groglin> type, Level worldIn) {super(type, worldIn, "groglin");}
	@Override public Faction getFaction() {return Faction.GROGLIN;}
	@Override protected Holder<MobEffect> getTargetEffect() {return MobEffectRegistry.GROGLIN_BOUNTY;}
}