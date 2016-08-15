package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.vethea.projectile.EntityZoragonBomb;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZoragon extends EntityDivineRPGMob {
	
	private static final double spawnLayer = 4;
    private ChunkCoordinates currentFlightTarget;
    private int flyTimer;
    private int special;

    public EntityZoragon(World var1) {
        super(var1);
        flyTimer = 0;
        special = 120;
        this.setSize(6.0F, 6.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.zoragonHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.zoragonSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.zoragonFollowRange);
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
    public void fall(float f) {}

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.entityToAttack != null) {
            int targetX = (int) this.entityToAttack.posX;
            int targetY = (int) this.entityToAttack.posY;
            int targetZ = (int) this.entityToAttack.posZ;
            currentFlightTarget = new ChunkCoordinates(targetX, targetY + 15, targetZ);
            if(this.entityToAttack instanceof EntityPlayer && ((EntityPlayer)this.entityToAttack).capabilities.isCreativeMode) this.entityToAttack = null;
        }
        else if (flyTimer != 0) {
            flyTimer = 360;
            currentFlightTarget = new ChunkCoordinates((int)(this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
        }

        if (currentFlightTarget != null) {
            double distX = currentFlightTarget.posX - this.posX;
            double distY = currentFlightTarget.posY - this.posY;
            double distZ = currentFlightTarget.posZ - this.posZ;

            if (Math.signum(distX) != 0 || Math.signum(distY) != 0 || Math.signum(distZ) != 0) {
                this.motionX += (Math.signum(distX) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(distY) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(distZ) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }

            if (Math.abs(distX) < 3 && Math.abs(distY) < 3 && Math.abs(distZ) < 3) {
                if (special == 0) {
                    special = 120;
                    EntityZoragonBomb bomb = new EntityZoragonBomb(this.worldObj, this.posX, this.posY - 1, this.posZ);
                    bomb.motionY=-0.1f;
                    this.worldObj.spawnEntityInWorld(bomb);
                } else {
                    special--;
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