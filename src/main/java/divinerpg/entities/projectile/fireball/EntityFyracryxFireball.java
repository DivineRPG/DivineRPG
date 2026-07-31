package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.FYRACRYX_FIREBALL;

public class EntityFyracryxFireball extends DivineFireball {
    public EntityFyracryxFireball(EntityType<? extends DivineFireball> type, Level world) {super(type, world);}
    public EntityFyracryxFireball(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(FYRACRYX_FIREBALL.get(), world, shooter, accelX, accelY, accelZ, (byte)1);
    }
    @Override public void tick() {
        super.tick();
        if(tickCount > 50) discard();
    }
}