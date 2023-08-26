package divinerpg.entities.projectile;

import divinerpg.registries.EntityRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityFyracryxFireball extends DivineFireball {
    public EntityFyracryxFireball(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
    }
    public EntityFyracryxFireball(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityRegistry.FYRACRYX_FIREBALL.get(), world, shooter, accelX, accelY, accelZ, (byte)1);
    }
    @Override
    public void tick() {
        super.tick();
        if(tickCount > 50) kill();
    }
}