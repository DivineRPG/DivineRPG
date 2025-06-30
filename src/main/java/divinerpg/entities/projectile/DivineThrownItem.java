package divinerpg.entities.projectile;

import divinerpg.items.ranged.ItemThrowable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import static net.minecraft.world.entity.projectile.ProjectileDeflection.REVERSE;
import static net.minecraft.world.item.Items.EGG;

public class DivineThrownItem extends ThrowableItemProjectile {
    public boolean canPickup = true;
    public DivineThrownItem(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {super(entityType, level);}
    @Override protected Item getDefaultItem() {return EGG;}
    public void drop() {
        ItemStack item = getItem();
        if(canPickup && !item.isEmpty()) spawnAtLocation(getItem(), .1F);
        discard();
    }
    @Override public void tick() {
        super.tick();
        if(tickCount > 200) drop();
    }
    public DamageSource getDamageSource(EntityHitResult result) {return damageSources().thrown(this, getOwner());}
    protected void doPostHurtEffects(LivingEntity living) {}
    @Override protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        ItemStack item = getItem();
        float f = (float)getDeltaMovement().length(), d0 = item.isEmpty() || !(item.getItem() instanceof ItemThrowable t) ? 1 : t.damage;
        Entity owner = getOwner();
        DamageSource damageSource = getDamageSource(result);
        if(getWeaponItem() != null && level() instanceof ServerLevel s) d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damageSource, d0);
        int j = Mth.ceil(Mth.clamp(f * d0, 0, Integer.MAX_VALUE)), i = entity.getRemainingFireTicks();
        if(owner instanceof LivingEntity livingOwner) livingOwner.setLastHurtMob(entity);
        if(isOnFire()) entity.igniteForSeconds(5);
        if(entity.hurt(damageSource, j)) {
            if(!(entity instanceof EnderMan)) {
                if(entity instanceof LivingEntity livingEntity) {
                    if(level() instanceof ServerLevel s1) EnchantmentHelper.doPostAttackEffectsWithItemSource(s1, livingEntity, damageSource, getWeaponItem());
                    doPostHurtEffects(livingEntity);
                } canPickup = false;
            } drop();
        } else {
            entity.setRemainingFireTicks(i);
            deflect(REVERSE, entity, getOwner(), false);
            setDeltaMovement(getDeltaMovement().scale(.2));
            if(!level().isClientSide && getDeltaMovement().lengthSqr() < 1-7) drop();
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        drop();
    }
    @Override public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("pickup", canPickup);
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        canPickup = compound.getBoolean("pickup");
    }
}