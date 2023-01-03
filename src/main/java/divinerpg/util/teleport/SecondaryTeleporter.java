package divinerpg.util.teleport;

import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.portal.*;

import java.util.function.*;

public class SecondaryTeleporter extends PortalForcer {
    BlockPos pos;

    public SecondaryTeleporter(ServerLevel world) {
        super(world);
    }

    public SecondaryTeleporter(ServerLevel world, BlockPos pos) {
        super(world);
        this.pos = pos;
    }

    public void placeInPortal(Entity entity, float rotationYaw) {
        if (entity instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) entity;
            if (player.getRespawnPosition() != null) {
                BlockPos spawnPoint = player.getRespawnPosition();
                entity.teleportTo(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ());
            }
        }
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (entity instanceof ServerPlayer) {
            this.placeInPortal(entity, yaw);
        }

        entity.setPortalCooldown();
        entity = repositionEntity.apply(false);
        if (pos == null) {
            ServerPlayer spe = (ServerPlayer) entity;
            entity.teleportTo(spe.getRespawnPosition().getX(), spe.getRespawnPosition().getY() + 1, spe.getRespawnPosition().getZ());
        } else {
            entity.teleportTo(pos.getX(), pos.getY() + 1, pos.getZ());
        }
        return entity;
    }
}
