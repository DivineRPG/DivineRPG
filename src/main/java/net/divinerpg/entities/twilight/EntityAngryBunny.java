package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAngryBunny extends EntityDivineRPGMob {
	
	public EntityAngryBunny(World var1) {
		super(var1);
		this.setSize(1.5F, 2F);
		this.experienceValue = 40;
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.angryBunnyHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.angryBunnySpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.angryBunnyFollowRange);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
        double i = EntityStats.angryBunnyDamage;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
    }

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.hiss);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.growlHurt);
	}
 
	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.growlHurt);
	}

	@Override
	public String mobName() {
		return "Angry Bunny";
	}
}