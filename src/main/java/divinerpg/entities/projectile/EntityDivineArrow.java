package divinerpg.entities.projectile;

import divinerpg.enums.ArrowType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.api.distmarker.*;

public class EntityDivineArrow extends AbstractArrow {
    private static final EntityDataAccessor<Byte> CRITICAL = SynchedEntityData.<Byte>defineId(EntityDivineArrow.class,
            EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> ARROW_ID = SynchedEntityData.<Byte>defineId(EntityDivineArrow.class,
            EntityDataSerializers.BYTE);
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
//    private int inData;
    protected boolean inGround;
    protected int timeInGround;
    public Pickup pickupStatus;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    //    private int ticksInAir;
    public double damageMin;
    public double damageMax;
    private int knockbackStrength;
    private ArrowType arrowType;
    public Item ammoItem;

    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.pickupStatus = Pickup.DISALLOWED;
    }

    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world, ArrowType arrowType, double x, double y, double z) {
        this(type, world);
        this.arrowType = arrowType;
        setArrowId((byte) arrowType.ordinal());
        this.damageMin = arrowType.getMinDamage();
        this.damageMax = arrowType.getMaxDamage();
        this.setPos(x, y, z);
    }

    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level world, ArrowType arrowType, LivingEntity shooter) {
        this(type, world, arrowType, shooter.xo, shooter.yo + (double) shooter.getEyeHeight() - 0.10000000149011612D, shooter.zo);
        this.shootingEntity = shooter;
    }

    public EntityDivineArrow(EntityType<? extends AbstractArrow> type, Level worldIn, ArrowType arrowType, LivingEntity shooter, LivingEntity target, float velocity, float inaccuracy) {
        this(type, worldIn, arrowType, shooter);
        Vec3 vector3d = this.getViewVector(1.0F);
        double d0 = target.getX() - (this.getX() + vector3d.x * 4.0D);
        double d1 = target.getY(0.5D) - (0.5D + this.getY(0.5D));
        double d2 = target.getZ() - (this.getZ() + vector3d.z * 4.0D);
        double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);
        this.shoot(d0, d1 + d3 * (double) 0.2F, d2, velocity, inaccuracy);
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
        this.shootingEntity = shooter;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CRITICAL, Byte.valueOf((byte) 0));
        this.entityData.define(ARROW_ID, Byte.valueOf((byte) 0));
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity, inaccuracy);
        this.ticksInGround = 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void setDeltaMovement(double x, double y, double z) {
        super.setDeltaMovement(x, y, z);
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            float f = Mth.sqrt((float) (x * x + z * z));
            this.xRot = (float) (Mth.atan2(y, (double) f) * (180D / Math.PI));
            this.yRot = (float) (Mth.atan2(x, z) * (180D / Math.PI));
            this.xRotO = this.xRot;
            this.yRotO = this.yRot;
            this.moveTo(this.xo, this.yo, this.zo, this.yRot, this.xRot);
            this.ticksInGround = 0;
        }
    }

