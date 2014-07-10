package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityNesro extends EntityDivineRPGMob {

	private int slimeJumpDelay = 0;

	public EntityNesro(World var1) {
		super(var1);
		this.slimeJumpDelay = this.rand.nextInt(20) + 10;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.nesroHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.nesroDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.nesroSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.nesroFollowRange);
	}

	@Override
	public int getTotalArmorValue() {
		return 10;
	}

	@Override
	public void onLivingUpdate() {
		if(this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float var1 = this.getBrightness(1.0F);

			if(var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
				this.setFire(8);
			}
		}
		super.onLivingUpdate();
	}

	protected int getJumpDelay() {
		return slimeJumpDelay;
	}

	@Override
	protected void updateEntityActionState() {
		this.despawnEntity();
		EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(var1 != null) {
			this.faceEntity(var1, 10.0F, 20.0F);
		}
		if(this.onGround && this.slimeJumpDelay-- <= 0) {
			this.slimeJumpDelay = this.getJumpDelay();

			if(var1 != null) {
				this.slimeJumpDelay /= 3;
			}
			this.isJumping = true;
			this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
			this.moveForward = 1.0F;
		} else {
			this.isJumping = false;
			if(this.onGround) {
				this.moveStrafing = this.moveForward = 0.0F;
			}
		}
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.nesro);
	}
 
	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.nesroHurt);
	}
 
	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.nesroHurt);
	}
 
	@Override
	protected Item getDropItem() {
		return TwilightItemsOther.edenSoul;
	}

	@Override
	public String mobName() {
		return "Nesro";
	}
}