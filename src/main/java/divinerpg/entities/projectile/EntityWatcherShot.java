package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

public class EntityWatcherShot extends ThrowableEntity {
    private static final DataParameter<ItemStack> STACK = EntityDataManager.createKey(EntityWatcherShot.class, DataSerializers.ITEMSTACK);
    public EntityWatcherShot(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerData() {
        this.getDataManager().register(STACK, ItemStack.EMPTY);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
            this.world.createExplosion(null, this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), 5.0F, Explosion.Mode.DESTROY);
        }

        if (result.hitInfo != null ) {
            if (result.hitInfo instanceof LivingEntity) {
                LivingEntity mob = (LivingEntity) result.hitInfo;
                mob.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 4.0F);
            }
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}
