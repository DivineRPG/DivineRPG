package divinerpg.entities.projectile;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityVileStorm extends DivineThrowable {

    public EntityVileStorm(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityVileStorm(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityVileStorm(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            result.getEntity().hurt(DamageSource.thrown(this, getOwner()), 7.0F);
            if (result.getEntity() instanceof LivingEntity)
                ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.POISON, 45, 3));
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult p_230299_1_) {
        if(tickCount != 1 || tickCount != 0) {
        if (!this.level.isClientSide) {
            ItemEntity item = new ItemEntity(level, xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm"))));
            level.addFreshEntity(item);
            this.kill();
        }
        }
    }
}