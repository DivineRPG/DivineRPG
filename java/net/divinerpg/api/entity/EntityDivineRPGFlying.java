package net.divinerpg.api.entity;

import net.divinerpg.entities.vethea.EntityTwins;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityDivineRPGFlying extends EntityFlying implements IMob {

	private ChunkCoordinates spawnPosition;

	public EntityDivineRPGFlying(World par1World) {
		super(par1World);
		addBasicAI();
	}

	public double getHP(){return getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();}
	public double getMoveSpeed(){return getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();}
	public double getAttackDamage(){return getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();}
	public double getFollowRange(){return getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();}
	public double getKnockbackResistance(){return getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();}
	public abstract String mobName();

	@Override
    protected void fall(float par1) {}

    @Override
    protected void updateFallState(double par1, boolean par3) {}

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
	
	protected void addBasicAI(){
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		if(this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1)) {
			this.spawnPosition = null;
		}

		if(this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F) {
			this.spawnPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}

		double d0 = (double)this.spawnPosition.posX + 0.01D - this.posX;
		double d1 = (double)this.spawnPosition.posY + 0.1D - this.posY;
		double d2 = (double)this.spawnPosition.posZ + 0.01D - this.posZ;
		double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
		this.motionX += d0 / d3 * 0.05D;
        this.motionY += d1 / d3 * 0.1D;
        this.motionZ += d2 / d3 * 0.05D;
		float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.001F;
		this.rotationYaw += f1;
	}
	
	@Override
    protected String getLivingSound() {
        return super.getLivingSound();
    }

    @Override
    protected String getHurtSound() {
        return super.getHurtSound();
    }

    @Override
    protected String getDeathSound() {
        return super.getDeathSound();
    }

	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)  {
        this.attackEntityAsMob(par1EntityPlayer);
    }

	public void onDeath(DamageSource d) {
		super.onDeath(d);	
		if(!worldObj.isRemote && ConfigurationHelper.canShowDeathChat){
			if(d.getSourceOfDamage() != null && d.getSourceOfDamage() instanceof EntityPlayer){
				EntityPlayer p = (EntityPlayer)d.getSourceOfDamage();
				String name = mobName() != null ? mobName() : "null";
				Util.sendMessageToAll(p.getDisplayName() + " has slain a " + name + ".");
			}
		}
	}
}