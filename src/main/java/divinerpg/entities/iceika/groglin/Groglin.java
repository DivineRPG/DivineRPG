package divinerpg.entities.iceika.groglin;

import divinerpg.entities.iceika.EntityIceikaNPC;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.entities.base.FactionEntity.Faction.GROGLIN;
import static divinerpg.registries.MobEffectRegistry.GROGLIN_BOUNTY;

public abstract class Groglin extends EntityIceikaNPC {
	public Groglin(EntityType<? extends Groglin> type, Level worldIn) {super(type, worldIn, "groglin");}
	@Override public Faction getFaction() {return GROGLIN;}
	@Override protected Holder<MobEffect> getTargetEffect() {return GROGLIN_BOUNTY;}
}