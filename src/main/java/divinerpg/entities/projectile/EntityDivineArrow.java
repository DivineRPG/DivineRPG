package divinerpg.entities.projectile;

import divinerpg.enums.ArrowType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityDivineArrow extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ARROW_ID = SynchedEntityData.defineId(EntityDivineArrow.class, EntityDataSerializers.BYTE);
    public double damageMin;
    public double damageMax;
    private ArrowType arrowType;
    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world) {super(type, world);}
    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world, ArrowType arrowType, double x, double y, double z) {
        this(type, world);
        this.arrowType = arrowType;
        setArrowId((byte)arrowType.ordinal());
        setBaseDamage(arrowType.getBaseDamage());
        setPos(x, y, z);
    }
    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world, ArrowType arrowType, LivingEntity shooter) {
        this(type, world, arrowType, shooter.xo, shooter.yo + (double)shooter.getEyeHeight() - .1, shooter.zo);
        setBaseDamage(arrowType.getBaseDamage());
        setOwner(shooter);
    }
    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level worldIn, ArrowType arrowType, LivingEntity shooter, LivingEntity target, float velocity, float inaccuracy) {
        this(type, worldIn, arrowType, shooter);
        setBaseDamage(arrowType.getBaseDamage());
        Vec3 vector3d = getViewVector(1);
        double d0 = target.getX() - (getX() + vector3d.x * 4);
        double d1 = target.getY(.5) - (.5 + getY(.5));
        double d2 = target.getZ() - (getZ() + vector3d.z * 4);
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        shoot(d0, d1 + d3 * .2, d2, velocity, inaccuracy);
        playSound(SoundEvents.SKELETON_SHOOT, 1, 1 / (random.nextFloat() * .4F + .8F));
        setOwner(shooter);
    }
    @Override protected ItemStack getPickupItem() {
        if(arrowType.getArrowSupplier() != null) return new ItemStack(arrowType.getArrowSupplier());
        else return new ItemStack(Items.AIR);
    }
    @Override public void tick() {
        super.tick();
        double f = (random.nextDouble() - random.nextDouble()) / 4;
        if(arrowType == ArrowType.ETERNAL_ARCHER_FLAME_ARROW) {
            double x = xo + f;
            double y = yo + f;
            double z = zo + f;
            level().addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        } else if(arrowType == ArrowType.ETERNAL_ARCHER_WITHER_ARROW) {
            double x = xo + f;
            double y = yo + f;
            double z = zo + f;
            level().addParticle(ParticleRegistry.BLACK_FLAME.get(), x, y, z, 0, 0, 0);
        }
    }
    @Override protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        if(entity instanceof LivingEntity livingEntity && !(entity instanceof EnderMan)) {
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.BLIND) livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, arrowType.effectSec * 20, 0));
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) livingEntity.setSecondsOnFire(arrowType.effectSec);
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.NAUSEA) livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, arrowType.effectSec * 20, 0));
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.POISON) livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, arrowType.effectSec * 20, 3));
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.SLOW) livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, arrowType.effectSec * 20, 2));
            if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.WITHER) livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, arrowType.effectSec * 20, 2));
        } super.onHitEntity(result);
    }
    @Override protected void doPostHurtEffects(LivingEntity entity) {
        if(getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE && !level().isClientSide) {
            if(arrowType == ArrowType.SNOWSTORM_ARROW) level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.NONE);
            else level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.TNT);
        }
    }
    @Override protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ARROW_ID, (byte)0);
    }
    @Override public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putByte("projectileId", getArrowId());
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setArrowId(compound.getByte("projectileId"));
        arrowType = ArrowType.getArrowFromId(getArrowId());
    }
    private byte getArrowId() {return (entityData.get(ARROW_ID));}
    private void setArrowId(byte projectileId) {entityData.set(ARROW_ID, projectileId);}
    public ArrowType getArrowType() {
        if(arrowType == null) arrowType = ArrowType.getArrowFromId(getArrowId());
        return arrowType;
    }
    public ResourceLocation getTexture() {return getArrowType().getTexture();}
}