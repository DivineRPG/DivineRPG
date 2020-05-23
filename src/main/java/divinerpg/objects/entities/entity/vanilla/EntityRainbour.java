package divinerpg.objects.entities.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.enums.ParticleType;
import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Calendar;

public class EntityRainbour extends EntityPeacefulUntilAttacked {
    private static final DataParameter<Boolean> HANGING = EntityDataManager.createKey(EntityBat.class,
            DataSerializers.BOOLEAN);
    private BlockPos spawnPosition;

    public EntityRainbour(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataManager.register(HANGING, Boolean.valueOf(false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected void collideWithEntity(Entity par1Entity) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    public boolean getIsBatHanging() {
        return this.dataManager.get(HANGING).booleanValue();
    }

    public void setIsBatHanging(boolean isHanging) {
        this.dataManager.set(HANGING, Boolean.valueOf(isHanging));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.getIsBatHanging()) {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
            this.posY = (double) MathHelper.floor(this.posY) + 1.0D - (double) this.height;
        } else {
            this.motionY *= 0.6000000238418579D;
        }
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        BlockPos blockpos = new BlockPos(this);
        BlockPos blockpos1 = blockpos.up();

        if (this.getAttackTarget() != null) {
            this.spawnPosition = this.getAttackTarget().getPosition();
        }

        if (this.getIsBatHanging()) {
            if (this.world.getBlockState(blockpos1).isNormalCube()) {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = (float) this.rand.nextInt(360);
                }

                if (this.world.getNearestPlayerNotCreative(this, 4.0D) != null) {
                    this.setIsBatHanging(false);
                    this.world.playEvent(null, 1025, blockpos, 0);
                }
            } else {
                this.setIsBatHanging(false);
                this.world.playEvent(null, 1025, blockpos, 0);
            }
        } else {
            if (this.spawnPosition != null
                    && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
                this.spawnPosition = null;
            }

            if (this.spawnPosition == null || this.rand.nextInt(30) == 0
                    || this.spawnPosition.distanceSq((int) this.posX, (int) this.posY,
                    (int) this.posZ) < 4.0D) {
                this.spawnPosition = new BlockPos((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7),
                        (int) this.posY + this.rand.nextInt(6) - 2,
                        (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }

            double d0 = (double) this.spawnPosition.getX() + 0.5D - this.posX;
            double d1 = (double) this.spawnPosition.getY() + 0.1D - this.posY;
            double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.posZ;
            this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
            this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
            this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
            float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
            this.moveForward = 0.5F;
            this.rotationYaw += f1;

            if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube()) {
                this.setIsBatHanging(true);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void onLivingUpdate() {
        super.onLivingUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            DivineRPG.proxy.spawnParticle(this.world, ParticleType.SPARKLER,
                    this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                    this.posY + this.rand.nextDouble() * (double) this.height - 0.25D,
                    this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                    (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
                    (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            if (!this.world.isRemote && this.getIsBatHanging()) {
                this.setIsBatHanging(false);
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.dataManager.set(HANGING, Boolean.valueOf(compound.getBoolean("Hanging")));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Hanging", this.dataManager.get(HANGING).booleanValue());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAINBOUR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_RAINBOUR;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        // Only spawn below sea level
        if (blockpos.getY() >= this.world.getSeaLevel()) {
            return false;
        } else {
            int lightLevel = this.world.getLightFromNeighbors(blockpos);
            int minLightLevel = 4;
            Calendar calendar = this.world.getCurrentDate();

            // Unless around Halloween (Oct 20 - Nov 3) there is a 50% chance not to spawn
            if ((calendar.get(Calendar.MONTH) != Calendar.OCTOBER || calendar.get(Calendar.DATE) < 20)
                    && (calendar.get(Calendar.MONTH) != Calendar.NOVEMBER || calendar.get(Calendar.DATE) > 3)) {
                if (this.rand.nextBoolean()) {
                    return false;
                }
            } else {
                minLightLevel = 7;
            }

            return world.provider.getDimension() == 0 && lightLevel <= this.rand.nextInt(minLightLevel)
                    && super.getCanSpawnHere();
        }
    }
}
