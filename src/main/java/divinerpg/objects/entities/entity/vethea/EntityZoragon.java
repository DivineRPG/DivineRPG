package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.projectiles.EntityZoragonBomb;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityZoragon extends EntityDivineRPGMob {
	
	private static final double spawnLayer = 4;
    private BlockPos currentFlightTarget;
    private int flyTimer;
    private int special;

    public EntityZoragon(World var1) {
        super(var1);
        flyTimer = 0;
        special = 120;
        this.setSize(6.0F, 6.0F);
        this.fall(0,0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(110);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 48.0D * spawnLayer  && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ZORAGON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ZORAGON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ZORAGON_HURT;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int targetX = (int) this.getAttackTarget().posX;
            int targetY = (int) this.getAttackTarget().posY;
            int targetZ = (int) this.getAttackTarget().posZ;
            currentFlightTarget = new BlockPos(targetX, targetY + 15, targetZ);
            if(this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer)this.getAttackTarget()).capabilities.isCreativeMode) this.attackingPlayer = null;
        }
        else if (flyTimer != 0) {
            flyTimer = 360;
            currentFlightTarget = new BlockPos((int)(this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
        }

        if (currentFlightTarget != null) {
            double distX = currentFlightTarget.getX() - this.posX;
            double distY = currentFlightTarget.getY() - this.posY;
            double distZ = currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(distX) != 0 || Math.signum(distY) != 0 || Math.signum(distZ) != 0) {
                this.motionX += (Math.signum(distX) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(distY) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(distZ) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }

            if (Math.abs(distX) < 3 && Math.abs(distY) < 3 && Math.abs(distZ) < 3) {
                if (special == 0) {
                    special = 120;
                    EntityZoragonBomb bomb = new EntityZoragonBomb(this.world, this.posX, this.posY - 1, this.posZ);
                    bomb.motionY=-0.1f;
                    this.world.spawnEntity(bomb);
                } else {
                    special--;
                }
            }

            flyTimer--;
        }

    }


}