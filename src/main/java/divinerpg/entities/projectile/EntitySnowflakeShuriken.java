package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
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
    protected void onHitEntity(EntityRayTraceResult result) {
        result.getEntity().hurt(DamageSource.thrown(this, getOwner()), 7.0F);
        if(result.getEntity() instanceof LivingEntity)
        ((LivingEntity)result.getEntity()).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 45, 3));
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult p_230299_1_) {
        if (!this.level.isClientSide) {
            ItemEntity item = new ItemEntity(level, xo, yo, zo);
            item.setItem(new ItemStack(ItemRegistry.snowflakeShuriken));
            level.addFreshEntity(item);
            this.kill();
        }
    }
}