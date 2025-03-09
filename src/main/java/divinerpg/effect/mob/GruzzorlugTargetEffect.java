package divinerpg.effect.mob;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.GameRules;

import static divinerpg.util.Utils.*;

public class GruzzorlugTargetEffect extends MobEffect {
	public GruzzorlugTargetEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.level() instanceof ServerLevel level && level.getGameTime() % 80 == 0 && level.getDifficulty() != Difficulty.PEACEFUL && !level.getGameRules().getBoolean(GameRules.RULE_DISABLE_RAIDS) && level.canSeeSky(entity.blockPosition()) && Faction.hasNearbyTarget(entity, entity.getBoundingBox().inflate(16D), Faction.GRUZZORLUG)) {
			BlockPos structure = level.findNearestMapStructure(TagRegistry.GRUZZORLUG_RAID_TARGETS, entity.blockPosition(), 4, false);
			if(structure != null && entity.distanceToSqr(structure.getX(), entity.getBlockY(), structure.getZ()) < 128D) {
				BlockPos pos = getNearbySpawnPos(level, entity.getRandom(), entity.blockPosition());
				AttachmentRegistry.IMPORTANT.set(EntityRegistry.GRUZZORLUG_COMMANDER.get().spawn(level, null, null, pos, MobSpawnType.REINFORCEMENT, false, false), false);
				EntityType<?> ent = EntityRegistry.GRUZZORLUG_CANNONEER.get();
				ent.spawn(level, adjustHeight(level, pos.offset(3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, 3).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(0, 0, -3).mutable()), MobSpawnType.REINFORCEMENT);
				AttachmentRegistry.IMPORTANT.set(EntityRegistry.GRUZZORLUG_GENERAL.get().spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, 0).mutable()), MobSpawnType.REINFORCEMENT, false, false), false);
				EntityRegistry.GRUZZORLUG_KNIGHT.get().spawn(level, adjustHeight(level, pos.offset(-6, 0, 0).mutable()), MobSpawnType.REINFORCEMENT);
				ent = EntityRegistry.GRUZZORLUG_SWORDSMAN.get();
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, 3).mutable()), MobSpawnType.REINFORCEMENT);
				ent.spawn(level, adjustHeight(level, pos.offset(-3, 0, -3).mutable()), MobSpawnType.REINFORCEMENT);
				return false;
			}
		} return true;
	}
}