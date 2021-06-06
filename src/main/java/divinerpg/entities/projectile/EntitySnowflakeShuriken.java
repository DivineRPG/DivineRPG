package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntitySnowflakeShuriken extends DivineThrowable {


    public EntitySnowflakeShuriken(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySnowflakeShuriken(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntitySnowflakeShuriken(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (result.hitInfo != null) {
            ((Entity)result.hitInfo).hurt(DamageSource.thrown(this, this.getOwner()), 7.0F);
        }
        if (!this.level.isClientSide) {
            ItemEntity item = new ItemEntity(level, xo, yo, zo);
            item.setItem(new ItemStack(ItemRegistry.snowflakeShuriken));
            level.addFreshEntity(item);
            this.kill();
        }
    }
}