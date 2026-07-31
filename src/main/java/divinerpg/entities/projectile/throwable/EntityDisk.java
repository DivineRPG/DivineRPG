package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.items.base.ItemThrowable;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import static divinerpg.registries.ItemRegistry.teaker_disk;

public class EntityDisk extends DivineThrownItem {
    public EntityDisk(EntityType<? extends DivineThrownItem> type, Level world) {super(type, world);}
    @Override public boolean isNoGravity() {return true;}
    @Override public void tick() {
        super.tick();
        Entity owner = getOwner();
        if(owner != null && (tickCount & 7) == 7) {
            Vec3 vec3 = owner.getEyePosition().subtract(position());
            setPosRaw(getX(), getY() + vec3.y * .03, getZ());
            if(level().isClientSide()) yOld = getY();
            addDeltaMovement(vec3.scale(.25));
            playSound(SoundEvents.ARROW_SHOOT, .5F, 1);
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        if(getOwner() == null) super.onHitBlock(result);
        else {
            BlockState blockstate = level().getBlockState(result.getBlockPos());
            blockstate.onProjectileHit(level(), blockstate, result, this);
            Vec3 mv = getDeltaMovement();
            double x = mv.x, y = mv.y, z = mv.z;
            if(result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) lerpMotion(new Vec3(x * .6, y * -.6, z * .6));
            else if(result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) lerpMotion(new Vec3(x * -.6, y * .6, z * .6));
            else if(result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) lerpMotion(new Vec3(x * .6, y * .6, z * -.6));
        }
    }
    @Override public void onHitEntity(EntityHitResult result) {
        Entity owner = getOwner(), entity = result.getEntity();
        if (owner.equals(entity) && owner instanceof Player p) {
            if (canPickup) p.addItem(getItem());
            discard();
            return;
        }
        ItemStack item = getItem();
        float f = (float) getDeltaMovement().length(), d0 = item.isEmpty() || !(item.getItem() instanceof ItemThrowable t) ? 1 : t.damage;
        DamageSource damageSource = getDamageSource(result);
        if (level() instanceof ServerLevel s) {
            if (getWeaponItem() != null)
                d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damageSource, d0);
            int j = Mth.ceil(Mth.clamp(f * d0, 0, Integer.MAX_VALUE));
            if (owner instanceof LivingEntity livingOwner) livingOwner.setLastHurtMob(entity);
            if (entity.hurtServer(s, damageSource, j)) {
                if (isOnFire()) entity.igniteForSeconds(5);
                if (entity instanceof LivingEntity livingEntity) {
                    if (level() instanceof ServerLevel s1)
                        EnchantmentHelper.doPostAttackEffectsWithItemSource(s1, livingEntity, damageSource, getWeaponItem());
                    doPostHurtEffects(livingEntity);
                }
            }
            deflect(ProjectileDeflection.REVERSE, entity, EntityReference.of(getOwner()), false);
            setDeltaMovement(getDeltaMovement().scale(.2));
        }
    }
    @Override protected Item getDefaultItem() {return teaker_disk.get();}
}