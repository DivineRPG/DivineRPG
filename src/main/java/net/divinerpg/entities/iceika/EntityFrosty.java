package net.divinerpg.entities.iceika;

import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFrosty extends EntityPeacefulUntilAttacked{

	public EntityFrosty(World w) {
		super(w);
		this.setSize(1, 2.5f);
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.frostyHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.frostyDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.frostySpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.frostyFollowRange);
    }
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		boolean attack = super.attackEntityAsMob(entity);
		if(attack && entity instanceof EntityLivingBase) {
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2, true));
			entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 2.5 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 2.5 * 0.5F);
		}
		return attack;
	}
	
	@Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.frosty);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.frostyHurt);
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.frostyHurt);
    }
 
	
	@Override
	public void dropFewItems(boolean beenHit, int lootingLevel) {
		this.dropItem(IceikaItems.peppermints, this.rand.nextInt(3));
		this.dropItem(IceikaItems.iceShards, this.rand.nextInt(4));
	}

	@Override
	public String mobName() {
		return "Frosty";
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

}
