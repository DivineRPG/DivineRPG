package net.divinerpg.entities.base;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.entities.twilight.EntityTwilightArcher;
import net.divinerpg.libs.DivineRPGAchievements;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityDivineArrow extends EntityArrow {
    protected int     xTile = -1;
    protected int     yTile = -1;
    protected int     zTile = -1;
    protected Block   inTile;
    protected int     inData;
    protected boolean inGround;
    public int        canBePickedUp;
    public int        arrowShake;
    public Entity     shootingEntity;
    protected int     ticksInGround;
    protected int     ticksInAir;
    public double     damageMin;
    public double     damageMax;
    protected int     knockbackStrength;
    public Item       ammoItem;

    public EntityDivineArrow(World w) {
        super(w);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
    }

    public EntityDivineArrow(World w, double x, double y, double z) {
        super(w);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        this.setPosition(x, y, z);
        this.yOffset = 0.0F;
    }

    public EntityDivineArrow(World w, EntityLivingBase shooter, EntityLivingBase target, float p_i1755_4_, float p_i1755_5_, float damage, String texture) {
        super(w);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;
        this.damageMax = this.damageMin = damage;
        this.dataWatcher.updateObject(17, texture);

        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }

        this.posY = shooter.posY + (double) shooter.getEyeHeight() - 0.10000000149011612D;
        double d0 = target.posX - shooter.posX;
        double d1 = target.boundingBox.minY + (double) (target.height / 3.0F) - this.posY;
        double d2 = target.posZ - shooter.posZ;
        double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D) {
            float f2 = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(shooter.posX + d4, this.posY, shooter.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float) d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double) f4 - 1, d2, p_i1755_4_, p_i1755_5_);
        }
    }

    public EntityDivineArrow(World w, EntityLivingBase shooter, float p_i1756_3_, float damageMin, float damageMax, String texturename) {
        super(w);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.dataWatcher.updateObject(17, texturename);

        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(shooter.posX, shooter.posY + (double) shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
        this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
        this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
        this.motionY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, p_i1756_3_ * 1.5F, 1.0F);
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
        this.dataWatcher.addObject(17, "");
    }

    @Override
    public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_) {
        float f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
        p_70186_1_ /= (double) f2;
        p_70186_3_ /= (double) f2;
        p_70186_5_ /= (double) f2;
        p_70186_1_ += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) p_70186_8_;
        p_70186_3_ += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) p_70186_8_;
        p_70186_5_ += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) p_70186_8_;
        p_70186_1_ *= (double) p_70186_7_;
        p_70186_3_ *= (double) p_70186_7_;
        p_70186_5_ *= (double) p_70186_7_;
        this.motionX = p_70186_1_;
        this.motionY = p_70186_3_;
        this.motionZ = p_70186_5_;
        float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(p_70186_3_, (double) f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
        this.setPosition(p_70056_1_, p_70056_3_, p_70056_5_);
        this.setRotation(p_70056_7_, p_70056_8_);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
        this.motionX = p_70016_1_;
        this.motionY = p_70016_3_;
        this.motionZ = p_70016_5_;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(p_70016_3_, (double) f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate() {
        super.onEntityUpdate();

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f) * 180.0D / Math.PI);
        }

        Block block = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);

        if (block.getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0) {
            --this.arrowShake;
        }

        if (this.inGround) {
            int j = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

            if (block == this.inTile && j == this.inData) {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
            } else {
                this.inGround = false;
                this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition position = this.worldObj.rayTraceBlocks(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (position != null) {
                vec3 = Vec3.createVectorHelper(position.hitVec.xCoord, position.hitVec.yCoord, position.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int i;
            float f1;

            for (i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity) list.get(i);

                if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double) f1, (double) f1, (double) f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

                    if (movingobjectposition1 != null) {
                        double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D) {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) position = new MovingObjectPosition(entity);

            if (position != null && position.entityHit != null && position.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) position.entityHit;

                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer)) {
                    position = null;
                }
            }

            float f2;
            float f4;

            if (position != null) {
                if (position.entityHit != null) {
                    f2 = MathHelper.sqrt_double(4 * (this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ));
                    int k = MathHelper.ceiling_double_int(f2 * (this.damageMin));
                    if (k > this.damageMax) k = MathHelper.ceiling_double_int(this.damageMax);

                    if (this.getIsCritical()) {
                        k += this.rand.nextInt(k / 3 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null) {
                        damagesource = DamageSource.causeArrowDamage(this, this);
                    } else {
                        damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
                    }

                    if (position.entityHit.attackEntityFrom(damagesource, (float) k)) {
                        if(position.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityTwilightArcher) ((EntityPlayer)position.entityHit).triggerAchievement(DivineRPGAchievements.arrowToTheKnee);
                        if (this.getTextureName() == "hunterArrow" && position.entityHit instanceof EntityLivingBase) {
                            ((EntityLivingBase) position.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, 40, 2));
                        }

                        if (this.isBurning() && !(position.entityHit instanceof EntityEnderman)) position.entityHit.setFire(5);
                        if (this.getTextureName() == "infernoArrow") position.entityHit.setFire(12);

                        if (this.getTextureName() == "bluefireArrow" || this.getTextureName() == "snowstormArrow") this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
                        if (position.entityHit instanceof EntityLivingBase) {
                            EntityLivingBase entitylivingbase = (EntityLivingBase) position.entityHit;

                            if (this.knockbackStrength > 0) {
                                f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (f4 > 0.0F) {
                                    position.entityHit.addVelocity(this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4, 0.1D, this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4);
                                }
                            }

                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase) this.shootingEntity, entitylivingbase);
                            }

                            if (this.shootingEntity != null && position.entityHit != this.shootingEntity && position.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP) this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }

                        this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                        if (!(position.entityHit instanceof EntityEnderman)) {
                            this.setDead();
                        }
                    } else {
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                } else {
                    this.xTile = position.blockX;
                    this.yTile = position.blockY;
                    this.zTile = position.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (double) ((float) (position.hitVec.xCoord - this.posX));
                    this.motionY = (double) ((float) (position.hitVec.yCoord - this.posY));
                    this.motionZ = (double) ((float) (position.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double) f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double) f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double) f2 * 0.05000000074505806D;
                    this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);

                    if (this.inTile.getMaterial() != Material.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                    }
                }
            }

            if (this.getIsCritical()) {
                for (i = 0; i < 4; ++i) {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double) i / 4.0D, this.posY + this.motionY * (double) i / 4.0D, this.posZ + this.motionZ * (double) i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
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
            float f3 = 0.99F;
            f1 = 0.05F;

            if (this.isInWater()) {
                for (int l = 0; l < 4; ++l) {
                    f4 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double) f4, this.posY - this.motionY * (double) f4, this.posZ - this.motionZ * (double) f4, this.motionX, this.motionY, this.motionZ);
                }

                f3 = 0.8F;
            }

            if (this.isWet()) {
                this.extinguish();
            }

            this.motionX *= (double) f3;
            this.motionY *= (double) f3;
            this.motionZ *= (double) f3;
            this.motionY -= (double) f1;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();

            if ((this.worldObj.getBlock((int) Math.round(this.posX), (int) Math.floor(this.posY) - 1, (int) Math.round(this.posZ)) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX), (int) Math.floor(this.posY), (int) Math.round(this.posZ)) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX) + 1, (int) Math.floor(this.posY), (int) Math.round(this.posZ)) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX) - 1, (int) Math.floor(this.posY), (int) Math.round(this.posZ)) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX), (int) Math.floor(this.posY), (int) Math.round(this.posZ) + 1) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX), (int) Math.floor(this.posY), (int) Math.round(this.posZ) - 1) != Blocks.air || this.worldObj.getBlock((int) Math.round(this.posX), (int) Math.floor(this.posY) + 1, (int) Math.round(this.posZ)) != Blocks.air) && this.getTextureName() == "snowstormArrow") {
                this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
                this.setDead();
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setShort("xTile", (short) this.xTile);
        tag.setShort("yTile", (short) this.yTile);
        tag.setShort("zTile", (short) this.zTile);
        tag.setShort("life", (short) this.ticksInGround);
        tag.setByte("inTile", (byte) Block.getIdFromBlock(this.inTile));
        tag.setByte("inData", (byte) this.inData);
        tag.setByte("shake", (byte) this.arrowShake);
        tag.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        tag.setByte("pickup", (byte) this.canBePickedUp);
        tag.setDouble("damage", this.damageMin);
        tag.setString("texture", this.dataWatcher.getWatchableObjectString(17));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        this.xTile = tag.getShort("xTile");
        this.yTile = tag.getShort("yTile");
        this.zTile = tag.getShort("zTile");
        this.ticksInGround = tag.getShort("life");
        this.inTile = Block.getBlockById(tag.getByte("inTile") & 255);
        this.inData = tag.getByte("inData") & 255;
        this.arrowShake = tag.getByte("shake") & 255;
        this.inGround = tag.getByte("inGround") == 1;
        this.dataWatcher.updateObject(17, tag.getString("texture"));

        if (tag.hasKey("damage", 99)) {
            this.damageMin = tag.getDouble("damage");
        }

        if (tag.hasKey("pickup", 99)) {
            this.canBePickedUp = tag.getByte("pickup");
        } else if (tag.hasKey("player", 99)) {
            this.canBePickedUp = tag.getBoolean("player") ? 1 : 0;
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && p_70100_1_.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !p_70100_1_.inventory.addItemStackToInventory(new ItemStack(ammoItem, 1))) {
                flag = false;
            }

            if (flag) {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                p_70100_1_.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }

    @Override
    public void setDamage(double p_70239_1_) {
        this.damageMin = p_70239_1_;
    }

    @Override
    public double getDamage() {
        return this.damageMin;
    }

    @Override
    public void setKnockbackStrength(int p_70240_1_) {
        this.knockbackStrength = p_70240_1_;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    @Override
    public void setIsCritical(boolean p_70243_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70243_1_) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    @Override
    public boolean getIsCritical() {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        return (b0 & 1) != 0;
    }

    public void setAmmoItem(Item ammo) {
        this.ammoItem = ammo;
    }

    public String getTextureName() {
        return this.dataWatcher.getWatchableObjectString(17);
    }

}
