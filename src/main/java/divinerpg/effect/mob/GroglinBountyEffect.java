package divinerpg.effect.mob;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;

import static divinerpg.entities.base.FactionEntity.Faction.GROGLIN;
import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static divinerpg.registries.TagRegistry.RAID_TARGETS;
import static divinerpg.util.Utils.*;
import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.effect.MobEffectCategory.HARMFUL;
import static net.minecraft.world.entity.MobSpawnType.REINFORCEMENT;
import static net.minecraft.world.level.GameRules.RULE_DISABLE_RAIDS;

public class GroglinBountyEffect extends MobEffect {
	public GroglinBountyEffect() {super(HARMFUL, 5606008);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.level() instanceof ServerLevel level && level.getGameTime() % 80 == 0 && level.getDifficulty() != PEACEFUL && !level.getGameRules().getBoolean(RULE_DISABLE_RAIDS) && level.canSeeSky(entity.blockPosition()) && Faction.hasNearbyTarget(entity, entity.getBoundingBox().inflate(16), GROGLIN)) {
			BlockPos structure = level.findNearestMapStructure(RAID_TARGETS, entity.blockPosition(), 4, false);
			if(structure != null && entity.distanceToSqr(structure.getX(), entity.getBlockY(), structure.getZ()) < 128) {
				BlockPos pos = getNearbySpawnPos(level, entity.getRandom(), entity.blockPosition());
				IMPORTANT.set(EntityRegistry.GROGLIN_SHARLATAN.get().spawn(level, null, null, pos, REINFORCEMENT, false, false), false);
				EntityType<?> ent = EntityRegistry.GROGLIN_HUNTER.get();
				ent.spawn(level, adjustHeight(level, pos.offset(3, 0, 0).mutable()), REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, 3).mutable()), REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, -3).mutable()), REINFORCEMENT);
				IMPORTANT.set(EntityRegistry.GROGLIN_CHIEFTAIN.get().spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, 0).mutable()), REINFORCEMENT, false, false), false);
				EntityRegistry.GROGLIN_WARRIOR.get().spawn(level, adjustHeight(level, pos.offset(-6, 0, 0).mutable()), REINFORCEMENT);
				ent = EntityRegistry.GROGLIN_RANGER.get();
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, 3).mutable()), REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, -3).mutable()), REINFORCEMENT);
				return false;
			}
		} return true;
	}
}