//    @Override
//    public Packet<?> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    @Override
    public void tick() {
        super.tick();
        if (getArrowType() == ArrowType.ETERNAL_ARCHER_FLAME_ARROW) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            level().addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        } else if (getArrowType() == ArrowType.ETERNAL_ARCHER_WITHER_ARROW) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            level().addParticle(ParticleRegistry.BLACK_FLAME.get(), x, y, z, 0, 0, 0);
        }
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            float f = Mth.sqrt((float) (this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z));
            this.yRot = (float) (Mth.atan2(this.getDeltaMovement().x, this.getDeltaMovement().z) * (180D / Math.PI));
            this.xRot = (float) (Mth.atan2(this.getDeltaMovement().y, (double) f) * (180D / Math.PI));
            this.yRotO = this.yRot;
            this.xRotO = this.xRot;
        }
        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
        BlockState iblockstate = this.level().getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if (!iblockstate.isAir()) {
            VoxelShape vox = iblockstate.getCollisionShape(this.level(), blockpos);
            if (vox != Shapes.empty()
                    && vox.move(blockpos.getX(), blockpos.getY(), blockpos.getZ()).equals(new Vec3(this.xo, this.yo, this.zo))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            if ((block != this.inTile)
                    && !this.level().noCollision(this.getBoundingBox().inflate(0.05D))) {
                this.inGround = false;
                setDeltaMovement(getDeltaMovement().x * this.random.nextFloat() * 0.2F, getDeltaMovement().y * this.random.nextFloat() * 0.2F, getDeltaMovement().z * this.random.nextFloat() * 0.2F);
                this.ticksInGround = 0;
//                this.ticksInAir = 0;
            } else {
                ++this.ticksInGround;

                if ((this.ticksInGround >= 200 && getArrowType() == ArrowType.PALE_ARCHER_ARROW)
                        || this.ticksInGround >= 1200) {
                    this.kill();
                }
            }
            ++this.timeInGround;
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            super.onHitEntity(result);
            if (result.getEntity() instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) result.getEntity();

                if (entity != null) {


                    float f = (float)this.getDeltaMovement().length();
                    int i = Mth.ceil(Mth.clamp((double)f * this.damageMin, 0.0D, 2.147483647E9D));

                    if (i > this.damageMax)
                        i = Mth.ceil(this.damageMax);

                    if (this.getIsCritical()) {
                        i += this.random.nextInt(i / 2 + 2);
                    }

                    DamageSource damagesource;

                    if (this.shootingEntity == null) {
                        damagesource = level().damageSources().arrow(this, this);
                    } else {
                        damagesource = level().damageSources().arrow(this, this.shootingEntity);
                    }

                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.WITHER)
                        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2));
                    else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.SLOW)
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
                    else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.BLIND)
                        entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
                    else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.NAUSEA)
                        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));

                    // Fire Damage
                    if (!(entity instanceof EnderMan)) {
                        if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) {
                            entity.setSecondsOnFire(12);
                        } else if (this.isOnFire()) {
                            entity.setSecondsOnFire(5);
                        }
                    }
                    // Poison Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.POSION) {
                        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 2));
                    }

                    // Explosion Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) {
                        this.level().explode(this, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.TNT);
                    }
                    
                    if (entity.hurt(damagesource, (float) i)) {

                        if (!this.level().isClientSide()) {
                            entity.setArrowCount(entity.getArrowCount() + 1);
                        }
                        if (this.knockbackStrength > 0) {
                            float f1 = Mth.sqrt((float) (this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z));
                            if (f1 > 0.0F) {
                                entity.setDeltaMovement(
                                        this.getDeltaMovement().x * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1,
                                        0.1D,
                                        this.getDeltaMovement().z * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                            }
                        }
                        if (this.shootingEntity instanceof LivingEntity) {
                            EnchantmentHelper.doPostHurtEffects(entity, this.shootingEntity);
                        }
                        if (this.shootingEntity != null && entity != this.shootingEntity
                                && entity instanceof Player
                                && this.shootingEntity instanceof ServerPlayer) {
                            ((ServerPlayer) this.shootingEntity).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                        }
                        this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                        if (!(entity instanceof EnderMan)) {
                            this.kill();
                        }
                    } else {
                        setDeltaMovement(getDeltaMovement().x * -0.10000000149011612D, getDeltaMovement().y * -0.10000000149011612D, getDeltaMovement().z * -0.10000000149011612D);
                        this.yRot += 180.0F;
                        this.yRotO += 180.0F;
//                this.ticksInAir = 0;
                        if (!this.level().isClientSide() && this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y
                                + this.getDeltaMovement().z * this.getDeltaMovement().z < 0.0010000000474974513D) {
                            if (this.pickupStatus == Pickup.ALLOWED) {
                                ItemEntity itemEnt = new ItemEntity(level(), xo, yo, zo, getArrowStack());
                                level().addFreshEntity(itemEnt);
                            }
                            this.kill();
                        }
                    }
                } else {
                    BlockPos blockpos = new BlockPos((int) result.getLocation().x, (int) result.getLocation().y, (int) result.getLocation().z);
                    this.xTile = blockpos.getX();
                    this.yTile = blockpos.getY();
                    this.zTile = blockpos.getZ();
                    setDeltaMovement(result.getLocation().x - this.xo, result.getLocation().y - this.yo, result.getLocation().z - this.zo);
                    float f2 = Mth
                            .sqrt((float) (this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y + this.getDeltaMovement().z * this.getDeltaMovement().z));
                    this.xo -= this.getDeltaMovement().x / (double) f2 * 0.05000000074505806D;
                    this.yo -= this.getDeltaMovement().y / (double) f2 * 0.05000000074505806D;
                    this.zo -= this.getDeltaMovement().z / (double) f2 * 0.05000000074505806D;
                    this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);

                    if (getArrowType() == ArrowType.SNOWSTORM_ARROW) {
                        this.level().explode(this, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.BLOCK);
                        this.kill();
                    }
                }
            } else if (result.getEntity() instanceof EnderDragonPart) {
                EnderDragonPart entity = (EnderDragonPart) result.getEntity();

                if (entity != null) {
                    float f = Mth
                            .sqrt((float) (this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y + this.getDeltaMovement().z * this.getDeltaMovement().z));
                    int i = Mth.ceil((double) f * this.damageMin);
                    if (i > this.damageMax)
                        i = Mth.ceil(this.damageMax);

                    if (this.getIsCritical()) {
                        i += this.random.nextInt(i / 2 + 2);
                    }

                    DamageSource damagesource;

                    if (this.shootingEntity == null) {
                        damagesource = level().damageSources().arrow(this, this);
                    } else {
                        damagesource = level().damageSources().arrow(this, this.shootingEntity);
                    }

                    // Fire Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) {
                        entity.setSecondsOnFire(12);
                    } else if (this.isOnFire()) {
                        entity.setSecondsOnFire(5);
                    }

                    if (entity.hurt(damagesource, (float) i)) {
                        // Explosion Damage
                        if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) {
                            this.level().explode(this, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.TNT);
                        }
                        if (this.knockbackStrength > 0) {
                            float f1 = Mth.sqrt((float) (this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z));
                            if (f1 > 0.0F) {
                                entity.setDeltaMovement(
                                        this.getDeltaMovement().x * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1,
                                        0.1D,
                                        this.getDeltaMovement().z * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                            }
                        }
                        this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                        this.kill();
                    }
                }
            }
        }
    }

    @Override
    public void move(MoverType type, Vec3 vec) {
        super.move(type, vec);
        if (this.inGround) {
            this.xTile = Mth.floor(this.xo);
            this.yTile = Mth.floor(this.yo);
            this.zTile = Mth.floor(this.zo);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("life", (short)this.tickCount);
        compound.putInt("xTile", this.xTile);
        compound.putInt("yTile", this.yTile);
        compound.putInt("zTile", this.zTile);
        compound.putByte("shake", (byte)this.shakeTime);
        compound.putBoolean("inGround", this.inGround);
        compound.putByte("pickup", (byte)this.pickup.ordinal());
        compound.putDouble("damage", this.damageMin);
        compound.putBoolean("crit", this.isCritArrow());
        compound.putByte("PierceLevel", this.getPierceLevel());
        compound.putByte("arrowId", getArrowId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.tickCount = compound.getShort("life");
        this.xTile = compound.getInt("xTile");
        this.yTile = compound.getInt("yTile");
        this.zTile = compound.getInt("zTile");
        this.shakeTime = compound.getByte("shake") & 255;
        this.inGround = compound.getBoolean("inGround");
        if (compound.contains("damage", 99)) {
            this.damageMin = compound.getDouble("damage");
        }
        this.pickup = Pickup.byOrdinal(compound.getByte("pickup"));
        this.setCritArrow(compound.getBoolean("crit"));
        this.setPierceLevel(compound.getByte("PierceLevel"));
        this.arrowType = ArrowType.getArrowFromId(getArrowId());
        this.damageMax = this.arrowType.getMaxDamage();
    }

    @Override
    public void playerTouch(Player entityIn) {
        if (!this.level().isClientSide() && this.inGround && this.arrowShake <= 0) {
            boolean flag = this.pickupStatus == Pickup.ALLOWED
                    || this.pickupStatus == Pickup.CREATIVE_ONLY
                    && entityIn.isCreative();
            if (this.pickupStatus == Pickup.ALLOWED
                    && !entityIn.inventory.add(this.getArrowStack())) {
                flag = false;
            }
            if (flag) {
                this.kill();
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return getArrowStack();
    }

    @Override
    public void setKnockback(int knockbackStrengthIn) {
        this.knockbackStrength = knockbackStrengthIn;
    }

    public void setIsCritical(boolean critical) {
        byte b0 = ((Byte) this.entityData.get(CRITICAL)).byteValue();

        if (critical) {
            this.entityData.set(CRITICAL, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.entityData.set(CRITICAL, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    public boolean getIsCritical() {
        byte b0 = ((Byte) this.entityData.get(CRITICAL)).byteValue();
        return (b0 & 1) != 0;
    }

    @Override
    public void doEnchantDamageEffects(LivingEntity p_174815_1_, Entity p_174815_2_) {
    }


    public void setDamage(double damageIn) {
        this.damageMin = damageIn;
    }

    public double getDamage() {
        return this.damageMin;
    }

    private byte getArrowId() {
        return ((Byte) this.entityData.get(ARROW_ID)).byteValue();
    }

    private void setArrowId(byte projectileId) {
        entityData.set(ARROW_ID, Byte.valueOf(projectileId));
    }

    public ArrowType getArrowType() {
        if (arrowType == null) {
            arrowType = ArrowType.getArrowFromId(getArrowId());
        }
        return arrowType;
    }

    public ResourceLocation getTexture() {
        return getArrowType().getTexture();
    }

    public void setAmmoItem(Item ammo, boolean infiniteAmmo) {
        this.ammoItem = ammo;

        if (infiniteAmmo) {
            this.pickupStatus = Pickup.DISALLOWED;
        }
    }

    protected ItemStack getArrowStack() {
        return new ItemStack(this.ammoItem);
    }
}
