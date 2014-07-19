package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAngryBunny extends EntityBunny {
	
	public EntityAngryBunny(World var1) {
		super(var1);
		this.setSize(1F, 1F);
		this.experienceValue = 40;
		addBasicAI();
		addAttackingAI();
	}
	
	public EntityAngryBunny(World var1, boolean tamed, String owner) {
		this(var1);
		this.setTamed(tamed);
        this.func_152115_b(owner);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.angryBunnyHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.angryBunnySpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.angryBunnyFollowRange);
	}
	
	@Override
	public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.worldObj.isRemote && this.isTamed() && (this.getAttackTarget() == null || this.getAttackTarget().isDead)) {
            EntityBunny var2 = new EntityBunny(this.worldObj, true, this.func_152113_b());
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(var2);
            this.setDead();
        }
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

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}