package divinerpg.effect.mob;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jspecify.annotations.Nullable;

import static divinerpg.entities.base.FactionEntity.Faction.GROGLIN;
import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.effect.MobEffectCategory.NEUTRAL;
import static net.minecraft.world.entity.EntitySpawnReason.REINFORCEMENT;

public class GroglinBountyEffect extends MobEffect {

    public GroglinBountyEffect() {
        super(NEUTRAL, 5606008);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyInstantaneousEffect(ServerLevel level, @Nullable Entity source, @Nullable Entity owner, LivingEntity mob, int amplification, double scale) {}

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        if (level.getGameTime() % 80 == 0 && level.getDifficulty() != PEACEFUL && !level.getGameRules().get(GameRules.RAIDS) && level.canSeeSky(mob.blockPosition()) && Faction.hasNearbyTarget(mob, mob.getBoundingBox().inflate(16), GROGLIN)) {
            BlockPos structure = level.findNearestMapStructure(TagRegistry.RAID_TARGETS, mob.blockPosition(), 4, false);
            if (structure != null && mob.distanceToSqr(structure.getX(), mob.getBlockY(), structure.getZ()) < 128) {
                BlockPos pos = getNearbySpawnPos(level, mob.getRandom(), mob.blockPosition());

                IMPORTANT.set(EntityRegistry.GROGLIN_SHARLATAN.get().spawn(level, null, null, pos, REINFORCEMENT, false, false), false);

                EntityType<?> hunter = EntityRegistry.GROGLIN_HUNTER.get();
                hunter.spawn(level, null, null, adjustHeight(level, pos.offset(3, 0, 0)), REINFORCEMENT, false, false);
                hunter.spawn(level, null, null, adjustHeight(level, pos.offset(0, 0, 3)), REINFORCEMENT, false, false);
                hunter.spawn(level, null, null, adjustHeight(level, pos.offset(0, 0, -3)), REINFORCEMENT, false, false);

                IMPORTANT.set(EntityRegistry.GROGLIN_CHIEFTAIN.get().spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, 0)), REINFORCEMENT, false, false), false);
                EntityRegistry.GROGLIN_WARRIOR.get().spawn(level, null, null, adjustHeight(level, pos.offset(-6, 0, 0)), REINFORCEMENT, false, false);

                EntityType<?> ranger = EntityRegistry.GROGLIN_RANGER.get();
                ranger.spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, 3)), REINFORCEMENT, false, false);
                ranger.spawn(level, null, null, adjustHeight(level, pos.offset(-3, 0, -3)), REINFORCEMENT, false, false);
                return false;
            }
        }
        return true;
    }

    private static BlockPos adjustHeight(ServerLevel level, BlockPos pos) {
        return level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos);
    }

    private static BlockPos getNearbySpawnPos(ServerLevel level, RandomSource random, BlockPos origin) {
        int x = origin.getX() + random.nextInt(16) - 8;
        int z = origin.getZ() + random.nextInt(16) - 8;
        return level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos(x, origin.getY(), z));
    }
}