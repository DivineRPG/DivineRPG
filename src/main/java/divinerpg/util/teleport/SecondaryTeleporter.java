package divinerpg.util.teleport;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.function.*;

public class SecondaryTeleporter extends Teleporter {
    private final ServerWorld worldServerInstance;

    private double x;
    private double y;
    private double z;

    public SecondaryTeleporter(ServerWorld world, double x, double y, double z) {
        super(world);
        this.worldServerInstance = world;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        this.worldServerInstance.getBlockState(entity.blockPosition());
        entity.moveTo(this.x, this.y, this.z);
        entity.setDeltaMovement(0, 0 ,0);
        return null;
    }
}
