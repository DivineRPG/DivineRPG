package net.divinerpg.entities.iceika;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAlicanto extends EntityDivineRPGMob {
	
    private ChunkCoordinates currentFlightTarget;
    private int flyTimer;

    public EntityAlicanto(World var1) {
        super(var1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), true));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWander(this, getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.flyTimer = 0;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.alicantoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.alicantoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.alicantoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.alicantoFollowRange);
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected String getLivingSound() {
        return this.rand.nextInt(4) != 0 ? null : Sounds.getSoundName(Sounds.alicanto);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.alicantoHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.alicantoHurt);
    }

    public void onUpdate()
	{
		super.onUpdate();
		this.motionY *= 0.6000000238418579D;
	}

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
			double var1 = (double)this.currentFlightTarget.posX - this.posX;
			double var3 = (double)this.currentFlightTarget.posY - this.posY;
			double var5 = (double)this.currentFlightTarget.posZ - this.posZ;

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
    protected void updateFallState(double par1, boolean par3) {}
 
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

	@Override
	public String mobName() {
		return "Alicanto";
	}
}