package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLorgaFlight extends EntityDivineRPGFlying {
	
    private static final double spawnLayer = 3;
    private ChunkCoordinates currentFlightTarget;
    private int flyTimer, lifeTick, spawnTick;
    public boolean canSpawnMinions;

    public EntityLorgaFlight(World var1, boolean canSpawnMinions) {
        super(var1);
        this.canSpawnMinions = canSpawnMinions;
        this.flyTimer = 0;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaFlightHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaFlightSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaFlightFollowRange);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    public EntityLorgaFlight(World var1, int life, boolean canSpawnMinions) {
        this(var1, canSpawnMinions);
        this.lifeTick = life;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.lorgaFlight.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.lorgaFlightHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.lifeTick == -1 && this.spawnTick == 0 && this.canSpawnMinions) {
            this.spawnTick = 120;
            EntityLorgaFlight var2 = new EntityLorgaFlight(this.worldObj, 10, false);
            var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
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
            int var1 = (int) this.getAttackTarget().posX;
            int var2 = (int) this.getAttackTarget().posY;
            int var3 = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new ChunkCoordinates(var1, var2, var3);
        }
        else if (this.flyTimer != 0) {
            this.flyTimer = 120;
            this.currentFlightTarget = new ChunkCoordinates((int)(this.posX + this.rand.nextInt(16)) - 8, (int)(this.posY + this.rand.nextInt(32)) - 16, (int)(this.posZ + this.rand.nextInt(16)) - 8);
        }

        if (this.currentFlightTarget != null) {
            double var1 = this.currentFlightTarget.posX - this.posX;
            double var3 = this.currentFlightTarget.posY - this.posY;
            double var5 = this.currentFlightTarget.posZ - this.posZ;

            if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                this.motionX += (Math.signum(var1) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(var5) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
            flyTimer--;
        }
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Flying Lorga";
	}
}