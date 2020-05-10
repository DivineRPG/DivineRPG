package divinerpg.objects.entities.entity.projectiles;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import divinerpg.DivineRPG;
import divinerpg.enums.ArrowType;
import divinerpg.enums.ParticleType;
import divinerpg.enums.ArrowType.ArrowSpecial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDivineArrow extends EntityArrow {
    private static final Predicate<Entity> ARROW_TARGETS = Predicates.and(EntitySelectors.NOT_SPECTATING,
            EntitySelectors.IS_ALIVE, new Predicate<Entity>() {
                public boolean apply(@Nullable Entity p_apply_1_) {
                    return p_apply_1_.canBeCollidedWith();
                }
            });
    private static final DataParameter<Byte> CRITICAL = EntityDataManager.<Byte>createKey(EntityArrow.class,
            DataSerializers.BYTE);
    private static final DataParameter<Byte> ARROW_ID = EntityDataManager.<Byte>createKey(EntityDivineArrow.class,
            DataSerializers.BYTE);
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    protected boolean inGround;
    protected int timeInGround;
    public EntityArrow.PickupStatus pickupStatus;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    public double damageMin;
    public double damageMax;
    private int knockbackStrength;
    private ArrowType arrowType;
    public Item ammoItem;

    public EntityDivineArrow(World world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
        this.setSize(0.5F, 0.5F);
    }

    public EntityDivineArrow(World worldIn, ArrowType arrowType, double x, double y, double z) {
        this(worldIn);
        this.arrowType = arrowType;
        setArrowId((byte) arrowType.ordinal());
        this.damageMin = arrowType.getMinDamage();
        this.damageMax = arrowType.getMaxDamage();
        this.setPosition(x, y, z);
    }

    public EntityDivineArrow(World worldIn, ArrowType arrowType, EntityLivingBase shooter) {
        this(worldIn, arrowType, shooter.posX, shooter.posY + (double) shooter.getEyeHeight() - 0.10000000149011612D,
                shooter.posZ);
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer) {
            this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
        }
    }

    public EntityDivineArrow(World worldIn, ArrowType arrowType, EntityLivingBase shooter, EntityLivingBase target,
            float velocity, float inaccuracy) {
        this(worldIn, arrowType, shooter);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + target.height / 3.0F - this.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        this.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, velocity, inaccuracy);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 0.8F));
    }

    @Override
    protected void entityInit() {
        this.dataManager.register(CRITICAL, Byte.valueOf((byte) 0));
        this.dataManager.register(ARROW_ID, Byte.valueOf((byte) 0));
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity, inaccuracy);
        this.ticksInGround = 0;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt(x * x + z * z);
            this.rotationPitch = (float) (MathHelper.atan2(y, (double) f) * (180D / Math.PI));
            this.rotationYaw = (float) (MathHelper.atan2(x, z) * (180D / Math.PI));
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate() {
        super.onEntityUpdate();
        if (getArrowType() == ArrowType.ETERNAL_ARCHER_FLAME_ARROW) {
            double x = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double y = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double z = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            this.world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0, 0, 0);
        } else if (getArrowType() == ArrowType.ETERNAL_ARCHER_WITHER_ARROW) {
            double x = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double y = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double z = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            DivineRPG.proxy.spawnParticle(this.world, ParticleType.BLACK_FLAME, x, y, z, 0, 0, 0);
        }
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));
            this.rotationPitch = (float) (MathHelper.atan2(this.motionY, (double) f) * (180D / Math.PI));
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }
        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if (iblockstate.getMaterial() != Material.AIR) {
            AxisAlignedBB axisalignedbb = iblockstate.getCollisionBoundingBox(this.world, blockpos);
            if (axisalignedbb != Block.NULL_AABB
                    && axisalignedbb.offset(blockpos).contains(new Vec3d(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            int j = block.getMetaFromState(iblockstate);
            if ((block != this.inTile || j != this.inData)
                    && !this.world.collidesWithAnyBlock(this.getEntityBoundingBox().grow(0.05D))) {
                this.inGround = false;
                this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInGround;

                if ((this.ticksInGround >= 200 && getArrowType() == ArrowType.FROST_ARCHER_ARROW)
                        || this.ticksInGround >= 1200) {
                    this.setDead();
                }
            }
            ++this.timeInGround;
        } else {
            this.timeInGround = 0;
            ++this.ticksInAir;
            Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
            vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (raytraceresult != null) {
                vec3d = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
            }
            Entity entity = this.findEntityOnPath(vec3d1, vec3d);
            if (entity != null) {
                raytraceresult = new RayTraceResult(entity);
            }
            if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) raytraceresult.entityHit;
                if (this.shootingEntity instanceof EntityPlayer
                        && !((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer)) {
                    raytraceresult = null;
                }
            }
            if (raytraceresult != null
                    && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
                this.onHit(raytraceresult);
            }
            if (this.getIsCritical()) {
                for (int k = 0; k < 4; ++k) {
                    this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * (double) k / 4.0D,
                            this.posY + this.motionY * (double) k / 4.0D, this.posZ + this.motionZ * (double) k / 4.0D,
                            -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f4 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));
            for (this.rotationPitch = (float) (MathHelper.atan2(this.motionY, (double) f4)
                    * (180D / Math.PI)); this.rotationPitch
                            - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
                ;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f1 = 0.99F;
            float f2 = 0.05F;
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    float f3 = 0.25F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D,
                            this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX,
                            this.motionY, this.motionZ);
                }
                f1 = 0.6F;
            }
            if (this.isWet()) {
                this.extinguish();
            }
            this.motionX *= (double) f1;
            this.motionY *= (double) f1;
            this.motionZ *= (double) f1;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.05000000074505806D;
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        Entity entity = raytraceResultIn.entityHit;

        if (entity != null) {
            float f = MathHelper
                    .sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            int i = MathHelper.ceil((double) f * this.damageMin);
            if (i > this.damageMax)
                i = MathHelper.ceil(this.damageMax);

            if (this.getIsCritical()) {
                i += this.rand.nextInt(i / 2 + 2);
            }

            DamageSource damagesource;

            if (this.shootingEntity == null) {
                damagesource = DamageSource.causeArrowDamage(this, this);
            } else {
                damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
            }

            if (entity instanceof EntityLivingBase) {
                if (this.getArrowType().getArrowSpecial() == ArrowSpecial.WITHER)
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowSpecial.SLOW)
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 2));
                else if (this.getArrowType().getArrowSpecial() == ArrowSpecial.BLIND)
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 0));
                else if (this.getArrowType().getArrowSpecial() == ArrowSpecial.NAUSEA)
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));
            }

            // Fire Damage
            if (!(entity instanceof EntityEnderman)) {
                if (this.getArrowType().getArrowSpecial() == ArrowSpecial.FLAME) {
                    entity.setFire(12);
                } else if (this.isBurning()) {
                    entity.setFire(5);
                }
            }

            if (entity.attackEntityFrom(damagesource, (float) i)) {
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;

                    // Poison Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowSpecial.POSION) {
                        ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 40, 2));
                    }

                    // Explosion Damage
                    if (this.getArrowType().getArrowSpecial() == ArrowSpecial.EXPLODE) {
                        this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
                    }

                    if (!this.world.isRemote) {
                        entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                    }
                    if (this.knockbackStrength > 0) {
                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                        if (f1 > 0.0F) {
                            entitylivingbase.addVelocity(
                                    this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1,
                                    0.1D,
                                    this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
                        }
                    }
                    if (this.shootingEntity instanceof EntityLivingBase) {
                        EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.shootingEntity);
                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase) this.shootingEntity,
                                entitylivingbase);
                    }
                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity
                            && entitylivingbase instanceof EntityPlayer
                            && this.shootingEntity instanceof EntityPlayerMP) {
                        ((EntityPlayerMP) this.shootingEntity).connection
                                .sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }
                this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                if (!(entity instanceof EntityEnderman)) {
                    this.setDead();
                }
            } else {
                this.motionX *= -0.10000000149011612D;
                this.motionY *= -0.10000000149011612D;
                this.motionZ *= -0.10000000149011612D;
                this.rotationYaw += 180.0F;
                this.prevRotationYaw += 180.0F;
                this.ticksInAir = 0;
                if (!this.world.isRemote && this.motionX * this.motionX + this.motionY * this.motionY
                        + this.motionZ * this.motionZ < 0.0010000000474974513D) {
                    if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED) {
                        this.entityDropItem(this.getArrowStack(), 0.1F);
                    }
                    this.setDead();
                }
            }
        } else {
            BlockPos blockpos = raytraceResultIn.getBlockPos();
            this.xTile = blockpos.getX();
            this.yTile = blockpos.getY();
            this.zTile = blockpos.getZ();
            IBlockState iblockstate = this.world.getBlockState(blockpos);
            this.inTile = iblockstate.getBlock();
            this.inData = this.inTile.getMetaFromState(iblockstate);
            this.motionX = (double) ((float) (raytraceResultIn.hitVec.x - this.posX));
            this.motionY = (double) ((float) (raytraceResultIn.hitVec.y - this.posY));
            this.motionZ = (double) ((float) (raytraceResultIn.hitVec.z - this.posZ));
            float f2 = MathHelper
                    .sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / (double) f2 * 0.05000000074505806D;
            this.posY -= this.motionY / (double) f2 * 0.05000000074505806D;
            this.posZ -= this.motionZ / (double) f2 * 0.05000000074505806D;
            this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            this.inGround = true;
            this.arrowShake = 7;
            this.setIsCritical(false);

            if (iblockstate.getMaterial() != Material.AIR) {
                this.inTile.onEntityCollidedWithBlock(this.world, blockpos, iblockstate, this);
            }

            if (getArrowType() == ArrowType.SNOWSTORM_ARROW) {
                this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
                this.setDead();
            }
        }
    }

    @Override
    public void move(MoverType type, double x, double y, double z) {
        super.move(type, x, y, z);
        if (this.inGround) {
            this.xTile = MathHelper.floor(this.posX);
            this.yTile = MathHelper.floor(this.posY);
            this.zTile = MathHelper.floor(this.posZ);
        }
    }

    @Nullable
    protected Entity findEntityOnPath(Vec3d start, Vec3d end) {
        Entity entity = null;
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this,
                this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D), ARROW_TARGETS);
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i) {
            Entity entity1 = list.get(i);

            if (entity1 != this.shootingEntity || this.ticksInAir >= 5) {
                AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
                RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(start, end);

                if (raytraceresult != null) {
                    double d1 = start.squareDistanceTo(raytraceresult.hitVec);

                    if (d1 < d0 || d0 == 0.0D) {
                        entity = entity1;
                        d0 = d1;
                    }
                }
            }
        }

        return entity;
    }

    public static void registerFixesArrow(DataFixer fixer) {
        registerFixesArrow(fixer, "DivineArrow");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("xTile", this.xTile);
        compound.setInteger("yTile", this.yTile);
        compound.setInteger("zTile", this.zTile);
        compound.setShort("life", (short) this.ticksInGround);
        ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(this.inTile);
        compound.setString("inTile", resourcelocation == null ? "" : resourcelocation.toString());
        compound.setByte("inData", (byte) this.inData);
        compound.setByte("shake", (byte) this.arrowShake);
        compound.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        compound.setByte("pickup", (byte) this.pickupStatus.ordinal());
        compound.setDouble("damage", this.damageMin);
        compound.setBoolean("crit", this.getIsCritical());
        compound.setByte("arrowId", getArrowId());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        this.xTile = compound.getInteger("xTile");
        this.yTile = compound.getInteger("yTile");
        this.zTile = compound.getInteger("zTile");
        this.ticksInGround = compound.getShort("life");
        if (compound.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(compound.getString("inTile"));
        } else {
            this.inTile = Block.getBlockById(compound.getByte("inTile") & 255);
        }
        this.inData = compound.getByte("inData") & 255;
        this.arrowShake = compound.getByte("shake") & 255;
        this.inGround = compound.getByte("inGround") == 1;

        if (compound.hasKey("damage", 99)) {
            this.damageMin = compound.getDouble("damage");
        }

        if (compound.hasKey("pickup", 99)) {
            this.pickupStatus = EntityArrow.PickupStatus.getByOrdinal(compound.getByte("pickup"));
        } else if (compound.hasKey("player", 99)) {
            this.pickupStatus = compound.getBoolean("player") ? EntityArrow.PickupStatus.ALLOWED :
                    EntityArrow.PickupStatus.DISALLOWED;
        }
        this.setIsCritical(compound.getBoolean("crit"));
        setArrowId(compound.getByte("arrowId"));
        this.arrowType = ArrowType.getArrowFromId(getArrowId());
        this.damageMax = this.arrowType.getMaxDamage();
    }

    public void onCollideWithPlayer(EntityPlayer entityIn) {
        if (!this.world.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean flag = this.pickupStatus == EntityArrow.PickupStatus.ALLOWED
                    || this.pickupStatus == EntityArrow.PickupStatus.CREATIVE_ONLY
                            && entityIn.capabilities.isCreativeMode;
            if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED
                    && !entityIn.inventory.addItemStackToInventory(this.getArrowStack())) {
                flag = false;
            }
            if (flag) {
                entityIn.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    public void setKnockbackStrength(int knockbackStrengthIn) {
        this.knockbackStrength = knockbackStrengthIn;
    }

    public void setIsCritical(boolean critical) {
        byte b0 = ((Byte) this.dataManager.get(CRITICAL)).byteValue();

        if (critical) {
            this.dataManager.set(CRITICAL, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(CRITICAL, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    public boolean getIsCritical() {
        byte b0 = ((Byte) this.dataManager.get(CRITICAL)).byteValue();
        return (b0 & 1) != 0;
    }

    @Override
    public void setEnchantmentEffectsFromEntity(EntityLivingBase p_190547_1_, float p_190547_2_) {
    }

    public void setDamage(double damageIn) {
        this.damageMin = damageIn;
    }

    public double getDamage() {
        return this.damageMin;
    }

    private byte getArrowId() {
        return ((Byte) this.dataManager.get(ARROW_ID)).byteValue();
    }

    private void setArrowId(byte projectileId) {
        dataManager.set(ARROW_ID, Byte.valueOf(projectileId));
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