package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

public class EntityWatcherShot extends ThrowableEntity {
    private static final DataParameter<ItemStack> STACK = EntityDataManager.defineId(EntityWatcherShot.class, DataSerializers.ITEM_STACK);
    public EntityWatcherShot(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(STACK, ItemStack.EMPTY);
    }


    @Override
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this);
            this.level.explode(null, getX(), getY(), getZ(), 5.0F, Explosion.Mode.DESTROY);
        }

        if (result.hitInfo != null ) {
            if (result.hitInfo instanceof LivingEntity) {
                LivingEntity mob = (LivingEntity) result.hitInfo;
                mob.hurt(DamageSource.thrown(this, this.getOwner()), 4.0F);
            }
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}
