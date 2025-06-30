package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.snowflake_shuriken;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN;

public class SnowFlakeShuriken extends DivineThrownItem {
    public SnowFlakeShuriken(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {super(entityType, level);}
    @Override protected void doPostHurtEffects(LivingEntity living) {
        //Slowness IV for 2 seconds
        living.addEffect(new MobEffectInstance(MOVEMENT_SLOWDOWN, 2 * 20, 3), getOwner());
    }
    @Override protected Item getDefaultItem() {return snowflake_shuriken.get();}
}