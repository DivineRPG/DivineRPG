package divinerpg.effect.mob;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.entities.iceika.groglin.Groglin;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.GameRules;

import static divinerpg.util.Utils.*;

public class GroglinBountyEffect extends MobEffect {
	public GroglinBountyEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.level() instanceof ServerLevel level && level.getGameTime() % 20 == 0 && level.getDifficulty() != Difficulty.PEACEFUL && !level.getGameRules().getBoolean(GameRules.RULE_DISABLE_RAIDS) && level.canSeeSky(entity.blockPosition()) && level.findNearestMapStructure(Groglin.RAID_TARGETS, entity.blockPosition(), 32, false) != null && Faction.hasNearbyTarget(entity, entity.getBoundingBox().inflate(16D), Faction.GROGLIN)) {
			BlockPos pos = getNearbySpawnPos(level, entity.random, entity.blockPosition());
			EntityRegistry.GROGLIN_SHARLATAN.get().create(level, null, null, pos, MobSpawnType.REINFORCEMENT, false, false);
			EntityType<?> ent = EntityRegistry.GROGLIN_HUNTER.get();
			ent.create(level, null, null, adjustHeight(level, pos.offset(3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			ent.create(level, null, null, adjustHeight(level, pos.offset(0, 0, 3).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			ent.create(level, null, null, adjustHeight(level, pos.offset(0, 0, -3).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			EntityRegistry.GROGLIN_CHIEFTAIN.get().create(level, null, null, adjustHeight(level, pos.offset(-3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			EntityRegistry.GROGLIN_WARRIOR.get().create(level, null, null, adjustHeight(level, pos.offset(-6, 0, 0).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			ent = EntityRegistry.GROGLIN_RANGER.get();
			ent.create(level, null, null, adjustHeight(level, pos.offset(-3, 0, 3).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			ent.create(level, null, null, adjustHeight(level, pos.offset(-3, 0, -3).mutable()), MobSpawnType.REINFORCEMENT, false, false);
			entity.removeEffect(this);
		}
	}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
}