package divinerpg.entities.projectile;

import divinerpg.enums.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.datasync.*;
import net.minecraft.network.play.server.*;
import net.minecraft.particles.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.fml.network.*;

public class EntityDivineArrow extends ArrowEntity {
    private static final DataParameter<Byte> CRITICAL = EntityDataManager.<Byte>defineId(EntityDivineArrow.class,
            DataSerializers.BYTE);
    private static final DataParameter<Byte> ARROW_ID = EntityDataManager.<Byte>defineId(EntityDivineArrow.class,
            DataSerializers.BYTE);
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    protected boolean inGround;
    protected int timeInGround;
    public PickupStatus pickupStatus;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    public double damageMin;
    public double damageMax;
    private int knockbackStrength;
    private ArrowType arrowType;
    public Item ammoItem;

    public EntityDivineArrow(EntityType<? extends ArrowEntity> type, World world) {
        super(type, world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.pickupStatus = PickupStatus.DISALLOWED;
    }

    public EntityDivineArrow(EntityType<? extends ArrowEntity> type, World world, ArrowType arrowType, double x, double y, double z) {
        this(type, world);
        this.arrowType = arrowType;
        setArrowId((byte) arrowType.ordinal());
        this.damageMin = arrowType.getMinDamage();
        this.damageMax = arrowType.getMaxDamage();
        this.setPos(x, y, z);
    }

    public EntityDivineArrow(EntityType<? extends ArrowEntity> type, World world, ArrowType arrowType, LivingEntity shooter) {
        this(type, world, arrowType, shooter.xo, shooter.yo + (double) shooter.getEyeHeight() - 0.10000000149011612D, shooter.zo);
    }

    public EntityDivineArrow(EntityType<? extends ArrowEntity> type, World worldIn, ArrowType arrowType, LivingEntity shooter, LivingEntity target, float velocity, float inaccuracy) {
        this(type, worldIn, arrowType, shooter);
        double d0 = target.xo - this.xo;
        double d1 = target.getBoundingBox().minY + target.getEyeHeight() / 3.0F - this.yo;
        double d2 = target.zo - this.zo;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        this.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, velocity, inaccuracy);
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
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
            float f = MathHelper.sqrt(x * x + z * z);
            this.xRot = (float) (MathHelper.atan2(y, (double) f) * (180D / Math.PI));
            this.yRot = (float) (MathHelper.atan2(x, z) * (180D / Math.PI));
            this.xRotO = this.xRot;
            this.yRotO = this.yRot;
            this.moveTo(this.xo, this.yo, this.zo, this.yRot, this.xRot);
            this.ticksInGround = 0;
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        if (getArrowType() == ArrowType.ETERNAL_ARCHER_FLAME_ARROW) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            level.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        } else if (getArrowType() == ArrowType.ETERNAL_ARCHER_WITHER_ARROW) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            level.addParticle(ParticleRegistry.BLACK_FLAME.get(), x, y, z, 0, 0, 0);
        }
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            float f = MathHelper.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
            this.yRot = (float) (MathHelper.atan2(this.getDeltaMovement().x, this.getDeltaMovement().z) * (180D / Math.PI));
            this.xRot = (float) (MathHelper.atan2(this.getDeltaMovement().y, (double) f) * (180D / Math.PI));
            this.yRotO = this.yRot;
            this.xRotO = this.xRot;
        }
        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
        BlockState iblockstate = this.level.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if (iblockstate.getMaterial() != Material.AIR) {
            VoxelShape vox = iblockstate.getCollisionShape(this.level, blockpos);
            if (vox != VoxelShapes.empty()
                    && vox.move(blockpos.getX(), blockpos.getY(), blockpos.getZ()).equals(new Vector3d(this.xo, this.yo, this.zo))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            if ((block != this.inTile)
                    && !this.level.noCollision(this.getBoundingBox().inflate(0.05D))) {
                this.inGround = false;
                setDeltaMovement(getDeltaMovement().x * this.random.nextFloat() * 0.2F, getDeltaMovement().y * this.random.nextFloat() * 0.2F, getDeltaMovement().z * this.random.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInGround;

                if ((this.ticksInGround >= 200 && getArrowType() == ArrowType.FROST_ARCHER_ARROW)
                        || this.ticksInGround >= 1200) {
                    this.kill();
                }
            }
            ++this.timeInGround;
        } else {
            this.timeInGround = 0;
            ++this.ticksInAir;
            Vector3d vec3d1 = new Vector3d(this.xo, this.yo, this.zo);
            Vector3d vec3d = new Vector3d(this.xo + this.getDeltaMovement().x, this.yo + this.getDeltaMovement().y, this.zo + this.getDeltaMovement().z);
            RayTraceResult raytraceresult = this.level.clipWithInteractionOverride(vec3d1, vec3d, blockpos, VoxelShapes.block(), level.getBlockState(blockpos));

            if (raytraceresult != null && raytraceresult.hitInfo instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) raytraceresult.hitInfo;
                if (this.shootingEntity instanceof PlayerEntity
                        && !((PlayerEntity) this.shootingEntity).canAttack(entityplayer)) {
                    raytraceresult = null;
                }
            }
            if (raytraceresult != null
                    && !ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
                this.onHit(raytraceresult);
            }
            if (this.getIsCritical()) {
                for (int k = 0; k < 4; ++k) {
                    this.level.addParticle(ParticleTypes.CRIT, this.xo + this.getDeltaMovement().x * (double) k / 4.0D,
                            this.yo + this.getDeltaMovement().y * (double) k / 4.0D, this.zo + this.getDeltaMovement().z * (double) k / 4.0D,
                            -this.getDeltaMovement().x, -this.getDeltaMovement().y + 0.2D, -this.getDeltaMovement().z);
                }
            }
            this.xo += this.getDeltaMovement().x;
            this.yo += this.getDeltaMovement().y;
            this.zo += this.getDeltaMovement().z;
            float f4 = MathHelper.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
            this.yRot = (float) (MathHelper.atan2(this.getDeltaMovement().x, this.getDeltaMovement().z) * (180D / Math.PI));
            for (this.xRot = (float) (MathHelper.atan2(this.getDeltaMovement().y, (double) f4)
                    * (180D / Math.PI)); this.xRot
                         - this.xRotO < -180.0F; this.xRotO -= 360.0F) {
                ;
            }
            while (this.xRot - this.xRotO >= 180.0F) {
                this.xRotO += 360.0F;
            }
            while (this.yRot - this.yRotO < -180.0F) {
                this.yRotO -= 360.0F;
            }
            while (this.yRot - this.yRotO >= 180.0F) {
                this.yRotO += 360.0F;
            }
            this.xRot = this.xRotO + (this.xRot - this.xRotO) * 0.2F;
            this.yRot = this.yRotO + (this.yRot - this.yRotO) * 0.2F;
            float f1 = 0.99F;
            float f2 = 0.05F;
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    float f3 = 0.25F;
                    this.level.addParticle(ParticleTypes.BUBBLE, this.xo - this.getDeltaMovement().x * 0.25D,
                            this.yo - this.getDeltaMovement().y * 0.25D, this.zo - this.getDeltaMovement().z * 0.25D, this.getDeltaMovement().x,
                            this.getDeltaMovement().y, this.getDeltaMovement().z);
                }
                f1 = 0.6F;
            }
            if (this.isInWater()) {
                this.clearFire();
            }
            setDeltaMovement(getDeltaMovement().x * f1, getDeltaMovement().y * f1, getDeltaMovement().z * f1);
            if (!this.isNoGravity()) {
                setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y - 0.05000000074505806D, getDeltaMovement().z);
            }
            this.setPos(this.xo, this.yo, this.zo);
            this.canBeCollidedWith();
        }
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        LivingEntity entity = (LivingEntity) result.getEntity();
        if(entity != null){
            float f = MathHelper
                    .sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y + this.getDeltaMovement().z * this.getDeltaMovement().z);
            int i = MathHelper.ceil((double) f * this.damageMin);
            if (i > this.damageMax)
                i = MathHelper.ceil(this.damageMax);

            if (this.getIsCritical()) {
                i += this.random.nextInt(i / 2 + 2);
            }

            DamageSource damagesource;

            if (this.shootingEntity == null) {
                damagesource = DamageSource.arrow(this, this);
            } else {
                damagesource = DamageSource.arrow(this, this.shootingEntity);
            }

            if (entity instanceof LivingEntity) {
                if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.WITHER)
                    entity.addEffect(new EffectInstance(Effects.WITHER, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.SLOW)
                    entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.BLIND)
                    entity.addEffect(new EffectInstance(Effects.BLINDNESS, 100, 0));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.NAUSEA)
                    entity.addEffect(new EffectInstance(Effects.CONFUSION, 200, 0));
            }

            // Fire Damage
            if (!(entity instanceof EndermanEntity)) {
                if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) {
                    entity.setSecondsOnFire(12);
                } else if (this.isOnFire()) {
                    entity.setSecondsOnFire(5);
                }
            }

            if (entity.hurt(damagesource, (float) i)) {
                if (entity instanceof LivingEntity) {
                    LivingEntity entitylivingbase = (LivingEntity) entity;

                    // Poison Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.POSION) {
                        ((LivingEntity) entity).addEffect(new EffectInstance(Effects.POISON, 40, 2));
                    }

                    // Explosion Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) {
                        this.level.explode(this, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
                    }

                    if (!this.level.isClientSide) {
                        entitylivingbase.setArrowCount(entitylivingbase.getArrowCount() + 1);
                    }
                    if (this.knockbackStrength > 0) {
                        float f1 = MathHelper.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
                        if (f1 > 0.0F) {
                            entitylivingbase.setDeltaMovement(
                                    this.getDeltaMovement().x * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1,
                                    0.1D,
                                    this.getDeltaMovement().z * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                        }
                    }
                    if (this.shootingEntity instanceof LivingEntity) {
                        EnchantmentHelper.doPostHurtEffects(entitylivingbase, this.shootingEntity);
                    }
                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity
                            && entitylivingbase instanceof PlayerEntity
                            && this.shootingEntity instanceof ServerPlayerEntity) {
                        ((ServerPlayerEntity) this.shootingEntity).connection.send(new SChangeGameStatePacket(SChangeGameStatePacket.ARROW_HIT_PLAYER, 0.0F));
                    }
                }
                this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                if (!(entity instanceof EndermanEntity)) {
                    this.kill();
                }
            } else {
                setDeltaMovement(getDeltaMovement().x * -0.10000000149011612D, getDeltaMovement().y * -0.10000000149011612D, getDeltaMovement().z * -0.10000000149011612D);
                this.yRot += 180.0F;
                this.yRotO += 180.0F;
                this.ticksInAir = 0;
                if (!this.level.isClientSide && this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y
                        + this.getDeltaMovement().z * this.getDeltaMovement().z < 0.0010000000474974513D) {
                    if (this.pickupStatus == PickupStatus.ALLOWED) {
                        ItemEntity itemEnt = new ItemEntity(level, xo, yo, zo);
                        itemEnt.setItem(getArrowStack());
                        level.addFreshEntity(itemEnt);
                    }
                    this.kill();
                }
            }
        }
    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        LivingEntity entity = (LivingEntity) result.hitInfo;

        if (entity != null) {
            float f = MathHelper
                    .sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y + this.getDeltaMovement().z * this.getDeltaMovement().z);
            int i = MathHelper.ceil((double) f * this.damageMin);
            if (i > this.damageMax)
                i = MathHelper.ceil(this.damageMax);

            if (this.getIsCritical()) {
                i += this.random.nextInt(i / 2 + 2);
            }

            DamageSource damagesource;

            if (this.shootingEntity == null) {
                damagesource = DamageSource.arrow(this, this);
            } else {
                damagesource = DamageSource.arrow(this, this.shootingEntity);
            }

            if (entity instanceof LivingEntity) {
                if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.WITHER)
                    entity.addEffect(new EffectInstance(Effects.WITHER, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.SLOW)
                    entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.BLIND)
                    entity.addEffect(new EffectInstance(Effects.BLINDNESS, 100, 0));
                else if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.NAUSEA)
                    entity.addEffect(new EffectInstance(Effects.CONFUSION, 200, 0));
            }

            // Fire Damage
            if (!(entity instanceof EndermanEntity)) {
                if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) {
                    entity.setSecondsOnFire(12);
                } else if (this.isOnFire()) {
                    entity.setSecondsOnFire(5);
                }
            }

            if (entity.hurt(damagesource, (float) i)) {
                if (entity instanceof LivingEntity) {
                    LivingEntity entitylivingbase = (LivingEntity) entity;

                    // Poison Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.POSION) {
                        ((LivingEntity) entity).addEffect(new EffectInstance(Effects.POISON, 40, 2));
                    }

                    // Explosion Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) {
                        this.level.explode(this, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
                    }

                    if (!this.level.isClientSide) {
                        entitylivingbase.setArrowCount(entitylivingbase.getArrowCount() + 1);
                    }
                    if (this.knockbackStrength > 0) {
                        float f1 = MathHelper.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
                        if (f1 > 0.0F) {
                            entitylivingbase.setDeltaMovement(
                                    this.getDeltaMovement().x * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1,
                                    0.1D,
                                    this.getDeltaMovement().z * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                        }
                    }
                    if (this.shootingEntity instanceof LivingEntity) {
                        EnchantmentHelper.doPostHurtEffects(entitylivingbase, this.shootingEntity);
                    }
                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity
                            && entitylivingbase instanceof PlayerEntity
                            && this.shootingEntity instanceof ServerPlayerEntity) {
                        ((ServerPlayerEntity) this.shootingEntity).connection.send(new SChangeGameStatePacket(SChangeGameStatePacket.ARROW_HIT_PLAYER, 0.0F));
                    }
                }
                this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                if (!(entity instanceof EndermanEntity)) {
                    this.kill();
                }
            } else {
                setDeltaMovement(getDeltaMovement().x * -0.10000000149011612D, getDeltaMovement().y * -0.10000000149011612D, getDeltaMovement().z * -0.10000000149011612D);
                this.yRot += 180.0F;
                this.yRotO += 180.0F;
                this.ticksInAir = 0;
                if (!this.level.isClientSide && this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y
                        + this.getDeltaMovement().z * this.getDeltaMovement().z < 0.0010000000474974513D) {
                    if (this.pickupStatus == PickupStatus.ALLOWED) {
                        ItemEntity itemEnt = new ItemEntity(level, xo, yo, zo);
                        itemEnt.setItem(getArrowStack());
                        level.addFreshEntity(itemEnt);
                    }
                    this.kill();
                }
            }
        } else {
            BlockPos blockpos = new BlockPos(result.getLocation());
            this.xTile = blockpos.getX();
            this.yTile = blockpos.getY();
            this.zTile = blockpos.getZ();
            setDeltaMovement(result.getLocation().x - this.xo, result.getLocation().y - this.yo, result.getLocation().z - this.zo);
            float f2 = MathHelper
                    .sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().y * this.getDeltaMovement().y + this.getDeltaMovement().z * this.getDeltaMovement().z);
            this.xo -= this.getDeltaMovement().x / (double) f2 * 0.05000000074505806D;
            this.yo -= this.getDeltaMovement().y / (double) f2 * 0.05000000074505806D;
            this.zo -= this.getDeltaMovement().z / (double) f2 * 0.05000000074505806D;
            this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            this.inGround = true;
            this.arrowShake = 7;
            this.setIsCritical(false);

            if (getArrowType() == ArrowType.SNOWSTORM_ARROW) {
                this.level.explode(this, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
                this.kill();
            }
        }
    }

    @Override
    public void move(MoverType type, Vector3d vec) {
        super.move(type, vec);
        if (this.inGround) {
            this.xTile = MathHelper.floor(this.xo);
            this.yTile = MathHelper.floor(this.yo);
            this.zTile = MathHelper.floor(this.zo);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("xTile", this.xTile);
        compound.putInt("yTile", this.yTile);
        compound.putInt("zTile", this.zTile);
        compound.putShort("life", (short) this.ticksInGround);
        compound.putByte("inData", (byte) this.inData);
        compound.putByte("shake", (byte) this.arrowShake);
        compound.putByte("inGround", (byte) (this.inGround ? 1 : 0));
        compound.putByte("pickup", (byte) this.pickupStatus.ordinal());
        compound.putDouble("damage", this.damageMin);
        compound.putBoolean("crit", this.getIsCritical());
        compound.putByte("arrowId", getArrowId());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        this.xTile = compound.getInt("xTile");
        this.yTile = compound.getInt("yTile");
        this.zTile = compound.getInt("zTile");
        this.ticksInGround = compound.getShort("life");
        this.inData = compound.getByte("inData") & 255;
        this.arrowShake = compound.getByte("shake") & 255;
        this.inGround = compound.getByte("inGround") == 1;

        if (compound.contains("damage", 99)) {
            this.damageMin = compound.getDouble("damage");
        }

        if (compound.contains("pickup", 99)) {
            this.pickupStatus = PickupStatus.byOrdinal(compound.getByte("pickup"));
        } else if (compound.contains("player", 99)) {
            this.pickupStatus = compound.getBoolean("player") ? PickupStatus.ALLOWED :
                    PickupStatus.DISALLOWED;
        }
        this.setIsCritical(compound.getBoolean("crit"));
        setArrowId(compound.getByte("arrowId"));
        this.arrowType = ArrowType.getArrowFromId(getArrowId());
        this.damageMax = this.arrowType.getMaxDamage();
    }

    @Override
    public void playerTouch(PlayerEntity entityIn) {
        if (!this.level.isClientSide && this.inGround && this.arrowShake <= 0) {
            boolean flag = this.pickupStatus == PickupStatus.ALLOWED
                    || this.pickupStatus == PickupStatus.CREATIVE_ONLY
                    && entityIn.isCreative();
            if (this.pickupStatus == PickupStatus.ALLOWED
                    && !entityIn.inventory.add(this.getArrowStack())) {
                flag = false;
            }
            if (flag) {
                this.kill();
            }
        }
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

        if (infiniteAmmo){
            this.pickupStatus = PickupStatus.DISALLOWED;
        }
    }

    protected ItemStack getArrowStack() {
        return new ItemStack(this.ammoItem);
    }
}