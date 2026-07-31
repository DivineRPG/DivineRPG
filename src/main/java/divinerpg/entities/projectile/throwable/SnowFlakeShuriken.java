package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.snowflake_shuriken;

public class SnowFlakeShuriken extends DivineThrownItem {
    public SnowFlakeShuriken(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {super(entityType, level);}
    @Override protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 2 * 20, 3), getOwner());
    }
    @Override protected Item getDefaultItem() {return snowflake_shuriken.get();}
}