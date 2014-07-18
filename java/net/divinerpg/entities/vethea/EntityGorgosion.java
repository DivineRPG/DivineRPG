package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGorgosion extends EntityDivineRPGMob {
	
	private static final double spawnLayer = 2;

	public EntityGorgosion(World var1) {
		super(var1);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.gorgosionHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.gorgosionSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.gorgosionFollowRange);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
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

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (par1DamageSource.isExplosion())
			return false;
		return super.attackEntityFrom(par1DamageSource, par2);
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