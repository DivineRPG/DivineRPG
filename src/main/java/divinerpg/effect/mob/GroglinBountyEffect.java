package divinerpg.effect.mob;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.entities.iceika.groglin.Groglin;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.GameRules;

import static divinerpg.util.Utils.*;

public class GroglinBountyEffect extends MobEffect {
	public GroglinBountyEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
//	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.level() instanceof ServerLevel level && level.getGameTime() % 20 == 0 && level.getDifficulty() != Difficulty.PEACEFUL && !level.getGameRules().getBoolean(GameRules.RULE_DISABLE_RAIDS) && level.canSeeSky(entity.blockPosition()) && Faction.hasNearbyTarget(entity, entity.getBoundingBox().inflate(16D), Faction.GROGLIN)) {
			BlockPos structure = level.findNearestMapStructure(Groglin.RAID_TARGETS, entity.blockPosition(), 4, false);
			if(structure != null && entity.distanceToSqr(structure.getX(), entity.getBlockY(), structure.getZ()) < 128D) {
				BlockPos pos = getNearbySpawnPos(level, entity.getRandom(), entity.blockPosition());
				EntityRegistry.GROGLIN_SHARLATAN.get().spawn(level, null, null, pos, MobSpawnType.REINFORCEMENT, false, false).setUnimportant();
				EntityType<?> ent = EntityRegistry.GROGLIN_HUNTER.get();
				ent.spawn(level, adjustHeight(level, pos.offset(3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, 3).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, -3).mutable()), MobSpawnType.REINFORCEMENT);
				EntityRegistry.GROGLIN_CHIEFTAIN.get().spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT, false, false).setUnimportant();
				EntityRegistry.GROGLIN_WARRIOR.get().spawn(level, adjustHeight(level, pos.offset(-6, 0, 0).mutable()), MobSpawnType.REINFORCEMENT);
				ent = EntityRegistry.GROGLIN_RANGER.get();
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, 3).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, -3).mutable()), MobSpawnType.REINFORCEMENT);
				entity.removeEffect(Holder.direct(this));
			}
		} return false;
	}
}