package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.entities.vethea.projectile.EntityZoragonBomb;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZoragon extends EntityDivineRPGFlying {
	
	private static final double spawnLayer = 4;
    private ChunkCoordinates currentFlightTarget;
    private int flyTimer;
    private int special;

    public EntityZoragon(World var1) {
        super(var1);
        this.flyTimer = 0;
        this.setSize(4.0F, 4.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.zoragonHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.zoragonSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.zoragonFollowRange);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.zoragon.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.zoragonHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
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
            int var2 = (int) this.getAttackTarget().posX;
            int var4 = (int) this.getAttackTarget().posY;
            int var6 = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new ChunkCoordinates(var2, var4 + 15, var6);
        }
        else if (this.flyTimer != 0) {
            this.flyTimer = 360;
            this.currentFlightTarget = new ChunkCoordinates((int)(this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
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

            if (Math.abs(var1) < 1 && Math.abs(var3) < 1 && Math.abs(var5) < 1) {
                if (this.special == 0) {
                    this.special = 120;
                    EntityZoragonBomb var9 = new EntityZoragonBomb(this.worldObj, this.posX, this.posY - 1, this.posZ);
                    var9.setVelocity(0, -0.1, 0);
                    this.worldObj.spawnEntityInWorld(var9);
                } else {
                    this.special--;
                }
            }

            flyTimer--;
        }

    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.shinyPearls, 1);
    }

	@Override
	public String mobName() {
		return "Zoragon";
	}
}