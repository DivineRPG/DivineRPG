package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.iceika.EntityIceikaNPC;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

import static divinerpg.entities.base.FactionEntity.Faction.GRUZZORLUG;
import static divinerpg.registries.MobEffectRegistry.GRUZZORLUG_TARGET;

public abstract class Gruzzorlug extends EntityIceikaNPC {
	public Gruzzorlug(EntityType<? extends Gruzzorlug> type, Level worldIn) {super(type, worldIn, "gruzzorlug");}
	@Override public Faction getFaction() {return GRUZZORLUG;}
	@Override protected Holder<MobEffect> getTargetEffect() {return GRUZZORLUG_TARGET;}
	public class AggressiveRangedAttackGoal extends RangedAttackGoal {
		public AggressiveRangedAttackGoal(int attackInterval) {
			super((RangedAttackMob) Gruzzorlug.this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), attackInterval, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue());
		}
		@Override public void start() {
			super.start();
			setAggressive(true);
		}
		@Override public void stop() {
			super.stop();
			setAggressive(false);
		}
	}
}