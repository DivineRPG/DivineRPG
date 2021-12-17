package divinerpg.util.teleport;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.function.*;

public class SecondaryTeleporter extends Teleporter {
    BlockPos pos;
    public SecondaryTeleporter(ServerWorld world) {
        super(world);
    }

    public SecondaryTeleporter(ServerWorld world, BlockPos pos) {
        super(world);
        this.pos = pos;
    }

    public void placeInPortal(Entity entity, float rotationYaw) {
        if(entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            if (player.getRespawnPosition() != null) {
                BlockPos spawnPoint = player.getRespawnPosition();
                entity.teleportTo(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ());
            }
        }
    }
    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (entity instanceof ServerPlayerEntity) {
            this.placeInPortal(entity, yaw);
        }

        entity.setPortalCooldown();
        entity = repositionEntity.apply(false);
        if(pos == null) {
            ServerPlayerEntity spe = (ServerPlayerEntity) entity;
            entity.teleportTo(spe.getRespawnPosition().getX(), spe.getRespawnPosition().getY() + 1, spe.getRespawnPosition().getZ());
        }else
        {
            entity.teleportTo(pos.getX(), pos.getY() + 1, pos.getZ());
        }
        return entity;
    }
}
