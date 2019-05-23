package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityCoriShot;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EdenCori extends EntityDivineRPGFlying {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/eden_cori");

    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private BlockPos currentFlightTarget;

    public EdenCori(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double var1 = this.waypointX - this.posX;
        double var3 = this.waypointY - this.posY;
        double var5 = this.waypointZ - this.posZ;
        double var7 = (double) MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);

        if (var7 < 1.0D || var7 > 60.0D) {
            this.waypointX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7)) {
                this.motionX += var1 / var7 * 0.1D;
                this.motionY += var3 / var7 * 0.1D;
                this.motionZ += var5 / var7 * 0.1D;
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

        double var9 = 64.0D;

        if (this.targetedEntity != null && this.targetedEntity.getDistanceSq(this) < var9 * var9) {
            double tx = this.targetedEntity.posX - this.posX;
            double ty = this.targetedEntity.getEntityBoundingBox().minY - this.posY;
            double tz = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(tx, tz)) * 180.0F / (float) Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity)) {
                ++this.attackCounter;

                if (this.attackCounter == 20) {
                    this.world.playSound((EntityPlayer) null, this.targetedEntity.posX, this.targetedEntity.posY,
                            this.targetedEntity.posZ, ModSounds.CORI_SHOOT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    EntityCoriShot shot = new EntityCoriShot(this.world, this, 30);
                    shot.shoot(tx, ty, tz, 1.6f, 4);
                    if (!this.world.isRemote) {
                        this.world.spawnEntity(shot);
                    }
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
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CORI_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CORI_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CORI_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}