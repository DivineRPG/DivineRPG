package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.DivineRPG;
import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

public abstract class Gruzzorlug extends EntityIceikaNPC {
	public static final TagKey<Structure> RAID_TARGETS = TagKey.create(Registries.STRUCTURE, new ResourceLocation(DivineRPG.MODID, "gruzzorlug_raid_targets"));
	public Gruzzorlug(EntityType<? extends Gruzzorlug> type, Level worldIn) {super(type, worldIn);}
	@Override public Faction getFaction() {return Faction.GRUZZORLUG;}
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.03F;}
	@Override protected TagKey<Structure> getRaidTargets() {return RAID_TARGETS;}
	@Override protected MobEffect getTargetEffect() {return MobEffectRegistry.GRUZZORLUG_TARGET.get();}
	public class AggressiveRangedAttackGoal extends RangedAttackGoal {
		public AggressiveRangedAttackGoal(int attackInterval) {
			super((RangedAttackMob) Gruzzorlug.this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), attackInterval, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue());
		}
		@Override
		public void start() {
			super.start();
			setAggressive(true);
		}
		@Override
		public void stop() {
			super.stop();
			setAggressive(false);
		}
	}
}