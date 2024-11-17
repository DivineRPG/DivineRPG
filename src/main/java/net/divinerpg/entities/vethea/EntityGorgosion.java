package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGorgosion extends VetheaMob {
	

	public EntityGorgosion(World var1) {
		super(var1);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.gorgosionHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.gorgosionSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.gorgosionFollowRange);
	}

	@Override
    public int getSpawnLayer() {
    	return 2;
    }

	@Override
	protected void fall(float par1) {
		if(par1 > 2) {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
			return;
		}
		super.fall(par1);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 10) != null && this.rand.nextInt(30) == 0) {
			this.addVelocity(0, 1, 0);
		}
	}

	@Override
	protected float getSoundVolume() {
		return 0.7F;
	}

	@Override
	protected String getLivingSound() {
		return Sounds.gorgosion.getPrefixedName();
	}

	@Override
	protected String getHurtSound() {
		return Sounds.gorgosionHurt.getPrefixedName();
	}

	@Override
	protected String getDeathSound() {
		return getHurtSound();
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float par2) {
		if (source.isExplosion()) return false;
		return super.attackEntityFrom(source, par2);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(VetheaItems.cleanPearls, 1);
	}

	@Override
	public String mobName() {
		return "Gorgosion";
	}
}