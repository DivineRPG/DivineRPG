package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.ItemRegistry.grenade;
import static net.minecraft.world.level.Level.ExplosionInteraction.TNT;

public class Grenade extends DivineThrownItem {
    public Grenade(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
        canPickup = false;
    }
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        if(!level().isClientSide()) level().explode(this, getX(), getY(), getZ(), 3, false, TNT);
    }
    @Override protected Item getDefaultItem() {return grenade.get();}
}