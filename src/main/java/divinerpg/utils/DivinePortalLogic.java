package divinerpg.utils;

import divinerpg.world.placement.Surface;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

import static divinerpg.registries.LevelRegistry.*;
import static divinerpg.registries.LevelRegistry.MORTUM;
import static divinerpg.registries.LevelRegistry.VETHEA;

public interface DivinePortalLogic extends Portal {
    default void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity.canUsePortal(true)) entity.setAsInsidePortal(this, pos);
    }
    @Override @Nullable
    default TeleportTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        TeleportTransition d = getSimpleConnection(level, entity, pos);
        if(d != null) return d;
        UniversalPosition target = getTargetLocation(level, entity, pos);
        if(target == null) return null;
        MinecraftServer server = level.getServer();
        ServerLevel targetLevel = target.level(server);
        BlockPos center = findSuitableLocation(targetLevel, entity, target.blockPos(), 0), targetPos = lookForNearbyPortal(targetLevel, entity, center);
        if(targetPos != null) {
            link(level, pos, targetLevel, targetPos);
            return transitionTo(targetLevel, entity, targetPos);
        } for(int tries = 1; tries < 10; tries++) {
            if(hasSpace(targetLevel, targetPos = findSuitableLocation(targetLevel, entity, center, tries))) break;
            if(tries == 9) targetPos = center;
        } return transitionTo(targetLevel, entity, placeAndLink(level, pos, targetLevel, targetPos, entity));
    }
    ResourceKey<Level> rootDimension();
    boolean hasSpace(ServerLevel level, BlockPos pos);
    /**
     * If the destination is known and does not need to be searched for, then it is provided by this method.
     * @param level origin
     * @param entity that is traveling
     * @param pos of origin
     * @return known portal destination. {@code null}, if a search procedure is needed.
     */
    @Nullable default TeleportTransition getSimpleConnection(ServerLevel level, Entity entity, BlockPos pos) {return null;}
    @Nullable default UniversalPosition getTargetLocation(ServerLevel source, Entity entity, BlockPos origin) {
        return new UniversalPosition(rootDimension(), scalePosition(origin, source.dimensionType(), source.getServer().getLevel(rootDimension()).dimensionType()));
    }
    @Nullable default BlockPos lookForNearbyPortal(ServerLevel level, Entity entity, BlockPos center) {return null;}
    default BlockPos findSuitableLocation(ServerLevel level, Entity entity, BlockPos center, int attempt) {
        ResourceKey<Level> d = level.dimension();
        RandomSource random = level.getRandom();
        BlockPos pos = center.offset(random.nextInt(1 + (attempt << 1)) - attempt, 0, random.nextInt(1 + (attempt << 1)) - attempt);
        BlockPos.MutableBlockPos m;
        if(d == EDEN || d == WILDWOOD || d == APALACHIA) m = Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 127, 250, 0, level, random, pos).mutable();
        else if(d == MORTUM) m = Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 20, 125, 0, level, random, pos).mutable();
        else if(d == VETHEA) m = Surface.getSurface(Surface.Surface_Type.LOWEST_GROUND, Surface.Mode.FULL, -55, 32, 0, level, random, pos).mutable();
        else m = Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, level.getMinY() + 5, level.dimensionType().logicalHeight(), 0, level, random, pos).mutable();
        while(level.getBlockState(m).is(Blocks.WATER)) m.move(0, 1, 0);
        return m;
    }
    default void link(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos) {}
    default BlockPos placeAndLink(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos, Entity entity) {return targetPos;}

    static TeleportTransition transitionTo(ServerLevel level, Entity entity, BlockPos pos) {
        return transitionTo(level, entity, Vec3.atBottomCenterOf(pos));
    }
    static TeleportTransition transitionTo(ServerLevel level, Entity entity, Vec3 pos) {
        return new TeleportTransition(level, pos, entity.getKnownMovement(), entity.getYRot(), entity.getXRot(), Set.of(), TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
    }
    static BlockPos scalePosition(BlockPos pos, DimensionType originDimension, DimensionType targetDimension) {
        double scale = DimensionType.getTeleportationScale(originDimension, targetDimension);
        return new BlockPos((int) (pos.getX() * scale), pos.getZ(), (int) (pos.getZ() * scale));
    }
    @Override
    default int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return entity instanceof Player player ? (level.getGameRules().get(player.getAbilities().invulnerable ? GameRules.PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.PLAYERS_NETHER_PORTAL_DEFAULT_DELAY)) : 0;
    }
}