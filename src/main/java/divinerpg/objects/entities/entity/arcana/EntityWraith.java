package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityWraith extends EntityDivineRPGTameable {
    private BlockPos spawnPosition;
    private BlockPos currentFlightTarget;
    private int age;

    public EntityWraith(World world) {
        super(world);
        this.setSize(0.9F, 1.4F);
        this.age = 120;
    }

    public EntityWraith(World world, EntityPlayer owner) {
        this(world);
        setTamedBy(owner);this.age = 120;
        this.setTamed(true);
        this.setOwnerId(owner.getUniqueID());
    }

    @Override
    public float getEyeHeight() {
        return 1.5F;
    }


    @Override
    public boolean attackEntityAsMob(Entity entity) {
        float damage = (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

        if (this.isPotionActive(MobEffects.STRENGTH)) {
            damage += 3 << this.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier();
        }
        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            damage -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        int knockback = 0;
        if (entity instanceof EntityLiving) {
            damage += EnchantmentHelper.getEfficiencyModifier((EntityLiving) entity);
            knockback += EnchantmentHelper.getKnockbackModifier((EntityLiving) entity);
        }

        boolean attacked = entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);

        if (attacked) {
            if (knockback > 0) {
                entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F,
                        0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int fire = EnchantmentHelper.getFireAspectModifier(this);
            if (fire > 0) {
                entity.setFire(fire * 4);
            }
        }

        return attacked;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        if (this.getOwnerId() == null) {
            compound.setString("Owner", "");
        } else {
            compound.setString("Owner", this.getOwnerId().toString());
        }
        compound.setBoolean("Sitting", this.isSitting());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : SoundRegistry.WRAITH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundRegistry.WRAITH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WRAITH_HURT;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    public boolean getIsBatHanging() {
        return false;
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

        if (this.getAttackTarget() != null) {
            int x = (int) this.getAttackTarget().posX;
            int y = (int) this.getAttackTarget().posY;
            int z = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new BlockPos(x, y, z);
        } else if (this.getOwner() != null) {
            this.currentFlightTarget = this.world.getPlayerEntityByName(this.getOwner().getName()).getPosition();
        }

        if (this.getIsBatHanging()) {
            if (!this.world
                    .getBlockState(
                            new BlockPos(MathHelper.floor(this.posX), (int) this.posY + 1, MathHelper.floor(this.posZ)))
                    .isNormalCube()) {
                this.world.playEvent(null, 1025,
                        new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ), 0);
            } else {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = this.rand.nextInt(360);
                }

                if (this.world.getClosestPlayerToEntity(this, 4.0D) != null) {
                    this.world.playEvent(null, 1025,
                            new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ), 0);
                }
            }
        } else {
            if (this.currentFlightTarget != null) {
                double x = this.currentFlightTarget.getX() - this.posX;
                double y = this.currentFlightTarget.getY() - this.posY;
                double z = this.currentFlightTarget.getZ() - this.posZ;

                if (Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                    this.motionX += (Math.signum(x) * 0.5D - this.motionX) * 0.10000000149011612D;
                    this.motionY += (Math.signum(y) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                    this.motionZ += (Math.signum(z) * 0.5D - this.motionZ) * 0.10000000149011612D;
                    float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
                    float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += f1;
                }
            }
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
        }
        	return super.attackEntityFrom(source, amount);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}