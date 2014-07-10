package net.divinerpg.entities.iceika;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFractite extends EntityDivineRPGFlying {

	public int courseChangeCooldown = 0;
	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private Entity targetedEntity = null;
	private int aggroCooldown = 0;
	public int prevAttackCounter = 0;
	public int attackCounter = 0;
	private ChunkCoordinates currentFlightTarget;

	public EntityFractite(World var1) {
		super(var1);
		this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.fractiteHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.fractiteSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.fractiteFollowRange);
	}

	@Override
	protected void updateEntityActionState() {
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
			var7 = MathHelper.sqrt_double(var7);

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
			this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);

			if (this.targetedEntity != null) {
				this.aggroCooldown = 20;
			}
		}

		double var9 = 64.0D;

		if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < var9 * var9) {
			double var11 = this.targetedEntity.posX - this.posX;
			double var13 = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0F - (this.posY + this.height / 2.0F);
			double var15 = this.targetedEntity.posZ - this.posZ;
			this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(var11, var15)) * 180.0F / (float)Math.PI;

			if (this.canEntityBeSeen(this.targetedEntity)) {
				if (this.attackCounter == 10) {
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
				}

				++this.attackCounter;

				if (this.attackCounter == 20) {
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
					/*EntityFractiteProjectile var17 = new EntityFractiteProjectile(this.worldObj, this, var11, var13, var15);
                    double var18 = 4.0D;
                    Vec3 var20 = this.getLook(1.0F);
                    var17.posX = this.posX + var20.xCoord * var18;
                    var17.posY = this.posY + this.height / 2.0F + 0.5D;
                    var17.posZ = this.posZ + var20.zCoord * var18;
                    this.worldObj.spawnEntityInWorld(var17);*///TODO
                    this.attackCounter = -40;
				}
			}
			else if (this.attackCounter > 0) {
				--this.attackCounter;
			}
		} else {
			this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;

			if (this.attackCounter > 0) {
				--this.attackCounter;
			}
		}
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected void updateFallState(double par1, boolean par3) {}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (this.isInWater()) {
			this.moveFlying(par1, par2, 0.02F);
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.800000011920929D;
			this.motionY *= 0.800000011920929D;
			this.motionZ *= 0.800000011920929D;
		}
		else if (this.handleLavaMovement()) {
			this.moveFlying(par1, par2, 0.02F);
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.5D;
			this.motionY *= 0.5D;
			this.motionZ *= 0.5D;
		} else {
			float var3 = 0.91F;

			if (this.onGround) {
				var3 = 0.54600006F;

			}

			float var8 = 0.16277136F / (var3 * var3 * var3);
			this.moveFlying(par1, par2, this.onGround ? 0.1F * var8 : 0.02F);
			var3 = 0.91F;

			if (this.onGround) {
				var3 = 0.54600006F;
				Block var5 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
			}

			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= var3;
			this.motionY *= var3;
			this.motionZ *= var3;
		}

		this.prevRotationYaw = this.rotationYaw;
		double var10 = this.posX - this.prevPosX;
		double var9 = this.posZ - this.prevPosZ;
		float var7 = MathHelper.sqrt_double(var10 * var10 + var9 * var9) * 4.0F;

		if (var7 > 1.0F) {
			var7 = 1.0F;
		}

		this.rotationYaw += (var7 - this.rotationYaw) * 0.4F;
		this.limbSwing += this.rotationYaw;
	}

	private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
		double var9 = (this.waypointX - this.posX) / par7;
		double var11 = (this.waypointY - this.posY) / par7;
		double var13 = (this.waypointZ - this.posZ) / par7;
		AxisAlignedBB var15 = this.boundingBox.copy();

		for (int var16 = 1; var16 < par7; ++var16) {
			var15.offset(var9, var11, var13);

			if (!this.worldObj.getCollidingBoundingBoxes(this, var15).isEmpty())
				return false;
		}

		return true;
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.fractite);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.fractiteHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.fractiteHurt);
	}

	@Override
	protected Item getDropItem() {
		return IceikaItems.iceShards;
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4) {
			this.dropItem(IceikaItems.iceShards, 3);
		}
	}

	@Override
	public String mobName() {
		return "Fractite";
	}
}