package divinerpg.entities.projectile;

import divinerpg.items.ranged.ItemThrowable;
import divinerpg.registries.EntityRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.*;

import static net.minecraft.world.entity.projectile.ProjectileDeflection.REVERSE;
import static net.minecraft.world.item.Items.EGG;

public class DivineThrownItem extends ThrowableItemProjectile {
    public boolean canPickup = true;

    public DivineThrownItem(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public DivineThrownItem(EntityType<? extends ThrowableItemProjectile> entityType, Level level, LivingEntity shooter, ItemStack itemStack) {
        super(entityType, shooter, level, itemStack);
    }

    public DivineThrownItem(EntityType<? extends ThrowableItemProjectile> entityType, Level level, double x, double y, double z, ItemStack itemStack) {
        super(entityType, x, y, z, level, itemStack);
    }

    public DivineThrownItem(ServerLevel serverLevel, LivingEntity entity, ItemStack stack) {
        super(EntityRegistry.THROWN_ITEM.get(), entity, serverLevel, stack);
    }

    @Override
    protected Item getDefaultItem() {
        return EGG;
    }

    public void drop() {
        ItemStack item = getItem();
        if (canPickup && !item.isEmpty() && level() instanceof ServerLevel serverLevel) {
            this.spawnAtLocation(serverLevel, item);
        }
        discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount > 200) {
            drop();
        }
    }

    public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().thrown(this, getOwner());
    }

    protected void doPostHurtEffects(LivingEntity living) {}

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!(level() instanceof ServerLevel serverLevel)) {
            return;
        }

        Entity entity = result.getEntity();
        ItemStack item = getItem();
        float f = (float) getDeltaMovement().length();
        float d0 = item.isEmpty() || !(item.getItem() instanceof ItemThrowable t) ? 1 : t.damage;
        Entity owner = getOwner();
        DamageSource damageSource = getDamageSource(result);

        if (!item.isEmpty()) {
            d0 = EnchantmentHelper.modifyDamage(serverLevel, item, entity, damageSource, d0);
        }

        int j = Mth.ceil(Mth.clamp(f * d0, 0, Integer.MAX_VALUE));
        int i = entity.getRemainingFireTicks();

        if (owner instanceof LivingEntity livingOwner) {
            livingOwner.setLastHurtMob(entity);
        }

        if (isOnFire()) {
            entity.igniteForSeconds(5);
        }

        if (entity.hurtServer(serverLevel, damageSource, j)) {
            if (!(entity instanceof EnderMan)) {
                if (entity instanceof LivingEntity livingEntity) {
                    if (!item.isEmpty()) {
                        EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, livingEntity, damageSource, item);
                    }
                    doPostHurtEffects(livingEntity);
                }
                canPickup = false;
            }
            drop();
        } else {
            entity.setRemainingFireTicks(i);
            deflect(REVERSE, entity, EntityReference.of(getOwner()), false);
            setDeltaMovement(getDeltaMovement().scale(0.2));
            if (getDeltaMovement().lengthSqr() < 1e-7) {
                drop();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            drop();
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("pickup", canPickup);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        canPickup = input.getBooleanOr("pickup", false);
    }
}