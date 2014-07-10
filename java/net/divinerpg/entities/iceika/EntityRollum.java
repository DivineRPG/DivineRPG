package net.divinerpg.entities.iceika;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityRollum extends EntityDivineRPGMob {
	
    public EntityRollum(World var1) {
        super(var1);
        float moveSpeed = 0.5F;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this,  0.56D, true));
		this.tasks.addTask(7, new EntityAIWander(this, moveSpeed));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.rollumHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.rollumDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.rollumSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.rollumFollowRange);
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        super.attackEntityAsMob(par1Entity);
        if (this.entityToAttack != null) {
            this.entityToAttack.addVelocity(this.motionX * 3.0D, 0.3D, this.motionZ * 3.0D);
            return true;
        }
        return false;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.rollum);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.rollumHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.rollumHurt);
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
		return "Rollum";
	}
}
