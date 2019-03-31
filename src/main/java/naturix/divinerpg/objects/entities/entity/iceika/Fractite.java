package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityFractiteShot;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Fractite extends EntityDivineRPGFlying {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/iceika/fractite");
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private BlockPos spawnPosition;

    public Fractite(World worldIn) {
        super(worldIn);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setSize(1.7F, 1.3F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0);
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        this.prevAttackCounter = this.attackCounter;
        double var1 = this.waypointX - this.posX;
        double var3 = this.waypointY - this.posY;
        double var5 = this.waypointZ - this.posZ;
        double var7 = var1 * var1 + var3 * var3 + var5 * var5;

        if (var7 < 1.0D || var7 > 3600.0D) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            var7 = MathHelper.sqrt(var7);

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
            double var11 = this.targetedEntity.posX - this.posX;
            double var13 = this.targetedEntity.getEntityBoundingBox().minY - 5 - this.posY;
            double var15 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(var11, var15)) * 180.0F / (float) Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity)) {

                ++this.attackCounter;

                if (this.attackCounter == 20) {
                    if (!this.world.isRemote)
                        this.playSound(DRPGSoundHandler.FRACTITE_ATTACK, 1.0F, 1.0F);
                    EntityFractiteShot shot = new EntityFractiteShot(this.world, this, var11, var13, var15);
                    double var18 = 4.0D;
                    Vec3d var20 = this.getLook(1.0F);
                    shot.posX = this.posX + var20.x * var18;
                    shot.posY = this.posY + this.height / 2.0F + 0.5D;
                    shot.posZ = this.posZ + var20.z * var18;
                    if (!this.world.isRemote)
                        this.world.spawnEntity(shot);
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
    public void travel(float strafe, float vertical, float forward) {
        if (this.isServerWorld()) {
            if (!this.isInWater()) {
                if (!this.isInLava()) {
                    float f6 = 0.91F;

                    if (this.onGround) {
                        f6 = 0.54600006F;
                    }

                    float f7 = 0.16277136F / (f6 * f6 * f6);
                    this.moveRelative(strafe, vertical, forward, this.onGround ? 0.1F * f7 : 0.02F);
                    f6 = 0.91F;

                    if (this.onGround) {
                        f6 = 0.54600006F;
                    }

                    this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

                    this.motionX *= (double) f6;
                    this.motionY *= (double) f6;
                    this.motionZ *= (double) f6;
                } else {
                    this.moveRelative(strafe, vertical, forward, 0.02F);
                    this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.5D;
                    this.motionY *= 0.5D;
                    this.motionZ *= 0.5D;
                }
            } else {
                this.moveRelative(strafe, vertical, forward, 0.02F);
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.800000011920929D;
                this.motionY *= 0.800000011920929D;
                this.motionZ *= 0.800000011920929D;
            }
        }
        this.prevRotationYaw = this.rotationYaw;
        double var10 = this.posX - this.prevPosX;
        double var9 = this.posZ - this.prevPosZ;
        float var7 = MathHelper.sqrt(var10 * var10 + var9 * var9) * 4.0F;

        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.rotationYaw += (var7 - this.rotationYaw) * 0.4F;
        this.limbSwing += this.rotationYaw;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.FRACTITE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.FRACTITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.FRACTITE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    /**
     * @Override public boolean getCanSpawnHere() { return
     *           world.provider.getDimension() ==
     *           ModDimensions.iceikaDimension.getId() && super.getCanSpawnHere(); }
     */
}
