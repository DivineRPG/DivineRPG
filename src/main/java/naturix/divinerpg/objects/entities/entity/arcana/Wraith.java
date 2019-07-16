package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Wraith extends Paratiku {
    private int age;
    private BlockPos currentFlightTarget;

    public Wraith(World par1World, EntityPlayer owner) {
        super(par1World);
        this.age = 120;
        this.setTamed(true);
        this.setOwnerId(owner.getUniqueID());
    }

    public Wraith(World par1World) {
        super(par1World);
        this.age = 120;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
	public SoundEvent getAmbientSound() {
        return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : ModSounds.WRAITH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.WRAITH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WRAITH_HURT;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.getIsBatHanging()) {
            this.motionX = this.motionY = this.motionZ = 0.0D;
            this.posY = MathHelper.floor(this.posY) + 1.0D - this.height;
        } else {
            this.motionY *= 0.6000000238418579D;
        }

        this.age--;
        if (this.age == 0) {
            this.setDead();
        }
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int var1 = (int) this.getAttackTarget().posX;
            int var2 = (int) this.getAttackTarget().posY;
            int var3 = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new BlockPos(var1, var2, var3);
        }
        else if (this.getOwner() != null) {
            this.currentFlightTarget = this.world.getPlayerEntityByName(this.getOwner().getName()).getPosition();
        }

        if (this.getIsBatHanging()) {
            if (!this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), (int)this.posY + 1, MathHelper.floor(this.posZ))).isNormalCube())
            {
                this.setIsBatHanging(false);
                this.world.playEvent((EntityPlayer)null, 1015, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
            } else {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = this.rand.nextInt(360);
                }

                if (this.world.getClosestPlayerToEntity(this, 4.0D) != null) {
                    this.setIsBatHanging(false);
                    this.world.playEvent((EntityPlayer)null, 1015, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
                }
            }
        } else {
            if (this.currentFlightTarget != null) {
                double var1 = this.currentFlightTarget.getX() - this.posX;
                double var3 = this.currentFlightTarget.getY() - this.posY;
                double var5 = this.currentFlightTarget.getZ() - this.posZ;

                if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                    this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
                    this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                    this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
                    float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                    float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += var8;
                }
            }
        }
    }
}