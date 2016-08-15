package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGreenfeet extends EntityDivineRPGMob {


	public EntityGreenfeet(World w) {
		super(w);
		this.addAttackingAI();
		this.setSize(1, 2);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.greenfeetHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.greenfeetDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.greenfeetSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.greenfeetFollowRange);
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
		return "Greenfeet";
	}
}