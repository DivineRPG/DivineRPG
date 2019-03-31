package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityEnderTripletsFireball;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EnderTriplets extends EntityDivineRPGFlying {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ender_triplets");
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;

    public EnderTriplets(World worldIn) {
        super(worldIn);
        this.setSize(2.0F, 2.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        } else if ("fireball".equals(damageSource.getDamageType())
                && damageSource.getTrueSource() instanceof EntityPlayer) {
            super.attackEntityFrom(damageSource, 1000.0F);
            // EntityPlayer player = (EntityPlayer)damageSource.getTrueSource();
            // player.triggerAchievement(DivineRPGAchievements.tripleDanger);
            return true;
        } else {
            return super.attackEntityFrom(damageSource, par2);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if (d3 < 1.0D || d3 > 3600.0D) {
            this.waypointX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.targetedEntity != null && this.targetedEntity.posY + 13 > this.posY)
            this.waypointY += 4;

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = (double) MathHelper.sqrt(d3);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
                this.motionX += d0 / d3 * 0.1D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.1D;
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }

        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }

        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.world.getNearestAttackablePlayer(this, 100.0D, 100.0D);

            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }

        double d4 = 64.0D;

        if (this.targetedEntity != null && this.targetedEntity.getDistanceSq(this) < d4 * d4) {
            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.getEntityBoundingBox().minY + (double) (this.targetedEntity.height / 2.0F)
                    - (this.posY + (double) (this.height / 2.0F)) - 5;
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.world.playEvent(1007, this.getPosition(), 0);
                }

                ++this.attackCounter;

                if (this.attackCounter == 20 && !this.world.isRemote) {
                    this.world.playEvent(1008, this.getPosition(), 0);
                    EntityEnderTripletsFireball entitylargefireball = new EntityEnderTripletsFireball(this.world, this,
                            d5, d6, d7);
                    double d8 = 4.0D;
                    Vec3d vec = this.getLook(1.0F);
                    entitylargefireball.posX = this.posX + vec.x * d8;
                    entitylargefireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
                    entitylargefireball.posZ = this.posZ + vec.z * d8;
                    this.world.spawnEntity(entitylargefireball);
                    this.attackCounter = -40;
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F
                    / (float) Math.PI;

            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }

    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double d4 = (this.waypointX - this.posX) / par7;
        double d5 = (this.waypointY - this.posY) / par7;
        double d6 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();

        for (int i = 1; (double) i < par7; ++i) {
            axisalignedbb.offset(d4, d5, d6);

            if (!this.world.getCollisionBoxes(this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GHAST_SCREAM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && world.provider.getDimension() == 1;
    }
}